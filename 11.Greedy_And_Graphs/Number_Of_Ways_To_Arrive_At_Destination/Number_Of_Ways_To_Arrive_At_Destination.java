package practice.dsa.sheet.part9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Number_Of_Ways_To_Arrive_At_Destination {
	
	public static void main(String[] args) {
		
//		int[][] roads = {{0,1,1}, {1,5,2}, {5,8,1}, {0,2,2}, {2,5,1},
//				         {0,3,1}, {3,5,2}, {3,7,3}, {7,8,1}, {0,4,2},
//				         {4,6,1}, {6,8,1}, {3,6,2}};
//		
//		int n = 9;
		
		int[][] roads = {{0,6,7}, {0,1,2}, {1,2,3}, {1,3,3},
						 {6,3,3}, {3,5,1}, {6,5,1}, {2,5,1},
						 {0,4,5},{4,6,2}};
		
		int n = 7;
		
		int noOfPaths = countPaths(n, roads);
		
		System.out.println(noOfPaths);
	}
	
	/*
	 * T = O(E*log V) ==>  same as Dijkstra
	 * S = O(2*E) + O(2V)
	 */
	public static int countPaths(int n, int[][] roads) {
		
		int src = 0;
		int dst = n-1;
        
		List<List<List<Integer>>> adjacencyList = new ArrayList<>();
		
		for(int i = 0; i <= n-1; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		
		for(int[] arr : roads) {
			adjacencyList.get(arr[0]).add(Arrays.asList(arr[1], arr[2]));
			adjacencyList.get(arr[1]).add(Arrays.asList(arr[0], arr[2]));
		}
		
		int[] ways = new int[n];
		Arrays.fill(ways, 0);
		ways[src] = 1;
		
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<List<Integer>>(Comparator.comparing((List<Integer> pair) -> pair.get(1)));
		minHeap.add(Arrays.asList(src, 0));
		
		while(!minHeap.isEmpty()) {
			
			List<Integer> popped = minHeap.poll();
			int node = popped.get(0);
			int dis = popped.get(1);
			
			if(dis != dist[node]) {
				continue;
			}
			
			List<List<Integer>> adjacentVertices = adjacencyList.get(node);
			for(List<Integer> vertex : adjacentVertices) {
				if(dis + vertex.get(1) < dist[vertex.get(0)]) {
					dist[vertex.get(0)] = dis + vertex.get(1);
					minHeap.add(Arrays.asList(vertex.get(0), dist[vertex.get(0)]));
					ways[vertex.get(0)] = ways[node];
					
				} else if(dis + vertex.get(1) == dist[vertex.get(0)]) {
					ways[vertex.get(0)] = ways[vertex.get(0)] + ways[node];
				}
			} 
		}
		
		return ways[dst];
    } 
}
