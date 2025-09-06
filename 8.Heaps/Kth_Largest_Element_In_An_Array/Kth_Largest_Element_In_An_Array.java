package practice.dsa.sheet.part5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Kth_Largest_Element_In_An_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6}; // 1, 2, 2, 3, 3, 4, 5, 5, 6
		
		int k = 4;
		
		int kthElement = findKthLargest(arr, k);
		
		System.out.println(kthElement);
	}
	
	/*
	 * T = O(n + k *log n)
	 * S = O(n)
	 */
	public static int findKthLargest(int[] arr, int k) {
        
		int n = arr.length;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n, Comparator.reverseOrder());
		maxHeap.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList())); // T = O(2n)
		
		for(int i = 1; i <= k-1; i++) { // T = O(k * log n)
			int max = maxHeap.poll();
		}
		
		return maxHeap.peek();
    }
}
