package algorithms.part3;

public class Longest_Palindromic_Substring {
	
	public static void main(String[] args) {
		
		String str = "efghabcddcbaijklm";
		String longestPalindrome = longestPalindromicSubstring(str);
		System.out.println(longestPalindrome);
		
		str = "dcdeabcbaebcbe";
		longestPalindrome = longestPalindromicSubstring(str);
		System.out.println(longestPalindrome);
		
	}
	
	/*
	 * T = O(n*n)
	 * S = O(1)
	 */
	public static String longestPalindromicSubstring(String str) {
		
		int n = str.length();
		
		int start = 0;
		int end = 0;
		int maxLen = 0;
		
		for(int i = 0; i <= n-1; i++) { // O(n)
			
			// For even palindromic substring
			int l = i;
			int h = i+1;
			while(l >= 0 && h < n && str.charAt(l) == str.charAt(h)) { // O(n)
				
				int len = h - l + 1;
				if(len > maxLen) {
					maxLen = len;
					start = l;
					end = h;
				}
				
				l--;
				h++;
			}
			
			// For odd palindromic substring
			l = i;
			h = i+2;
			while(l >= 0 && h < n && str.charAt(l) == str.charAt(h)) { // O(n)
				
				int len = h - l + 1;
				if(len > maxLen) {
					maxLen = len;
					start = l;
					end = h;
				}
				
				l--;
				h++;
			}
		}
		
		return str.substring(start, end+1); // O(n)
	}
}
