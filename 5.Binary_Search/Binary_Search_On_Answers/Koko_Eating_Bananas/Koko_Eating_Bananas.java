package algorithms.part2;

public class Koko_Eating_Bananas {
	
	public static void main(String[] args) {
		
		int[] arr = {3, 6, 7, 11};
		int h = 8;
		
		//int[] arr = {1, 1, 1, 12};
		//int h = 5;
		
		//int[] arr = {805306368,805306368,805306368};
		//int h = 1000000000;
		
		int k = minEatingSpeed(arr, h);
		
		System.out.println("Speed (no. of bananas per hour)= " + k);
	}
	
	/*
	 * Brute Force using linear search
	 * 
	 * T = O(n) + O(max * n)
	 * S = O(1)
	 */
	public static int minEatingSpeed_BF(int[] piles, int h) {
		
		// Possible values of k = 1, 2, 3, .... , max(piles)
		int n = piles.length;
		//int max = Collections.max(Arrays.stream(piles).boxed().collect(Collectors.toList()));
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= n-1; i++) { // T = O(n)
			if(piles[i] > max) {
				max = piles[i];
			}
		}
		
		// T = O(max * n)
		for(int k = 1; k <= max; k++) {
			if(hoursRequiredToEatBananas(piles, k) <= h) {
				return k;
			}
		}
		
		return 0;
	}
	
	/*
	 * Optimal approach using binary search
	 * 
	 * T = O(n) + O(log(max) * n)
	 */
	public static int minEatingSpeed(int[] piles, int h) {
		
		// Possible values of k = 1, 2, 3, .... , max(piles)
		int n = piles.length;
		//int max = Collections.max(Arrays.stream(piles).boxed().collect(Collectors.toList()));
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= n-1; i++) { // T = O(n)
			if(piles[i] > max) {
				max = piles[i];
			}
		}
		
		int minResult = max;
		
		int left = 1;
		int right = max;
		while(left <= right) {
			int mid = (left + right) / 2;
			int totalHrs = hoursRequiredToEatBananas(piles, mid);
			if(totalHrs <= h) {
				right = mid - 1;
				if(minResult > mid) {
					minResult = mid;
				}
			} else if(totalHrs > h) {
				left = mid + 1;
			}
		}
		
		return minResult;
	}
	
	// T = O(n)
	public static int hoursRequiredToEatBananas(int[] piles, int k) {
        
        int n = piles.length;
        double sum = 0;
        //find total hours:
        for (int i = 0; i < n; i++) {
            sum = sum + Math.ceil((double)(piles[i]) / (double)(k));
        }
        return (int)sum;
    }
	
}
