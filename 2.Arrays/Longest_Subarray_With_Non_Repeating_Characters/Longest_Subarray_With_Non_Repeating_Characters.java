package algorithms.part1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Subarray_With_Non_Repeating_Characters {
	
	public static void main(String[] args) {
		
		//String str = "aac";
		//int maxLength = longest_subarray_without_repeating_Worst_BF(str);
		//int maxLength = longest_subarray_without_repeating_BF(str);
		//int maxLength = longest_subarray_without_repeating_better(str);
		//int maxLength = longest_subarray_without_repeating(str);
		
		//String str = "Hello";
		//int maxLength = longest_subarray_without_repeating_Worst_BF(str);
		//int maxLength = longest_subarray_without_repeating_BF(str);
		//int maxLength = longest_subarray_without_repeating_better(str);
		//int maxLength = longest_subarray_without_repeating(str);
		
		//String str = "abcaabcdba";
		String str = "aabcdceadecb";
		//int maxLength = longest_subarray_without_repeating_Worst_BF(str);
		//int maxLength = longest_subarray_without_repeating_BF(str);
		//int maxLength = longest_subarray_without_repeating_better(str);
		int maxLength = longest_subarray_without_repeating(str);
		
		System.out.println(maxLength);
	}
	
	/*
	 * Worst Brute Force
	 * 
	 * T = O(n^3)
	 * S = O(n)
	 */
	private static int longest_subarray_without_repeating_Worst_BF(String str) {
		
		int n = str.length();
		int maxLength = Integer.MIN_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			for(int j = i; j <= n-1; j++) {
				Set<Character> hashSet = new HashSet<>();
				int count = 0;
				for(int k = i; k <= j; k++) {
					if(!hashSet.contains(str.charAt(k))) {
						hashSet.add(str.charAt(k));
						count++;
					} else {
						break;
					}
				}
				
				if(count > maxLength) {
					maxLength = count;
				}
			}
		}
		
		return maxLength;
	}
	
	/*
	 * Better Brute Force
	 * 
	 * T = O(n^2)
	 * S = O(n)
	 */
	private static int longest_subarray_without_repeating_BF(String str) {
		
		int n = str.length();
		int maxLen = Integer.MIN_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			
			Set<Character> hSet = new HashSet<>();
			int count = 0;
			
			for(int j = i; j <= n-1; j++) {
				
				if(!hSet.contains(str.charAt(j))) {
					hSet.add(str.charAt(j));
					count++;
				} else {
					break;
				}
			}
			
			if(count > maxLen) {
				maxLen = count;
			}
		}
		
		return maxLen;
	}
	
	/*
	 * Better Solution: Using HashSet
	 * 
	 * T = O(2n)
	 * S = O(n)
	 */
	private static int longest_subarray_without_repeating_better(String str) {
		
		int n = str.length();
		Set<Character> hSet = new HashSet<>();
		int maxLen = 0;
		
		int l = 0, r = 0;
		
		while(r < n) {
			if(!hSet.contains(str.charAt(r))) {
				int len = r - l + 1;
				if(len > maxLen) {
					maxLen = len;
				}
				
				hSet.add(str.charAt(r));
				r++;
			} else {
				hSet.remove(str.charAt(l));
				l++;
			}
		}
		
		return maxLen;
	}
	
	/*
	 * Best Solution: Using HashMap
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	private static int longest_subarray_without_repeating(String str) {
		
		int n = str.length();
		Map<Character, Integer> hMap = new HashMap<>();
		int maxLen = 0;
		
		int l = 0, r = 0;
		
		while(r < n) {
			Integer index = hMap.get(str.charAt(r));
			if(index != null) {
				if(index >= l && index < r) {
					l = index + 1;
				}
			}
			
			int len = r - l + 1;
			if(len > maxLen) {
				maxLen = len;
			}
			hMap.put(str.charAt(r), r);
			r++;
		}
		
		return maxLen;
	}
	
}
