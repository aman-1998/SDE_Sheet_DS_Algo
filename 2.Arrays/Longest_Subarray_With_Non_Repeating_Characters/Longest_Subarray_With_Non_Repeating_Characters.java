package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Subarray_With_Non_Repeating_Characters {
	
	public static void main(String[] args) {
		
		//String str = "aac";
		//int maxLength = longest_subarray_without_repeating_better_BF(str);
		//int maxLength = longest_subarray_without_repeating_better(str);
		//int maxLength = longest_subarray_without_repeating(str);
		
		//String str = "Hello";
		//int maxLength = longest_subarray_without_repeating_better_BF(str);
		//int maxLength = longest_subarray_without_repeating_better(str);
		//int maxLength = longest_subarray_without_repeating(str);
		
		String str = "aabcdceadecb";
		//int maxLength = longest_subarray_without_repeating_better_BF(str);
		//int maxLength = longest_subarray_without_repeating_better(str);
		int maxLength = longest_subarray_without_repeating(str);
		
		System.out.println(maxLength);
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n^3)
	 * S = O(n)
	 */
	private static int longest_subarray_without_repeating_better_BF(String str) {
		
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
	 * Better Solution: Using HashSet
	 * 
	 * T = O(2n)
	 * S = O(n)
	 */
	private static int longest_subarray_without_repeating_better(String str) {
		
		int n = str.length();
		Set<Character> hashSet = new HashSet<>();
		int l = 0;
		int r = 0;
		int maxLength = Integer.MIN_VALUE;
		
		while(r < n) {
			
			if(hashSet.contains(str.charAt(r))) {
				
				int count = r - l;
				if(count > maxLength) {
					maxLength = count;
				}
				
				do {
					hashSet.remove(str.charAt(l));
					l++;
				} while(hashSet.contains(str.charAt(r)));
				
				hashSet.add(str.charAt(r));
			}
			hashSet.add(str.charAt(r));
			r++;
		}

        int length = r - l;
		if(length > maxLength) {
			maxLength = length;
		}
		
		return maxLength;
	}
	
	/*
	 * Best Solution: Using HashMap
	 * 
	 * T = O(n)
	 * S = O(n)
	 */
	private static int longest_subarray_without_repeating(String str) {
		
		int n = str.length();
		Map<Character, Integer> hashMap = new HashMap<>();
		int l = 0;
		int r = 0;
		int maxLength = Integer.MIN_VALUE;
		
		while(r < n) {
			
			Integer index = hashMap.get(str.charAt(r));
			if(index != null) {
				if(l <= index && index < r) {
					int length = r - l;
					if(length > maxLength) {
						maxLength = length;
					}
					hashMap.put(str.charAt(r), r);
					l = index + 1;
				}
			}
			hashMap.put(str.charAt(r), r);
			r++;
		}

        int length = r - l;
		if(length > maxLength) {
			maxLength = length;
		}
		
		return maxLength == Integer.MIN_VALUE ? 1 : maxLength;
	}
}
