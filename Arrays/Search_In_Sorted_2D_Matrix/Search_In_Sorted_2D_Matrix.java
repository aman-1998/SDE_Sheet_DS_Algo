package algorithms;

import java.util.Collections;

public class Search_In_Sorted_2D_Matrix {
	 
	public static void main(String[] args) {
		
		int[][] mat = {{1,3,5,7},
					  {10,11,16,20},
				      {23,30,34,60}};
		
		int target = 3;
		
		boolean check = searchIn2DMatrix_3(mat, target);
		System.out.println(check);
	}
	
	// Brute Force
	// T = O(mn)
	// S = O(1)
	private static boolean searchIn2DMatrix_1(int[][] mat, int target) {
		
		for(int i = 0; i <= mat.length - 1; i++) {
			for(int j = 0; j <= mat[i].length - 1; j++) {
				if(mat[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}
	
	// Better Approach
	// T = O(m) + O(log n)
	// S = O(1)
	private static boolean searchIn2DMatrix_2(int[][] mat, int target) {
		
		int m = mat.length;
		int n = mat[0].length;	
		
		for(int i = 0; i <= mat.length-1; i++) {
			if(target <= mat[i][mat[i].length-1]) {
				boolean check = binarySearch(mat[i], target);
				return check;
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] arr, int target) {
		int l = 0, r = arr.length-1;
		while(l <= r) {
			int mid = (l+r)/2;
			if(target > arr[mid]) {
				l = mid + 1;
			} else if(target < arr[mid]) {
				r = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
	
	// Best Approach
	// T = O(log(mn))
	// S = O(1)
	private static boolean searchIn2DMatrix_3(int[][] mat, int target) {
		
		int m = mat.length;
		int n = mat[0].length;
		
		int l = 0, r = m*n - 1;
		while(l <= r) {
			int mid = (l+r)/2;
			if(target > mat[mid/n][mid%n]) {
				l = mid + 1;
			} else if(target < mat[mid/n][mid%n]) {
				r = mid - 1;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
