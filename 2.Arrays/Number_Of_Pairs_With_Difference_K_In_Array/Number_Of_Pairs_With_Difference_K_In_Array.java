package algorithms.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Number_Of_Pairs_With_Difference_K_In_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {6, 3, 5, 7, 2, 3, 3, 8, 2, 4};
		int k = 2;
		
		//int[] arr = {3, 1, 4, 1, 5};
		//int k = 2;
		
		int noOfPairs = count_Pairs_With_Diff_K_2ndApproach(arr, k);
		
		System.out.println(noOfPairs);
	}
	
	/*
	 * Using HashSet
	 * 
	 * T = O(n) * O(2*hashSet_Search + hashSet_Add)
	 * 
	 * In worst case:
	 * ----------------
	 * T = O(n) * O(2*n + n) = O(n) * O(3n) = O(3(n^2)) = O(n^2)
	 * 
	 * 
	 * In average case:
	 * -----------------
	 * T = O(n) * O(2 + 1) = O(n) * O(3) = O(n)
	 * 
	 * In hashSet worst case is very very very rare.
	 * 
	 * S = O(2n) = O(n)
	 */
	public static int count_Pairs_With_Diff_K(int[] arr, int k) {
		
		int n = arr.length;
		Set<Integer> hashSet = new HashSet<>();
		Set<List<Integer>> set = new HashSet<>();
		
		int count = 0;
		for(int i = 0; i <= n-1; i++) {
			if(hashSet.contains(arr[i] - k)) {
				
				List<Integer> tempList = new ArrayList<>();
				tempList.add(arr[i]);
				tempList.add(arr[i] - k);
				tempList = tempList.stream().sorted().collect(Collectors.toList()); // O(1)
				set.add(tempList);
			} 
			
			if(hashSet.contains(arr[i] + k)) {
				List<Integer> tempList = new ArrayList<>();
				tempList.add(arr[i]);
				tempList.add(arr[i] + k);
				tempList = tempList.stream().sorted().collect(Collectors.toList()); // O(1)
				set.add(tempList);
			}
			hashSet.add(arr[i]);
		}
		
		return set.size();
	}
	
	/*
	 * Using binary search
	 * 
	 * T = o(n*log(n)) + O(n*log(n)) = O(n*log(n))
	 * 
	 * S = O(1)
	 */
	public static int count_Pairs_With_Diff_K_2ndApproach(int[] arr, int k) {
		
		int n = arr.length;
		Arrays.sort(arr);
		
		int count = 0;
		
		int i = 0;
		while(i <= n-2) {
			int position = Arrays.binarySearch(arr, i+1, n, arr[i]+k);
			
			if(position >= 0) {
				count++;
			}
			
			int temp = arr[i];
			while(temp == arr[i]) {
				i++;
				if(i > n-2) {
					break;
				}
			}
		}
		
		return count;
	}
}
