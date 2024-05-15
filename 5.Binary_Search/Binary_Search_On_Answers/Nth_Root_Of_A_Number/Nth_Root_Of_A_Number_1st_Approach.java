package algorithms.part2;

public class Nth_Root_Of_A_Number_1st_Approach {
	
	public static void main(String[] args) {
		
		int x = 125;
		int n = 3;
		
		int r = nthRoot(n, x);
		System.out.println(r);
	}
	
	public static int nthRoot(int n, int x) {
		
		int left = 1;
		int right = x;
		
		while(left <= right) {
			int mid = (left + right)/2;
			//int r = (int) Math.pow(mid, n);
			int r = (int) power(mid, n); // O(n)
			if(r == x) {
				return mid;
			} else if(r > x) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	// T = O(n)
	private static long power(long mid, int n) {
		
		long ans = 1;
		for(int i = 1; i <= n; i++) {
			ans = ans * mid;
		}
		return ans;
	}
}
