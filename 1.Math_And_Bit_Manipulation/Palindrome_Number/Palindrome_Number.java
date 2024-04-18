package algorithms;

public class Palindrome_Number {
	
	public static void main(String[] args) {
		
		int n = 1627261;
		//int n = -121;
		boolean check = checkPalindrome(n);
		System.out.println(check);
	}
	
	/*
	 * T = O(log n) [base = 10]
	 * S = O(1)
	 */
	private static boolean checkPalindrome(int n) {
		
		if(n < 0) {
            return false;
        }

        int original = n;
		int sum = 0;
		while(n != 0) {
			int r = n % 10;
			n = n / 10;
			sum = sum*10 + r;
		}
		
		return original == sum ? true : false;
	}
}
