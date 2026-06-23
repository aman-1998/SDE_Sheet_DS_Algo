package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.dsa.sheet.part7.utility.Node;

public class Topological_Sorting {
	
	public static void main(String[] args) {
		
		int[][] G = {{0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 0, 0, 0, 0, 0},
				     {0, 0, 0, 0, 1, 0, 1},
				     {0, 0, 1, 0, 0, 0, 0},
				     {0, 1, 0, 0, 0, 0, 0},
				     {0, 0, 1, 0, 0, 0, 0},
				     {0, 1, 0, 0, 1, 0, 0}};
		
		List<Integer> res = topologicalSorting_matrix(G);
		
		System.out.println(res);
		
		System.out.println("\n===========================================");
		
		List<Node> Graph = new ArrayList<>();
		
		Graph.add(null);
		
		Graph.add(null);
		
		Node node = new Node(4);
		node.next = new Node(6);
		Graph.add(node);
		
		node = new Node(2);
		Graph.add(node);
		
		node = new Node(1);
		Graph.add(node);
		
		node = new Node(2);
		Graph.add(node);
		
		node = new Node(4);
		node.next = new Node(1);
		Graph.add(node);
		
		res = topologicalSorting_AdjacencyList(Graph);
		
		System.out.println(res);
	}
	
	/*
	 * T = O(v^2)
	 * S = O(v + v) = O(v)
	 */
	public static List<Integer> topologicalSorting_matrix(int[][] G) {
		 
		int n = G.length;
		int[] indegree = new int[n];
		Arrays.fill(indegree, 0);
		
		Queue<Integer> queue = new LinkedList<>();
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = 1; i <= n-1; i++) {
			for(int j = 1; j <= n-1; j++) {
				if(G[j][i] == 1) {
					indegree[i]++;
				}
			}
			
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int popped = queue.poll();
			indegree[popped] = -1;
			res.add(popped);
			
			for(int i = 1; i <= n-1; i++) {
				if(G[popped][i] == 1 && indegree[i] > 0) {
					indegree[i]--;
					if(indegree[i] == 0) {
						queue.add(i);
					}
				}
			}
		}
		
		return res;
	}
	
	/*
	 * T = O(v + e)
	 * S = O(v + v) = O(v)
	 */
	public static List<Integer> topologicalSorting_AdjacencyList(List<Node> G) {
		 
		int n = G.size();
		int[] indegree = new int[n];
		Arrays.fill(indegree, 0);
		
		Queue<Integer> queue = new LinkedList<>();
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = 1; i <= n-1; i++) {
			Node t = G.get(i);
			while(t != null) {
				indegree[t.vertex]++;
				t = t.next;
			}
		}
		
		for(int i = 1; i <= n-1; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int popped = queue.poll();
			indegree[popped] = -1;
			res.add(popped);
			
			Node t = G.get(popped);
			
			while(t != null) {
				indegree[t.vertex]--;
				if(indegree[t.vertex] == 0) {
					queue.add(t.vertex);
				}
				
				t = t.next;
			}
		}
		
		return res;
	}
}
