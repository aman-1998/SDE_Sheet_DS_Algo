package practice.dsa.sheet.part2;

public class Median_Of_Row_Wise_Sorted_Matrix {
	
	public static void main(String[] args) {
		
		int[][] mat = {{1, 5, 7, 9, 11},
					   {2, 3, 4, 5, 10},
					   {9, 10, 12, 14, 16}};
		
		int median = findMedian(mat);
		
		System.out.println(median);
	}
	
	/*
	 * Binary search on answers
	 * 
	 * T = O(log max-min) * O(m * log n)
	 * 
	 * where, m = no. of rows, n = no. of columns
	 *        max = maximum element, min = minimum element
	 * 
	 * S = O(1)
	 */
	public static int findMedian(int[][] mat) {
		
		int m = mat.length;
		int n = mat[0].length;
		
		int l = Integer.MAX_VALUE;
		int r = Integer.MIN_VALUE;
		
		for(int i = 0; i <= m-1; i++) {
			
			if(mat[i][0] < l) {
				l = mat[i][0];
			}
			
			if(mat[i][n-1] > r) {
				r = mat[i][n-1];
			}
		}
		
		int req = (m*n)/2;
		int ans = Integer.MAX_VALUE;
		
		while(l <= r) {
			
			int mid = (l+r)/2;
			int count = countSmallOrEqual(mat, mid);
			if(count > req) {
				r = mid - 1;
				if(mid < ans) {
					ans = mid;
				}
			} else {
				l = mid + 1;
			}
		}
		
		return ans;
	}
	
	/*
	 * T = O(m * log n)
	 */
	private static int countSmallOrEqual(int[][] mat, int x) {
		
		int m = mat.length;
		int n = mat[0].length;
		int sum = 0;
		for(int i = 0; i <= m-1; i++) {
			sum = sum + upperBound(mat[i], x);
		}
		
		return sum;
	}
	
	/*
	 * T = O(log n)
	 */
	private static int upperBound(int[] arr, int x) {
		
		int n = arr.length;
		int l = 0;
		int r = n-1;
		int index = n;
		while(l <= r) {
			int mid = (l+r)/2;
			if(arr[mid] > x) {
				r = mid - 1;
				if(mid < index) {
					index = mid;
				}
			} else {
				l = mid + 1;
			}
		}
		
		return index;
	}
}
