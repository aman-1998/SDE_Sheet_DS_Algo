package algorithms;

public class Jump_Game_2_recursion {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 3, 1, 4, 1, 1, 2, 1};
		
		int minJumps = jump(arr);
		
		System.out.println(minJumps);
	}
	
	/*
	 * T = O(2^n)
	 * S = O(2^n)
	 */
	public static int jump(int[] arr) {
		return jumping(arr, 0, arr.length);
	}
	
	public static int jumping(int[] arr, int i, int n) {
		
		if(i >= n-1) {
			return 0;
		} else {
			int min = n-1;
			for(int j = 1; j <= arr[i]; j++) {
				int val = jumping(arr, i+j, n);
				if(val < min) {
					min = val;
				}
			}
			return 1 + min;
		}
	}
}
