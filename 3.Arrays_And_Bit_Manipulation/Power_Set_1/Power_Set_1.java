package practice.dsa.sheet.part1;

import java.util.ArrayList;
import java.util.List;
/*
 * Given an integer array nums of unique elements, return all possible 
 * subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the 
 * solution in any order.
 */
public class Power_Set_1 {
	
	public static void main(String[] args) {
		int[] arr = {8, 9, 3}; // Elements can't be duplicate
		
		List<List<Integer>> listOfAllSubsets = powerSet_2nd(arr);
		
		System.out.println("All subsets/Subsequences:-  ");
		System.out.println("--------------------------------");
	
		listOfAllSubsets.stream().forEach((List<Integer> subset) -> System.out.println(subset));
	}
	
	/* 
	 * T = O(n * 2^n)
	 * S = O(n)
	 */
	private static List<List<Integer>> powerSet_1st(int[] arr) {
		
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
	 * Link : https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma 
	 * 
	 * T = O(n * 2^n)
	 * 
	 * S = O(n) + O(n) ; O(n) = > Stack , O(n) => subset max size
	 * 	 = O(n)
	 */
	public static List<List<Integer>> powerSet_2nd(int[] arr) {
		
		List<Integer> subset = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		solve(arr, 0, subset, res);
		return res;
	}
	
	/*
	 * T = O(n * 2^n)
	 * 
	 * S = O(n) + O(n) ; O(n) = > Stack , O(n) => subset max size
	 * 	 = O(n)
	 */
	public static void solve(int[] arr, int index, List<Integer> subset, List<List<Integer>> res) {
		
		if(index == arr.length) {
			res.add(new ArrayList<>(subset)); // O(n)
			return;
		}
		
		subset.add(arr[index]);
		solve(arr, index+1, subset, res);
		subset.remove(subset.size()-1);
		
		solve(arr, index+1, subset, res);
	}
	
}
