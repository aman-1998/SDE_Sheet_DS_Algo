package algorithms.part3;

import java.util.HashMap;
import java.util.Map;

public class Roman_To_Integer {
	
	public static void main(String[] args) {
		
		String roman = "CMXCVIII";
		int result = romanToInt(roman);
		
		System.out.println(result);
	}
	
	/*
	 * T= O(n)
	 * S = O(hash_Map_size) = O(7) = O(1)
	 */
	public static int romanToInt(String roman) {
		
		int n = roman.length();
		
		Map<Character, Integer> hMap = new HashMap<Character, Integer>();
		hMap.put('I', 1);
		hMap.put('V', 5);
		hMap.put('X', 10);
		hMap.put('L', 50);
		hMap.put('C', 100);
		hMap.put('D', 500);
		hMap.put('M', 1000);
		
		int res = 0;
		for(int i = 0; i <= n-1; i++) {
			if(i+1 < n && hMap.get(roman.charAt(i)) >= hMap.get(roman.charAt(i+1))) {
				res = res + hMap.get(roman.charAt(i));
			} else if(i+1 < n && hMap.get(roman.charAt(i)) < hMap.get(roman.charAt(i+1))) {
				res = res - hMap.get(roman.charAt(i));
			} else {
				res = res + hMap.get(roman.charAt(i));
			}
		}
		
		return res;
	}
}
