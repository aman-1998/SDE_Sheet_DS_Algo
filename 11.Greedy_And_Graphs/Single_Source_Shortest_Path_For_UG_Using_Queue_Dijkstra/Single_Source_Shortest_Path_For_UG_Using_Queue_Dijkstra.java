package practice.dsa.sheet.part9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Single_Source_Shortest_Path_For_UG_Using_Queue_Dijkstra {
	
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
		
		int[] dis = shortestPath_better_2nd(graph, source);
		
		IntStream.of(dis).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * Here, for an undirected graph, we are using queue to find shortest path 
	 * from a source to all vertices. This is not best way to do it. We can use 
	 * priorityQueue or Set to achieve better time complexity.
	 * 
	 * Unlike, classic dijkstra's algo, here we are relaxing an edge multiple
	 * times. So, time complexity degrades.
	 * 
	 * 
	 * T = O(V * k*E) ; k = constant
	 *   = O(V*E)
	 *   
	 * S = O(V)
	 */
	private static int[] shortestPath_1st(int[][][] graph, int source) {
		
		int n = graph.length;
		
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(source, 0));
		dis[source] = 0;
		
		while(!queue.isEmpty()) {
			
			List<Integer> popped = queue.poll();
			
			int[][] adjacentVertices = graph[popped.get(0)];
			
			for(int[] vertex : adjacentVertices) {
				if(popped.get(1) + vertex[1] < dis[vertex[0]]) {
					dis[vertex[0]] = popped.get(1) + vertex[1];
					
					queue.add(Arrays.asList(vertex[0], dis[vertex[0]]));
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
	
	/*
	 * This version will run noticeably faster than the first because the stale check prunes a lot of dead work
	 * but it doesn't change the theoretical worst-case guarantee.
	 * 
	 * T = O(V * k*E) ; k = constant
	 *   = O(V*E)
	 *   
	 * S = O(V)
	 */
	private static int[] shortestPath_better_2nd(int[][][] graph, int source) {
		
		int n = graph.length;
		
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(source, 0));
		dis[source] = 0;
		
		while(!queue.isEmpty()) {
			
			List<Integer> popped = queue.poll();
			
			if(dis[popped.get(0)] != popped.get(1)) {
				continue;
			}
			
			int[][] adjacentVertices = graph[popped.get(0)];
			
			for(int[] vertex : adjacentVertices) {
				if(popped.get(1) + vertex[1] < dis[vertex[0]]) {
					dis[vertex[0]] = popped.get(1) + vertex[1];
					
					queue.add(Arrays.asList(vertex[0], dis[vertex[0]]));
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
