package algorithms;

import java.util.Arrays;

public class Closest_Prime_Numbers_In_Range {
	
	public static void main(String[] args) {
		int left = 45;
		int right = 62;
		int[] pairs = closestPrimes(left, right);
		
		for(int i : pairs) {
			System.out.print(i +" | ");
		}
	}
	
	/*
	 * Since, right >= left, So, make the Sieve array of size "right+1".
	 * Once, Sieve array is ready, then you have to iterate from left to right 
	 * and find the pairs with minimum difference.
	 * 
	 * T = O(right * log(log(right))) + O(right - left) =~ O(right * log(log(right)))
	 * S = O(right)
	 */
	private static int[] closestPrimes(int left, int right) {
		
        int sieve_array_size = right;
		boolean[] primes = new boolean[sieve_array_size+1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		
		// Create Sieve Array
		for(int i = 2; i*i <= sieve_array_size; i++) {
			if(primes[i]) {
				for(int j = i*i; j <= sieve_array_size; j=j+i) {
					primes[j] = false;
				}
			}
		}

        int tempFirstPrime = 0;
        int tempSecondPrime = 0;
        int firstPrime = 0;
        int secondPrime = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++) {
            if(primes[i] && tempFirstPrime == 0) {
            	tempFirstPrime = i;
            } else if(primes[i] && tempSecondPrime == 0) {
            	tempSecondPrime = i;
            }
            
            if(tempFirstPrime != 0 && tempSecondPrime != 0) {
                int diff = tempSecondPrime - tempFirstPrime;
                if(diff < minDiff) {
                	minDiff = diff;
                	firstPrime = tempFirstPrime;
                	secondPrime = tempSecondPrime;
                } 
                tempFirstPrime = tempSecondPrime;
            	tempSecondPrime = 0;
            }
        }
        
        if(firstPrime != 0 && secondPrime != 0) {
            return new int[]{firstPrime, secondPrime};
        }

        return new int[]{-1, -1};
    }
}
