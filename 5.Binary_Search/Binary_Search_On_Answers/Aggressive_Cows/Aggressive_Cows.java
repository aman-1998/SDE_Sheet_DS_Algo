package algorithms.part2;

import java.util.Arrays;

public class Aggressive_Cows {
	
	public static void main(String[] args) {
		
		int[] stalls = {1, 2, 4, 8, 9};
		int cows = 3;
		
		int dis = maxOfMinDistanceBetweenCows(stalls, cows);
		
		System.out.println(dis);
	}
	
	/*
	 * Brute Force using linear search
	 * 
	 * T = O(n*log(n)) + O((max-min)*n)
	 * S = O(1)
	 */
	public static int maxOfMinDistanceBetweenCows_BF(int[] stalls, int cows) {
		
		int n = stalls.length;
		
		Arrays.sort(stalls);
		
		int max = stalls[n-1];
		int min = stalls[0];
		
		for(int i = 1; i <= max-min; i++) {
			if(PossibleToPlaceCows(stalls, cows, i)) {
				continue; 
			} else {
				return i-1;
			}
		}
		
		return -1;
	}
	
	/*
	 * Optimal approach using binary search
	 * 
	 * T = O(n*log(n)) + O(log(max-min)*n)
	 * S = O(1)
	 */
	public static int maxOfMinDistanceBetweenCows(int[] stalls, int cows) {
		
		int n = stalls.length;
		
		Arrays.sort(stalls);
		
		int max = stalls[n-1];
		int min = stalls[0];
		
		int left = 1;
		int right = max-min;
		
		while(left <= right) {
			int mid = (left+right)/2;
			if(PossibleToPlaceCows(stalls, cows, mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return right;
	}
	
	// T = O(n)
	private static boolean PossibleToPlaceCows(int[] stalls, int cows, int minDistance) {
		
		int n = stalls.length;
		int last = stalls[0];
		int countCow = 1;
		for(int i = 1; i <= n-1; i++) {
			if((stalls[i] - last) >= minDistance) {
				last = stalls[i];
				countCow++;
			}
			
			if(countCow == cows) {
				return true;
			}
		}
		
		return false;
	}
}
