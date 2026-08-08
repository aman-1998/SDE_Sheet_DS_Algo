package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Clone_Graph {
	
	public static void main(String[] args) {
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node1.neighbors.addAll(Arrays.asList(node2, node3));
		node2.neighbors.addAll(Arrays.asList(node1, node3, node4));
		node3.neighbors.addAll(Arrays.asList(node1, node2, node5));
		node4.neighbors.addAll(Arrays.asList(node2, node5));
		node5.neighbors.addAll(Arrays.asList(node3, node4));
		
		Node clonedNode = cloneGraph(node1);
		
		System.out.println(clonedNode);
	}
	
	/*
	 * T = O(V+E) + O(V+E) = O(V+E)
	 * S = O(V)
	 * 
	 */
	public static Node cloneGraph(Node node) {
		
		if(node == null) {
			return null;
		}
        
		Map<Node, Node> hashMap = bfs(node);
		
		for(Map.Entry<Node, Node> entry : hashMap.entrySet()) {
			
			Node clone = entry.getValue();
			List<Node> adjacentVertices = entry.getKey().neighbors;
			
			for(Node vertex : adjacentVertices) {
				clone.neighbors.add(hashMap.get(vertex));
			}
		}
		
		return hashMap.get(node);
    }

	private static Map<Node, Node> bfs(Node node) {
		
		Map<Node, Node> hashMap = new HashMap<>();
		hashMap.put(node, new Node(node.val));
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			Node popped = queue.poll();
			List<Node> adjacentVertices = popped.neighbors;
			
			for(Node vertex : adjacentVertices) {
				if(!hashMap.containsKey(vertex)) {
					hashMap.put(vertex, new Node(vertex.val));
					queue.add(vertex);
				}
			}
		}
		
		return hashMap;
	} 
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
    
	@Override
	public String toString() {
		List<Integer> vals = new ArrayList<>();

	    for (Node n : neighbors) {
	        vals.add(n.val);
	    }

	    return "Node{val=" + val + ", neighbors=" + vals + "}";
	}
}
