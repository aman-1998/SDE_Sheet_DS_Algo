package practice.dsa.sheet.part1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct_Prime_Factors_Of_Product_Of_Array {
	
	public static void main(String[] args) {
		
		int[] arr = {2, 20, 16, 2, 6, 13, 7, 9};
		int res = distinctPrimeFactors(arr);
		
		System.out.println(res);
	}
	
	public static Set<Integer> set = new HashSet<>();
	
	/*
	 * T = O(n*max*log(log max)) ; S = O(max): 3rd approach
	 * or T = O(n*max*sqrt(max)) ; S = O(1) : 1st approach
	 * or T = O(n*max) ; S = O(1) : 2nd approach
	 */
    public static int distinctPrimeFactors(int[] nums) {

        for(int i = 0; i <= nums.length-1; i++) {
        	primeFactorization_2nd_approach(nums[i]);
        }
        
        return set.size();
    }
    
    /*
     * T = O(n*sqrt(n))
     * S = O(1)
     */
    public static void primeFactorization_1st_approach(int n) {
		
		for(int i = 2; i <= n; i++) {
			if(isPrime(i)) {
				if(n%i == 0) {
					set.add(i);
				}
			}
		}
	}
    
    /*
     * T = O(sqrt(n)) + O(sqrt(n)) = O(n)
     * S = O(1)
     */
    public static void primeFactorization_2nd_approach(int n) {
    	
		for(int i = 2; i*i <= n; i++) {
			
			if(n%i == 0) {
				if(isPrime(i)) {
					set.add(i);
				}
				
				int q = n/i;
				if(n%q == 0) {
					if(isPrime(q)) {
						set.add(q);
					}
				}
			}
		}
		
		if(isPrime(n)) {
    		set.add(n);
    	}
	}
	
	private static boolean isPrime(int x) {
		
		for(int i = 2; i*i <= x; i++) {
			if(x%i == 0) {
				return false;
			}
		}
		return true;
	}
    
    
    /*
     * T = O(n*log(log n))
     * S = O(n)
     */
    public static void primeFactorization_3rd_approach(int n) {
		
		boolean[] sieveArray = new boolean[n+1];
		Arrays.fill(sieveArray, true);
		sieveArray[0] = false;
		sieveArray[1] = false;
		
		for(int i = 2; i <= n; i++) {
			if(sieveArray[i] == true) {
				if(n%i == 0) {
					set.add(i);
				}
				for(int j = i*i; j <= n; j+=i) {
					sieveArray[j] = false;
				}
			}
		}
	}
}
