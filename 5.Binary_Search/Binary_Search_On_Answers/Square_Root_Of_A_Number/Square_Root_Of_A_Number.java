package algorithms.part2;

public class Square_Root_Of_A_Number {
	
	public static void main(String[] args) {
		
		int x = 69;
		int n = 3;
		
		int res = nthRoot(2, x);
		
		System.out.println(res);
	}
	
	/*
	 * This is the best solution out of all.
	 * Here, even for very large values we will get correct answer
	 * 
	 * 
	 * T = O(log x) * O(log n)
	 * => T = O(log(x*n)) , where base = 2
	 * 
	 * Since, n = 2, so, T = O(log x)
	 * 
	 * S = O(1)
	 */
	public static int nthRoot(int n, int x) {
		
        long result = 0;

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
                if(result < mid) {
                    result = mid;
                }
			}
		}
		
		return (int)result;
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
