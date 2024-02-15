package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Three_Sum {
	
	public static void main(String[] args) {
		
		int[] arr = {-1, 0, 1, 2, -1, 4};
		int target = 0; // Target can be anything
		
		System.out.println("Unique Pairs:-");
		List<List<Integer>> listOfTriplets = three_sum_3(arr, target);
		listOfTriplets.stream().forEach(triplet -> System.out.println("(" + triplet.get(0) + ", " + triplet.get(1) + ", " + triplet.get(2) + ")"));
	}
	
	// Brute Force
	// T = O(n^3) + O(n) = O(n^3)
	// S = O(n)
	private static List<List<Integer>> three_sum_1(int[] arr, int target) {
		
		int n = arr.length;
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		
		for(int i = 0; i <= n-1; i++) {
			for(int j = i+1; j <= n-1; j++) {
				for(int k = j+1; k <= n-1; k++) {
					if(arr[i] + arr[j] + arr[k] == target) {
						List<Integer> tempTriplet = new ArrayList<>();
						tempTriplet.add(arr[i]);
						tempTriplet.add(arr[j]);
						tempTriplet.add(arr[k]);
						tempTriplet = tempTriplet.stream().sorted().collect(Collectors.toList()); // O(1)
						
						set.add(tempTriplet); // O(1)
					}
				}
			}
		}
		
		result.addAll(set); // O(n)
		return result;
	}
	
	/*
	 * Better Approach : In LeetCode it will give TLE (Time Limit Exceed). Because HashMap and HashSet gives amortized 
	 * and average time performance of O(1), not worst case. This means, we can suffer an O(n) operation 
	 * from time to time.
	 * 
	 * T = o(n^2)*O(hashMap_Search + hashMap_put + hashSet_add) = O(n^2)
	 * S = O(n)
	 * 
	 */
	private static List<List<Integer>> three_sum_2(int[] arr, int target) {
		int n = arr.length;
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(arr[0], 0);
		hashMap.put(arr[1], 1);
		
		Set<List<Integer>> hashSet = new HashSet<>();
		
		for(int i = 0; i <= n-1; i++) {
			for(int j = i+1; j <= n-1; j++) {
				int searchKey = target - (arr[i] + arr[j]);
				Integer index = hashMap.get(searchKey); // O(1)
				if(index != null) {
					if(index != i && index != j) {
						List<Integer> tempTriplet = new ArrayList<>();
						tempTriplet.add(arr[i]);
						tempTriplet.add(arr[j]);
						tempTriplet.add(searchKey);
						tempTriplet = tempTriplet.stream().sorted().collect(Collectors.toList()); // O(1)
						
						hashSet.add(tempTriplet); // O(1)
					}
				}
				hashMap.put(arr[j], j); // O(1)
			}
		}
		
		result.addAll(hashSet); // O(n)
		return result;
	}
	
	// Best Approach (Optimal)
	// T = O(n*logn) * O(n^2) = O(n^2)
	// S = O(1)
	private static List<List<Integer>> three_sum_3(int[] arr, int target) {
		
		Arrays.sort(arr); // T = O(n*logn)
		int n = arr.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int i = 0;
		while(i < n) { // T = O(n)
			
			int j = i+1;
			int k = n-1;
			int newTarget = target - arr[i];
			
			// T = O(n)
			while(j < k) {
				if(arr[j] + arr[k] > newTarget) {
					k--;
				} else if(arr[j] + arr[k] < newTarget) {
					j++;
				} else {
					List<Integer> temp = new ArrayList<>();
					temp.add(arr[i]);
					temp.add(arr[j]);
					temp.add(arr[k]);
					
					result.add(temp);
					j++;
					k--;
					while((arr[j-1] == arr[j]) && (arr[k] == arr[k+1])) {
						j++;
						k--;
						if(j >= k) {
							break;
						}
					}
				}
			}
			
			// Increment logic of 'i'
			int temp = arr[i];
			while(arr[i] == temp) {
				i++;
				if(i >= n) {
					break;
				}
			}
		}
		
		return result;
	} 
}
