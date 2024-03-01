package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Longest_Subarray_With_Sum_k {
	 
	public static void main(String[] args) {
		
		//int[] arr = {7, 4, -2, 1, -3};
		//int maxLength = longest_subbarray_with_sum_k_buteForce(arr, 7);
		
		//int[] arr = {1, -1, 7, 3, 4, 2, -5, -4, 3, 2, 5};
		//int maxLength = longest_subbarray_with_sum_k_buteForce(arr, 7);
		//int maxLength = longest_subarray_with_sum_k(arr, 7);
		
		//int[] arr = {3, 4, 7, 2, -3, 1, 4, 2, 1};
		//int maxLength = longest_subbarray_with_sum_k_buteForce(arr, 7);
		//int maxLength = longest_subarray_with_sum_k(arr, 7);
		
		//int[] arr = {3, 4, 7, 2, -3, 1, 4, 2, 1};
		//int maxLength = longest_subarray_with_sum_0(arr);
		//int maxLength = longest_subarray_with_sum_k(arr, 0);
		
		int[] arr = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
		//int maxLength = longest_subarray_with_sum_0(arr);
		int maxLength = longest_subarray_with_sum_k(arr, 0);
		
		System.out.println(maxLength);
	}
	
	/*
	 * Brute Force : Find all the sub-arrays whose sum is equal to k. Out of those sub-arrays find the 
	 * 				 one with max length. Return that length.
	 * T = O(n^2)
	 * S = O(1)
	 * 
	 */
	private static int longest_subbarray_with_sum_k_buteForce(int[] arr, int k) {
		
		int n = arr.length;
		int maxCount = Integer.MIN_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			
			int count = 0;
			int sum = 0;
			
			for(int j = i; j <= n-1; j++) {
				sum = sum + arr[j];
				count++;
				if(sum == k) {
					if(maxCount < count) {
						maxCount = count;
					}
				}
			}
		}
		
		return maxCount;
	}
	
	/*
	 * Best Solution: n hashMap, key = prefix_sum & value = index of this sum
	 * 
	 * Here target is Zero.
	 * 
	 * 					s
	 * |<--------------------------------->|
	 * |<------------>|<------------------>|
	 * 		  s                0
	 * 
	 * Length of (s) has to minimum therefore, length of 0 will be maximum
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	private static int longest_subarray_with_sum_0(int[] arr) {
		
		int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int maxLength = Integer.MIN_VALUE;
		int count = 0;
		int sum = 0;
		
		for(int i = 0; i <= n-1; i++) {
			sum = sum + arr[i];
			if(sum == 0) {
				maxLength = i + 1;
			} else {
				Integer index = hashMap.get(sum);
				if(index == null) {
					hashMap.put(sum, i);
				} else {
					count = i - index;
					if(maxLength < count) {
						maxLength = count;
					}
				}
			}
		}
		
		return maxLength;
	}
	
	/*
	 * Best Solution: n hashMap, key = prefix_sum & value = index of this sum
	 * 
	 * Here, target is k (anything)
	 * 
	 * 					s
	 * |<--------------------------------->|
	 * |<------------>|<------------------>|
	 * 		s-k                k
	 * 
	 * Length of (s-k) has to minimum therefore, length of k will be maximum
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	private static int longest_subarray_with_sum_k(int[] arr, int k) {
		
		int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<>();
		int sum = 0;
		int maxLength = 0;
		
		for(int i = 0; i <= n-1; i++) {
			sum = sum + arr[i];
			if(sum == k) {
				maxLength = i + 1;
			} else {
				Integer index = hashMap.get(sum-k);
				if(index != null) {
					int count = i - index;
					if(maxLength < count) {
						maxLength = count;
					}
				}
			}
			
			if(hashMap.get(sum) == null) {
				hashMap.put(sum, i);
			}
		}
		
		return maxLength;
	}
	
}
