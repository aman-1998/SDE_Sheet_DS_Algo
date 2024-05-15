package algorithms.part2;

public class Least_Capacity_Of_Ship_To_Deliver_Packages_Within_D_Days {
	
	public static void main(String[] args) {
		
		int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int daya = 5;
		
		int capacity = shipWithinDays(weights, 5);
		
		System.out.println(capacity);
	}
	
	/*
	 * Brute Force using linear search
	 * 
	 * T = O(n) + O((sum-max)*n)
	 * 
	 * S = O(1)
	 * 
	 */
	public static int shipWithinDays_BF(int[] weights, int days) {
        
		int n = weights.length;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i <= n-1; i++) {
			if(weights[i] > max) {
				max = weights[i];
			}
			sum = sum + weights[i];
		}
		
		for(int i = max; i <= sum; i++) { // i = capacity
			if(possibleToDeliver(weights, days, i)) {
				return i;
			}
		}
		
		return -1;
    }
	
	/*
	 * Optimal Solution using binary search
	 * 
	 * T = O(n) + O(log(sum-max)*n)
	 * 
	 * S = O(1)
	 * 
	 */
	public static int shipWithinDays(int[] weights, int days) {
        
		int n = weights.length;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i <= n-1; i++) {
			if(weights[i] > max) {
				max = weights[i];
			}
			sum = sum + weights[i];
		}
		
		int left = max;
		int right = sum;
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(possibleToDeliver(weights, days, mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
    }
	
	// T = O(n)
	private static boolean possibleToDeliver(int[] weights, int days, int capacity) {
		
		int n = weights.length;
		int sum = 0;
		int dayCount = 0;
		for(int i = 0; i <= n-1; i++) {
			sum = sum + weights[i];
			if(sum > capacity) {
				sum = 0;
				i--;
				dayCount++;
			}
		}
		
		dayCount++;
		
		if(dayCount <= days) {
			return true;
		}
		
		return false;
	} 
	
}
