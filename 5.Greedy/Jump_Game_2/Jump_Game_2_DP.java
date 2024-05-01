package algorithms;

import java.util.Arrays;

public class Jump_Game_2_DP {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 3, 1, 4, 1, 1, 2, 1};
		
		int minJumps = jump(arr);
		
		System.out.println(minJumps);
	}
	
	/*
	 * T = O(n * max_jump_length)
	 * S = O(n)
	 */
	public static int jump(int[] arr) {
		
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 0);
		
		return jumping(arr, 0, arr.length, dp);
	}
	
	public static int jumping(int[] arr, int i, int n, int[] dp) {
		
		if(i >= n-1) {
			return 0;
		} else {
			
			if(dp[i] == 0) {
				int min = n-1;
				for(int j = 1; j <= arr[i]; j++) {
					int val = jumping(arr, i+j, n, dp);
					if(val < min) {
						min = val;
					}
				}
				
				dp[i] = 1 + min;
			}
			
			return dp[i];
		}
	}
}
