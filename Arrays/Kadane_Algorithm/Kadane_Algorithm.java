package practice;

public class Kadane_Algorithm {
	
	public static int[] startEnd = {0, 0};
	
	public static void main(String[] args) {
		
		int[] arr = {-2, -3, 1, -1, 3, 2, -3, 11};
		int sum = continuousSubArrayWithMaxSum(arr);
		
		System.out.print("The continuous sub-array with maximum sum is: ");
		for(int i = startEnd[0]; i <= startEnd[1]; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\nSum = " + sum);
		
	}
	
	/*
	 * T = O(n)
	 */
	public static int continuousSubArrayWithMaxSum(int[] arr) {
		
		int sum = arr[0];
		int tempSum = 0;
		int start = 0;
		
		for(int i=0; i < arr.length; i++) {
			tempSum = tempSum + arr[i];
			if(tempSum > sum) {
				sum = tempSum;
				startEnd[0] = start;
				startEnd[1] = i;
			}
			
			if(tempSum < 0) {
				tempSum = 0;
				start = i + 1;
			}
		}
		
		return sum;
	}
}
