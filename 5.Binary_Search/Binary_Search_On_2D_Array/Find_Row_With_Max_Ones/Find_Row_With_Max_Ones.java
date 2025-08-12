package algorithms.part2;

public class Find_Row_With_Max_Ones {
	
	public static void main(String[] args) {
		
		/*
		int[][] mat = {{0, 0, 0, 0, 0, 1},
					   {0, 0, 0, 0, 1, 1},
				       {0, 0, 0, 0, 1, 1},
				       {0, 0, 1, 1, 1, 1},
				       {0, 0, 0, 1, 1, 1},
				       {0, 0, 1, 1, 1, 1}};*/
		
		int[][] mat = {{0, 1},
				       {0, 1}};
		
		int[] res = rowAndMaximumOnes(mat);
		
		System.out.println(res[0] + ", " + res[1]);
	}
	
	/*
	 * T = O(m * log n)
	 * S = O(1)
	 */
	public static int[] rowAndMaximumOnes(int[][] mat) {
        
		int m = mat.length;
		int n = mat[0].length;
		int maxCount = Integer.MIN_VALUE;
		int row = 0;
		for(int i = 0; i <= m-1; i++) {
			int lb = lowerBound(mat[i], 1);
			int count = n - lb;
			if(count > maxCount) {
				maxCount = count;
				row = i;
			}
		}
		
		return new int[] {row, maxCount};
    }
	
	/*
	 * T = O(log n)
	 * S = O(1)
	 */
	public static int lowerBound(int[] arr, int target) {
		
		int n = arr.length;
		
		int l = 0;
		int r = n-1;
		int index = n;
		while(l <= r) {
			int mid = (l+r)/2;
			if(arr[mid] >= target) {
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
