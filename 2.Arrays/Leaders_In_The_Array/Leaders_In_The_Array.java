package algorithms.part1;

import java.util.ArrayList;
import java.util.List;

public class Leaders_In_The_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {10, 22, 12, 3, 0, 6};
		List<Integer> leaders = leadersInArray(arr);
		
		leaders.forEach(t -> System.out.println(t + " "));
	}
	
	/*
	 * T = O(n)
	 * S = O(1)
	 */
	public static List<Integer> leadersInArray(int[] arr) {
		
		List<Integer> result = new ArrayList<>();
		int n = arr.length;
		
		int maxRight =Integer.MIN_VALUE;
		
		for(int i = n-1; i >= 0; i--) {
			
			if(arr[i] > maxRight) {
				result.add(arr[i]);
			}
			
			if(arr[i] > maxRight) {
				maxRight = arr[i];
			}
		}
		
		return result;
	}
}
