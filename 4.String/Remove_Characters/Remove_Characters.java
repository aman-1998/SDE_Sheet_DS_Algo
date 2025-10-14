package algorithms.part3;

import java.util.HashSet;
import java.util.Set;

public class Remove_Characters {
	
	public static void main(String[] args) {
		
		String output = removeCharacters("Main", "inkn");
		
		System.out.println(output);
	}
	
	/*
	 * T = O(2n) = O(n)
	 * S = O(n) for output
	 */
	public static String removeCharacters(String str1, String str2) {
		
		int n = str1.length();
		int m = str2.length();
		Set<Character> hashSet = new HashSet<>();
		
		for(int i = 0; i <= m-1; i++) {
			hashSet.add(str2.charAt(i));
		}
		
		StringBuilder output = new StringBuilder();
		for(int i = 0; i <= n-1; i++) {
			if(!hashSet.contains(str1.charAt(i))) {
				output.append(str1.charAt(i));
			}
		}
		
		return output.toString();
	}
}
