package algorithms;

import java.util.Arrays;

public class Single_Number_version2 {
	
	public static void main(String[] args) {
		
		int[] arr = {2, 2, 1, 5, 1, 1, 2};
		int singleNumber = single_number_version2(arr);
		
		System.out.println(singleNumber);
	}
	
	/*
	 * In better Brute Force approach, we can use a hashMap and get the answer by storing frequency 
	 * of each element in O(n) time but in that case, S = O(1)
	 */
	
	
	/*
	 * Best Solution
	 * 
	 * T = O(32) + O(n*32) + O(32) = O(n)
	 * S = O(32) = O(1)
	 */
	private static int single_number_version2(int[] arr) {
		
		int n = arr.length;
		int[] bitCountArray = new int[32];
		Arrays.fill(bitCountArray, 0);
		
		for(int i = 0; i <= n-1; i++) {
			
			for(int j = 0; j <= 31; j++) {
				if((arr[i] & (1 << j)) != 0) {
					bitCountArray[j]++;
				}
			}
		}
		
		int sum = 0;
		int p = 1;
		for(int i = 0; i <= 31; i++) {
			sum = sum + (bitCountArray[i]%3) * p;
			p = p*2;
		}
		
		return sum;
		
	}
}
