package algorithms;

import java.util.Arrays;

public class Grid_Unique_Path_1 {
	
	public static void main(String[] args) {
		
		int m = 4;
		int n = 5;
		
		int noOfUniquePaths = uniquePaths(m, n);
		
		System.out.println("No. of unique paths = " + noOfUniquePaths);
	}
	
	private static int uniquePaths(int m, int n) {
		
		//int[][] dp = new int[m][n];
		//for(int i = 0; i <= m-1; i++) {
		//	Arrays.fill(dp[i], -1);
		//}
		//int noOfUniquePaths = uniquePathsUsingRecursion(m, n, 0, 0);
		//int noOfUniquePaths = uniquePathsUsingDP(m, n, 0, 0, dp);
		int noOfUniquePaths = uniquePathsUsingCombination(m, n);
		
		return noOfUniquePaths;
	}
	
	/*
	 * 
	 * T = Exponential, S = exponential
	 * 
	 */
	private static int uniquePathsUsingRecursion(int m, int n, int i, int j) {
		
		if(i == m-1 && j == n-1) {
			return 1;
		} else if(i > m-1 || j > n-1) {
			return 0;
		} else {
			return uniquePathsUsingRecursion(m, n, i, j+1) + uniquePathsUsingRecursion(m, n, i+1, j);
		}
	}
	
	/*
	 * 
	 * T = O(mn), S = O(mn)
	 * 
	 */
	private static int uniquePathsUsingDP(int m, int n, int i, int j, int[][] dp) {
		
		if(i == m-1 && j == n-1) {
			return 1;
		} else if(i > m-1 || j > n-1) {
			return 0;
		} else {
			if(dp[i][j] != -1) {
				return dp[i][j];
			}
			dp[i][j] = uniquePathsUsingDP(m, n, i, j+1, dp) + uniquePathsUsingDP(m, n, i+1, j, dp);
			return dp[i][j];
		}
	}
	
	// T = O(min(m, n))
	private static int uniquePathsUsingCombination(int m, int n) {
		
		if(m < n) {
			return nCr(m+n-2, m-1); // T = O(m)
		} else {
			return nCr(m+n-2, n-1); // T = O(n)
		}
	}
	
	// T = O(r)
	private static int nCr(int n , int r) {
		double numerator = 1;
		double denomerator = 1;
		for(int i = 0; i < r; i++) {
			numerator = numerator * (n-i);
			denomerator = denomerator * (i + 1);
		}
		return (int) (numerator / denomerator);
	}
}
