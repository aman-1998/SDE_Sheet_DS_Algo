package algorithms;

import java.util.Arrays;

public class Primes_Upto_N {
	
	public static void main(String[] args) {
		
		int n = 30;
		
		/*
		 * In brute force approach we will iterate over each element till n
		 * and see if it is prime or not.
		 * 
		 * Now, in order to check whether a no. of prime or not, we check 
		 * from 2 till sqrt(n), if a factor of n exist or not. So, T = O(sqrt(n))
		 * 
		 * So, overall time complexity (T) = O(n * sqrt(n))
		 */
		
		//int count = primes_upto_N_inclusive(n);
		int count = primes_upto_N_inclusive_best(n);
		//int count = primes_upto_N_exclusive(n);
		//int count = primes_upto_N_exclusive_best(n);
		
		System.out.println("No. of prime upto " + n +" = " + count);
	}
	
	/*
	 * Best approach: Sieve of Eratosthenes
	 * 
	 * Here, n is inclusive
	 * 
	 * T = O(n * log(log n)) + O(n) =~ O(n * log(log n)) 
	 * S = O(n)
	 */
	private static int primes_upto_N_inclusive(int n) {
		
		if(n <= 1) {
			return 0;
		}
		
		boolean[] primes = new boolean[n+1];
		Arrays.fill(primes, true);
		
		for(int i = 2; i <= (int)Math.sqrt(n); i++) { 
			
			if(primes[i] == true) {
				for(int j = i*i; j <= n; j = j+i) {
					primes[j] = false;
				}
			}
		}
		
		int count = 0;
		for(int i = 2; i <= n; i++) {
			if(primes[i] == true) {
				System.out.println(i);
				count++;
			}
		}
		
		return count;
	}
	
	/*
	 * Best approach: Sieve of Eratosthenes (One extra loop is removed)
	 * 
	 * Here, n is inclusive
	 * 
	 * T = O(n * log(log n))
	 * S = O(n)
	 * 
	 */
	private static int primes_upto_N_inclusive_best(int n) {
		
		if(n <= 1) {
			return 0;
		}
		
		boolean[] primes = new boolean[n+1];
		Arrays.fill(primes, true);
		
		int count = 0;
		
		for(int i = 2; i <= n; i++) { 
			
			if(primes[i] == true) {
				count++;
				System.out.println(i);
				for(int j = i*i; j <= n; j = j+i) {
					primes[j] = false;
				}
			}
		}
		
		return count;
	}
	
	/*
	 * Best approach: Sieve of Eratosthenes
	 * 
	 * Here, n is exclusive
	 * 
	 *  T = O(n * log(log n)) + O(n) =~ O(n * log(log n)) 
	 * S = O(n)
	 */
	private static int primes_upto_N_exclusive(int n) {
		
		 if(n <= 2) {
			return 0;
		}
		
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		
		for(int i = 2; i*i <= n; i++) {
			
			if(primes[i] == true) {
				for(int j = i*i; j < n; j = j+i) {
					primes[j] = false;
				}
			}
		}
		
		int count = 0;
		for(int i = 2; i < n; i++) {
			if(primes[i] == true) {
				System.out.println(i);
				count++;
			}
		}
		
		return count;
	}
	
	/*
	 * Best approach: Sieve of Eratosthenes (One extra loop is removed)
	 * 
	 * Here, n is exclusive
	 * 
	 * T = O(n * log(log n))
	 * S = O(n)
	 * 
	 */
	public static int primes_upto_N_exclusive_best(int n) {
        if(n <= 2) {
			return 0;
		}
		
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);

        int count = 0;
		
		for(int i = 2; i < n; i++) {
			
			if(primes[i] == true) {
                count++;
                System.out.println(i);
				for(int j = i*i; j < n; j = j+i) {
					primes[j] = false;
				}
			}
		}
		
		return count;
    }
}
