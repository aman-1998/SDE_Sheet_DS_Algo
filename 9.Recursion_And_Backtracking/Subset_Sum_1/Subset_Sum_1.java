package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * Given an array arr of integers of unique elements, return the sums of 
 * all subsets in the list. Return the sums in any order.
 * 
 * Link : https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma
 */
public class Subset_Sum_1 {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3}; // Unique elements
		
		List<Integer> subSetSum = subsetSum_BF(arr);
		
		System.out.println(subSetSum);
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n * 2^n)
	 * 
	 * S = O(1)
	 */
	public static List<Integer> subsetSum_BF(int[] arr) {
		
		int n = arr.length;
		List<Integer> listOfAllSubsetSum = new ArrayList<>();
		
		for(int i = 0; i <= (1 << n)-1; i++) {
			int sum = 0;
			for(int j = 0; j <= n-1; j++) {
				if(((1 << j) & i) != 0) { // bit is 1
					sum = sum + arr[j];
				}
			}
			listOfAllSubsetSum.add(sum);
		}
		
		return listOfAllSubsetSum;
	}
	
	/*
	 * Optimal approach (recursive approach is optimal approach here.)
	 * 
	 * T = O(2^n)
	 * S = O(n)
	 */
	public static List<Integer> subsetSum_Optimal(int[] arr) {
		
		List<Integer> listOfAllSubsetSum = new ArrayList<>();
		solve(arr, 0, 0, listOfAllSubsetSum);
		
		return listOfAllSubsetSum;
	}
	
	/*
	 * T = O(2^n)
	 * S = O(n) + O(2^n) ; O(n) => stack , O(2^n) => res
	 * if we ignore res space then S = O(n)
	 */
	public static void solve(int[] arr, int index, int sum, 
							 List<Integer> listOfAllSubsetSum) {
		
		if(index == arr.length) {
			listOfAllSubsetSum.add(sum);
			return;
		}
		
		solve(arr, index+1, sum+arr[index], listOfAllSubsetSum);
		solve(arr, index+1, sum, listOfAllSubsetSum);
	}
	
}
