package algorithms;

public class GCD_Of_Max_And_Min_In_Array {
	
	public static void main(String[] args) {
		
		//int[] arr = {2, 5, 6, 9, 10};
		int[] arr = {35, 28, 24, 32, 60, 44};
		int gcdOfMaxAndMin = gcd_of_max_and_min_in_array(arr);
		
		System.out.println(gcdOfMaxAndMin);
	}
	
	/*
	 * T = O(n) + O(log(min))
	 * S = O(1)
	 */
	private static int gcd_of_max_and_min_in_array(int[] arr) {
		
		int n = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int  i = 0; i <= n-1; i++) {
			
			if(arr[i] < min) {
				min = arr[i];
			}
			
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		return gcd_euclids_method(min, max); // T = O(log(min))
	}
	
	/*
	 * T = O(log( min(a,b) ) )
	 */
	private static int gcd_euclids_method(int a, int b) {
		
		return a%b == 0 ? b : gcd_euclids_method(b, a%b);
	}
}
