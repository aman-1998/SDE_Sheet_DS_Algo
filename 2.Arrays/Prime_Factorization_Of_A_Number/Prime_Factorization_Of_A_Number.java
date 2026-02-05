package practice.dsa.sheet.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prime_Factorization_Of_A_Number {
	
	public static void main(String[] args) {
		
		int n = 30;
		
		List<Integer> res = primeFactorization_4th_Approach(n);
		
		res.stream().forEach(t -> System.out.println(t + " "));
	}
	
	/*
	 * T = O(n * root(max))
	 * S = O(1)
	 */
	public static List<Integer> primeFactorization_1st_Approach(int n) {
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = 2; i <= n; i++) {
			if(isPrime(i)) {
				if(n%i == 0) {
					res.add(i);
				}
			}
		}
		
		return res;
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
	 * T = O(n*log(log n)) + O(n)
	 * S = O(n)
	 */
	public static List<Integer> primeFactorization_2nd_Approach(int n) {
		
		boolean[] sieveArray = new boolean[n+1];
		Arrays.fill(sieveArray, true);
		sieveArray[0] = false;
		sieveArray[1] = false;
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = 2; i*i <= n; i++) {
			if(sieveArray[i] == true) {
				for(int j = i*i; j <= n; j+=i) {
					sieveArray[j] = false;
				}
			}
		}
		
		for(int i = 2; i <= n; i++) {
			if(sieveArray[i] == true) {
				if(n%i == 0) {
					res.add(i);
				}
			}
		}
		
		return res;
	}
	
	/*
	 * T = O(n*log(log n))
	 * S = O(n)
	 */
	public static List<Integer> primeFactorization_3rd_Approach(int n) {
		
		boolean[] sieveArray = new boolean[n+1];
		Arrays.fill(sieveArray, true);
		sieveArray[0] = false;
		sieveArray[1] = false;
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = 2; i <= n; i++) {
			if(sieveArray[i] == true) {
				if(n%i == 0) {
					res.add(i);
				}
				for(int j = i*i; j <= n; j+=i) {
					sieveArray[j] = false;
				}
			}
		}
		
		return res;
	}

	// T = O(sqrt(n) * sqrt(n)) +  O(x) = O(n)
	// S = O(1)
	public static List<Integer> primeFactorization_4th_Approach(int n) {
		Set<Integer> set = new HashSet<>();
		for(int i = 2; i*i <= n; i++) {
			if(n%i == 0) {
				if(isPrime(i)) {
					set.add(i);
				}

				int q = n/i;
				if(isPrime(q)) {
					set.add(q);
				}
			}
		}

		if(isPrime(n)) {
    		set.add(n);
    	}

		List<Integer> res = new ArrayList<>(set);
		return res;
	}

}
