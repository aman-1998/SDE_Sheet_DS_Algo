package algorithms.part3;

public class Index_Of_First_Occurrence {
	
	static int p = 5381; // We can take any prime no. but larger prime no. means less no.of collisions
	static int base = 26; // As we have only 26 characters (a to z)
	
	public static void main(String[] args) {
		String str = "sdbsksksvvvjlaowytvjlanndd";
		String substr = "vjla";
		
		//int index = str.indexOf(substr);
		int index = firstOccurrence(str, substr);
		System.out.println(index);
	}
	
	/*
	 * Optimal Approach : Rabin Karp / Rolling Hash
	 * 
	 * Just modify Rabin Karp algorithm to return index instead of boolean value.
	 * 
	 * In worst case T = O(m*n) but because of strong hashFunction Average time complexity will be much less.
	 * In average case T = O(m + n)
	 * where m = length of substr, n = length of str
	 * 
	 * S = O(1)
	 */
	public static int firstOccurrence(String str, String substr) {
        int n = str.length();
		int m = substr.length();
		
		if(m > n) {
			return -1;
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
					return -1;
				}
			}
			
			if(hashValOfWindow == hashValOfSubstr) {
				if(substr.equals(str.substring(i, i+m))) {
					return i;
				}
			}		
		}
		
		return -1;
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
