package practice.dsa.sheet.part9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class Single_Source_Shortest_Path_For_UG_Using_PriorityQueue_Dijkstra {
	
	public static void main(String[] args) {
		
		/*       
		 * 				2
		 *       (1)---------(4)
		 *     3 /|			  |\
		 *      / |   		  | \
		 *   (0)  |	1		2 |  \ 1
		 *     \  |			  |   \
		 *    5 \ |			  |    \
		 *       \|           |     \
		 *      (2)----------(3)----(6)
		 *              4         3
		 */
		
		int[][][] graph = {{{1,3}, {2,5}}, 
						   {{0,3}, {2,1}, {4,2}},
						   {{0,5}, {1,1}, {3,4}},
						   {{2,4}, {4,2}, {5,3}},
						   {{1,2}, {3,2}, {5,1}},
						   {{3,3}, {4,1}}};
		
		int source = 0;
		
		int[] dis = shortestPath(graph, source);
		
		IntStream.of(dis).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * Dijkstra's algorithm using PriorityQueue
	 * 
	 * Dijkstra's algorithm works for even Directed graphs the only 
	 * condition is that the edges should have positive weight.
	 * 
	 * T = O(V + E*log V)
	 * S = O(V)
	 */
	private static int[] shortestPath(int[][][] graph, int source) {
		
		int n = graph.length;
		
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparing((List<Integer> list) -> list.get(1)));
		minHeap.add(Arrays.asList(source, 0));
		dis[source] = 0;
		
		while(!minHeap.isEmpty()) {
			
			List<Integer> popped = minHeap.poll();
			
			// Once a pair is out from minHeap then that vertex is relaxed
			// Next time if the same vertex is popped, we will discard
			// So, each vertex is relaxed only once.
			if(dis[popped.get(0)] != popped.get(1)) { 
				continue;
			}
			
			int[][] adjacentVertices = graph[popped.get(0)];
			
			for(int[] vertex : adjacentVertices) {
				if(popped.get(1) + vertex[1] < dis[vertex[0]]) {
					dis[vertex[0]] = popped.get(1) + vertex[1];
					
					minHeap.add(Arrays.asList(vertex[0], dis[vertex[0]]));
				}
			}
		}
		
		for(int i = 0; i <= n-1; i++) {
			if(dis[i] == Integer.MAX_VALUE) {
				dis[i] = -1; // if some vertices are not connected. -1 = unreachable
			}
		}
		
		return dis;
	}
	
}
