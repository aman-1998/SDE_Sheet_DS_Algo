package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Power_Set {
	
	public static void main(String[] args) {
		int[] arr = {8, 9, 3};
		
		List<List<Integer>> listOfAllSubsets = powerSet(arr);
		
		System.out.println("All subsets/Subsequences:-  ");
		System.out.println("--------------------------------");
		for(List<Integer> subset : listOfAllSubsets) {
			if(subset.isEmpty()) {
				System.out.println("empty");
				continue;
			}
			for(Integer j : subset) {
				System.out.print(j + " | ");
			}
			System.out.println();
		}
		
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
	
}
