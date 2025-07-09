package algorithms.part1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * 
Find the Majority Element that occurs more than N/2 times
------------------------------------------------------------
Problem Statement: Given an array of N integers, write a program to return an element that occurs 
more than N/2 times in the given array. You may consider that such an element always exists in 
the array.

Examples
Example 1:
Input Format: N = 3, nums[] = {3,2,3}
Result: 3
Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

Example 2:
Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}

Result: 2

Explanation: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

Example 3:
Input Format:  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}

Result: 4
 * 
 */

public class Majority_Element_More_Than_n_By_2_Times {
	 
	public static void main(String[] args) {
		int[] arr = {4, 6, 7, 6, 7, 7, 7, 8, 7};
		//int[] arr = {3, 2, 3};
		int element = majorityElement_byNeetCode(arr);
		if(element != Integer.MIN_VALUE) {
			System.out.println("Majority element = " + element);
		} else {
			System.out.println("Majority elemet doesn't exit");
		}
	}
	
	// T = O(n + n) = O(2n) = O(n)
	//S = O(n)
	private static int majorityElementMoreThan_n_by_2_times_1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			if(map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		
		// Iterating over the hashmap
		Iterator<Map.Entry<Integer, Integer>> ite = map.entrySet().iterator();
		while(ite.hasNext()) {
			Map.Entry<Integer, Integer> entry = ite.next();
			if(entry.getValue() > n/2) {
				return entry.getKey();
			}
		}
		
		return Integer.MIN_VALUE;
	}
	
	// Better Approach
	// T = O(n)
	// S = O(n)
	private static int majorityElementMoreThan_n_by_2_times_2(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			if(map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
				if(map.get(arr[i]) > n/2) {
					return arr[i];
				}
			}
		}
		
		return Integer.MIN_VALUE;
	}
	
	// Best Approach
	// Moore's Voting Algorithm
	// T = O(n)
	// S = O(1)
	private static int majorityElementMoreThan_n_by_2_times_3(int[] arr) {
		
		int n = arr.length;
		int element = Integer.MIN_VALUE; // The element which is not present in the array
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			if(count == 0) {
				element = arr[i];
				count = 1;
			} else if(element == arr[i]) {
				count++;
			} else {
				count--;
			}
		}
		
		return element;
	}
	
	/*
	 * Best Approach : By Neet Code (Easy to understand)
	 * 
	 * Moore's Voting Algorithm
	 * T = O(n)
	 * S = O(1)
	 */
	private static int majorityElement_byNeetCode(int[] arr) {
		
		int n = arr.length;
		Map<Integer, Integer> hMap = new HashMap<>();
		
		for(int i = 0; i <= n-1; i++) {
			Integer count = hMap.get(arr[i]);
			if(count != null) {
				hMap.put(arr[i], count + 1);
			} else {
				if(hMap.size() == 1) {
					int element1=0, count1=0;
                    for(Map.Entry<Integer, Integer> entry: hMap.entrySet()) {
                    	element1 = entry.getKey();
                    	count1 = entry.getValue();
                    }
                    
                    if(count1 == 1) {
                    	hMap.remove(element1);
                    } else {
                    	hMap.put(element1, count1 - 1);
                    }
				} else {
					hMap.put(arr[i], 1);
				}
			}
		}
		
		Integer possibleResult = Integer.MIN_VALUE; // Default value if majority element does not exist
		for(Map.Entry<Integer, Integer> entry: hMap.entrySet()) {
			possibleResult = entry.getKey();
        }
		
		int count = 0;
		for(int i = 0; i <= n-1; i++) {
			if(arr[i] == possibleResult) {
				count++;
				if(count > n/2) {
					return possibleResult;
				}
			}
		}
		
		return possibleResult;
	}
}
