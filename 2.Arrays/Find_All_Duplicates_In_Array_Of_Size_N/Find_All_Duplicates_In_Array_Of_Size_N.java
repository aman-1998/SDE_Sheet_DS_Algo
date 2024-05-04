package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_In_Array_Of_Size_N {
	
	public static void main(String[] args) {
		
		int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
		
		List<Integer> duplicates = findDuplicates(arr);
		
		duplicates.forEach(t -> System.out.print(t + " | "));
	}
	
	/*
	 * T = O(n)
	 * S = O(1)
	 */
	public static List<Integer> findDuplicates(int[] arr) {
		
		int n = arr.length;
		
		List<Integer> duplicates = new ArrayList<>();
		
		for(int i = 0; i <= n-1; i++) {
			
			if(arr[Math.abs(arr[i]) - 1] > 0) {
				arr[Math.abs(arr[i]) - 1] = -1 * arr[Math.abs(arr[i]) - 1];
			} else {
				duplicates.add(Math.abs(arr[i]));
			}
		}
		
		return duplicates;
	}
}
