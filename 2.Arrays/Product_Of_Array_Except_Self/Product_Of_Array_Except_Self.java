package algorithms.part1;

import java.util.stream.IntStream;

public class Product_Of_Array_Except_Self {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		int[] output = productExceptSelf(arr);
		
		IntStream.of(output).forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = O(2n) = O(n)
	 * S = O(n)
	 */
	private static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        int prefixProd = 1;
        int postfixProd = 1;
        for(int i = 0; i <= n-1; i++) {
            output[i] = prefixProd;
            prefixProd = prefixProd * arr[i];
        }

        for(int i = n-1; i >= 0; i--) {
            output[i] = postfixProd * output[i];
            postfixProd = postfixProd * arr[i];
        }

        return output;
    }
}
