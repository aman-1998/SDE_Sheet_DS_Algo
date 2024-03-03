package algorithms;

public class Determine_If_N_Is_Odd_Or_Even {
	
	public static void main(String[] args) {
		
		//int n = 78;
		int n = 57;
		is_even_or_odd(n);
	}
	
	/*
	 * T = O(1)
	 * S = O(1)
	 */
	private static void is_even_or_odd(int n) {
		
		if((n & 1) == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
	}
}
