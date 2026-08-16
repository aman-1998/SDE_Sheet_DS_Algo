package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * Given an array arr of integers, return the sums of all subsets in the list.
 * Return the sums in any order.
 * 
 * Link : https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma
 */
public class Subset_Sum_1 {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3};
		
		List<Integer> subSetSum = subsetSum_Optimal(arr);
		
		System.out.println(subSetSum);
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n * 2^n) + O(n * 2^n)
	 * 	 = O(n * 2^n)
	 * 
	 * S = O(n * 2^n) ; SetOfAllSubsets takes n * 2^n space
	 */
	public static List<Integer> subsetSum_BF(int[] arr) {
		
		List<Integer> res = new ArrayList<>();
		
		List<List<Integer>> SetOfAllSubsets = powerSet(arr); // O(n * 2^n)
		
		for(int i = 0; i <= SetOfAllSubsets.size()-1; i++) { // O(2^n)
			int sum = 0;
			for(int j = 0; j <= SetOfAllSubsets.get(i).size()-1; j++) { // O(n)
				sum = sum + SetOfAllSubsets.get(i).get(j);
			}
			res.add(sum);
		}
		
		//Collections.sort(res); // O(2^n * log 2^n)
		
		return res;
	}
	
	/*
	 * T = O(n * 2^n)
	 * S = O(1)
	 */
	private static List<List<Integer>> powerSet(int[] arr) {
		
		int n = arr.length;
		List<List<Integer>> listOfAllSubsets = new ArrayList<List<Integer>>();
		
		for(int i = 0; i <= (1 << n)-1; i++) {
			List<Integer> subset = new ArrayList<>();
			for(int j = 0; j <= n-1; j++) {
				if(((1 << j) & i) != 0) { // bit is 1
					subset.add(arr[j]);
				}
			}
			listOfAllSubsets.add(subset);
		}
		
		return listOfAllSubsets;
	}
	
	/*
	 * Optimal approach (recursive approach is optimal approach here.)
	 * 
	 * T = O(2^n)
	 * S = O(n)
	 */
	public static List<Integer> subsetSum_Optimal(int[] arr) {
		
		List<Integer> res = new ArrayList<>();
		solve(arr, 0, 0, res);
		
		//Collections.sort(res);
		
		return res;
	}
	
	/*
	 * T = O(2^n)
	 * S = O(n) + O(2^n) ; O(n) => stack , O(2^n) => res
	 * if we ignore res space then S = O(n)
	 */
	public static void solve(int[] arr, int index, int sum, List<Integer> res) {
		
		if(index == arr.length) {
			res.add(sum);
			return;
		}
		
		solve(arr, index+1, sum+arr[index], res);
		solve(arr, index+1, sum, res);
	}
	
}
