package algorithms;

/* Problem Statement: Given an integer array arr, find the contiguous 
 * subarray (containing at least one number) which has the largest 
 * sum and return its sum and print the subarray.
 * 
 * Note: The length of subArray should be maximum
 * */
public class Kadanes_Algo_Modified {
	private static int[] subArrayStartEnd = {0,0};
	
	public static void main(String[] args) {
		//int[] arr = {-2, 1, -3, 4, -1, 2, 1, -7, 4};
		//int[] arr = {-3, -2, -4, -7};
		//int[] arr = {-3, -2, 4, -2, 3, 2, -1, 2};
		int[] arr = {-3, -2, 4, -2, 3, 2, -1, 1};
		int maxSum = maxSubArray(arr);
		System.out.println("Sum = " + maxSum);
		System.out.print("Sub-array with maximum sum: | ");
		for(int i = subArrayStartEnd[0]; i <= subArrayStartEnd[1]; i++) {
			System.out.print(arr[i] + " | ");
		}
	}
	
	public static int maxSubArray(int[] arr) {
		int sum = arr[0];
		int start = 0;
		int tempSum = 0;
		
		for(int i = 0; i <= arr.length - 1; i++) {
			tempSum = tempSum + arr[i];
			if(tempSum >= sum) {
				sum = tempSum;
				subArrayStartEnd[0] = start;
				subArrayStartEnd[1] = i;
			}
			
			if(tempSum < 0) {
				start = i + 1;
				tempSum = 0;
			}
		}
		return sum;
	}
}
