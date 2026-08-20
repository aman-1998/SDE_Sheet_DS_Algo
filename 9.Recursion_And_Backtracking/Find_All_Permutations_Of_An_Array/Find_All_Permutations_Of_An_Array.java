package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Find_All_Permutations_Of_An_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3};
		
		List<List<Integer>> res = permutations_Optimal(arr);
		
		res.stream().forEach((List<Integer> list) -> System.out.println(list));
	}
	
	/*
	 * T = O(n) * O(n!)  [O(n!) time to generate n! permutations and O(n) time to copy each permutation to resultList]
	 *   = O(n * n!)
	 *   
	 * S = O(n) + O(n) + O(n)  [O(n) for stack; O(n) for tempList; O(n) for hashSet]
	 *   = O(n)
	 */
	public static List<List<Integer>> permutations_BF(int[] arr) {
        
		List<List<Integer>> permutationList = new ArrayList<>();
		
		Set<Integer> hashSet = new HashSet<>();
		List<Integer> tempList = new ArrayList<>();
		
		solve1(arr, tempList, hashSet, permutationList);
		
		return permutationList;
    }

	private static void solve1(int[] arr, List<Integer> tempList, 
					   Set<Integer> hashSet, 
					   List<List<Integer>> permutationList) {
		
		int n = arr.length;
		
		if(hashSet.size() == n) {
			permutationList.add(new ArrayList<>(tempList));
			return;
		}
		
		
		for(int i = 0; i <= n-1; i++) {
			if(!hashSet.contains(arr[i])) {
				
				tempList.add(arr[i]);
				hashSet.add(arr[i]);
				
				solve1(arr, tempList, hashSet, permutationList);
				
				tempList.remove(tempList.size()-1);
				hashSet.remove(arr[i]);
			}
		}
	}
	
	/*
	 * T = O(n! * n)  [O(n!) to generate all permutations and O(n) to copy arr to result]
	 * 
	 * S = O(n)  [for system stack]
	 */
	public static List<List<Integer>> permutations_Optimal(int[] arr) {
		
		List<List<Integer>> permutationsList = new ArrayList<>();
		
		solve2(arr, 0, permutationsList);
		
		return permutationsList;
		
	}

	private static void solve2(int[] arr, int start, List<List<Integer>> permutationsList) {
		
		int n = arr.length;
		
		if(start == n) {
			//Convert array of int to List<Integer>
			//List<Integer> permutation = Arrays.stream(arr)
			//								  .boxed()
			//								  .collect(Collectors.toList());
			
			List<Integer> permutation = new ArrayList<>(arr.length);

			for (int value : arr) {
				permutation.add(value);
			}
			
			permutationsList.add(permutation);
			
			return;
		}
		
		for(int i = start; i <= n-1; i++) {
			swap(arr, start, i);
			solve2(arr, start+1, permutationsList);
			swap(arr, start, i);
		}
	}

	private static void swap(int[] arr, int start, int i) {
		
		int temp = arr[start];
		arr[start] = arr[i];
		arr[i] = temp;
	}
}
