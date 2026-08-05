package practice.dsa.sheet.part9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Network_Delay_Time {
	
	public static void main(String[] args) {
		
		int[][] times = {{0,1,2}, {0,2,1}, {1,3,2}, {1,2,1},
						 {3,5,3}, {3,4,2}, {2,4,3}, {4,5,1}};
		
		int n = 6;
		
		int src = 0;
		
		int minTime = networkDelayTime(times, n, src);
		
		System.out.println(minTime);
	}
	
	/*
	 * T = O(E*log V) ==> Same as Dijkstra
	 * S = O(2*E) + O(V)
	 */
	public static int networkDelayTime(int[][] times, int n, int src) {
        
		List<List<List<Integer>>> adjacencyList = new ArrayList<>();
		
		for(int i = 0; i <= n-1; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		
		for(int[] arr : times) {
			adjacencyList.get(arr[0]).add(Arrays.asList(arr[1], arr[2]));
		}
		
		int[] disArr = new int[n];
		Arrays.fill(disArr, Integer.MAX_VALUE);
		disArr[src] = 0;
		
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparing((List<Integer> pair) -> pair.get(1)));
		minHeap.add(Arrays.asList(src, 0));
		
		int max = -1;
		Set<Integer> set = new HashSet<>();
		
		while(!minHeap.isEmpty()) {
			
			List<Integer> popped = minHeap.poll();
			int node = popped.get(0);
			int dis = popped.get(1);
			
			set.add(node);
			
			if(disArr[node] > max) {
                max = disArr[node];
            }
			
			List<List<Integer>> adjacentVertices = adjacencyList.get(node);
			for(List<Integer> vertex : adjacentVertices) {
				if(dis + vertex.get(1) < disArr[vertex.get(0)]) {
					disArr[vertex.get(0)] = dis + vertex.get(1);
					minHeap.add(Arrays.asList(vertex.get(0), disArr[vertex.get(0)]));
				}
			}
		}
		
//		int max = -1;
//		for(int i = 0; i <= n-1; i++) {
//			if(disArr[i] > max) {
//				max = disArr[i];
//			}
//		}
//		
//		return max == Integer.MAX_VALUE ? -1 : max;
		
		return set.size() == n ? max : -1;
    }
}
