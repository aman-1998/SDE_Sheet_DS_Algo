package practice.dsa.sheet.part9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Floyd_Warshall_Algorithm {
	
	public static void main(String[] args) {
		
		int[][] graph = {{0, 6, 2, 4, Integer.MAX_VALUE},
				         {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
				         {Integer.MAX_VALUE, 3, 0, Integer.MAX_VALUE, 1},
				         {Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
				         {Integer.MAX_VALUE, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}};
		
		int[][] dis = allPairShortestPath_1(graph);
		
		for(int[] arr : dis) {
			for(int i = 0; i <= arr.length-1; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n==============================");
		
		List<List<List<Integer>>> adjacencyList = new ArrayList<>();
		
		adjacencyList.add(Arrays.asList(Arrays.asList(1,6), 
										Arrays.asList(2,2), 
										Arrays.asList(3,4)));
		
		adjacencyList.add(null);
		
		adjacencyList.add(Arrays.asList(Arrays.asList(1,3), 
										Arrays.asList(4,1)));
		
		adjacencyList.add(Arrays.asList(Arrays.asList(1,1)));
		
		adjacencyList.add(Arrays.asList(Arrays.asList(1,1)));
		
		dis = allPairShortestPath_2(adjacencyList);
		
		for(int[] arr : dis) {
			for(int i = 0; i <= arr.length-1; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 * T = O(V^3)
	 * S = O(1)
	 * 
	 */
	public static int[][] allPairShortestPath_1(int[][] adjacencyMatrix) {
		
		int n = adjacencyMatrix.length;
		
		for(int via = 0; via <= n-1; via++) {
			for(int i = 0; i <= n-1; i++) {
				for(int j = 0; j <= n-1; j++) {
					
					if(adjacencyMatrix[i][via] == Integer.MAX_VALUE
						|| adjacencyMatrix[via][j] == Integer.MAX_VALUE	) {
						
						continue;
					}
					
					int cost = adjacencyMatrix[i][via] +
							   adjacencyMatrix[via][j];
					
					if(cost < adjacencyMatrix[i][j]) {
						
						adjacencyMatrix[i][j] = cost;
						if(i == j && cost < 0) { // negative weight cycle
							return new int[0][0];
						}
					}
				}
			}
		}
		
		return adjacencyMatrix;
	}
	
	/*
	 * T = O(V^2) + O(V*E) + O(V^3)
	 * 	 = O(V*E) + O(V^3)  [E = V^2 for dense graphs]
	 * 	 = O(V^3)
	 * 
	 * S = O(V^2)
	 */
	public static int[][] allPairShortestPath_2(List<List<List<Integer>>> adjacencyList) {
		
		int n = adjacencyList.size();
		
		int[][] dis = new int[n][n];
		for(int i = 0; i <= n-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				dis[i][j] = Integer.MAX_VALUE;
				if(i == j) {
					dis[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i <= n-1; i++) {
			List<List<Integer>> adjacentVertices = adjacencyList.get(i);
			
			if(adjacentVertices == null ) {
				continue;
			}
			
			for(List<Integer> vertex : adjacentVertices) {
				dis[i][vertex.get(0)] = vertex.get(1);
			}
		}
		
		for(int via = 0; via <= n-1; via++) {
			for(int i = 0; i <= n-1; i++) {
				for(int j = 0; j <= n-1; j++) {
					
					if(dis[i][via] == Integer.MAX_VALUE
						|| dis[via][j] == Integer.MAX_VALUE	) {
						
						continue;
					}
					
					int cost = dis[i][via] + dis[via][j];
					
					if(cost < dis[i][j]) {
						
						dis[i][j] = cost;
						if(i == j && cost < 0) { // negative weight cycle
							return new int[0][0];
						}
					}
				}
			}
		}
		
		return dis;
	}
}
