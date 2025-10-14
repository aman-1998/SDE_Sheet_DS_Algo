package algorithms.part3;

public class Rabin_Karp_Algorithm {
	
	static int p = 5381; // We can take any prime no. but larger prime no. means less no.of collisions
	static int base = 26; // As we have only 26 characters (a to z)
	
	public static void main(String[] args) {
		String str = "mississippi";
		String subStr = "issip";
		boolean check = contains_leetCode(str, subStr);
		System.out.println(check);
	}
	
	/*
	 * Brute Force:
	 * --------------
	 * m = length of substring
	 * n = length of string
	 * 
	 * Compare 'substr' with all windows of m size in 'str'
	 * 
	 * T = O(m*n)
	 * S = O(1)
	 */
	public static boolean contains_BF(String str, String substr) {
		
		int n = str.length();
		int m = substr.length();
		
		for(int i = 0; i <= n-1; i++) {
			boolean noMatch = false;
			for(int j = 0; j <= m-1; j++) {
				if(i+j >= n || substr.charAt(j) != str.charAt(i+j)) {
					noMatch = true;
					break;
				}
			}
			
			if(noMatch == false) {
				return true;
			}
		}
		
		
		//for(int i = 0; i <= n-m; i++) {
		//	boolean noMatch = false;
		//	for(int j = 0; j <= m-1; j++) {
		//		if(substr.charAt(j) != str.charAt(i+j)) {
		//			noMatch = true;
		//			break;
		//		}
		//	}
		//	
		//	if(noMatch == false) {
		//		return true;
		//	}
		//}
		
		return false;
	}
	
	/*
	 * Optimal Approach : Rabin Karp / Rolling Hash
	 * 
	 * In worst case T = O(m*n) but because of strong hashFunction Average time complexity will be much less.
	 * In average case T = O(m + n)
	 * where m = length of substr, n = length of str
	 * 
	 * S = O(1)
	 */
	public static boolean contains(String str, String substr) {
		
		int n = str.length();
		int m = substr.length();
		
		if(m > n) {
			return false;
		}
		
		int hashValOfSubstr = hashValue(substr);
		
		String window = str.substring(0, m);
		int hashValOfWindow = hashValue(window);
		
		int highestPowerOfBase = 1;
		for(int i = 1; i <= m-1; i++) {
			highestPowerOfBase = highestPowerOfBase * base;
		}
		// highestPowerOfBase = Math.pow(26, m-1)
		
		for(int i = 0; i <= n-1; i++) {
			
			if(i != 0) {
				if(i+m-1 < n) {
					int num1 = str.charAt(i-1) - 'a' + 1;
					hashValOfWindow = hashValOfWindow - (num1 * highestPowerOfBase);
					hashValOfWindow = hashValOfWindow * 26;
					int num2 = str.charAt(i+m-1) - 'a' + 1;
					hashValOfWindow = hashValOfWindow + num2;
				} else {
					return false;
				}
			}
			
			if(hashValOfWindow == hashValOfSubstr) {
				if(substr.equals(str.substring(i, i+m))) {
					return true;
				}
			}		
		}
		
		return false;
	}
	
	public static int hashValue(String str) {
		
		int n = str.length();
		int res = 0;
		int x = 1;
		for(int i = n-1; i >= 0; i--) {
			int num = str.charAt(i) - 'a' + 1;
			res = res + num * x;
			x = x*base;
		}
		return res;
	}
	
//===================================================================================================================
// This code is for submission on leetccode
	
	/*
	 * Optimal Approach : Rabin Karp / Rolling Hash
	 * 
	 * In worst case T = O(m*n) but because of strong hashFunction Average time complexity will be much less.
	 * In average case T = O(m + n)
	 * where m = length of substr, n = length of str
	 * 
	 * S = O(1)
	 */
	public static boolean contains_leetCode(String str, String substr) {
		
		int n = str.length();
		int m = substr.length();
		
		if(m > n) {
			return false;
		}
		
		int hashValOfSubstr = hashValue_leetCode(substr);
		
		String window = str.substring(0, m);
		int hashValOfWindow = hashValue_leetCode(window);
		
		int highestPowerOfBase = 1;
		for(int i = 1; i <= m-1; i++) {
			highestPowerOfBase = (highestPowerOfBase * base) % p;
		}
		// highestPowerOfBase = Math.pow(26, m-1)
		
		for(int i = 0; i <= n-1; i++) {
			
			if(i != 0) {
				if(i+m-1 < n) {
					int p = 5381;
					int num1 = str.charAt(i-1) - 'a' + 1;
					hashValOfWindow = (hashValOfWindow - (num1 * highestPowerOfBase) % p + p) % p ;
					hashValOfWindow = hashValOfWindow * 26;
					int num2 = str.charAt(i+m-1) - 'a' + 1;
					hashValOfWindow = (hashValOfWindow + num2) % p;
				} else {
					return false;
				}
			}
			
			if(hashValOfWindow == hashValOfSubstr) {
				if(substr.equals(str.substring(i, i+m))) {
					return true;
				}
			}		
		}
		
		return false;
	}
	
	public static int hashValue_leetCode(String str) {
		
		int n = str.length();
		int res = 0;
		int x = 1;
		for(int i = n-1; i >= 0; i--) {
			int num = str.charAt(i) - 'a' + 1;
			res = (res + num * x) % p;
			x = (x * base) % p;
		}
		return res;
	}
	
}
