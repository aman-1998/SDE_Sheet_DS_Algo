package algorithms;

import java.util.Arrays;

public class Jump_Game_2_Iteration_Optimal {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 3, 1, 4, 1, 1, 2, 1};
		
		int minJumps = jump(arr);
		
		System.out.println(minJumps);
	}
	
	/*
	 * T = O(n)
	 * S = O(1)
	 */
	public static int jump(int[] arr) {
		
		int n = arr.length;
		int l = 0;
		int r = 0;
		int jumps = 0;
		
		while(r <= n-2) {
			int farthest = 0;
			for(int i = l; i <= r; i++) {
				if(i + arr[i] > farthest) {
					farthest = i + arr[i];
				}
			}
			
			l = r + 1;
			r = farthest;
			jumps++;
		}
		
		return jumps;
	}
}
