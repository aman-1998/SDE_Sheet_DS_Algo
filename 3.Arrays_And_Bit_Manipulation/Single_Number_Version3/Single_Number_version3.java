package algorithms;

public class Single_Number_version3 {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 1, 3, 2, 5};
		//int[] arr = {0, 0, 1, 2};
		int[] pair = single_number_version3(arr);
		
		System.out.println(pair[0] + ", " + pair[1]);
	}
	
	/*
	 * In better Brute Force approach, we can use a hashMap and get the answer by storing frequency 
	 * of each element in O(n) time but in that case, S = O(1)
	 */
	
	
	/*
	 * Best Solution
	 * 
	 * T = O(2n) = O(n)
	 * S = O(1)
	 */
	private static int[] single_number_version3(int[] arr) {
		
		int n = arr.length;
		int xr = 0;
		for(int i = 0; i <= n-1; i++) {
			xr = xr ^ arr[i];
		}
		
		int pos = 0;
		for(int i = 0; i <= 31; i++) {
			if((xr & (1 << i)) != 0) {
				pos = i+1;
				break;
			}
		}
		
		int temp = 0; // temp = xr; // both are correct
		int mask = 1 << (pos-1);
		
		for(int i = 0; i <= n-1; i++) {
			if((arr[i] & mask) != 0) {
				temp = temp ^ arr[i];
			}
		}
		
		return new int[] {temp, xr^temp};
	}
}
