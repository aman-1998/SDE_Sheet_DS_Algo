package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import practice.dsa.sheet.part7.utility.Node;

public class Depth_First_Search {
	
	public static void main(String[] args) {
		
		int[][] G = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 1, 1, 0, 0, 0, 0, 0},
				     {0, 1, 0, 0, 1, 1, 0, 0, 0},
				     {0, 1, 0, 0, 0, 0, 1, 1, 0},
				     {0, 0, 1, 0, 0, 0, 0, 0, 1},
				     {0, 0, 1, 0, 0, 0, 0, 0, 1},
				     {0, 0, 0, 1, 0, 0, 0, 0, 1},
				     {0, 0, 0, 1, 0, 0, 0, 0, 1},
				     {0, 0, 0, 0, 1, 1, 1, 1, 0}};
		
		List<Integer> res = DFTUsingMatrix(G, 1);
		
		System.out.println(res);
		
		System.out.println("\n===============================================");
		
		List<Node> Graph = new ArrayList<>();
		
		Graph.add(null);
		
		Node node = new Node(2);
		node.next = new Node(3);
		Graph.add(node);
		
		node = new Node(1);
		node.next = new Node(4);
		node.next.next = new Node(5);
		Graph.add(node);
		
		node = new Node(1);
		node.next = new Node(6);
		node.next.next = new Node(7);
		Graph.add(node);
		
		node = new Node(2);
		node.next = new Node(8);
		Graph.add(node);
		
		node = new Node(2);
		node.next = new Node(8);
		Graph.add(node);
		
		node = new Node(3);
		node.next = new Node(8);
		Graph.add(node);
		
		node = new Node(3);
		node.next = new Node(8);
		Graph.add(node);
		
		node = new Node(4);
		node.next = new Node(5);
		node.next.next = new Node(6);
		node.next.next.next = new Node(7);
		Graph.add(node);
	
		res = DFTUsingAdjacencyList(Graph, 1);
	
		System.out.println(res);
	}
	
	/*
	 * 1. And array to keep track of the vertices which are visited and which or not
	 * 2. System stack (recursion)
	 * 
	 * T = O(v^2) ; v = no. of vertices
	 * S = O(v + v) = O(v)
	 */
	public static List<Integer> DFTUsingMatrix(int[][] G, int start) {
		
		int n = G.length;
		int[] visited = new int[n];
		
		Arrays.fill(visited, 0);
		
		List<Integer> res = new ArrayList<>();
		
		solve(G, res, visited, start);
		
		return res;
	}

	private static void solve(int[][] G, List<Integer> res, int[] visited, int start) {
		
		int n = G.length;
		
		visited[start] = 1;
		
		res.add(start);
		
		for(int i = 1; i <= n-1; i++) {
			if(G[start][i] == 1 && visited[i] == 0) {
				solve(G, res, visited, i);
			}
		}
	}
	
	/*
	 * 1. And array to keep track of the vertices which are visited and which or not
	 * 2. System stack (recursion)
	 * 
	 * T = O(v + 2e) = O(v + e) ; v = no. of vertices, e = no. of edges
	 * S = O(v + v) = O(v)
	 */
	public static List<Integer> DFTUsingAdjacencyList(List<Node> G, int start) {
		
		int n = G.size();
		int[] visited = new int[n];
		Arrays.fill(visited, 0);
		
		List<Integer> res = new ArrayList<>();
		
		solve(G, res, visited, start);
		
		return res;
	}
	
	private static void solve(List<Node> G, List<Integer> res, int[] visited, int start) {
		
		visited[start] = 1;
		
		res.add(start);
		
		Node t = G.get(start);
		
		while(t != null) {
			if(visited[t.vertex] == 0) {
				solve(G, res, visited, t.vertex);
			}
			
			t = t.next;
		}
	}
}
