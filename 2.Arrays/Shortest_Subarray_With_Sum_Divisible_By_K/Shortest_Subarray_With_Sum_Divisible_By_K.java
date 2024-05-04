package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Shortest_Subarray_With_Sum_Divisible_By_K {
	
	private static int start = 0;
	private static int end = 0;
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 2, 1, 2, 4};
		int k = 7;
		
		//int[] arr = {1, 2, 2, 1, 2, 2};
		//int k = 7;
		
		int minLen = shortest_subarray_with_sum_divisible_by_k(arr, k);
		
		System.out.println(minLen);
		
		for(int i = start; i <= end; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	/*
	 * Brute Force technique will take O(n^2) time
	 */
	
	/*
	 * T = O(n) * O(hashMap_search) = O(n)
	 * S = O(n)
	 */
	public static int shortest_subarray_with_sum_divisible_by_k(int[] arr, int k) {
		
		int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<>();
		
		int sum = 0;
		int minLength = Integer.MAX_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			
			if(arr[i] < 0) {
				arr[i] = (arr[i] % k) + k;
			}
			
			sum = sum + arr[i];
			int rem = sum % k;
			if(rem == 0) {
				int count = i+1;
				if(count < minLength) {
					minLength = count;
				}
			}
			
			Integer index = hashMap.get(rem);
			if(index != null) {
				int count = i - index;
				if(count < minLength) {
					minLength = count;
					
					start = index + 1;
					end = i;
				}
			}
			
			hashMap.put(rem, i);
		}
		
		return minLength;
	}
}
