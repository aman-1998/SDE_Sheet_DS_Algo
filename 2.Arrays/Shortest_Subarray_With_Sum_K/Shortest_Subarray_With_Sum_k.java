package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Shortest_Subarray_With_Sum_k {
	public static void main(String[] args) {
		
		//int[] arr = {7, 4, -2, 1, -3};
		//int minLength = shortest_subbarray_with_sum_k_buteForce(arr, 7);
		
		//int[] arr = {1, -1, 7, 3, 4, 2, -5, -4, 3, 2, 5};
		//int minLength = shortest_subbarray_with_sum_k_buteForce(arr, 7);
		//int minLength = shortest_subarray_with_sum_k(arr, 7);
		
		//int[] arr = {3, 4, 7, 2, -3, 1, 4, 2, 1};
		//int minLength = shortest_subbarray_with_sum_k_buteForce(arr, 6);
		//int minLength = shortest_subarray_with_sum_k(arr, 6);
		
		//int[] arr = {3, 4, 7, 2, -3, 1, 4, 2, 1};
		//int minLength = shortest_subarray_with_sum_k(arr, 0);
		
		int[] arr = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
		int minLength = shortest_subarray_with_sum_k(arr, 0);
		
		System.out.println(minLength);
	}
	
	/*
	 * Brute Force : Find all the sub-arrays whose sum is equal to k. Out of those sub-arrays find the 
	 * 				 one with min length. Return that length.
	 * T = O(n^2)
	 * S = O(1)
	 * 
	 */
	private static int shortest_subbarray_with_sum_k_buteForce(int[] arr, int k) {
		
		int n = arr.length;
		int minCount = Integer.MAX_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			int count = 0;
			int sum = 0;
			
			for(int j = i; j <= n-1; j++) {
				sum = sum + arr[j];
				count++;
				if(sum == k) {
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
	 * Best Solution: In hashMap, key = prefix_sum & value = index of this sum
	 * 
	 * Here, target is k (anything)
	 * 
	 * 					s
	 * |<--------------------------------->|
	 * |<------------>|<------------------>|
	 * 		s-k                k
	 * 
	 * Length of (s-k) has to maximum therefore, length of k will be minimum
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	private static int shortest_subarray_with_sum_k(int[] arr, int k) {
		
		int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<>();
		int sum = 0;
		int minLength = Integer.MAX_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			
			sum = sum + arr[i];
			if(sum == k) {
				int count = i + 1;
				if(count < minLength) {
					minLength = i + 1;
				}
			}
			
			Integer index = hashMap.get(sum-k);
			
			if(index != null) {
				int count = i - index;
				if(count < minLength) {
					minLength = count;
				}
			}
			
			hashMap.put(sum, i);
		}
		
		return minLength;
	}
}
