package algorithms;

/*
 * Points to be noted:-
 * 
 * 1. (a + b) % n = (a%n + b%n)%n
 * 2. (a * b) % n = (a%n * b%n)%n
 * 
 */
public class Exponentiation_With_Modulus {
	
	public static void main(String[] args) {
		
		int x = 3978432;
		int n = 5;
		int z = 1000000007;
		
		int result = pow(x, n, z);
		System.out.println(result);
	}
	
	/*
	 * Recursive Solution
	 * 
	 * T = O(log n) [base = 2]
	 * S = System's internal stack space is used = O(log n) [base = 2]
	 */
	private static int myPow(int x, int n, int z) {
		
		long xx = (long)x;
		long nn = (long)n;
		long zz = (long)z;
		
		return (int)power(xx, nn, zz);
	}
	
	private static long power(long x, long n, long z) {
		
		if(n == 0) {
			return 1;
		} else if(n % 2 == 0) {
			return power(((x%z) * (x%z))%z, n/2, z);
		} else {
			return ((x%z) * (power(x, n-1, z)%z))%z;
		}
	}
	
	/*
	 * Iterative Solution
	 * 
	 * T = O(log n) [base = 2]
	 * S = O(1)
	 */
	private static int pow(int x, int n, int z) {
		
		long xx = (long)x;
		long nn = (long)n;
		long zz = (long)z;
		
		long ans = 1;
		while(nn > 0) {
			if(nn % 2 == 0) {
				xx = ((xx % z) * (xx % z)) % z;
				nn = nn / 2;
			} else {
				ans = ((xx % z) * (ans % z)) % z;
				nn = nn - 1;
			}
		}
		
		return (int)ans;
	}
}
