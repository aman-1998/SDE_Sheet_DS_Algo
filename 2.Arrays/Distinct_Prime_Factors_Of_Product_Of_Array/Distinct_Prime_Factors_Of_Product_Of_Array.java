package practice.dsa.sheet.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Distinct_Prime_Factors_Of_Product_Of_Array {
	
	public static void main(String[] args) {
		
	}
	
	public static Set<Integer> set = new HashSet<>();
	
	/*
	 * T = O(n*max*log(log max))
	 */
    public static int distinctPrimeFactors(int[] nums) {

        for(int i = 0; i <= nums.length-1; i++) {
        	primeFactorization_1st_approach(nums[i]);
        }
        
        return set.size();
    }
    
    public static void primeFactorization_1st_approach(int n) {
		
		for(int i = 2; i <= n; i++) {
			if(isPrime(i)) {
				if(n%i == 0) {
					set.add(i);
				}
			}
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
    public static void primeFactorization_2nd_approach(int n) {
		
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
