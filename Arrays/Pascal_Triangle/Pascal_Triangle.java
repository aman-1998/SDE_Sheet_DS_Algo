package algorithms;

import java.util.LinkedList;
import java.util.List;

/*
 * This problem has 3 variations. They are stated below:
 * Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
 * Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
 * Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
 * 
 */

public class Pascal_Triangle {
	
	public static void main(String[] args) {
		
		System.out.println("6th row and 4th column of Pascal's triangle will be " + solve_nCr(6-1, 4-1));
		System.out.println("Printing 6th row of Pascal's triangle:-");
		int[] row = rowOfPascalTriangle(6);
		for(int i : row) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nPascal's Triangle:-");
		int[][] pascalTriangle = makePascalTriangle(8);
		for(int[] i : pascalTriangle) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	// T = O(r) = Optimal
	public static int solve_nCr(int n, int r) {
		int ans = 1;
		for(int i = 0; i < r; i++) {
			ans = ans * (n-i);
			ans = ans / (i+1);
		}
		return ans;
	}
	
	// T = O(n) = Optimal
	public static int[] rowOfPascalTriangle(int n) {
		
		int[] row = new int[n];
		row[0] = 1;
		row[n-1] = 1;
		
		int ans = 1;
		for(int i = 1; i <= n-2; i++) {
			ans = ans * (n - i);
			ans = ans / i;
			row[i] = ans;
		}
		return row;
	}
	
	/*
	 * T = O(n^2)
	 */
	public static int[][] makePascalTriangle(int n) {
		int[][] pascalTriangle = new int[n][n];
		for(int i = 1; i <= n; i++) {
			pascalTriangle[i-1] = rowOfPascalTriangle(i);
		}
		return pascalTriangle;
	}
}



// LeetCode Submission
class Solution {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascalTriangle = new LinkedList<List<Integer>>();
		if(numRows == 0) {
			return pascalTriangle;
		}
      
		int n = numRows;
		for(int i = 1; i <= n; i++) {
		  pascalTriangle.add(rowOfPascalTriangle(i));
	  	}
		return pascalTriangle;
    }

    public LinkedList<Integer> rowOfPascalTriangle(int n) {
		
        LinkedList<Integer> row = new LinkedList<>();
		row.add(1);

		if(n == 1) {
			return row;
		}
		
		int ans = 1;
		for(int i = 1; i <= n-2; i++) {
			ans = ans * (n - i);
			ans = ans / i;
            row.add(ans);
		}
		row.add(1);
		return row;
	}
}
