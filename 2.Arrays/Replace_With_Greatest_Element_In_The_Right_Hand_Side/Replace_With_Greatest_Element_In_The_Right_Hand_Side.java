package algorithms.part1;

import java.util.Arrays;

public class Replace_With_Greatest_Element_In_The_Right_Hand_Side {
	
	public static void main(String[] args) {
		
		int[] arr = {17,18,5,4,6,1};
		
		arr = replaceElements(arr);
		
		Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = O(n)
	 * S = O(1)
	 */
	public static int[] replaceElements(int[] arr) {
        
		int n = arr.length;
		int maxRight = -1;
		
		for(int i = n-1; i >= 0; i--) {
			
            int temp = arr[i];
            arr[i] = maxRight;
			if(temp > maxRight) {
				maxRight = temp;
			}
		}
		
		return arr;
    }
}
