package algorithms.part2;

public class Kth_Missing_Positive_In_Strictly_Increasing_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {2, 3, 4, 7, 11};
		int k = 5;
		
		int res = findKthMissingPositive_BF(arr, k);
		
		System.out.println(res);
	}
	
	/*
	 * Brute Force
	 * 
	 * T = O(n)
	 * S = O(1)
	 */
	public static int findKthMissingPositive_BF(int[] arr, int k) {
        
		int n = arr.length;
		if(k < arr[0]) {
			return k;
		}
		
		for(int i = 0; i <= n-1; i++) {
			if(k > arr[i]) {
				k++;
			} else {
				break;
			}
		}
		
		return k;
    }
	
	/*
	 * Optimal solution using Binary search
	 * 
	 * T = O(log n)
	 * 
	 * S = O(1)
	 */
	public static int findKthMissingPositive(int[] arr, int k) {
        
		int n = arr.length;
		if(k < arr[0]) {
			return k;
		}

		int left = 0;
		int right = n-1;
		while(left <= right) {
			int mid = (left + right)/2;
			int noOfMissing = arr[mid] - (mid+1);
			if(noOfMissing < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return right + 1 + k; // left + k;
    }
}
