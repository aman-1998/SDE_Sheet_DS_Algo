package practice.dsa.sheet.part5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class K_Closest_Points_To_Origin {
	
	public static void main(String[] args) {
		
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int k = 2;
		
		int[][] output = kClosest(points, k);
		
		Arrays.stream(output).forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
		
	}
	
	/*
	 * Best Solution : Using MaxHeap
	 * 
	 * T = O(n + k + m*log k) ; m = no. of unique points
	 * S = O(m + k) ; distanceMap + heapSize
	 */
	public static int[][] kClosest(int[][] points, int k) {
        
		int n = points.length;
		Map<int[], Double> distanceMap = new HashMap<>();
		
		for(int i = 0; i <= n-1; i ++) { // T = O(n)
			Double distance = distanceMap.get(points[i]);
			if(distance == null) {
				distanceMap.put(points[i], Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]));
			}
		}
		
		PriorityQueue<Map.Entry<int[], Double>> maxHeap = new PriorityQueue<>(Comparator.comparing((Map.Entry<int[], Double> entry) -> entry.getValue()).reversed());
		
		for(Map.Entry<int[], Double> entry : distanceMap.entrySet()) { // T = O(m*log k) ; m = no. of unique points
			maxHeap.add(entry);
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		//int[][] output = new int[k][2];
		//for(int i = 0; i <= k-1; i++) { // T = O(k*log k)
		//	output[i] = maxHeap.poll().getKey();
		//}
		
		int[][] output = new int[k][2];
		int i = 0;
		for(Map.Entry<int[], Double> entry : maxHeap) { // T = O(k)
			output[i] = entry.getKey();
			i++;
		}
		
		return output;
    }
}
