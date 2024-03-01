package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Number_Of_Subarrays_With_Sum_k {
	
	public static void main(String[] args) {
		
		//int[] arr = {1, -1, 7, 3, 4, 2, -5, -4, 3, 2, 5};
		//int count = number_of_subbarrays_with_sum_k_buteForce(arr, 7);
		//int count = number_of_subbarrays_with_sum_k(arr, 7);
		
		int[] arr = {3, 4, 7, 2, -3, 1, 4, 2, 1};
		//int count = Number_Of_subbarrays_with_sum_k_buteForce(arr, 7);
		int count = number_of_subbarrays_with_sum_k(arr, 7);
		
		System.out.println(count);
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n^2)
	 * S = O(1)
	 * 
	 */
	private static int number_of_subbarrays_with_sum_k_buteForce(int[] arr, int k) {
		
		int n = arr.length;
		int count = 0;
		
		for(int i = 0; i <= n-1; i++) {
			int sum = 0;
			for(int j = i; j <= n-1; j++) {
				sum = sum + arr[j];
				if(sum == k) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	/*
	 * Best Solution : In hashMap, key = prefix_sum & value = count of prefix_sum
	 * 
	 * T = O(n)
	 * S = O(n)
	 * 
	 */
	private static int number_of_subbarrays_with_sum_k(int[] arr, int k) {
		
		int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<>(); // (sum , no. of times we have seen this sum) = (sum ,count)
		int sum = 0;
		int count = 0;
		
		for(int i = 0; i <= n-1; i++) {
			
			sum = sum + arr[i];
			if(sum == k) {
				count++;
			}
			
			Integer frequency = hashMap.get(sum - k);
			
			if(frequency != null) {
				count = count + frequency;
			}
			
			if(hashMap.get(sum) == null) {
				hashMap.put(sum, 1);
			} else {
				hashMap.put(sum, hashMap.get(sum) + 1);
			}
		}
		
		return count;
	}
}
