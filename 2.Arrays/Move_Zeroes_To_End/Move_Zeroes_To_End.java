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
}
