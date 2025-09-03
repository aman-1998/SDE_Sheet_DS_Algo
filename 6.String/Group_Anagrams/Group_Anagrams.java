package practice.dsa.sheet.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Group_Anagrams {
	
	public static void main(String[] args) {
		
		String[] strArr = {"bdddddddddd","bbbbbbbbbbc"};
		List<List<String>> anagramGroups = groupAnagrams(strArr);
		
		anagramGroups.forEach(t -> System.out.println(t.toString()));
	}
	
	/*
	 * T = O(n) * O(n*(n*(x+y) + n*log n))
	 * S = O(n)
	 */
	public List<List<String>> groupAnagrams_BruteForce(String[] strArr) {
        
		int n = strArr.length;
		List<List<String>> anagramGroups = new ArrayList<>();
		Set<List<String>> set = new HashSet<>();
		
        for(int i = 0; i <= n-1; i++) {
        	List<String> group = new ArrayList<>();
        	for(int j = i; j <= n-1; j++) {
        		if(isAnagram(strArr[i], strArr[j])) { // T = O(x+y)
        			group.add(strArr[j]);
        		}
        	}
        	Collections.sort(group); // T = O(n*log n)
        	set.add(group);
        }
        
        anagramGroups.addAll(set);
        return anagramGroups;
    }
	
	public boolean isAnagram(String str1, String str2) {
		
		int m = str1.length();
		int n = str2.length();
		
		int[] letter = new int[26];
		
		for(int i = 0; i <= m-1; i++) {
			letter[str1.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i <= n-1; i++) {
			letter[str2.charAt(i) - 'a']--;
		}
		
		for(int i = 0 ; i <= 25; i++) {
			if(letter[i] != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Optimal solution
	 * 
	 * T = O(n*x) ; where n = length of array, x = maximum length of a string
	 * S = O(n)
	 */
	public static List<List<String>> groupAnagrams(String[] strArr) {
		
		int n = strArr.length;
		Map<String, List<String>> groupMap = new HashMap<>();
		for(int i = 0; i <= n-1; i++) {
			int[] letter = new int[26];
			String str = strArr[i];
			int len = str.length();
			for(int j = 0; j <= len-1; j++) { // T = O(x)
				letter[str.charAt(j) - 'a']++;
			}
			
			String key = "";
			for(int j = 0 ; j <= 25; j++) {
				key = key + letter[j] + "#";
			}
			
			List<String> group = groupMap.get(key);
			if(group == null) {
				group = new ArrayList<>();
			} 
			group.add(str);
			groupMap.put(key, group);
		}
		
		return new ArrayList<>(groupMap.values());
		
	}
}
