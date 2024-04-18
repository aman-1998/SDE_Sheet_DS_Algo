package algorithms;

public class GCD_Euclids_Method {
	
	public static void main(String[] args) {
		
		//int gcd = gcd_euclids_method_1(24, 60);
		//int gcd = gcd_euclids_method_2(24, 60);
		int gcd = gcd_euclids_method_3(24, 60);
		//int gcd = gcd_euclids_method_4(24, 60);
		System.out.println(gcd);
	}
	
	/*
	 * T = O(log( min(a,b) ) )
	 */
	private static int gcd_euclids_method_1(int a, int b) {
		
		if(b == 0) {
			return a;
		}
		
		return gcd_euclids_method_1(b, a%b);
	}
	
	/*
	 * T = O(log( min(a,b) ) )
	 */
	private static int gcd_euclids_method_2(int a, int b) {
		
		return b == 0 ? a : gcd_euclids_method_1(b, a%b);
	}
	
	/*
	 * T = O(log( min(a,b) ) )
	 */
	private static int gcd_euclids_method_3(int a, int b) {
		
		if(a%b == 0) {
			return b;
		}
		
		return gcd_euclids_method_1(b, a%b);
	}
	
	/*
	 * T = O(log( min(a,b) ) )
	 */
	private static int gcd_euclids_method_4(int a, int b) {
		
		return a%b == 0 ? b : gcd_euclids_method_2(b, a%b);
	}
}
