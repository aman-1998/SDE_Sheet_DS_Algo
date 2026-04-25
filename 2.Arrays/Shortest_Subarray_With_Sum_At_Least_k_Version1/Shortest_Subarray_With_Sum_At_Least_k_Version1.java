
// Here, elements of array can only be positive
public class Shortest_Subarray_With_Sum_At_Least_k_Version1 {
	public static void main(String[] args) {
		
		int[] arr = {2, 3, 1, 2, 4, 3};
		//int minLength = shortest_subarray_with_sum_at_least_k_BF(arr, 7);
		int minLength = shortestSubarrayWithSumAtLeastK(arr, 7);
		
		System.out.println(minLength);
	}
	
	/*
	 * Brute Force : Find all the sub-arrays whose sum is greater than or equal to k. Out of those sub-arrays find the 
	 * 				 one with min length. Return that length.
	 * 
	 * T = O(n^2)
	 * S= O(1)
	 * 
	 */
	private static int shortest_subarray_with_sum_at_least_k_BF(int[] arr, int k) {
		
		int n = arr.length;
		int minCount = Integer.MAX_VALUE;
		
		for(int i = 0; i <= n-1; i++) {
			int count = 0;
			int sum = 0;
			
			for(int j = i; j <= n-1; j++) {
				sum = sum + arr[j];
				count++;
				if(sum >= k) {
					if(count < minCount) {
						minCount = count;
					}
					break;
				}
			}
		}
		
		return minCount;
	}
	
	/*
	 * Better Solution : Variable size sliding window
	 * 
	 * T = O(2n) = O(n)
	 * S = O(1)
	 * 
	 */
	private static int shortest_subarray_with_sum_at_least_k(int[] arr, int k) {
		
		int n = arr.length;
		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		int l = 0;
		int r = 0;
		
		while(r < n && l <= r) {
			
			while(sum < k) {
				if(r < n) {
					sum = sum + arr[r];
					r++;
				} else {
					return minLength == Integer.MAX_VALUE ? 0 : minLength;
				}
			}
			r--;
			
			while(sum >= k) {
				if(l <= r) {
					sum = sum - arr[l];
					l++;
				} else {
					return 1;
				}
			}
			
			int windowSize = ((r-l) + 1) + 1;
			if(windowSize < minLength) {
				minLength = windowSize;
			}
			r++;
		}
		
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
	
	/*
	 * Best Solution : Variable size sliding window
	 * 
	 * T = O(2n) = O(n)
	 * S = O(1)
	 * 
	 */
	public static int shortestSubarrayWithSumAtLeastK(int[] arr, int k) {
	
		int n = arr.length;
		int i = 0;
		int j = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		while(j < n) {
			sum = sum + arr[j];
			if(sum >= k) {
				while(i <= j && sum >= k) {
					sum = sum - arr[i];
					i++;
				}
				int count = (j-i+1)+1;
				if(count < min) {
					min = count;
				}
			}
			j++;
		}
		
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
