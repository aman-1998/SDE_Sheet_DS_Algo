package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Longest_Subarray_With_Sum_Divisible_By_K {
	
	private static int start = 0;
	private static int end = 0;
	
	public static void main(String[] args) {	
		
		int[] arr = {1, 2, 2, 1, 2, 3};
		int k = 7;
		
		int maxLen = longest_Subarray_With_Sum_Divisible_By_K(arr, k);
		
		System.out.println(maxLen);
		
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
	public static int longest_Subarray_With_Sum_Divisible_By_K(int[] arr, int k) {
		
		int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<>();
		
		int maxLength = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i <= n-1; i++) {
			
			if(arr[i] < 0) {
				arr[i] = (arr[i] % k) + k;
			}
			
			sum = sum + arr[i];
			int rem = sum % k;
			if(rem == 0) {
				maxLength = i + 1;
			} else {
				Integer index = hashMap.get(rem);
				if(index != null) {
					int count = i - index;
					if(count > maxLength) {
						maxLength = count;
						
						start = index + 1;
						end = i;
					}
				}
			}
			
			if(hashMap.get(rem) == null) {
				hashMap.put(rem, i);
			}
		}
		
		return maxLength;
	}
	
}
