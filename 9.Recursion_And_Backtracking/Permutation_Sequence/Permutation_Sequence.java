package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence {
	
	public static void main(String[] args) {
		
		int n = 4;
		int k = 17;
		
		String res = getPermutation(n, k);
		
		System.out.println(res);
	}
	
	/*
	 * T = O(n) + O(n) + O(n)*O(n)
	 *   = O(n^2)
	 *   
	 * S = O(n)
	 */
	public static String getPermutation(int n, int k) {
        
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		
		StringBuilder resSb = new StringBuilder();
		int x = k-1;
		int fact = factorial(n-1);
		
		while(numbers.size() != 1) {
			int q = x / fact;
			int r = x % fact;
			
			resSb.append(numbers.get(q));
			numbers.remove(q);
			
			x = r;
			fact = fact / numbers.size();
		}
		
		resSb.append(numbers.get(0));
		
		return resSb.toString();
    }

	private static int factorial(int n) {
		int f = 1;
		for(int i = 1; i <= n; i++) {
			f = f*i;
		}
		return f;
	}

}
