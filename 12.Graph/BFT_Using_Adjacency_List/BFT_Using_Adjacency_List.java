package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.dsa.sheet.part7.utility.Node;

public class BFT_Using_Adjacency_List {
	
	public static void main(String[] args) {
		
//		int[][] G = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
//				     {0, 0, 1, 1, 0, 0, 0, 0, 0},
//				     {0, 1, 0, 0, 1, 0, 0, 0, 0},
//				     {0, 1, 0, 0, 1, 0, 0, 0, 0},
//				     {0, 0, 1, 1, 0, 1, 1, 1, 0},
//				     {0, 0, 0, 0, 1, 0, 0, 0, 1},
//				     {0, 0, 0, 0, 1, 0, 0, 0, 1},
//				     {0, 0, 0, 0, 1, 0, 0, 0, 1},
//				     {0, 0, 0, 0, 0, 1, 1, 1, 0}};
		
		List<Node> G = new ArrayList<>();
		
		G.add(null);
		
		Node node = new Node(2);
		node.next = new Node(3);
		G.add(node);
		
		node = new Node(1);
		node.next = new Node(4);
		G.add(node);
		
		node = new Node(1);
		node.next = new Node(4);
		G.add(node);
		
		node = new Node(2);
		node.next = new Node(3);
		node.next.next = new Node(5);
		node.next.next.next = new Node(6);
		node.next.next.next.next = new Node(7);
		G.add(node);
		
		node = new Node(4);
		node.next = new Node(8);
		G.add(node);
		
		node = new Node(4);
		node.next = new Node(8);
		G.add(node);
		
		node = new Node(4);
		node.next = new Node(8);
		G.add(node);
		
		node = new Node(5);
		node.next = new Node(6);
		node.next.next = new Node(7);
		G.add(node);
		
		List<List<Integer>> res = bft(G, 1);
		
		System.out.print(res);
	}
	
	/*
	 * T = O(2n + 2e) = O(n + e) = O(v + e) ; v = no. of vertices ; e = no. of edges
	 *  S = O(n + n) = O(v + v) = O(v)
	 */
	public static List<List<Integer>> bft(List<Node> G, int start) {
		
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
				if(visited[t.data] == 0) {
					visited[t.data] = 1;
					temp.add(t.data);
					queue.add(t.data);
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
