package algorithms.part3;

public class Min_Chars_To_Be_Added_At_Beginning_To_Make_Palindrome {
	
	public static void main(String[] args) {
		
		String str = "baabcd";
		
		int noOfCharsToBeAdded =  makePalindromeByAddingAtBeg(str);
		
		System.out.println(noOfCharsToBeAdded);
	}
	
	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static int makePalindromeByAddingAtBeg(String str) {
		
		int n = str.length();
		
		str = str + "$" + new StringBuilder(str).reverse();
		int[] lps = prepareLPS(str);
		
		int noOfCharsToBeAdded = n - lps[lps.length-1];
		
		return noOfCharsToBeAdded;
	}
	
	/*
	 * Prepare Longest-Prefix-Suffix-Array
	 * Find length of Longest-perfect-prefix which is also a suffix at each position.
	 * Perfect prefix means it should be a prefix not the string itself.
	 * 
	 * T = O(2*n) = O(n)
	 * S = O(1)
	 * 
	 */
	private static int[] prepareLPS(String substr) {
		
		int m = substr.length();
		int[] lps = new int[m];
		
		int prevLPS = 0;
		int i = 1;
		while(i < m) {
			if(substr.charAt(i) == substr.charAt(prevLPS)) {
				lps[i] = prevLPS + 1;
				i++;
				prevLPS++;
			} else {
				if(prevLPS == 0) {
					lps[i] = 0;
					i++;
				} else {
					prevLPS = lps[prevLPS - 1];
				}
			}
		}
		
		return lps;
	}
}
