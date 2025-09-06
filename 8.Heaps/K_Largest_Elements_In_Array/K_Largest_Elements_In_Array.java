package practice.dsa.sheet.part5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class K_Largest_Elements_In_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {5, 2, 4, 1, 3, 6};
		int k = 3;
		
		int[] kLargestElements = kLargestElements_Best(arr, k);
		
		Arrays.stream(kLargestElements).boxed().forEach(t -> System.out.print(t + " | "));
	}
	
	/*
	 * Better Solution : Using MaxHeap
	 * 
	 * This solution is better for larger values of k i.e., when k is close to n
	 * 
	 * T = O(n + k*log n)
	 * S = O(n)
	 */
	public static int[] kLargestElements_Better(int[] arr, int k) {
		
		int n = arr.length;
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, Comparator.reverseOrder());
		maxHeap.addAll(IntStream.of(arr).boxed().collect(Collectors.toList())); // T = O(2n)
		
		int[] output = new int[k];
		for(int i = 0; i <= k-1; i++) { // T = O(k * log n)
			output[i] = maxHeap.poll();
		}
		
		return output;
	}
	
	/*
	 * Best Solution : Using MinHeap
	 * 
	 * This solution is better for smaller values of k i.e., when k is far less than n
	 * Additionally, here we don't have to create a heap of size n. Which makes the 
	 * algorithm memory efficient.
	 * 
	 * T = O(k + n*log k)
	 * S = O(k)
	 */
	public static int[] kLargestElements_Best(int[] arr, int k) {
		
		int n = arr.length;
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i <= k-1; i++) { // T = O(k)
			list.add(arr[i]);
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
		minHeap.addAll(list); // T = O(k)
		
		for(int i = k; i <= n-1; i++) { // T = O((n-k)*log k)
			minHeap.add(arr[i]);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		int[] output = new int[k];
		for(int i = 0; i <= k-1; i++) { // T = O(k*log k)
			output[i] = minHeap.poll();
		}
		
		return output;
	}
}
