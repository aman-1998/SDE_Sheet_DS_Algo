package practice.dsa.sheet.part5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
 * Video link : https://www.youtube.com/watch?v=2g_b1aYTHeg
 */
public class Reorganize_String_Such_That_Adjacent_Characters_Not_Same {
	
	public static void main(String[] args) {
		
		//String str = "aaab";
		String str = "aabcab";
		String output = reorganizeString(str);
		
		System.out.println(output);
	}
	
	/*
	 * T = O(n + n*log n) = O(n*log n)
	 * S = O(n)
	 */
	public static String reorganizeString(String str) {
		
		int n = str.length();
		Map<Character, Integer> freqMap = new HashMap<>();
		
		for(int i = 0; i <= n-1; i++) { // T = O(n)
			Integer freq = freqMap.get(str.charAt(i));
			if(freq == null) {
				freqMap.put(str.charAt(i), 1);
			} else {
				freqMap.put(str.charAt(i), freq+1);
			}
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparing((Map.Entry<Character, Integer> entry) -> entry.getValue()).reversed());
		
		for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) { // T = O(n*log n)
			maxHeap.add(entry);
		}
		
		Map.Entry<Character, Integer> prev = null;
		StringBuilder output = new StringBuilder();
		while(!maxHeap.isEmpty()) { // T = O(n*2*log n)
			Map.Entry<Character, Integer> popped = maxHeap.poll(); // T = O(log n)
			output.append(popped.getKey());
			popped.setValue(popped.getValue()-1);
			if(prev != null && prev.getValue() > 0) {
				maxHeap.add(prev); // T = O(log n)
			}
			prev = popped;
		}
		
		if(output.length() != str.length()) {
			return "";
		}
		
		return output.toString();
	}
}
