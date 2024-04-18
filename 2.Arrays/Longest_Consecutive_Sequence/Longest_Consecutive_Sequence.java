package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 
Longest Consecutive Sequence in an Array
------------------------------------------
Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

Examples
Example 1:

Input: [100, 200, 1, 3, 2, 4]

Output: 4

Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.

Input: [3, 8, 5, 7, 6]

Output: 4

Explanation: The longest consecutive subsequence is 5, 6, 7, and 8.
 * 
 */

/*
 * Note:-
 * ------
 * Longest subsequence of consecutive elements = Longest consecutive sequence
 * 
 */
public class Longest_Consecutive_Sequence {
	
	public static void main(String[] args) {
		
		int[] arr = {100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2};
		//int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		//int[] arr = {};
		
		int maxLength = longest_consecutive_sequence_1(arr);
		System.out.println(maxLength);
		
	}
	
	// Brute Force
	// T = O(n^3)
	// S = O(1)
	private static int longest_consecutive_sequence_1(int[] arr) {
		
		int n = arr.length;
		int maxLength = Integer.MIN_VALUE;
		
		for(int i = 0; i <= n-1; i++) { // O(n)
			
			int current = arr[i]; // Longest consecutive sequence starting from current
			int tempLength = 1;
			
			int j=0;
			while(j < n) { // =~ O(n^2)
				if(arr[j] == current + 1) {
					current = current + 1;
					tempLength++;
					j = 0;
					continue;
				}
				j++;
			}
			
			if(tempLength > maxLength) {
				maxLength = tempLength;
			}
		}
		
		return maxLength;
	}
	
	// Better Solution
	// T = O(n*log n) + O(n) = O(n*log n)
	// S = O(1)
	private static int longest_consecutive_sequence_2(int[] arr) {
		
		int n = arr.length;
		Arrays.sort(arr);
		
		int current = Integer.MIN_VALUE;
		int tempLength = 0;
		int maxLength = Integer.MIN_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			
			if(arr[i] == current + 1) {
				current = current + 1;
				tempLength++;
			} else if(arr[i] == current) {
				continue;
			} else {
				
				if(maxLength < tempLength) {
					maxLength = tempLength;
				}
				current = arr[i];
				tempLength = 1;
			}
		}
		
		if(maxLength < tempLength) {
			maxLength = tempLength;
		}
		
		return maxLength;
	}
	
	// Best Solution
	//Assumption: Considering HashMap takes O(1) time
	// T = O(n) + O(2n) = O(n) 
	// S = O(n)
	private static int longest_consecutive_sequence_3(int[] arr) {
		
		int n = arr.length;
		Map<Integer, Boolean> hashMap = new HashMap<>();
		/*
		 * HashMap<Integer, Boolean>
		 * --------------------------
		 * (100, true) ---> This means we have already found the length of longest consecutive sequence starting with 100
		 * (102, false)
		 * (101, false)
		 * (4, false)
		 * (3, false)
		 * (2, false)
		 * (1, false) ---> This means we have not yet found the length of longest consecutive sequence starting with 1
		 */
		
		int tempLength = 0;
		int maxLength = Integer.MIN_VALUE;
		
		for(int i = 0; i <= n-1; i++) { // T = O(n)
			hashMap.put(arr[i], false);
		}
		int current = Integer.MIN_VALUE;
		
		for(int i = 0; i <= n-1; i++) { // T = O(2n) ==> Think about it logically
			if(!hashMap.containsKey(arr[i]-1)) {
				Boolean val = hashMap.get(arr[i]);
				if(val == false) { // That means we have not yet found length of longest consecutive sequence starting with arr[i]
					current = arr[i];
					tempLength = 1;
					while(hashMap.containsKey(current+1)) {
						current = current + 1;
						tempLength++;
					}
					
					if(maxLength < tempLength) {
						maxLength = tempLength;
					}
					
					hashMap.put(arr[i], true); // That means we have found length of longest consecutive sequence starting with arr[i]. So, marking it true.
				}
			}
		}
		
		if(maxLength < tempLength) {
			maxLength = tempLength;
		}
		
		return maxLength;
	}
}
