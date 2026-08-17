package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * Given an array arr of integers, return the sums of all subsets in the list.
 * Return the sums in any order but return only unique values.
 * 
 * Link : Link : https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma
 */
public class Subset_Sum_2 {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 2, 2, 3, 3}; // Duplicate elements allowed
		
		List<Integer> subSetSum = subsetSum_BF(arr);
		
		System.out.println(subSetSum);
	}
	
	/* 
	 * Brute Force
	 * 
	 * T = O(n * 2^n) + O(2^n) 
	 *   = O(n * 2^n)
	 *   
	 * S = O(2^n)
	 */
	private static List<Integer> subsetSum_BF(int[] arr) {
		
		int n = arr.length;
		
		Arrays.sort(arr);
		
		List<Integer> listOfAllSubsetSum = new ArrayList<>();
		Set<Integer> setOfAllSubsetSum = new HashSet<>();
		
		for(int i = 0; i <= (1 << n)-1; i++) {
			int sum = 0;
			for(int j = 0; j <= n-1; j++) {
				if(((1 << j) & i) != 0) { // bit is 1
					sum = sum + arr[j];
				}
			}
			setOfAllSubsetSum.add(sum);
		}
		
		listOfAllSubsetSum.addAll(setOfAllSubsetSum);
		
		return listOfAllSubsetSum;
	}
	
	/*
	 * 
	 * T = O(2^n)  [ 2^n time to generate all subsets]
	 *   = O(2^n)
	 *   
	 * S = O(n) + O(2^n)  [O(n) for stack, O(2^n) for set]
	 *   = O(2^n)
	 */
	public static List<Integer> subsetSum_Optimal(int[] arr) {
		
		Arrays.sort(arr); // O(n * log n)
	    
		List<Integer> listOfAllSubsetSum = new ArrayList<>();
		Set<Integer> setOfAllSubsetSum = new HashSet<>();
		
		solve(arr, 0, 0, setOfAllSubsetSum);
		
		listOfAllSubsetSum.addAll(setOfAllSubsetSum);
		
		return listOfAllSubsetSum;
	}

	private static void solve(int[] arr, int start, 
						      int sum, Set<Integer> setOfAllSubsetSum) {
		
		setOfAllSubsetSum.add(sum);
		
		for(int i = start; i <= arr.length-1; i++) {
			
			if(i > start && arr[i-1] == arr[i]) {
				continue;
			}
			
			sum = sum + arr[i];
			
			solve(arr, i+1, sum, setOfAllSubsetSum);
			
			sum = sum - arr[i];
		}
	}
}
