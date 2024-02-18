package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Four_Sum {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 5, 5, 1, 2, 3, 2, 4, 4, 4, 1, 3};
		int target = 8; // Target can be anything
		
		//int[] arr = {1000000000,1000000000,1000000000,1000000000};
		//int target = -294967296;
		
		
		System.out.println("Unique Quadruplet:-");
		List<List<Integer>> listOfQuadruplet = four_sum_4(arr, target);
		listOfQuadruplet.stream().forEach(quadruplet -> System.out.println(quadruplet));
	}
	
	// Brute Force
	// T = O(n^4) * O(hashSet_search) + O(n) = O(n^4)
	// S = O(n)
	private static List<List<Integer>> four_sum_1(int[] arr, int target) {
		
		int n = arr.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<List<Integer>> hashSet = new HashSet<>();
		
		for(int i = 0; i <= n-1; i++) {
			for(int j = i+1; j <= n-1; j++) {
				for(int k = j+1; k <= n-1; k++) {
					for(int l = k+1; l <= n-1; l++) {
						if(arr[i] + arr[j] + arr[k] + arr[l] == target) {
							List<Integer> quadruplet = new ArrayList<Integer>();
							quadruplet.add(arr[i]);
							quadruplet.add(arr[j]);
							quadruplet.add(arr[k]);
							quadruplet.add(arr[l]);
							quadruplet = quadruplet.stream().sorted().collect(Collectors.toList());
							
							hashSet.add(quadruplet);
						}
					}
				}
			}
		}
		
		result.addAll(hashSet);
		return result;
	}
	
	/*
	 * Better Approach : In LeetCode it will give TLE (Time Limit Exceed). Because HashMap and HashSet gives amortized 
	 * and average time performance of O(1), not worst case. This means, we can suffer an O(n) operation 
	 * from time to time.
	 * 
	 * T = o(n^3)*O(hashMap_Search + hashSet_add + hashMap_put) + O(n)= O(n^3)
	 * S = O(n) + O(n) = O(n)
	 * 
	 */
	private static List<List<Integer>> four_sum_2(int[] arr, int target) {
		
		int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(arr[0], 0);
		hashMap.put(arr[1], 1);
		hashMap.put(arr[2], 2);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<List<Integer>> hashSet = new HashSet<List<Integer>>();
		
		for(int i = 0; i <= n-1; i++) {
			for(int j = i+i; j <= n-1; j++) {
				for(int k = j+1; k <= n-1; k++) {
					int searchKey = target - (arr[i] + arr[j] + arr[k]);
					Integer index = hashMap.get(searchKey);
					if(index != null) {
						if(index != i && index != j && index != k) {
							List<Integer> quadruplet = new ArrayList<>();
							quadruplet.add(arr[i]);
							quadruplet.add(arr[j]);
							quadruplet.add(arr[k]);
							quadruplet.add(searchKey);
							quadruplet = quadruplet.stream().sorted().collect(Collectors.toList());
							
							hashSet.add(quadruplet);
						}
					}
					hashMap.put(arr[k], k);
				}
			}
		}
		
		result.addAll(hashSet);
		return result;
	}
	
	// Best Approach (Optimal) - Two Pointer Solution
	// T = O(n*logn) * O(n^3) = O(n^3)
	// S = O(1)
	private static List<List<Integer>> four_sum_3(int[] arr, int target) {
		
		int n = arr.length;
		Arrays.sort(arr);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int i = 0;
		while(i < n) {
			
			int j = i+1;
			while(j < n) {
				
				int k = j+1;
				int l = n-1;
				int newTarget = target - (arr[i] + arr[j]);
				while(k < l) {
					
					if(arr[k] + arr[l] > newTarget) {
						l--;
					} else if(arr[k] + arr[l] < newTarget) {
						k++;
					} else {
						List<Integer> quadruplet = new ArrayList<Integer>();
						quadruplet.add(arr[i]);
						quadruplet.add(arr[j]);
						quadruplet.add(arr[k]);
						quadruplet.add(arr[l]);
						
						result.add(quadruplet);
						k++;
						l--;
						while(arr[k-1] == arr[k]) {
							k++;
							if(k >= l) {
								break;
							}
						}
						
						while(arr[l] == arr[l+1]) {
							l--;
							if(k >= l) {
								break;
							}
						}
					}
				}
				
				// Increment logic of 'j'
				int temp = arr[j];
				while(temp == arr[j]) {
					j++;
					if(j >= n) {
						break;
					}
				}
			}
			
			// Increment logic of 'i'
			int temp = arr[i];
			while(temp == arr[i]) {
				i++;
				if(i >= n) {
					break;
				}
			}
		}
		
		return result;
	}
	
	// Best Approach (Optimal) - Two Pointer Solution
	// Just taken care of constraints so that it can be submitted on LeetCode
	// T = O(n*logn) * O(n^3) = O(n^3)
	// S = O(1)
	private static List<List<Integer>> four_sum_4(int[] arr, int target) {
		
		int n = arr.length;
		Arrays.sort(arr);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int i = 0;
		while(i < n) {
			
			int j = i+1;
			while(j < n) {
				
				int k = j+1;
				int l = n-1;
				//int newTarget = target - (arr[i] + arr[j]);
				while(k < l) {
					
					long sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    sum += arr[l];
					if(sum > target) {
						l--;
					} else if(sum < target) {
						k++;
					} else {
						List<Integer> quadruplet = new ArrayList<Integer>();
						quadruplet.add(arr[i]);
						quadruplet.add(arr[j]);
						quadruplet.add(arr[k]);
						quadruplet.add(arr[l]);
						
						result.add(quadruplet);
						k++;
						l--;
						while(arr[k-1] == arr[k]) {
							k++;
							if(k >= l) {
								break;
							}
						}
						
						while(arr[l] == arr[l+1]) {
							l--;
							if(k >= l) {
								break;
							}
						}
					}
				}
				
				// Increment logic of 'j'
				int temp = arr[j];
				while(temp == arr[j]) {
					j++;
					if(j >= n) {
						break;
					}
				}
			}
			
			// Increment logic of 'i'
			int temp = arr[i];
			while(temp == arr[i]) {
				i++;
				if(i >= n) {
					break;
				}
			}
		}
		
		return result;
	}
}
