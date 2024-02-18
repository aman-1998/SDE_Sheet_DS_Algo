package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Two_Sum {
	
	private static int[] pos = new int[2];
	public static void main(String[] args) {
		
		//int[] arr = new int[] {2, 4, 6, 8, 11};
		//int[] arr = new int[] {2, 4, 6, 8, 11, 10};
		//int target = 14;
		
		int[] arr = new int[] {2, 4, 6, 8, 5, 11, 10, 5};
		int target = 10;
		
		//int[] arr = new int[] {5, 5, 5};
		//int target = 10;
		
		//boolean check = twoSum_3(arr, target);
		boolean check = twoSum_2(arr, target);
		
		System.out.println(check);
		
		System.out.println("----------------------------------------");
		
		for(int i : pos) {
			System.out.println(i + " ");
		}
		
		System.out.println("----------------------------------------");
		
		System.out.println("Unique Pairs:-");
		List<List<Integer>> listOfPairs = twoSum_5(arr, target);
		listOfPairs.stream().forEach(pair -> System.out.println("(" + pair.get(0) + ", " + pair.get(1) + ")"));
	}
	
	// Brute Force
	// Original array is not altered. So, indices can be found
	// T = O(n^2)
	// S = O(1)
	private static boolean twoSum_1(int[] arr, int target) {
		
		for(int i = 0; i <= arr.length; i++) {
			for(int j = i+1; j <= arr.length-1 ; j++) {
				if(arr[i] + arr[j] == target) {
					pos[0] = i;
					pos[1] = j;
					return true;
				}
			}
		}
		
		return false;
	}
	
	// Tells whether a pair exist or not and also return the indices of the elements of the pair
	// Original array is not altered. So, indices can be found
	// Using HashMap
	// T = O(n)
	// S = O(n)
	private static boolean twoSum_2(int[] arr, int target) {
		
		Map<Integer, Integer> hMap = new HashMap<>();
		for(int i = 0; i <= arr.length-1; i++) {
			Integer val = hMap.get(target-arr[i]);
			if(val == null) {
				hMap.put(arr[i], i);
			} else {
				pos[0] = val;
				pos[1] = i;
				return true;
			}
		}
		
		return false;
	}
	
	// Two Pointer Solution. Just tells whether a pair exist or not
	// Original array is altered. So, indices can't be found
	// T = O(n*logn) + O(n) = O(n*logn)
	// S = O(1)
	// Here, we are not finding indices
	private static boolean twoSum_3(int[] arr, int target) {
		
		Arrays.sort(arr); //T = O(n*logn)
		int i = 0; 
		int j = arr.length - 1;
		
		while(i < j) {
			if(arr[i] + arr[j] < 14) {
				i++;
			} else if(arr[i] + arr[j] > 14) {
				j--;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	// Find all unique pairs and also in a pair same element (index-wise) can't be taken twice.
	// Original array is not altered here. So, indices can be found
	// Using HashMap and HashSet
	// T = O(n) * O(hashMap_Search + hashMap_put + hashSet_Search) + O(n) = O(n)
	// S = (n) + O(n/2 * 2) = O(n)
	private static List<List<Integer>> twoSum_4(int[] arr, int target) {
		
		int n = arr.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Map<Integer, Integer> hashMap = new HashMap<>();
		Set<List<Integer>> set = new HashSet<>();
		
		for(int i = 0; i <= n-1; i++) { // O(n)
			
			Integer val = hashMap.get(target - arr[i]);
			if(val != null) {
				List<Integer> temp = new ArrayList<>();
				temp.add(target - arr[i]);
				temp.add(arr[i]);
				temp = temp.stream().sorted().collect(Collectors.toList()); // O(1) because only two elements are present
				
				set.add(temp); // O(1)
			}
			hashMap.put(arr[i], i);
		}
		result.addAll(set); // O(n)
		
		return result;
	}
	
	// Find all unique pairs and also in a pair same element (index-wise) can't be taken twice.
	// Original array is altered here. So, indices can't be found
	// Two Pointer Solution
	// T = O(n*logn) + O(n) = O(n*logn)
	// S = O(1)
	private static List<List<Integer>> twoSum_5(int[] arr, int target) {
		
		Arrays.sort(arr); // T = O(n*logn)
		int i = 0;
		int j = arr.length-1;
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		// T = O(n)
		while(i < j) {
			if(arr[i] + arr[j] > target) {
				j--;
			} else if(arr[i] + arr[j] < target) {
				i++;
			} else {
				List<Integer> temp = new ArrayList<>();
				temp.add(arr[i]);
				temp.add(arr[j]);
				
				result.add(temp);
				i++;
				j--;
				while(arr[i-1] == arr[i]) {
					i++;
					if(i >= j) {
						break;
					}
				}
				
				while(arr[j] == arr[j+1]) {
					j--;
					if(i >= j) {
						break;
					}
				}
			}
		}
		
		return result;
	} 
}
