package practice.dsa.sheet.part9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Single_Source_Shortest_Path_For_DAG {
	
	public static void main(String[] args) {
		
		int[][][] graph = {{{5,1}}, {{5,3}}, {{5,2}}, 
						   {}, {{3,2}, {6,3}}, {{7,4}, {8,2}}, 
						   {}, {{3,4}, {4,1}}, {{6,1}}};
		
		int source = 2;
		
		int[] dis = shortestPath(graph, source);
		
		Arrays.stream(dis).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * First we find topological sorted order. Because, that is the order
	 * in which we can reach those vertices. Without visiting earlier
	 * vertices, we can not reach later vertices. So, we have to follow 
	 * topological order.
	 * 
	 * T = O(V+E) + O(V) + O(V+E) => T = O(V+E)
	 * s = O(V)
	 */
	public static int[] shortestPath(int[][][] adjacencyList, int source) {
		
		int n = adjacencyList.length;
		
		int[] topoSort = topologicalSort(adjacencyList); // O(V+E)
		
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[source] = 0;
		
		int sourceIndex = 0;
		for(int i = 0; i <= topoSort.length-1; i++) {
			if(topoSort[i] == source) {
				sourceIndex = i;
				break;
			}
		}
		
		for(int i = sourceIndex; i <= topoSort.length-1; i++) { // O(V+E)
			int[][] adjacentVertices = adjacencyList[topoSort[i]];
			
			for(int[] vertex : adjacentVertices) {
				if(dis[topoSort[i]] + vertex[1] < dis[vertex[0]]) {
					dis[vertex[0]] = dis[topoSort[i]] + vertex[1];
				}
			}
		}
		
		for(int i = 0; i <= n-1; i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				dis[i] = -1; // unreachable from source
			}
		}
		
		return dis;
	}

	private static int[] topologicalSort(int[][][] adjacencyList) {
		
		int n = adjacencyList.length;
		
		int[] indegree = new int[n];
		Arrays.fill(indegree, 0);
		
		for(int i = 0; i <= n-1; i++) {
			int[][] adjacentVertices = adjacencyList[i];
			for(int[] vertex : adjacentVertices) {
				indegree[vertex[0]]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i <= n-1; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		int[] topoSort = new int[n];
		int x = 0;
		
		while(!queue.isEmpty()) {
			
			int popped = queue.poll();
			indegree[popped] = -1;
			
			topoSort[x++] = popped;
			
			int[][] adjacentVertices = adjacencyList[popped];
			
			for(int[] vertex : adjacentVertices) {
				indegree[vertex[0]]--;
				if(indegree[vertex[0]] == 0) {
					queue.add(vertex[0]);
				}
			}
		}
		
		return topoSort;
	}
}
