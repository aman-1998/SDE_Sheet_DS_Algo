package algorithms;

/*
 * You are given a read only array of n integers from 1 to n.
 * Each integer appears exactly once except A which appears twice and B which is missing.
 * Return A and B.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Note that in your output A should precede B.
 * 
 * Example:
 *
 * Input:[3 1 2 5 3] 
 *
 * Output:[3, 4] 
 *
 * A = 3, B = 4
 */

public class Repeating_And_Missing_Number {
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 5 ,3};
		int[] repeatingAndMissing = repeatingAndMissingNo(arr);
		
		System.out.println("Repeating No. = " + repeatingAndMissing[0]);
		System.out.println("Missing No. = " + repeatingAndMissing[1]);
	}
	
	public static int[] repeatingAndMissingNo(int[] arr) {
		
		Integer n = arr.length; // Size of array
		/*
		 * We can have numbers ranging from 1 to n (inclusive).
		 * So, either all numbers will be distinct.
		 * Or, if one of the number is missing then another no. will be repeating
		 */
		
		Integer sn = (n*(n+1)) / 2; // Sum of first n natural numbers.
		Integer s2n = (n*(n+1)*(2*n + 1)) / 6; // Sum of squares of first n natural numbers
		
		Integer s1 = 0;
		Integer s2 = 0;
		for(int i = 0; i < n; i++) {
			s1 = s1 + arr[i];
			s2 = s2 + arr[i]*arr[i];
		}
		
		Integer val1 = s1 - sn; // x - y = val1 , where x = repeating no. and y = missing no.
		Integer val2 = s2 - s2n; // x^2 - y^2 = (x-y)*(x+y) = val2
		Integer val3 = val2 / val1; // x + y = val3
		
		Integer x = (val1 + val3) / 2; // Repeating no.
		Integer y = (val3 - val1) / 2; // Missing no.
		
		return new int[] {x, y};
	}
}
