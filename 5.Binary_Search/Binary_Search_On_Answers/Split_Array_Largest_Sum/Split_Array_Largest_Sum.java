package algorithms.part2;

public class Split_Array_Largest_Sum {
	
	public static void main(String[] args) {
		
		int[] arr = {7, 2, 5, 10, 8};
		int k = 2;
		int minOfMaximumSum = splitArray(arr, k);
		
		System.out.println(minOfMaximumSum);
	}
	
	/*
	 * T = O(n) + O(n*log(sum-max))
	 * S = O(1)
	 */
	private static int splitArray(int[] arr, int k) {
        
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i <= n-1; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
			sum = sum + arr[i];
		}
		
		int l = max;
		int r = sum;
		int ans = Integer.MAX_VALUE;
		while(l <= r) {
			int mid = (l+r)/2;
			int noOfSubArr = possibleSubArrays(arr, mid, k);
			if(noOfSubArr <= k) {
				if(mid <= ans) {
					ans = mid;
				}
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		
		return ans;
    }

	private static int possibleSubArrays(int[] arr, int maxSum, int k) {

		int n = arr.length;
		int sum = 0;
		int noOfSubArr = 0;
		for(int i = 0; i <= n-1; i++) {
			sum = sum + arr[i];
			if(sum > maxSum) {
				i--;
				sum = 0;
				noOfSubArr++;
			} else {
				if(i == n-1) {
					noOfSubArr++;
				}
			}
		}
		
		return noOfSubArr;
	}
}
