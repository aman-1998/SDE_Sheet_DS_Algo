package algorithms.part3;

public class Repeated_String_Match {
	
	static int p = 5381; // We can take any prime no. but larger prime no. means less no.of collisions
	static int base = 26; // As we have only 26 characters (a to z)
	
	public static void main(String[] args) {
		
		String a = "abcd";
		String b = "cdabcdab";
		
		int min = repeatedStringMatch(a, b);
		
		System.out.println(min);
	}
	
	/*
	 * Best approach (Using Rabin Karp algorithm)
	 * 
	 * T = O(n/m) * O(m + n) , where m = length of a and n = length of b
	 */
    public static int repeatedStringMatch(String a, String b) {
        
        int m = a.length();
		int n = b.length();
		
		String original = new String(a);
		//for(int i = 1; i <= n/m+2; i++) {
		for(int i = 1; i <= Math.ceil((double)(m+n-1)/(double)m); i++) {
			
			if(contains(a, b) == true) {
				return i;
			}
			a = a + original;
		}
		
		return -1;
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
	
	public static int hashValue(String str) {
		
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
