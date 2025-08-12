package algorithms.part2;

public class Search_In_Row_And_Column_Wise_Sorted_Matrix {
	
	public static void main(String[] args) {
		
		int[][] mat = {{1, 4, 7, 11, 15},
					   {2, 5, 8, 12, 19},
					   {3, 6, 9, 16, 22},
					   {10, 13, 14, 17, 24},
					   {18, 21, 23, 26, 30}};
		
		int target = 14;
		
		boolean isPresent = searchInMatrix(mat, target);
		
		System.out.println(isPresent);
	}
	
	/*
	 * Better approach : For each apply binary search
	 * T = O(m * log n) ; m = no. of row, n = no. of columns
	 * S = O(1)
	 */
	
	
	/*
	 * Best or optimized approach
	 * 
	 * T = O(m+n)
	 * S = O(1)
	 */
	public static boolean searchInMatrix(int[][] mat, int target) {
		
		int m = mat.length;
		int n = mat[0].length;
		int row = 0;
		int col = n-1;
		while(row < m && col >= 0) {
			if(mat[row][col] < target) {
				row++;
			} else if(mat[row][col] > target) {
				col--;
			} else {
				return true;
			}
		}
		
		return false;
	}
}
