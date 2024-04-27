package algorithms;

import java.util.LinkedList;
import java.util.List;

public class Spiral_Matrix {
	
	public static void main(String[] args) {
		//int[][] mat = {{1, 2, 3, 4, 5, 6}};
		
//		int[][] mat = {{1}, 
//				       {2}, 
//				       {3}, 
//				       {4}, 
//				       {5}, 
//				       {6}};
		
		int[][] mat = {{1, 2, 3, 4, 5, 6},
				       {20, 21, 22, 23, 24, 7},
				       {19, 32, 33, 34, 25, 8},
				       {18, 31, 36, 35, 26, 9},
				       {17, 30, 29, 28, 27, 10},
				       {16, 15, 14, 13, 12, 11}};
		
		List<Integer> spiralOrderList = spiralOrder(mat);
		
		spiralOrderList.forEach(t -> System.out.print(t + "  "));
	}
	
	/*
	 * T = o(m * n)
	 * S = O(1)
	 */
	public static List<Integer> spiralOrder(int[][] mat) {
		
		int m = mat.length; // rows
		int n = mat[0].length; // col
		
		List<Integer> result = new LinkedList<>();
		
		int left = 0;
		int top = 0;
		int right = n-1;
		int bottom = m-1;
		
		while(left <= right && top <= bottom) {
			
			// --->
			for(int i = left; i <= right; i++) {
				result.add(mat[top][i]);
			}
			top++;
			
			/*
			 * |
			 * |
			 * v
			 */
			for(int i = top; i <= bottom; i++) {
				result.add(mat[i][right]);
			}
			right--;
			
			// <---
			if(top <= bottom) { // Edge case: In case we have just one row
				for(int i = right; i >= left; i--) {
					result.add(mat[bottom][i]);
				}
				bottom--;
			}
			
			
			/*
			 * ^
			 * |
			 * |
			 */
			if(left <= right) { // Edge case: In case we have just one column
				for(int i = bottom; i >= top; i--) {
					result.add(mat[i][left]);
				}
				left++;
			}
		}
		
		return result;
	}
}
