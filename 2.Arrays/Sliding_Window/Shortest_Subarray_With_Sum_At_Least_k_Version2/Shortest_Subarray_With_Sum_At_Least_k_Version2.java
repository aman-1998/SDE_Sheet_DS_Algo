package algorithms;

import java.util.Deque;
import java.util.LinkedList;

class Pair1 {
	
	long cumulativeSum;
	int index;
	
	public Pair1(long cumulativeSum, int index) {
		this.cumulativeSum = cumulativeSum;
		this.index = index;
	}
}

// Here, elements of the array can be either positive or negative
public class Shortest_Subarray_With_Sum_At_Least_k_Version2 {
	
	public static void main(String[] args) {
		
		//int[] arr = {2, 3, 1, 2, 4, 3};
		//int minLength = shortest_subarray_with_sum_at_least_k(arr, 7);
		
		//int[] arr = {1, 4, 45, 6, 0, 19};
		//int minLength = shortest_subarray_with_sum_at_least_k(arr, 51);
		
		int[] arr = {2, 7, 3, -8, 4, 10};
		//int minLength = shortest_subarray_with_sum_at_least_k_BF(arr, 12);
		int minLength = shortest_subarray_with_sum_at_least_k(arr, 12);
		
		System.out.println(minLength);
	}
	
	/*
	 * Brute Force : Find all the sub-arrays whose sum is greater than or equal to k. Out of those sub-arrays find the 
	 * 				 one with min length. Return that length.
	 * 
	 * T = O(n^2)
	 * S= O(1)
	 * 
	 */
	private static int shortest_subarray_with_sum_at_least_k_BF(int[] arr, int k) {
		
		int n = arr.length;
		int minCount = Integer.MAX_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			int count = 0;
			int sum = 0;
			
			for(int j = i; j <= n-1; j++) {
				sum = sum + arr[j];
				count++;
				if(sum >= k) {
					if(count < minCount) {
						minCount = count;
					}
					break;
				}
			}
		}
		
		return minCount;
	}
	
	/*
	 * Best Solution : Using monotonic double-ended-queue
	 * 
	 * T = O(2n) = O(n)
	 * S = O(n)
	 * 
	 */
	private static int shortest_subarray_with_sum_at_least_k(int[] arr, int k) {
		
		int n = arr.length;
		Deque<Pair1> deque = new LinkedList<>();
		int minLength = Integer.MAX_VALUE;
		long sum = 0;
		
		for(int i = 0; i <= n-1; i++) {
			
			sum = sum + arr[i];
			if(sum >= k) {
				int count = i + 1;
				if(count < minLength) {
					minLength = count;
				}
			}
			
			Pair1 discarded = null;
			while(!deque.isEmpty() && sum - deque.getFirst().cumulativeSum >= k) {
				discarded = deque.getFirst();
				deque.removeFirst();
			}
			
			if(discarded != null) {
				int count = i - discarded.index;
				if(count < minLength) {
					minLength = count;
				}
			}
			
			while(!deque.isEmpty() && deque.getLast().cumulativeSum >= sum) {
				deque.removeLast();
			}
			deque.add(new Pair1(sum, i));
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
