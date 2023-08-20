package algorithms;

/*
 * Find the duplicate in an array of N+1 integers
 * Problem Statement: Given an array of N + 1 size, where each element is 
 * between 1 and N. Find the one duplicate number.
 * 
 * Optional Condition: Assuming there is only one duplicate number, your task 
 * is to find the duplicate number.
 */


/*
 * Brute Force approach 1: For each element compare with each of the other elements 
 * T = O(n^2)
 * S = O(1)
 */

/*
 * Brute Force approach 2 (Slightly better): Sort the elements. Then iterate over the array and
 * check if arr[i] == arr[i+1].
 * T = O(nlog n)
 * S = O(1)
 */

/*
 * Better Solution: Iterate over the array and put the element in HashMap.
 * If an element is already present in HashMap then that is the duplicate element
 * T = O(n)
 * S = O(n)
 */
public class Find_Duplicate_In_Array_Of_N_plus_1_Size {
	public static void main(String[] args) {
		int[] arr = {3, 9, 8, 4, 2, 7, 5, 6, 9, 4, 9};
		int duplicateElement = duplicateElementInArray(arr);
		System.out.println("One of the duplicate element in the array = " + duplicateElement);
	}
	
	/*
	 * Optimal Approach: Here, we will use Floyd's cycle detection algorithm
	 * 
	 * T = O(n)
	 * S = O(1)
	 */
	public static int duplicateElementInArray(int[] arr) {
		int arraySize = arr.length; // arraySize = n + 1 => n = arraySize - 1
		int n = arraySize - 1;
		
		// Initialize fast and slow
		int slow = arr[0];
		int fast = arr[0];
		
		// Move slow by 1 step
		// Move fast by 2 steps
		do {
			slow = arr[slow];
			fast = arr[arr[fast]];
			
		} while(slow != fast); // when slow and fast becomes equal then that is the meeting point
		
		int meet = slow; // or fast
		
		int t = arr[0]; // Take a pointer at start to traverse
		
		//Move both t and meet by 1 step till the meet
		// Whenever they meet then that is the duplicate number
		while(t != meet) {
			t = arr[t];
			meet = arr[meet];
		}
		
		return t;
	}
}
