package algorithms.part4;

import java.util.Stack;

public class Maximal_Rectangle {
	
	public static void main(String[] args) {
		
		int[][] mat = {{1,0,1,0,0},
					   {1,0,1,1,1},
					   {1,1,1,1,1},
					   {1,0,0,1,0}};
		
		int maxAreaRectangle =  maximalRectangle(mat);
		
		System.out.println(maxAreaRectangle);
	}
	
	/*
	 * T = O(m*n) + O(2*m*n) = O(m*n)
	 * S = O(n)
	 */
	public static int maximalRectangle(int[][] mat) {
		
		int m = mat.length; // rows
		int n = mat[0].length; // col
		
		for(int i = 0; i <= n-1; i++) { // T = O(n * m)
			int sum = 0;
			for(int j = 0; j <= m-1; j++) {
				if(mat[j][i] == 1) {
					sum = sum + 1;
				} else {
					sum = 0;
				}
				mat[j][i] = sum;
			}
		}
	
		int maxArea = Integer.MIN_VALUE;
		for(int i = 0; i <= m-1; i++) { // T = O(m * 2n)
			int maxAreaInHistogram = largestRectangleAreaInHistogram(mat[i]);
			if(maxAreaInHistogram > maxArea) {
				maxArea = maxAreaInHistogram;
			}
		}
		
		return maxArea;
	}
	
	/*
	 * T = O(2n)
	 * S = O(n)
	 * 
	 */
	public static int largestRectangleAreaInHistogram(int[] height) {
		
		int n = height.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = Integer.MIN_VALUE;
		
		for(int  i = 0; i <= n-1; i++) {
			
			while(!stack.isEmpty() && height[stack.peek()] >= height[i]) {
				int nse = i;
				int element = height[stack.pop()];
				int pse = stack.isEmpty() ? -1 : stack.peek();
				
				int area = element * (nse - pse - 1);
				if(area > maxArea) {
					maxArea = area;
				}
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int nse = n;
			int element = height[stack.pop()];
			int pse = stack.isEmpty() ? -1 : stack.peek();
			
			int area = element * (nse - pse - 1);
			if(area > maxArea) {
				maxArea = area;
			}
		}
		
		return maxArea;
	}
}


/*
 * LeetCode Version
 * 
 * char[][] mat = {{'1','0','1','0','0'},
 *				  {'1','0','1','1','1'},
 *				  {'1','1','1','1','1'},
 *				  {'1','0','0','1','0'}};
 */
class Solution {

    /*
	 * T = O(m*n) + O(2*m*n) = O(m*n)
	 * S = O(m*n) + O(n)
	 */
    public int maximalRectangle(char[][] mat) {
        
        int m = mat.length; // rows
		int n = mat[0].length; // 

        int[][] prefxSumMat = new int[m][n];
		
		for(int i = 0; i <= n-1; i++) { // T = O(n * m)
			int sum = 0;
			for(int j = 0; j <= m-1; j++) {
				if(mat[j][i] == '1') {
					sum = sum + 1;
				} else {
					sum = 0;
				}
				prefxSumMat[j][i] = sum;
			}
		}
		
		int maxArea = Integer.MIN_VALUE;
		for(int i = 0; i <= m-1; i++) { // T = O(m * 2n)
			int maxAreaInHistogram = largestRectangleAreaInHistogram(prefxSumMat[i]);
			if(maxAreaInHistogram > maxArea) {
				maxArea = maxAreaInHistogram;
			}
		}
		
		return maxArea;
    }

    /*
	 * T = O(2n)
	 * S = O(n)
	 * 
	 */
	public int largestRectangleAreaInHistogram(int[] height) {
		
		int n = height.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = Integer.MIN_VALUE;
		
		for(int  i = 0; i <= n-1; i++) {
			
			while(!stack.isEmpty() && height[stack.peek()] >= height[i]) {
				int nse = i;
				int element = height[stack.pop()];
				int pse = stack.isEmpty() ? -1 : stack.peek();
				
				int area = element * (nse - pse - 1);
				if(area > maxArea) {
					maxArea = area;
				}
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int nse = n;
			int element = height[stack.pop()];
			int pse = stack.isEmpty() ? -1 : stack.peek();
			
			int area = element * (nse - pse - 1);
			if(area > maxArea) {
				maxArea = area;
			}
		}
		
		return maxArea;
	}
}
