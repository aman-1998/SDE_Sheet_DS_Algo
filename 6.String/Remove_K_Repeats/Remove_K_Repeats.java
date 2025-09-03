package practice.dsa.sheet.part3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Remove_K_Repeats {
	
	public static void main(String[] args) {
		
		int[] arr = {8, 8, 5, 1, 5, 8, 1, 1, 5};
		int k = 3;
		boolean check = removeKRepeats(arr, k);
		
		System.out.println(check);
	}
	
	/*
	 * T = O(n + x) ; where n = no. of elements, x = no. of unique elements
	 * S = O(x)
	 */
	public static boolean removeKRepeats(int[] arr, int k) {
		
		int n = arr.length;
		Map<Integer, Integer> freqMap = new HashMap<>();
		for(int i = 0; i <= n-1; i++) {
			if(freqMap.containsKey(arr[i])) {
				freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
			} else {
				freqMap.put(arr[i], 1);
			}
		}
		
		for(Entry<Integer, Integer> entry : freqMap.entrySet()) {
			int value = entry.getValue();
			if(value % 3 != 0) {
				return false;
			}
		}
		
		return true;
	}
}
