package practice.dsa.sheet.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * Given an integer array nums, return all possible 
 * subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the 
 * solution in any order.
 */
public class Power_Set_2 {
	
	public static void main(String[] args) {
		int[] arr = {8, 9, 9, 3, 3, 8, 9}; // Elements can be duplicate
		
		List<List<Integer>> listOfAllSubsets = powerSet_Optimal(arr);
		
		System.out.println("All subsets/Subsequences:-  ");
		System.out.println("--------------------------------");
	
		listOfAllSubsets.stream().forEach((List<Integer> subset) -> System.out.println(subset));
	}
	
	/* 
	 * Brute Force
	 * 
	 * T = O(2n * 2^n) + O(2^n) 
	 *   = O(n * 2^n)
	 *   
	 * S = O(n)
	 */
	private static List<List<Integer>> powerSet_BF(int[] arr) {
		
		int n = arr.length;
		
		Arrays.sort(arr);
		
		List<List<Integer>> listOfAllSubsets = new ArrayList<List<Integer>>();
		Set<List<Integer>> setOfAllSubsets = new HashSet<>();
		
		for(int i = 0; i <= (1 << n)-1; i++) {
			List<Integer> subset = new ArrayList<>();
			for(int j = 0; j <= n-1; j++) {
				if(((1 << j) & i) != 0) { // bit is 1
					subset.add(arr[j]);
				}
			}
			setOfAllSubsets.add(subset);
		}
		
		listOfAllSubsets.addAll(setOfAllSubsets);
		
		return listOfAllSubsets;
	}
	
	/*
	 * This Optimal approach also has same asymptotic time complexity as
	 * Brute force approach. But still it is slightly better.
	 * 
	 * Link : https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma
	 * 
	 * T = O(2^n) * O(n)  [ 2^n time to generate all subsets and each subset is deep-copied to the result which will take O(n) time]
	 *   = O(n * 2^n)
	 *   
	 * S = O(n) + O(n)  [O(n) for stack, O(n) for subset]
	 *   = O(n)
	 */
	public static List<List<Integer>> powerSet_Optimal(int[] arr) {
		
		Arrays.sort(arr); // O(n * log n)
	    
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		
		solve(arr, 0, subset, res);
		
		return res;
	}

	private static void solve(int[] arr, int start, 
						      List<Integer> subset, 
						      List<List<Integer>> res) {
		
		res.add(new ArrayList<>(subset));
		
		for(int i = start; i <= arr.length-1; i++) {
			
			if(i > start && arr[i-1] == arr[i]) {
				continue;
			}
			
			subset.add(arr[i]);
			
			solve(arr, i+1, subset, res);
			
			subset.remove(subset.size()-1);
		}
	}
}
