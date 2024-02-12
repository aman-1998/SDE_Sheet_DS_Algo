package algorithms;

import java.util.Arrays;

public class Grid_Unique_Path_2 {
	
	public static void main(String[] args) {
		
		/*
		 * Here, it is assumed that starting point is (0, 0) and 
		 * end point is (m-1, n-1).
		 * 
		 * But this solution works even if starting point is (i, j)
		 * and end point is (p, q) where matrix size is mxn and i <= m and j <= n
		 * i.e., staring and end points are some random position in the matrix of size mxn.
		 */
		int m = 2;
		int n = 3;
		int startRow = 0;
		int startCol = 0;
		int endRow = m-1;
		int endCol = n-1;
		
		if(startRow < 0 || startCol < 0) {
			System.out.println("Not posible");
			return;
		}
		
		if(endRow > m-1 || endCol > n-1) {
			System.out.println("Not posible");
			return;
		}
		
		//int[][] dp = new int[m][n];
		//for(int i = 0; i <= m-1; i++) {
		//	Arrays.fill(dp[i], -1);
		//}
		//int noOfUniquePaths = uniquePathsUsingRecursion(startRow, startCol, endRow, endCol);
		//int noOfUniquePaths = uniquePathsUsingDP(startRow, startCol, endRow, endCol, dp);
		int noOfUniquePaths = uniquePathsUsingCombination(startRow, startCol, endRow, endCol);
		
		System.out.println("No. of unique paths = " + noOfUniquePaths);
	}
	
	/*
	 * 
	 * T = Exponential, S = exponential
	 * 
	 */
	private static int uniquePathsUsingRecursion(int i, int j, int p, int q) {
		
		if(i == p && j == q) {
			return 1;
		} else if(i > p || j > q) {
			return 0;
		} else {
			return uniquePathsUsingRecursion(i, j+1, p, q) + uniquePathsUsingRecursion(i+1, j, p, q);
		}
	}
	
	/*
	 * 
	 * T = O(p-i * q-j), S = O(mn)
	 * Here, p = m-1, q = n-1. So, T = O(mn)
	 * 
	 */
	private static int uniquePathsUsingDP(int i, int j, int p, int q, int[][] dp) {
		
		if(i == p && j == q) {
			return 1;
		} else if(i > p || j > q) {
			return 0;
		} else {
			if(dp[i][j] != -1) {
				return dp[i][j];
			}
			dp[i][j] = uniquePathsUsingDP(i, j+1, p, q, dp) + uniquePathsUsingDP(i+1, j, p, q, dp);
			return dp[i][j];
		}
	}
	
	// T = O(min(p-i, q-j))
	private static int uniquePathsUsingCombination(int i, int j, int p, int q) {
		
		if(p-i < q-j) {
			return nCr(p+q-(i+j), p-i); // T = O(p-i)
		} else {
			return nCr(p+q-(i+j), q-j); // T = O(q-j)
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
