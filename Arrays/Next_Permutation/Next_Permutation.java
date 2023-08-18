package algorithms;

public class Next_Permutation {
	public static void main(String[] args) {
		int[] arr = {2, 1, 5, 4, 3, 0, 0};
		//int[] arr = {2, 6, 5, 4, 3, 0, 0};
		//int[] arr = {2, 1 , 3, 5, 4};
		//int[] arr = {1, 2, 3, 4};
		//int[] arr = {2, 3, 4};
		//int[] arr = {4, 3, 2};
		//int[] arr = {4, 7};
		//int[] arr = {7, 4};
		arr = nextPermutation(arr);
		
		//Next Permutation
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	/*
	 * T = O(n)
	 */
	public static int[] nextPermutation(int[] arr) {
		
		int n = arr.length;
		
		int i, j;
		//Find breaking point (i.e., arr[i] < arr[i+1])
		for(i = n-2; i >= 0; i--) {
			if(arr[i] < arr[i+1]) {
				break;
			}
		}
		
		//If input array sorted in descending order then return reverse of it  (i.e., sorted in ascending order)
		if(i == -1) {
			reverse(arr, 0, n-1);
			return arr;
		}
		
		//Finding smallest no. element greater than the element at ith index in the range(i+1 to n-1)
		for(j = n-1; j > i; j--) {
			if(arr[j] > arr[i]) {
				//swap the element at index i and j
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				break;
			}
		}
		
		reverse(arr, i+1, n-1);
		
		return arr;
	}

	private static int[] reverse(int[] arr, int i, int j) {
		
		int n = arr.length;
		
		if(i < 0 || i > n-1) {
			return arr;
		}
		
		if(j < 0 || j > n-1) {
			return arr;
		}
		
		while(i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		return arr;
	}
}
