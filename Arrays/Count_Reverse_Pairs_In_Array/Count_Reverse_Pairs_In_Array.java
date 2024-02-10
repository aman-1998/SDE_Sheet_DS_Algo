package algorithms;

import java.math.BigInteger;

/*
 * 
 * 
Count Reverse Pairs
---------------------
Problem Statement: Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].

Examples
Example 1:

Input: N = 5, array[] = {1,3,2,3,1)

Output: 2 

Explanation: The pairs are (3, 1) and (3, 1) as from both the pairs the condition arr[i] > 2*arr[j] is satisfied.

Example 2:

Input: N = 4, array[] = {3,2,1,4}

Output: 1

Explaination: There is only 1 pair  ( 3 , 1 ) that satisfy the condition arr[i] > 2*arr[j]
 * 
 */

public class Count_Reverse_Pairs_In_Array {
	
	public static int countReversePair = 0;
	
	public static void main(String[] args) {
		
		int[] arr = {40, 25, 19, 12, 9, 6, 2};
		//int[] arr = {9, 3, 7, 1, 1, 5, 8};
		arr = mergeSort(arr, 0, arr.length - 1);
		System.out.println(countReversePair);
	}
	
	private static int[] mergeSort(int[] arr, int p, int r) {
		
		int q = (p+r)/2;
		if(p < r) {
			arr = mergeSort(arr, p, q);
			arr = mergeSort(arr, q+1, r);
			countReversePair(arr, p, q, r);
			arr = merge(arr, p, q, r);
		}
		return arr;
	}
	
	private static void countReversePair(int[] arr, int p, int q, int r) {
		
		int j = q+1;
		for(int i = p; i <= q; i++) {
			while(j <= r && arr[i] > 2*arr[j]) {
				j++;
			}
			countReversePair = countReversePair + (j - (q+1));
		}
	}
	
	private static int[] merge(int[] arr, int p, int q, int r) {
		
		int[] left = new int[q-p+2];
		int[] right = new int[r-q+1];
		
		left[left.length - 1] = Integer.MAX_VALUE;
		right[right.length - 1] = Integer.MAX_VALUE;

		for(int i = p; i <= q; i++) {
			left[i-p] = arr[i];
		}
		
		for(int i = q+1; i <= r; i++) {
			right[i-q-1] = arr[i];
		}
		
		int j = 0;
		int k = 0;
		for(int i = p; i <= r; i++) {
			
			if(left[j] <= right[k]) {
				arr[i] = left[j];
				j++;
			} else {
				arr[i] = right[k];
				k++;
			}
		}
		
		return arr;
	}
}
