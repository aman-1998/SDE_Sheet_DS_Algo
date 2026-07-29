package practice.dsa.sheet.part9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Single_Source_Shortest_Path_For_UG_With_Unit_Weight {
	
	public static void main(String[] args) {
		
		/*       
		 * 				1
		 *       (1)---------(4)
		 *     1 /|			  |\
		 *      / |   		  | \
		 *   (0)  |	1		1 |  \ 1
		 *     \  |			  |   \
		 *    1 \ |			  |    \
		 *       \|           |     \
		 *      (2)----------(3)----(6)
		 *              1         1
		 */
		
		int[][] graph = {{1,2}, {0,2,4}, {0,1,3}, {2,4,5}, {1,3,5}, {3,4}};
		int source = 0;
		
		int[] dis = shortestPath(graph, source);
		
		IntStream.of(dis).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * For an undirected graph, using queue we can solve this problem in 
	 * optimal time. No need of Dijkstra's algorithm to solve this because 
	 * every weight is same. So, every edge will be relaxed only once.
	 * 
	 * T = O(V+E)
	 * S = O(V)
	 */
	public static int[] shortestPath(int[][] adjacencyList, int source) {
		
		int n = adjacencyList.length;
		
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(source, 0));
		dis[source] = 0;
		
		while(!queue.isEmpty()) {
			
			List<Integer> popped = queue.poll();
			
			int[] adjacentVertices = adjacencyList[popped.get(0)];
			
			for(int i = 0; i <= adjacentVertices.length-1; i++) {
				if(popped.get(1) + 1 < dis[adjacentVertices[i]]) {
					dis[adjacentVertices[i]] = popped.get(1) + 1;
					queue.add(Arrays.asList(adjacentVertices[i], dis[adjacentVertices[i]]));
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
