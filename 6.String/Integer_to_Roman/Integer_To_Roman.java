package algorithms.part3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Integer_To_Roman {
	
	public static void main(String[] args) {
		
		int num = 998;
		String roman = IntToRoman_3rd(num);
		
		System.out.println(roman);
	}
	
	/*
	 * T = O(1)
	 * S = O(1)
	 */
	public static String IntToRoman_1st(int num) {
		
		Map<Integer, String> sortedMap = new TreeMap<>(Comparator.reverseOrder());
		sortedMap.put(1, "I");
		sortedMap.put(5, "V");
		sortedMap.put(10, "X");
		sortedMap.put(50, "L");
		sortedMap.put(100, "C");
		sortedMap.put(500, "D");
		sortedMap.put(1000, "M");
		sortedMap.put(4, "IV");
		sortedMap.put(9, "IX");
		sortedMap.put(40, "XL");
		sortedMap.put(90, "XC");
		sortedMap.put(400, "CD");
		sortedMap.put(900, "CM");
		
		StringBuilder romanSb = new StringBuilder();
		Iterator<Map.Entry<Integer, String>> iterator = sortedMap.entrySet().iterator();
		while(num != 0 && iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			int key = entry.getKey();
			String value = entry.getValue();
			
			int q = num / key;
		    num = num % key;
		    for(int i = 1; i <= q; i++) {
		    	romanSb.append(value);
		    }
		}
		
		return romanSb.toString();
	}
	
	/*
	 * T = O(1)
	 * S = O(1)
	 */
	public static String IntToRoman_2nd(int num) {
		
		Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put(1000, "M");
		linkedHashMap.put(900, "CM");
		linkedHashMap.put(500, "D");
		linkedHashMap.put(400, "CD");
		linkedHashMap.put(100, "C");
		linkedHashMap.put(90, "XC");
		linkedHashMap.put(50, "L");
		linkedHashMap.put(40, "XL");
		linkedHashMap.put(10, "X");
		linkedHashMap.put(9, "IX");
		linkedHashMap.put(5, "V");
		linkedHashMap.put(4, "IV");
		linkedHashMap.put(1, "I");
		
		StringBuilder romanSb = new StringBuilder();
		Iterator<Map.Entry<Integer, String>> iterator = linkedHashMap.entrySet().iterator();
		while(num != 0 && iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			int key = entry.getKey();
			String value = entry.getValue();
			
			int q = num / key;
		    num = num % key;
		    for(int i = 1; i <= q; i++) {
		    	romanSb.append(value);
		    }
		}
		
		return romanSb.toString();
	}
	
	static class Pair {
		
		int intValue;
		String romanValue;
		
		public Pair(int intValue, String romnValue) {
			this.intValue = intValue;
			this.romanValue = romnValue;
		}
	}	
	
	/*
	 * Best
	 * 
	 * T = O(1)
	 * S = O(1)
	 */
	public static String IntToRoman_3rd(int num) {
		
		List<Pair> list = new ArrayList<>();
		list.add(new Pair(1000, "M"));
		list.add(new Pair(900, "CM"));
		list.add(new Pair(500, "D"));
		list.add(new Pair(400, "CD"));
		list.add(new Pair(100, "C"));
		list.add(new Pair(90, "XC"));
		list.add(new Pair(50, "L"));
		list.add(new Pair(40, "XL"));
		list.add(new Pair(10, "X"));
		list.add(new Pair(9, "IX"));
		list.add(new Pair(5, "V"));
		list.add(new Pair(4, "IV"));
		list.add(new Pair(1, "I"));
		
		StringBuilder romanSb = new StringBuilder();
		Iterator<Pair> iterator = list.iterator();
		while(num != 0 && iterator.hasNext()) {
			Pair pair = iterator.next();
			int intVal = pair.intValue;
			String romanVal = pair.romanValue;
			
			int q = num / intVal;
		    num = num % intVal;
		    for(int i = 1; i <= q; i++) {
		    	romanSb.append(romanVal);
		    }
		}
		
		return romanSb.toString();
	}
	
}
