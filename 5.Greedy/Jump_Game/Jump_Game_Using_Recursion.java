package algorithms;

public class Jump_Game_Using_Recursion {
public static void main(String[] args) {
		
		//int[] arr = new int[] {1, 3, 2, 0, 1};
		
		//int[] arr = new int[] {1, 2, 1, 0, 2};
		
		//int[] arr = new int[] {2, 3, 1, 1, 4};
		
		int[] arr = new int[] {3, 2, 1, 0, 4};
		
		boolean possible = jumpGame(arr);
		
		System.out.println(possible);
	}
	
	/*
	 * Using recursion
	 * 
	 * T = Exponential = O(2^n)
	 * 
	 * S = Exponential = O(2^n)
	 * 
	 */
	public static boolean jumpGame(int[] arr) {
		
		return jump(arr, 0, arr.length);
	}
	
	public static boolean jump(int[] arr, int i, int n) {
		
		if(i >= n-1) {
			return true;
		} else if(i < n-1 && arr[i] == 0) {
			return false;
		} else {
			
			boolean result = false;
			for(int j = 1; j <= arr[i]; j++) {
				result = result || jump(arr, i+j, n);
			}
			return result;
		}
	}
	
	
}
