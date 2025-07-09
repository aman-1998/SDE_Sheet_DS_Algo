package algorithms.part1;

import java.util.Arrays;

public class Rotate_Array_By_K_Positions {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int k = 3;
		
		int[] output = rotateArray(arr, k);
		
		Arrays.stream(output).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n + k)
	 * S = O(k)
	 */
	private static int[] rotateArray_BruteForce(int[] arr, int k) {
		
		int n = arr.length;
		
		int[] tempArr = new int[k];
		for(int i = 0; i <= k-1; i++) { // T = O(k)
			tempArr[i] = arr[i];
		}
		
		for(int i = k; i <= n-1 ; i++) { // T = O(n - k)
			arr[i-k] = arr[i];
		}
		
		int j = 0;
		for(int i = n-k; i <= n-1; i++) { // T = O(k)
			arr[i] = tempArr[j];
			j++;
		}
		
		return arr;
	}
	
	/*
	 * Optimal approach
	 * 
	 * T = O(2n) = O(n)
	 * S = O(1)
	 */
	private static int[] rotateArray(int[] arr, int k) {
		
		int n = arr.length;
		
		reverse(arr, 0, k-1); // T = O(k)
		reverse(arr, k, n-1); // T = O(n - k)
		reverse(arr, 0, n-1); // T = O(n)
		
		return arr;
	}
	
	private static void reverse(int[] arr, int fromIndex, int toIndex) {
		
		int n = arr.length;
		int i = fromIndex;
		int j = toIndex;
		
		while(i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			i++;
			j--;
		}

	}
	
}
