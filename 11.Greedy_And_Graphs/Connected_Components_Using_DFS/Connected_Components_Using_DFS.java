package practice.dsa.sheet.part7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.dsa.sheet.part7.utility.Node;

public class Connected_Components_Using_DFS {
	
	public static void main(String[] args) {
		
		List<Node> G = new ArrayList<>();
		
		G.add(null);
		
		Node node = new Node(2);
		node.next = new Node(4);
		G.add(node);
		
		node = new Node(1);
		G.add(node);
		
		node = new Node(5);
		G.add(node);
		
		node = new Node(1);
		G.add(node);
		
		node = new Node(3);
		G.add(node);
		
		G.add(null);
		
		int count = noOfConnectedComponents(G);
		
		System.out.println(count);
	}
	
	/*
	 * T = O(n^2 + n*e)
	 * S = O(n)
	 */
	public static int noOfConnectedComponents(List<Node> G) {
		
		int n = G.size();
		
		int[] visited = new int[n];
		
		Arrays.fill(visited, 0); // O(n)
		
		int count = 0;
		for(int i = 1; i <= n-1; i++) { // O(n)
			if(visited[i] == 0) {
				DFTUsingAdjacencyList(G, visited, i); // O(n + e)
				count++;
			}
		}
		
		return count;
	}
	
	private static void DFTUsingAdjacencyList(List<Node> G, int[] visited, int start) {
		
		visited[start] = 1;
		
		Node t = G.get(start);
		
		while(t != null) {
			if(visited[t.vertex] == 0) {
				DFTUsingAdjacencyList(G, visited, t.vertex);
			}
			
			t = t.next;
		}
	}
}
