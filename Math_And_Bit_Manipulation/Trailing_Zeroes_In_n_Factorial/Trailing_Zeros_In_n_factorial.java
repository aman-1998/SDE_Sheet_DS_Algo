package algorithms;

public class Trailing_Zeros_In_n_Factorial {
	
	public static void main(String[] args) {
		
		int n = 734;
		int trailingZeroes = trailing_zeroes(n);
		
		System.out.println(trailingZeroes);
	}
	
	/*
	 * T = O(log n) [base = 5]
	 * S = O(1)
	 */
	private static int trailing_zeroes(int n) {
		
		int res = 0;
		for(int i = 5; i <= n; i=i*5) {
			res = res + n/i;
		}
		return res;
	}
}
