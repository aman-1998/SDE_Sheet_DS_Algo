package practice.dsa.sheet.part9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cheapest_Flight_With_K_Stops {
	
	public static void main(String[] args) {
		
		int[][] flights = {{0,1,5}, {0,3,2}, {1,2,5}, {1,4,1}, {3,1,2}, {4,2,1}};
		int n = 5;
		int src = 0;
		int dst = 2;
		int k = 2;
		
		int minPrice = findCheapestPrice(n, flights, src, dst, k);
		
		System.out.println(minPrice);
	}
	
	/*
	 * T should be O(V*E) but O(k*E) is a tighter bound.
	 * This problem artificially caps the number of allowed relaxation 
	 * rounds at k+1 (the stops constraint), regardless of how large V is. 
	 * So even if the graph is huge (V=1000), if k=3, the algorithm only 
	 * ever expands 4 levels deep before the stops >= k+1 pruning kicks in 
	 * and stops further expansion — it physically cannot do V rounds of 
	 * relaxation, only k+1 rounds.
	 * 
	 * 
	 * T = O(k*E)
	 * S = O(2*E) + O(V)
	 */
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
		List<List<List<Integer>>> adjacencyList = new ArrayList<>();
		for(int i = 0; i <= n-1; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		
		for(int[] arr : flights) {
			List<List<Integer>> list = adjacencyList.get(arr[0]);
			list.add(Arrays.asList(arr[1], arr[2])); // (vertex, price)
		}
		
		int[] priceArr = new int[n]; // similar to distance array
		Arrays.fill(priceArr, Integer.MAX_VALUE);
		priceArr[src] = 0;
		
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(src, 0, 0)); // (node, price, stops)
		
		int minPrice = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			
			List<Integer> popped = queue.poll();
			int node = popped.get(0);
			int price = popped.get(1);
			int stops = popped.get(2);
			
			if(node == dst && stops <= k+1) {
				if(price < minPrice) {
					minPrice = price;
				}
				continue;
			}
			
			if(node != dst && stops >= k+1) {
				continue;
			}
			
			List<List<Integer>> adjacentVertices = adjacencyList.get(node);
			for(List<Integer> vertex : adjacentVertices) {
				if(price + vertex.get(1) < priceArr[vertex.get(0)]) {
					priceArr[vertex.get(0)] = price + vertex.get(1);
					
					queue.add(Arrays.asList(vertex.get(0), 
							priceArr[vertex.get(0)], 
											stops+1));
				}
			}
		}
		
		return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }
}
