package algorithms.part3;

public class KMP_Knuth_Morris_Pratt_Algorithm {

	public static void main(String[] args) {
		
		String str = "ABCAABDABDCABCABDABCCBA";
		String substr = "ABCABDABC";
		
		//String str = "AAAXAAAAA";
		//String substr = "AAAA";
		
		//String str = "ABABXABAXABABAA";
		//String substr = "ABABA";
		
		//String str = "AAAXAAAXA";
		//String substr = "AAAA";
		
		boolean check = contains(str, substr);
		
		System.out.println(check);
	}
	
	/*
	 * Optimal solution : Using KMP algorithm
	 * 
	 * T = O(m + n) where, m = length of substr and n = length of str
	 * 
	 * S = O(n)
	 */
	public static boolean contains(String str, String substr) {
		
		int m = substr.length();
		int n = str.length();
		
		// Longest-Prefix-Suffix Array
		int[] lps = prepareLPS(substr);
		
		int i = 0; // to iterate str
		int j = 0; // to iterate substr
		while(i < n) {
			if(str.charAt(i) == substr.charAt(j)) {
				i++;
				j++;
			} else {
				if(j == 0) {
					i++;
				} else {
					j = lps[j - 1];
				}
			}
			
			if(j == m) {
				return true;
			}
		}
		
		return false;
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
