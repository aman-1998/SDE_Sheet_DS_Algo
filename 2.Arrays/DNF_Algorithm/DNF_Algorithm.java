package algorithms;

/*
 * Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place 
 * sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) 
 * and constant space)
 */
public class DNF_Algorithm {
	public static void main(String[] args) {
		int[] arr = {2, 1, 0, 0, 1, 2, 0, 1, 0, 2, 2, 0, 1, 2, 0};
		//int[] arr = {2};
		arr = sortUsingDNFAlgo(arr);
		
		// Sorted array
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	/*
	 * DNF = Dutch National Flag Algorithm
	 * T=O(n)
	 */
	public static int[] sortUsingDNFAlgo(int[] arr) {
		
		int n = arr.length; // No. of elements in array
		
		int low = 0;
		int mid = 0;
		int high = n-1;
		
		while(mid <= high) {
			if(arr[mid] == 0) {
				
				//swap(arr[low], arr[mid])
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				
				low = low + 1;
				mid = mid + 1;
			} else if(arr[mid] == 1) {
				mid = mid + 1;
			} else if(arr[mid] == 2) {
				
				//swap(arr[mid], arr[high])
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				
				high = high - 1;
			}
		}
		
		return arr;
	}
}
