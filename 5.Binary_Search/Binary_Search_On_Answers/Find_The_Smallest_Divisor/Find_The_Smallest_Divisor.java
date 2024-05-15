package algorithms.part2;

public class Find_The_Smallest_Divisor {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 5, 9};
        int threshold = 6;
        int ans = smallestDivisor(arr, threshold);
        
        System.out.println(ans);
	}
	
	/*
	 * Brute Force using linear search
	 * 
	 * T = O(n) + O(max * n)
	 * 
	 * S = O(1)
	 * 
	 */
	public static int smallestDivisor_BF(int[] arr, int threshold) {
        
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		for(int i = 0; i <= n-1; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		for(int d = 1; d <= max; d++) {
			if(possible(arr, threshold, d)) {
				return d;
			}
		}
		
		return -1;
    }
	
	/*
	 * Optimal solution using binary search
	 * 
	 * T = O(n) + O(log(max) * n)
	 * 
	 * S = O(1)
	 */
	public static int smallestDivisor(int[] arr, int threshold) {
        
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= n-1; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		int left = 1;
		int right = max;
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(possible(arr, threshold, mid) == false) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return left; // because of opposite polarity
    }
	
	// T = O(n)
	private static boolean possible(int[] arr, int threshold, int d) {
		
		int n = arr.length;
		double sum = 0;
		for(int i = 0; i <= n-1; i++) {
			sum = sum + Math.ceil((double)arr[i]/d) ;
			if((int)sum > threshold) {
				return false;
			}
		}
		
		return true;
	}
}
