package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
	
	public static void main(String[] args) {
		String str = "aabb";
		
		List<List<String>> palindromePartitions = partition(str);
		
		palindromePartitions.stream().forEach((List<String> list) -> System.out.println(list));
	}
	
	/*
	 * T = O(n * 2^n)
	 * S = O(n)
	 */
	public static List<List<String>> partition(String str) {
        
		List<String> path = new ArrayList<>();
		List<List<String>> res = new ArrayList<>();
		solve(str, 0, path, res);
		return res;
    }
	
	public static void solve(String str, int index, 
							 List<String> path, List<List<String>> res) {
		
		if(index == str.length()) {
			res.add(new ArrayList<>(path));
			return;
		}
		
		for(int i = index; i <= str.length()-1; i++) {
			if(isPalindrome(str, index, i)) {
				path.add(str.substring(index, i+1));
				solve(str, i+1, path, res);
				path.remove(path.size()-1);
			}
		}
	}

	private static boolean isPalindrome(String str, int start, int end) {
		
		int i = start;
		int j = end;
		
		while(i <= j) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
}
