package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.dsa.sheet.part7.utility.Node;

public class Breadth_First_Traversal {
	
	public static void main(String[] args) {
		
		int[][] G = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 1, 1, 0, 0, 0, 0, 0},
				     {0, 1, 0, 0, 1, 0, 0, 0, 0},
				     {0, 1, 0, 0, 1, 0, 0, 0, 0},
				     {0, 0, 1, 1, 0, 1, 1, 1, 0},
				     {0, 0, 0, 0, 1, 0, 0, 0, 1},
				     {0, 0, 0, 0, 1, 0, 0, 0, 1},
				     {0, 0, 0, 0, 1, 0, 0, 0, 1},
				     {0, 0, 0, 0, 0, 1, 1, 1, 0}};
		
		List<List<Integer>> res = BFTUsingMatrix(G, 1);
		
		System.out.print(res);
		
		System.out.println("\n===============================================");
		
		List<Node> Graph = new ArrayList<>();
		
		Graph.add(null);
		
		Node node = new Node(2);
		node.next = new Node(3);
		Graph.add(node);
		
		node = new Node(1);
		node.next = new Node(4);
		Graph.add(node);
		
		node = new Node(1);
		node.next = new Node(4);
		Graph.add(node);
		
		node = new Node(2);
		node.next = new Node(3);
		node.next.next = new Node(5);
		node.next.next.next = new Node(6);
		node.next.next.next.next = new Node(7);
		Graph.add(node);
		
		node = new Node(4);
		node.next = new Node(8);
		Graph.add(node);
		
		node = new Node(4);
		node.next = new Node(8);
		Graph.add(node);
		
		node = new Node(4);
		node.next = new Node(8);
		Graph.add(node);
		
		node = new Node(5);
		node.next = new Node(6);
		node.next.next = new Node(7);
		Graph.add(node);
		
		res = BFTUsingAdjacencyList(Graph, 1);
		
		System.out.print(res);
	}
	
	/*
	 * 1. An array to keep track of the vertices which are visited and which are not
	 * 2. A queue to keep track of the vertices which are visited but not explored
	 * 
	 * T = O(n + n*n) = O(n*n) = O(v^2) ; v = no. of vertices
	 * S = O(n + n) = O(v + v) = O(v)
	 */
	public static List<List<Integer>> BFTUsingMatrix(int[][] G, int start) {
		
		int n = G.length;
		
		int[] visited = new int[n];
		Arrays.fill(visited, 0); // O(n)
		visited[start] = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		List<List<Integer>> res = new ArrayList<>();
		res.add(Arrays.asList(start));
		
		while(!queue.isEmpty()) { // O(n*n)
			int popped = queue.poll();
			List<Integer> temp = new ArrayList<>();
			for(int i = 1; i <= n-1; i++) {
				if(G[popped][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					temp.add(i);
					queue.add(i);
				}
			}
			
			if(!temp.isEmpty()) {
				res.add(temp);
			}
		}
		
		return res;
	}
	
	/*
	 * 1. An array to keep track of the vertices which are visited and which are not
	 * 2. A queue to keep track of the vertices which are visited but not explored
	 * 
	 * T = O(2n + 2e) = O(n + e) = O(v + e) ; v = no. of vertices ; e = no. of edges
	 *  S = O(n + n) = O(v + v) = O(v)
	 */
	public static List<List<Integer>> BFTUsingAdjacencyList(List<Node> G, int start) {
		
		int n = G.size();
		
		int[] visited = new int[n];
		Arrays.fill(visited, 0); // O(n)
		visited[start] = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		List<List<Integer>> res = new ArrayList<>();
		res.add(Arrays.asList(start));
		
		while(!queue.isEmpty()) { // O(n + 2*e)
			int popped = queue.poll();
			List<Integer> temp = new ArrayList<>();
			Node t = G.get(popped);
			while(t != null) {
				if(visited[t.vertex] == 0) {
					visited[t.vertex] = 1;
					temp.add(t.vertex);
					queue.add(t.vertex);
				}
				
				t = t.next;
			}
			
			if(!temp.isEmpty()) {
				res.add(temp);
			}
		}
		
		return res;
	}
}
