package algorithms.part2;
/*
 * Video: https://www.youtube.com/watch?v=nGGp5XBzC4g
 */
public class Find_Peak_Element_In_Matrix {
	
	public static void main(String[] args) {
		
		int[][] mat = {{4, 2, 5, 1, 4, 5},
				       {2, 9, 3, 2, 3, 2},
				       {1, 7, 6, 0, 1, 3},
				       {3, 6, 2, 3, 7, 2}};
		
		int[] peakElement = findPeakElement_in_matrix(mat);
		
		System.out.println(peakElement[0] + ", " + peakElement[1]);
	}
	
	/*
	 * T = O(m * log n) ; m = no. of rows, n = no. of columns
	 * S = O(1)
	 */
	private static int[] findPeakElement_in_matrix(int[][] mat) {

		int m = mat.length;
		int n = mat[0].length;
		
		int l = 0;
		int r = n-1;
		
		while(l <= r) {
			int mid = (l+r)/2;
			int maxIndex = maxInRow(mat, mid);
			int left = mid-1 >= 0 ? mat[maxIndex][mid-1] : -1;
			int right = mid+1 < n ? mat[maxIndex][mid+1] : -1;
			if(mat[maxIndex][mid] >  left && mat[maxIndex][mid] > right) {
				return new int[]{maxIndex, mid};
			} else if(left > mat[maxIndex][mid]) {
				r = mid - 1;
			} else if(right > mat[maxIndex][mid]) {
				l = mid + 1;
			}
		}
		
		return new int[] {-1, -1};
    }

	private static int maxInRow(int[][] mat, int mid) {
		
		int m = mat.length;
		int n = mat[0].length;
		int max = -1;
		int rowIndex = 0;
		for(int i = 0; i <= m-1; i++) {
			if(mat[i][mid] > max) {
				max = mat[i][mid];
				rowIndex = i;
			}
		}
		
		return rowIndex;
	}
}
