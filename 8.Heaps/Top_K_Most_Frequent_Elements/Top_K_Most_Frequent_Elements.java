package practice.dsa.sheet.part5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Top_K_Most_Frequent_Elements {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Better approach : using MaxHeap
	 * 
	 * This solution is better for larger values of k i.e., when k is close to m
	 * 
	 * T = O(n + (m+k)*log m) ; m = no. of unique elements
	 * S = O(2m) ; freqMap + heap
	 */
	public static int[] topKFrequent_Better(int[] arr, int k) {
		
		int n = arr.length;
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		for(int i = 0; i <= n-1; i++) { // T = O(n)
			Integer freq = freqMap.get(arr[i]);
			if(freq == null) {
				freqMap.put(arr[i], 1);
			} else {
				freqMap.put(arr[i], freq + 1);
			}
		}
        
		//Map<Integer, Integer> freqMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(t -> t, Collectors.toList()))
		//						  			  .entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().size()));
		
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparing((Map.Entry<Integer, Integer> entry) -> entry.getValue()).reversed());
		
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) { // T = O(m*log m) ; m = no. of unique elements
			maxHeap.add(entry);
		}
		
		int[] output = new int[k];
		for(int i = 0; i <= k-1; i++) { // T = O(k*log m)
			output[i] = maxHeap.poll().getKey();
		}
		
		return output;
    }
	
	/*
	 * Best approach : Using minHeap
	 * 
	 * This solution is better for smaller values of k i.e., when k is far less than m
	 * Additionally, here we don't have to create a heap of size m. Which makes the 
	 * algorithm memory efficient.
	 * 
	 * T = O(n + (m+k)*log k) ;  m = no. of unique elements
	 * S = O(m + k) ; freqMap + heap
	 */
	public int[] topKFrequent_Best(int[] arr, int k) {
		
		int n = arr.length;
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		for(int i = 0; i <= n-1; i++) { // T = O(n)
			Integer freq = freqMap.get(arr[i]);
			if(freq == null) {
				freqMap.put(arr[i], 1);
			} else {
				freqMap.put(arr[i], freq + 1);
			}
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, Comparator.comparing(entry -> entry.getValue()));
		
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) { // T = O(m * 2*log k)
			minHeap.add(entry);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		int[] output = new int[k];
		for(int i = 0; i <= k-1; i++) { // T = O(k*log k)
			output[i] = minHeap.poll().getKey();
		}
		
		return output;
	}
}
