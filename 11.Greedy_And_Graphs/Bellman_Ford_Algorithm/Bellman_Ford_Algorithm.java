package practice.dsa.sheet.part9;

import java.util.Arrays;

public class Bellman_Ford_Algorithm {
	
	public static void main(String[] args) {
		
		int[][] edges = {{0,1,1}, {4,5,1}, {2,1,2}, 
				         {1,4,4}, {0,2,3}, {2,5,2}};
		
		int[] dis = singleSourcePath_BellmanFord_1(edges, 6, 0);
		
		Arrays.stream(dis).forEach(t -> System.out.print(t + " "));
		
		System.out.println("\n=====================================");
		
		int[][][] graph = {{{1,1}, {2,3}}, {{4,4}}, 
				           {{1,2}, {5,2}}, {}, {{5,1}}, {}};
		
		dis = singleSourcePath_BellmanFord_2(graph, 6, 0);
		
		Arrays.stream(dis).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * -> Bellman Ford Algo is used to find Single Source Shortest Path (like Dijkstra)
	 * 
	 * -> Dijkstra fails when edges have negative weights in case of directed graphs.
	 *    This is because there can be a negative weight cycle in that graph.
	 * 
	 * -> Bellman Ford Algo can find negative weight cycle in directed graph. 
	 *    And if there is no negative weight cycle then it can find shortest path 
	 *    to all vertices from a given source just like Dijkstra' Algo.   
	 * 
	 * -> Bellman Ford Algo is applicable only for Directed graphs.
	 * 
	 * -> Dijkstra's Algo is applicable for undirected graphs with both 
	 *    positive and negative weights. It is also applicable for Directed
	 *    graphs with positive weights.
	 *   
	 * 
	 * Input is given as edges and weights
	 * 
	 * T = O(V*E) + O(E) = O(V*E)
	 * S = O(V)
	 */
	public static int[] singleSourcePath_BellmanFord_1(int[][] edges, int n, int src) {
		
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[src] = 0;
		
		for(int i = 1; i <= n-1; i++) {
			for(int[] edge : edges) {
				int v1 = edge[0];
				int v2 = edge[1];
				int edgeLength = edge[2];
				
				if(dis[v1] != Integer.MAX_VALUE) {
					if(dis[v1] + edgeLength < dis[v2]) {
						dis[v2] = dis[v1] + edgeLength;
					}
				}
			}
		}
		
		// check for negative weight cycle
		for(int[] edge : edges) {
			int v1 = edge[0];
			int v2 = edge[1];
			int edgeLength = edge[2];
			
			if(dis[v1] != Integer.MAX_VALUE) {
				if(dis[v1] + edgeLength < dis[v2]) {
					return new int[0];
				}
			}
		}
		
		return dis;
	}
	
	/*
	 * -> Bellman Ford Algo is used to find Single Source Shortest Path (like Dijkstra)
	 * 
	 * -> Dijkstra fails when edges have negative weights in case of directed graphs.
	 *    This is because there can be a negative weight cycle in that graph.
	 * 
	 * -> Bellman Ford Algo can find negative weight cycle in directed graph. 
	 *    And if there is no negative weight cycle then it can find shortest path 
	 *    to all vertices from a given source just like Dijkstra' Algo.   
	 * 
	 * -> Bellman Ford Algo is applicable only for Directed graphs.
	 * 
	 * -> Dijkstra's Algo is applicable for undirected graphs with both 
	 *    positive and negative weights. It is also applicable for Directed
	 *    graphs with positive weights.
	 *   
	 * 
	 * Input is given as adjacency list
	 * 
	 * T = O(V*E) + O(E) = O(V*E)
	 * S = O(V)
	 */
	public static int[] singleSourcePath_BellmanFord_2(int[][][] adjacencyList, int n, int src) {
		
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[src] = 0;
		
		for(int i = 1; i <= n-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				int[][] adjacentVertices = adjacencyList[j];
				for(int k = 0; k <= adjacentVertices.length-1; k++) {
					int v1 = j;
					int v2 = adjacentVertices[k][0];
					int edgeLength = adjacentVertices[k][1];
					
					if(dis[v1] != Integer.MAX_VALUE) {
						if(dis[v1] + edgeLength < dis[v2]) {
							dis[v2] = dis[v1] + edgeLength;
						}
					}
				}
			}
		}
		
		// Check for negative weight cycle
		for(int j = 0; j <= n-1; j++) {
			int[][] adjacentVertices = adjacencyList[j];
			for(int k = 0; k <= adjacentVertices.length-1; k++) {
				int v1 = j;
				int v2 = adjacentVertices[k][0];
				int edgeLength = adjacentVertices[k][1];
				
				if(dis[v1] != Integer.MAX_VALUE) {
					if(dis[v1] + edgeLength < dis[v2]) {
						return new int[0];
					}
				}
			}
		}
		
		return dis;
	}
}
