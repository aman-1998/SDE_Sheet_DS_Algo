package algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Single_Number_version1 {
	
	public static void main(String[] args) {
		
		int[] arr = {4, 7, 6, 7, 6, 5, 4};
		int singleNumber = singleNumber(arr);
		System.out.println(singleNumber);
	}
	
	/*
	 * Brute Force will take O(n^2) => Using Outer For loop and Inner For loop
	 */
	
	/*
	 * Better : Using HashMap
	 * 
	 * T = O(n)*O(hash_map_operation) =~ O(n)
	 * S = O(n)
	 */
	private static int singleNumber_better(int[] arr) {
		
		int n = arr.length;
		Map<Integer, Integer> hashMap = new HashMap<>();
		
		for(int i = 0; i <= n-1; i++) {
			Integer element = hashMap.get(arr[i]);
			if(element == null) {
					hashMap.put(arr[i], 1);
			} else {
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
			}
		}
		
		int result = -1;
		Iterator<Map.Entry<Integer, Integer>> ite = hashMap.entrySet().iterator();
		while(ite.hasNext()) {
			Map.Entry<Integer, Integer> entry = ite.next();
			if(entry.getValue() == 1) {
				result = entry.getKey();
				break;
			}
		}
		
		return result;
	}
	
	/*
	 * Best Solution : Using XOR
	 * 
	 * T = O(n)
	 * S = O(1)
	 */
	private static int singleNumber(int[] arr) {
		
		int xr = 0;
		for(int i : arr) {
			xr = xr ^ i;
		}
		return xr;
	}
}
