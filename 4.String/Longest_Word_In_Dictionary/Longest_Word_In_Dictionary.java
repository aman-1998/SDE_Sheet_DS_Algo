package practice.dsa.sheet.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Longest_Word_In_Dictionary {
	
	public static void main(String[] args) {
		
		String s = "aewfafwafjlwajflwajflwafj";
		List<String> dictionary = Arrays.asList("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf");
		
		String output = findLongestWord_1st_version(s, dictionary);
		
		System.out.println(output);
		
		System.out.println("==============================================================");
		
		s = "oetdg";
		dictionary = Arrays.asList("to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana");
		
		List<String> result = findLongestWord_2nd_version(s, dictionary);
		
		result.stream().forEach(t -> System.out.println(t + " "));
	}
	
	
	/*
	 * Given a string of letters and a dictionary, the function should find the longest word in the dictionary 
	 * that can be made from the letters. If there are more then one such words then return smallest lexicographical 
	 * order. Only lowercase letters will occur in the dictionary and the letters. The length of letters will be 
	 * between 1 and 10 characters. The solution should work well for a dictionary of over 100,000 words.
	 * 
	 * Example1 - letters = "oet", dictionary = {"to","toe","toes"}, Output: "toe" 
	 * 
	 * Example2 -letters = "oetdg", dictionary = {"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"}, Output: "doe"
	 */
	public static String findLongestWord_1st_version(String s, List<String> dictionary) {
        
		int n = dictionary.size();
		int len = s.length();
		int maxLen = Integer.MIN_VALUE;
		String ans = "";
		
		for(int i = 0; i <= n-1; i++) {
			
			int[] letters = new int[26];
			String str = dictionary.get(i);
			int individualLen = str.length();
			
			for(int j = 0; j < individualLen; j++) {
				letters[str.charAt(j) - 'a']++;
			}
			
			for(int j = 0; j < len; j++) {
				if(letters[s.charAt(j) - 'a'] != 0) {
					letters[s.charAt(j) - 'a']--;
				}
			}
			
			boolean possible = true;
			for(int j = 0; j <= 25; j++) {
				if(letters[j] != 0) {
					possible = false;
					break;
				}
			}
			
			if(possible) {
				if(individualLen > maxLen) {
					maxLen = individualLen;
					ans = str;
				} else if(individualLen == maxLen) {
					if(ans.isEmpty()) {
						ans = str;
					} else if(str.compareTo(ans) < 0) {
						ans = str;
					}
				}
			}
		}
		
		return ans;
    }
	
	
	/*
	 * Given a string of letters and a dictionary, the function should find the longest word or words in the dictionary 
	 * that can be made from the letters. Only lowercase letters will occur in the dictionary and the letters. 
	 * The length of letters will be between 1 and 10 characters. The solution should work well for a dictionary of 
	 * over 100,000 words.
	 * 
	 * Example1 - letters = "oet", dictionary = {"to","toe","toes"}, Output: {"toe"} 
	 * 
	 * Example2 -letters = "oetdg", dictionary = {"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"}, Output: {"doe", "toe", "dog", "god"}
	 */
	public static List<String> findLongestWord_2nd_version(String s, List<String> dictionary) {
        
		int n = dictionary.size();
		int len = s.length();
		int maxLen = Integer.MIN_VALUE;
		List<String> tempStringList = new ArrayList<>();
		
		for(int i = 0; i <= n-1; i++) {
			
			int[] letters = new int[26];
			String str = dictionary.get(i);
			int individualLen = str.length();
			
			for(int j = 0; j < individualLen; j++) {
				letters[str.charAt(j) - 'a']++;
			}
			
			for(int j = 0; j < len; j++) {
				if(letters[s.charAt(j) - 'a'] != 0) {
					letters[s.charAt(j) - 'a']--;
				}
			}
			
			boolean possible = true;
			for(int j = 0; j <= 25; j++) {
				if(letters[j] != 0) {
					possible = false;
					break;
				}
			}
			
			if(possible) {
				if(individualLen >= maxLen) {
					maxLen = individualLen;
					tempStringList.add(str);
				}
			}
		}
		
		List<String> result = new ArrayList<>();
		for(String str : tempStringList) {
			if(str.length() == maxLen) {
				result.add(str);
			}
		}
		
		return result;
    }
}
