package algorithms.part4;

import java.util.Stack;
import java.util.stream.IntStream;

public class Next_Greater_Element_NGE_1 {
	
	public static void main(String[] args) {
		
		int[] arr = {4 ,12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
		IntStream.of(arr).boxed().forEach(t -> System.out.print(t + " "));
		System.out.println();
		
		int[] nge = nextGreaterElement_BF(arr);
		
		IntStream.of(nge).boxed().forEach(t -> System.out.print(t + " "));
		
		System.out.println();
		
		nge = nextGreaterElement(arr);
		
		IntStream.of(nge).boxed().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = O(n*n)
	 * S = O(n) => because of output is in different array
	 */
	private static int[] nextGreaterElement_BF(int[] arr) {
		
		int n = arr.length;
		int[] nge = new int[n];
		for(int i = 0; i <= n-1; i++) {
			boolean found = false;
			for(int j = i+1; j <= n-1; j++) {
				if(arr[j] > arr[i]) {
					nge[i] = arr[j];
					found = true;
					break;
				}
			}
			
			if(!found) {
				nge[i] = -1;
			}
		}
		
		return nge;
	}
	
	/*
	 * T = O(2n)
	 * S = O(n) => because of output is in different array
	 */
	private static int[] nextGreaterElement(int[] arr) {
		
		int n = arr.length;
		int[] nge = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = n-1; i >= 0; i--) {
			int val = -1;
			if(!stack.isEmpty()) {
				val = stack.peek();
				while(val <= arr[i]) {
					stack.pop();
					if(stack.isEmpty()) {
						val = -1;
						break;
					}
					val = stack.peek();
				}
			}
			nge[i] = val;
			stack.push(arr[i]);
		}
		
		return nge;
	}
}
