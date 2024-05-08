package algorithms;

import java.util.Arrays;

public class Jump_Game_Using_DP {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 3, 2, 0, 1};
		
		//int[] arr = new int[] {1, 2, 1, 0, 2};
		
		//int[] arr = new int[] {2, 3, 1, 1, 4};
		
		//int[] arr = new int[] {3, 2, 1, 0, 4};
		
		boolean possible = jumpGame(arr);
		
		System.out.println(possible);
	}
	
	/*
	 * Using recursion
	 * 
	 * T = O(n * max_jump_length)
	 * 
	 * S = O(n)
	 * 
	 */
	public static boolean jumpGame(int[] arr) {
		
		boolean[] dp = new boolean[arr.length];
		Arrays.fill(dp, false);
		
		return jump(arr, 0, arr.length, dp);
	}
	
	public static boolean jump(int[] arr, int i, int n, boolean[] dp) {
		
		if(i >= n-1) {
			return true;
		} else if(i < n-1 && arr[i] == 0) {
			return false;
		} else {
			
			if(dp[i] == false) {
				boolean result = false;
				for(int j = 1; j <= arr[i]; j++) {
					result = result || jump(arr, i+j, n, dp);
				}
				dp[i] = result;
			}
			
			return dp[i];
		}
	}
	
	
}
