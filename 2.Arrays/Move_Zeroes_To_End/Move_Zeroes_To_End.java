package algorithms;

import java.util.Arrays;

public class Move_Zeroes_To_End {
	
	public static void main(String[] args) {
		int[] arr = {1, 0, 2, 4, 5, 0, 0, 0, 2, 7, 0, 3};
		arr = moveZeroes(arr);
		Arrays.stream(arr).forEach(t -> System.out.print(t + " | "));
	}
	
	public static int[] moveZeroes(int[] arr) {
		
		int n = arr.length;
		int i = -1;
		for(int j = 0; j <= n-1; j++) {
			if(i > -1 && arr[j] != 0 && arr[i] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
			
			if(i == -1 && arr[j] == 0) {
				i = j;
			}
		}
		
		return arr;
	}
	
	public static int[] moveZeroes_2nd_approach(int[] arr) {
		
		int n = arr.length;
		int j = 0;
		
		// Move j to first index where zero appears
		while(j < n) {
			if(arr[j] == 0) {
				break;
			}
			j++;
		}
		
		// i always points to zero
		int i = j;
		while(j != n) {
			if(arr[j] != 0) { // if arr[j] is not zero then swap
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
			}
			j++;
		}
		
		return arr;
	}
}
