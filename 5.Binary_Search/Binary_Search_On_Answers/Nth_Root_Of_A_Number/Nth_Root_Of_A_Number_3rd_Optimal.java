package algorithms.part2;

public class Nth_Root_Of_A_Number_3rd_Optimal {
	
	public static void main(String[] args) {
		
		int x = 27;
		int n = 3;
		
		int r = nthRoot(n, x);
		System.out.println(r);
	}
	
	/*
	 * Here, even for very large values we will get correct answer
	 * 
	 * 
	 * T = O(log x) * O(n)
	 * => T = O(n * log x) , where base = 2
	 * 
	 * S = O(1)
	 */
	public static int nthRoot(int n, int x) {
		
		long left = 1;
		long right = x;
		
		while(left <= right) {
			long mid = (left + right)/2;
			long r = power(mid, n, x); // O(n)
			if(r == 1) {
				return (int)mid;
			} else if(r == 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	// T = O(n)
	private static long power(long mid, int n, int x) {
		
		long ans = 1;
		
		for(int i = 1; i <= n; i++) {
			ans = ans * mid;
			if(ans > x) {
				return 0;
			}
		}
		
		if(ans == x) {
			return 1;
		}
		
		return 2;
	}
}
