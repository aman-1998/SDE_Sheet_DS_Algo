package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Link : https://www.youtube.com/watch?v=vgnhZzw-kfU
 */
public class Letter_Combinations_Of_A_Phone_Number {
	
	public static void main(String[] args) {
		
		String digits = "237";
		
		List<String> res = letterCombinations(digits);
		
		res.stream().forEach(word -> System.out.println(word));
	}
	
	/*
	 * Worst case occurs when each digit is either 7 or 9 because they points to 4 alphabets. 
	 * After finding a word we add it to result which takes O(n) time.
	 * 
	 * T = O(n x 4^n)  ; n = digit length
	 * 
	 * S = O(n)
	 */
	public static List<String> letterCombinations(String digits) {
        
		Map<Character, String> keypadMap = new HashMap<>();
		keypadMap.put('2', "abc");
		keypadMap.put('3', "def");
		keypadMap.put('4', "ghi");
		keypadMap.put('5', "jkl");
		keypadMap.put('6', "mno");
		keypadMap.put('7', "pqrs");
		keypadMap.put('8', "tuv");
		keypadMap.put('9', "wxyz");
		
		List<String> res = new ArrayList<>();
		StringBuilder wordSb = new StringBuilder();
		
		solve(digits, keypadMap, 0, wordSb, res);
		
		return res;
    }
	
	private static void solve(String digits, Map<Character, String> keypadMap, 
							  int index, StringBuilder wordSb, List<String> res) {

		if(index == digits.length()) {
			res.add(wordSb.toString());
			return;
		}
		
		String letters = keypadMap.get(digits.charAt(index));
		
		for(int i = 0; i <= letters.length()-1; i++) {
			wordSb.append(letters.charAt(i));
			solve(digits, keypadMap, index+1, wordSb, res);
			wordSb.deleteCharAt(wordSb.length()-1);
		}
	}
}
