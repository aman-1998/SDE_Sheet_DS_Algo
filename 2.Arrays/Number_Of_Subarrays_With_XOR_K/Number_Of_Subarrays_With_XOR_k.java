package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Number_Of_Subarrays_With_XOR_k {
	
	public static void main(String[] args) {
		
		//int[] arr = {4, 2, 2, 6, 4};
		//long count = number_of_subarrays_with_xor_k_BF(arr, 6);
		//long count = number_of_subarrays_with_xor_k(arr, 6);
		
		int[] arr = {5, 6, 7, 8, 9};
		//long count = number_of_subarrays_with_xor_k_BF(arr, 5);
		long count = number_of_subarrays_with_xor_k(arr, 5);
		
		System.out.println(count);
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n^2)
	 * S = O(1)
	 * 
	 */
	private static long number_of_subarrays_with_xor_k_BF(int[] arr, int k) {
		
		int n = arr.length;
		int count = 0;
		
		for(int i = 0; i <= n-1; i++) {
			int xr = 0;
			for(int j = i; j <= n-1; j++) {
				xr = xr ^ arr[j];
				if(xr == k) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	/*
	 * T = O(n)*O(hash_Map) = O(n) = Average Case
	 * S = O(n)
	 * 
	 */
	private static long number_of_subarrays_with_xor_k(int[] arr, int k) {
		
		int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<>();
		int xr = 0;
		long count = 0;
		
		for(int i = 0; i <= n-1; i++) {
			
			xr = xr ^ arr[i];
			if(xr == k) {
				count++;
			}
			
			Integer frequency = hashMap.get(xr ^ k);
			if(frequency != null) {
				count = count + frequency;
			}
			
			if(hashMap.get(xr) == null) {
				hashMap.put(xr, 1);
			} else {
				hashMap.put(xr, hashMap.get(xr) + 1);
			}
		}
		
		return count;
	}
}
