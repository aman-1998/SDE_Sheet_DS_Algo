
public class Nth_Root_Of_A_Number_2nd_Approach {
	
	public static void main(String[] args) {
		
		int x = 123;
		int n = 3;
		
		int r = nthRoot(n, x);
		System.out.println(r);
	}
	
	/*
	 * For very large x, we will get wrong answer because power(mid, n) won't give 
	 * correct values for bigger mid.
	 * 
	 * 
	 * T = O(log x) * O(log n)
	 * => T = O(log(x*n)) , where base = 2
	 * 
	 * S = O(1)
	 */
	public static int nthRoot(int n, int x) {
		
		int left = 1;
		int right = x;
		int res = 0;
		
		while(left <= right) {
			int mid = (left + right)/2;
			int r = power(mid, n); // O(log n)
			if(r == x) {
				return mid;
			} else if(r > x) {
				right = mid - 1;
			} else {
				if(mid > res) {
					res = mid;
				}
				left = mid + 1;
			}
		}
		
		return res;
	}
	
	// T = O(log n)
	private static int power(int mid, int n) {
		
		int ans = 1;
		while(n > 0) {
			if(n % 2 != 0) {
				ans = ans * mid;
				n = n - 1;
			} else {
				mid = mid * mid;
				n = n / 2;
			}
		}
		
		return ans;
	}
}
