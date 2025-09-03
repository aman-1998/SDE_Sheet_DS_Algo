package algorithms;

/*

Count inversions in an array
Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).

What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

Examples
Example 1:
Input Format: N = 5, array[] = {1,2,3,4,5}
Result: 0
Explanation: we have a sorted array and the sorted array has 0 inversions as for i < j you will never find a pair such that A[j] < A[i]. More clear example: 2 has index 1 and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an inversion.

Example 2:
Input Format: N = 5, array[] = {5,4,3,2,1}
Result: 10
Explanation: we have a reverse sorted array and we will get the maximum inversions as for i < j we will always find a pair such that A[j] < A[i]. Example: 5 has index 0 and 3 has index 2 now (5,3) pair is inversion as 0 < 2 and 5 > 3 which will satisfy out conditions and for reverse sorted array we will get maximum inversions and that is (n)*(n-1) / 2.For above given array there is 4 + 3 + 2 + 1 = 10 inversions.

Example 3:
Input Format: N = 5, array[] = {5,3,2,1,4}
Result: 7
Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and (1,4) as both are not satisfy our condition. 
 
 */

public class Count_Inversion_Pairs_In_Array {
	
	public static int countInversionPair = 0;
	
	public static void main(String[] args) {
		
		int[] arr = {40, 25, 19, 12, 9, 6, 2};
		//int[] arr = {9, 3, 7, 1, 1, 5, 8};
		arr = mergeSort(arr, 0, arr.length - 1);
		System.out.println(countInversionPair);
		
		//------------------------
		countInversionPair = 0;
		//------------------------
		
		int[] arr2 = {40, 25, 19, 12, 9, 6, 2};
		//int[] arr2 = {9, 3, 7, 1, 1, 5, 8};
		arr = mergeSort_1(arr2, 0, arr2.length - 1);
		System.out.println(countInversionPair);
	}
	
	/*
	 * Generalized and clean code approach
	 * T  = O(2n * log(n)) = T = O(n * log(n))
	 */
	private static int[] mergeSort(int[] arr, int p, int r) {
		
		int q = (p+r)/2;
		if(p < r) {
			arr = mergeSort(arr, p, q);
			arr = mergeSort(arr, q+1, r);
			countInversionPair(arr, p, q, r);
			arr = merge(arr, p, q, r);
		}
		return arr;
	}
	
	private static void countInversionPair(int[] arr, int p, int q, int r) {
		
		int j = q+1;
		for(int i = p; i <= q; i++) {
			while(j <= r && arr[i] > arr[j]) {
				j++;
			}
			countInversionPair = countInversionPair + (j - (q+1));
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
		
		int i = 0;
		int j = 0;
		for(int k = p; k <= r; k++) {
			
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
		}
		
		return arr;
	}
	
	//---------------------------------------------------------------------------------------------------------------
	/*
	 * This approach is slightly better in terms of time complexity, T = O(n * log(n))
	 */
	private static int[] mergeSort_1(int[] arr, int p, int r) {
		
		int q = (p+r)/2;
		if(p < r) {
			arr = mergeSort_1(arr, p, q);
			arr = mergeSort_1(arr, q+1, r);
			arr = merge_1(arr, p, q, r);
		}
		return arr;
	}
	
	private static int[] merge_1(int[] arr, int p, int q, int r) {
		
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
		
		int i = 0;
		int j = 0;
		for(int k = p; k <= r; k++) {
			
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				// Additional counting inversion-pair logic
				if(i <= left.length -2) {
					countInversionPair = countInversionPair + (q - p - i) + 1;
					// Note: q-p+1 is second last index in left array
				}
				arr[k] = right[j];
				j++;
			}
		}
		
		return arr;
	}
}
