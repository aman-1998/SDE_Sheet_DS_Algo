package algorithms;

import java.util.Arrays;

public class Nth_Prime_Number {
	public static void main(String[] args) {
		
		/*
		 * Here, 1 <= n <= 10^4
		 * Let's consider sieve_array_size = 10^6. We are choosing 10^6 because I am 100% confirmed that in a
		 * Sieve array of size 10^6, 10^4th prime no. will definitely exist. After that I will find at what position
		 * 10^4th prime no. exist by running the program roughly. We get answer as 104729. So, in the code that we 
		 * are going to submit on LeetCode, we will take sieve_array_size = 104729
		 */
		nth_prime_rough_just_for_checking();
		//------------------------------------------------------------------------------------------------------
		
		int n = 3638;
		int nthPrimeNumer = nth_prime(n);
		System.out.println(nthPrimeNumer);
	}
	
	// Rough to find sieve_array_size with pin-point accuracy
	public static void nth_prime_rough_just_for_checking() {
		
		int n = 10000; // Given, 1 <= n <= 10^4
		int sieve_array_size = 1000000; // Let's assume
		
		boolean[] primes = new boolean[sieve_array_size+1];
		Arrays.fill(primes, true);
		
		// Create Sieve Array
		for(int i = 2; i*i <= sieve_array_size; i++) {

			if(primes[i]) {
				for(int j = i*i; j <= sieve_array_size; j=j+i) {
					primes[j] = false;
				}
			}
		}
		
		int count = 0;
		int index = 0;
		for(int i=2; i <= sieve_array_size; i++) {
			if(primes[i]) {
				count++;
				if(count == n) {
					index = i;
					break;
				}
			}
		}
		
		System.out.println(index);
	}
	
	
	/*
	 * If sieve_array_size = S
	 * T = O(S * log(log S)) + O(S) =~ O(S * log(log S))
	 * S = O(S)
	 * 
	 * So here, time complexity depends on our assumption of sieve_array_size. So, we should be very accurate
	 * while choosing the value for sieve_array_size.
	 * 
	 */
	public static int nth_prime(int n) {
		
		int sieve_array_size = 104729;
		
		boolean[] primes = new boolean[sieve_array_size+1];
		Arrays.fill(primes, true);
		
		// Create Sieve Array
		for(int i = 2; i*i <= sieve_array_size; i++) {

			if(primes[i]) {
				for(int j = i*i; j <= sieve_array_size; j=j+i) {
					primes[j] = false;
				}
			}
		}
		
		int count = 0;
		int result = 0;
		for(int i=2; i <= sieve_array_size; i++) {
			if(primes[i]) {
				count++;
				if(count == n) {
					result = i;
					break;
				}
			}
		}
		
		return result;
	}
	
	/*
	 * If sieve_array_size = S
	 * T = O(S * log(log S))
	 * S = O(S)
	 * 
	 * So here, time complexity depends on our assumption of sieve_array_size. So, we should be very accurate
	 * while choosing the value for sieve_array_size.
	 * 
	 */
	public static int nth_prime_best(int n) {
		
		int sieve_array_size = 104729;
		boolean[] primes = new boolean[sieve_array_size+1];
		java.util.Arrays.fill(primes, true);
		int count = 0 ;
		int result = 0;
		for(int i = 2; i<= sieve_array_size; i++) {

			if(primes[i]) {
				count++;
				if(count== n){
					result = i;
					break;
				}
				for(int j = i*i; j <= sieve_array_size; j=j+i) {
					primes[j] = false;
				}
			}
		}
		
		return result;
	}
}
