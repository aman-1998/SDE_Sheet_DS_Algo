package practice.dsa.sheet.part7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Check_Bipartite {
	
	public static void main(String[] args) {
		
		int[][] graph = {{1, 2, 3},
						 {0, 2},
						 {0, 1, 3},
						 {0, 2}};
		
		boolean check = isBipartite_using_DFS(graph);
		
		System.out.println(check);
	}
	
	/*
	 * Points to be noted:
	 * --------------------
	 * If a Graph doesn't have cycle it is always bipartite
	 * If a graph has cycle the it may or may not be bipartite.
	 * If length of the cycle in graph is odd then it cannot be bipartite.
	 * If length of the cycle in graph is even then it is a bipartite graph.
	 * 
	 * T = O(V) + O(V+E) = O(V+E)
	 * S = O(v)
	 */
	public static boolean isBipartite_using_BFS(int[][] adjacencyList) {
		
		int n = adjacencyList.length;
		
		int[] visited = new int[n];
		Arrays.fill(visited, -1);
		
		/*
		 * Graph may or may not be connected
		 */
		for(int i = 0; i <= n-1; i++) {
			if(visited[i] == -1) {
				boolean test = bfs(adjacencyList, visited, i);
				if(!test) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean bfs(int[][] adjacencyList, int[] visited, int start) {
        
		// Two colors 0/1
		visited[start] = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			
			int[] adjacentVertices = adjacencyList[x];
			
			for(int i = 0; i <= adjacentVertices.length-1; i++) {
				if(visited[adjacentVertices[i]] == -1) {
					queue.add(adjacentVertices[i]);
					if(visited[x] == 0) {
						visited[adjacentVertices[i]] = 1;
					} else {
						visited[adjacentVertices[i]] = 0;
					}
				} else {
					if(visited[adjacentVertices[i]] == visited[x]) {
						return false;
					}
				}
			}
		}
		
		return true;
    }
	
	/*
	 * T = O(V) + O(V+E)
	 * S = O(V)
	 */
	public static boolean isBipartite_using_DFS(int[][] adjacencyList) {
		
		int n = adjacencyList.length;
		
		int[] visited = new int[n];
		Arrays.fill(visited, -1);
		
		/*
		 * Graph may or may not be connected
		 */
		for(int i = 0; i <= n-1; i++) {
			if(visited[i] == -1) {
				boolean test = dfs(adjacencyList, visited, i, 0);
				if(!test) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean dfs(int[][] adjacencyList, int[] visited, int start, int color) {
		
		visited[start] = color;
		
		int[] adjacentVertices = adjacencyList[start];
		
		for(int i = 0; i <= adjacentVertices.length-1; i++) {
			if(visited[adjacentVertices[i]] == -1) {
				boolean check = dfs(adjacencyList, visited, adjacentVertices[i], 1-color);
				if(!check) {
					return false;
				}
			} else {
				if(visited[adjacentVertices[i]] == color) {
					return false;
				}
			}
		}
		
		return true;
	}
}
