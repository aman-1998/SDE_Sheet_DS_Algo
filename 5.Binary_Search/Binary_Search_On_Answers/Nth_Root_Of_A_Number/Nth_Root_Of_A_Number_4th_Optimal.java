package algorithms.part2;

public class Nth_Root_Of_A_Number_4th_Optimal {
	
	public static void main(String[] args) {
		
		int x = 1728;
		int n = 3;
		
		int r = nthRoot(n, x);
		System.out.println(r);
	}
	
	/*
	 * This is the best solution out of all.
	 * Here, even for very large values we will get correct answer
	 * 
	 * 
	 * T = O(log x) * O(log n)
	 * => T = O(log(x*n)) , where base = 2
	 * 
	 * S = O(1)
	 */
	public static int nthRoot(int n, int x) {
		
		long left = 1;
		long right = x;
		
		while(left <= right) {
			long mid = (left + right)/2;
			long r = power(mid, n, x); // O(log n)
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

	// T = O(log n)
	private static long power(long mid, int n, int x) {
		
		long ans = 1;
		while(n > 0) {
			if(n % 2 != 0) {
				ans = ans * mid;
				n = n - 1;
			} else {
				mid = mid * mid;
				n = n / 2;
			}
			
			if(ans > x || mid > x) {
				return 0;
			}
		}
		
		if(ans == x) {
			return 1;
		}
		
		return 2;
	}
}
