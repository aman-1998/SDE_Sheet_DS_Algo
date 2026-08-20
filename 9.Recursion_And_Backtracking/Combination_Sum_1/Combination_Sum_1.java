package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_1 {
	
	public static void main(String[] args) {
		
		int[] arr = {2, 3, 6, 7};
		int target = 7;
		
		List<List<Integer>> combinationList = combinationSum(arr, target);
		
		combinationList.stream().forEach((List<Integer> list) -> System.out.println(list));
	}
	
	/*
	 * If an element can be picked only once (i.e., pick or not pick) then the
	 * time complexity would have been 2^n but here an element can be picked
	 * multiple times so, it will be 2^t where t is a variable. And each
	 * combination can of any length say k. So, to copy eac combination in
	 * result list takes O(k) time. 
	 * T = O(2^t + k)
	 * 
	 * S = O(k) + O(k)  [k is the avg size of each combination and O(k) is approx system stack size]
	 *   = O(k)
	 */
	public static List<List<Integer>> combinationSum(int[] arr, int target) {
        
		List<List<Integer>> combinationList = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		
		solve(arr, target, 0, combination, combinationList);
		
		return combinationList;
    }

	private static void solve(int[] arr, int target, int start, 
					   List<Integer> combination, 
					   List<List<Integer>> combinationList) {
		
		int n = arr.length;
		
		for(int i = start; i <= n-1; i++) {
			
			if(target < 0) {
				return;
			} else if(target == 0) {
				combinationList.add(new ArrayList<>(combination));
				return;
			} else {
				combination.add(arr[i]);
				solve(arr, target-arr[i], i, combination, combinationList);
				combination.remove(combination.size()-1);
			}
		}
	}
	
}
