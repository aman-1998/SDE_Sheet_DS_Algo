package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class First_Missing_Positive {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, -1, 0};
		int firstMissingPositive = firstMissingPositive_better(arr);
		
		System.out.println(firstMissingPositive);
	}
	
	/*
	 * Brute Force: Using sorting
	 * 
	 * T = O(n*log(n)) + O(n) = O(n*log(n))
	 * S = O(1)
	 */
	public static int firstMissingPositive_BF(int[] arr) {
		
		int n = arr.length;
		Arrays.sort(arr); // O(n * log(n))
		
		// Find first index where 1 occurs
		int firstIndexOf1 = -1;
		for(int i = 0; i <= n-1; i++) { // O(x)
			if(arr[i] == 1) {
				firstIndexOf1 = i;
				break;
			}
		}
		
		// If 1 is not found the 1 is the answer
		if(firstIndexOf1 == -1) { 
			return 1;
		}
		
		// Check which positive is missing starting from 1 to 
		int i = firstIndexOf1;
		int target = 1;
		while(i < n) { // O(n-x)
			while(target == arr[i]) {
				i++;
				if(i >= n) {
					break;
				}
			}
			
			if(i < n && arr[i] == target+1) {
				target++;
			} else {
				break;
			}
		}
		
		return target + 1;
	}
	
	/*
	 * Better approach : Using hashSet
	 * 
	 * T = O(2 * n) = O(n)
	 * S = O(n)
	 */
	public static int firstMissingPositive_better(int[] arr) {
		
		int n = arr.length;
		Set<Integer> hashSet = new HashSet<Integer>();
		
		for(int i = 0; i <= n-1; i++) {
			hashSet.add(arr[i]);
		}
		
		int firstMissingPositive = 0;
		for(int i = 1; i <= n+1; i++) {
			if(!hashSet.contains(i)) {
				firstMissingPositive = i;
				break;
			}
		}
		
		return firstMissingPositive;
	}
	
	/*
	 * Best approach
	 * 
	 * T = O(3 * n) = O(n)
	 * S = O(1)
	 */
	public static int firstMissingPositive(int[] arr) {
		
		int n = arr.length;
		// Possible positive missing no. : 1, 2, 3, .... , n+1
		
		for(int i = 0; i <= n-1; i++) {
			if(arr[i] < 0) {
				arr[i] = 0; // because -ve nos. is of no use
			}
		}
		
		// Mark -ve for the positive nos. which are present
		for(int i = 0; i <= n-1; i++) {
			if(0 <=  Math.abs(arr[i])-1 && Math.abs(arr[i])-1 <= n-1) {
				if(arr[Math.abs(arr[i])-1] > 0) {
					arr[Math.abs(arr[i])-1] = -1 * arr[Math.abs(arr[i])-1];
				} else if(arr[Math.abs(arr[i])-1] == 0) {
					arr[Math.abs(arr[i])-1] = -(n+1);
				}
			}
		}
		
		// Check for which number, -ve is marked
		int firstMissingPositive = n+1;
		for(int i = 1; i <= n; i++) {
			if(arr[i-1] >= 0) {
				firstMissingPositive = i;
				break;
			}
		}
		
		return firstMissingPositive;
	}
}
