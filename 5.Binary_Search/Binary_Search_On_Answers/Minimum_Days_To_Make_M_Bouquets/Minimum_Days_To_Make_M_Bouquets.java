package algorithms.part2;

public class Minimum_Days_To_Make_M_Bouquets {
	
	public static void main(String[] args) {
		
		int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = minDays_BF(arr, m, k);
        
        System.out.println(ans);
	}
	
	/*
	 * Brute Force using liner search
	 * 
	 * T = O(n) + O((max-min) * n)
	 * S = O(1)
	 */
	public static int minDays_BF(int[] bloomDay, int m, int k) {
        
		int n = bloomDay.length;
		if(m * k > n) {
			return -1;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= n-1; i++) {
			if(bloomDay[i] > max) {
				max = bloomDay[i];
			}
			if(bloomDay[i] < min) {
				min = bloomDay[i];
			}
		}
		
		for(int d = min; d <= max; d++) {
			if(possibleToMakeBouquets(bloomDay, m, k, d)) {
				return d;
			}
		}
		
		return -1;
    }
	
	/*
	 * Optimal Solution using binary search
	 * 
	 * T = O(n) + O(log(max-min) * n), where base = 2
	 * S = O(1)
	 */
	public static int minDays(int[] bloomDay, int m, int k) {
        
		int n = bloomDay.length;
		long val = (long)m * k;
		if(val > n) {
			return -1;
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= n-1; i++) {
			if(bloomDay[i] > max) {
				max = bloomDay[i];
			}
			if(bloomDay[i] < min) {
				min = bloomDay[i];
			}
		}
		
		int left = min;
		int right = max;
		
		while(left <= right) {
			int mid = (left + right)/2;
			boolean check = possibleToMakeBouquets(bloomDay, m, k, mid);
			if(check == false) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return left;
    } 
	
	// T = O(n)
	public static boolean possibleToMakeBouquets(int[] bloomDay, int m, int k, int d) {
		
		int n = bloomDay.length;
		int count = 0;
		int noOfBanquets = 0;
		for(int i = 0; i <= n-1; i++) {
			if(d >= bloomDay[i]) {
				count++;
			} else {
				noOfBanquets = noOfBanquets + count/k;
				count = 0;
			}
		}
		
		noOfBanquets = noOfBanquets + count/k;
		
		if(noOfBanquets >= m) {
			return true;
		}
		
		return false;
	}
}
