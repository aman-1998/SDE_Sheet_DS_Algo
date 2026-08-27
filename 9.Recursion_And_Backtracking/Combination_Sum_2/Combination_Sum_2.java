package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination_Sum_2 {
	
	public static void main(String[] args) {
		
		int[] arr = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		
		List<List<Integer>> combinationList = combinationSum(arr, target);
		
		combinationList.stream().forEach((List<Integer> list) -> System.out.println(list));
	}
	
	public static List<List<Integer>> combinationSum(int[] arr, int target) {
        
		List<List<Integer>> combinationList = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		
		Arrays.sort(arr);
		
		solve(arr, target, 0, combination, combinationList);
		
		return combinationList;
    }
	
	/*
	 * An element can be picked only once (i.e., pick or not pick) then the
	 * time complexity will be 2^n. And each combination can of any length 
	 * say k. So, to copy each combination in result list takes O(k) time. 
	 * T = O(2^n * k)
	 * 
	 * S = O(k) + O(k)  [k is the avg size of each combination and O(k) is approx system stack size]
	 *   = O(k)
	 */
	private static void solve(int[] arr, int target, int start, 
			   List<Integer> combination, 
			   List<List<Integer>> combinationList) {

		int n = arr.length;
		
		if(target == 0) {
			combinationList.add(new ArrayList<>(combination));
			return;
		}
		
		for(int i = start; i <= n-1; i++) {
			
			// Skip duplicates at the same recursion level
	        if (i > start && arr[i-1] == arr[i]) {
	            continue;
	        }

	        // Since array is sorted, no later element can work either
	        if (arr[i] > target) {
	            return;
	        }
			
			if(target < 0) {
				return;
			} 
			
			combination.add(arr[i]);
			solve(arr, target-arr[i], i+1, combination, combinationList);
			combination.remove(combination.size()-1);
		}
	}
}
