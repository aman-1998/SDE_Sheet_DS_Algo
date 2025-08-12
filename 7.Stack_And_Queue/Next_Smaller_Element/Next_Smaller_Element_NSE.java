package algorithms.part4;

import java.util.Arrays;
import java.util.Stack;

public class Next_Smaller_Element_NSE {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {4, 2, 1, 5, 3};
		int[] nse = nextSmallerElement(arr);
		
		Arrays.stream(nse).boxed().forEach(t -> System.out.print(t + " "));
	}
	
	private static int[] nextSmallerElement(int[] arr) {
		
		int n = arr.length;
		int[] nse = new int[n];
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = n-1; i >= 0; i--) {
			int val = -1;
			if(!stack.isEmpty()) {
				val = stack.peek();
				while(val >= arr[i]) {
					stack.pop();
					if(stack.isEmpty()) {
						val = -1;
						break;
					}
					val = stack.peek();
				}
			}
			nse[i] = val;
			stack.push(arr[i]);
		}
		
		return nse;
	}
}
