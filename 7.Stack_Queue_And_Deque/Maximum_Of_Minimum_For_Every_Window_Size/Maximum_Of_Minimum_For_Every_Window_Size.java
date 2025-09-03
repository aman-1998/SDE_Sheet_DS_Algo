package practice.dsa.sheet.part4;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Maximum_Of_Minimum_For_Every_Window_Size {
	
	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 50, 10, 70, 30};
		
		int[] res = maxOfMinForEverySlidingWindow_Best(arr);
		
		Arrays.stream(res).boxed().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = O(n*n)
	 * S = O(n)
	 */
	public static int[] maxOfMinForEverySlidingWindow_BF(int[] arr) {
        
		int n = arr.length;
		int[] res = new int[n];
		
		for(int k = 1; k <= n; k++) {
			res[k-1] = slidingWindowMin(arr, k);
		}
		
		return res;
    }
	
	/*
	 * Optimized approach
	 * 
	 * T = O(2n)
	 * S = O(k)  (Deque can have maximum k elements at any moment)
	 */
	public static int slidingWindowMin(int[] arr, int k) {
		
		int n = arr.length;
		Deque<Integer> deque = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		
		if(k == 1) {
			for(int i = 0; i <= n-1; i++) {
				if(arr[i] > max) {
					max = arr[i];
				}
			}
			return max;
		}
		
		for(int i = 0; i <= n-1; i++) {
			if(deque.isEmpty()) {
				deque.addFirst(i);
			} else {
				int val = deque.peekLast();
				int initialIndexOfWindow = i - k + 1;
				int lastIndexOfWindow = i;
				if(initialIndexOfWindow <= val && val <= lastIndexOfWindow) {
					
					int top = deque.peekFirst();
					while(arr[i] <= arr[top]) {
						deque.pollFirst();
						if(deque.isEmpty()) {
							break;
						}
						top = deque.peekFirst();
					}
					deque.addFirst(i);
					
					if(initialIndexOfWindow >= 0) {
						if(arr[deque.peekLast()] > max) {
							max = arr[deque.peekLast()];
						}
					}
					
				} else {
					deque.pollLast();
					i--;
				}
			}
		}
		
		return max;
	}
	
	
	//============================================================================
	
	
	/*
	 * T = O(6n)
	 * S = O(2n)
	 */
	public static int[] maxOfMinForEverySlidingWindow_Best(int[] arr) {
		
		int n = arr.length;
		int[] res = new int[n];
		Arrays.fill(res, Integer.MIN_VALUE);
		
		int[] nse_indexes = nextSmallerElement(arr);
		int[] pse_indexes = previousSmallerElement(arr);
		
		for(int i = 0; i <= n-1; i++) { // T = O(n)
			int windowSize = nse_indexes[i] - pse_indexes[i] - 1;
			if(arr[i] > res[windowSize-1]) {
				res[windowSize-1] = arr[i];
			}
		}
		
		for(int i = n-2; i >=0; i--) { // T = O(n)
			if(res[i] < res[i+1]) {
				res[i] = res[i+1];
			}
		}
		
		return res;
	}
	
	/*
	 * T = O(2n)
	 * S = O(n)
	 */
	private static int[] previousSmallerElement(int[] arr) {
		
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int[] pse = new int[n];
		
		for(int i = 0; i <= n-1; i++) {
			int index = -1;
			if(!stack.isEmpty()) {
				index = stack.peek();
				while(arr[index] >= arr[i]) {
					stack.pop();
					if(stack.isEmpty()) {
						index = -1;
						break;
					}
					index = stack.peek();
				}
			}
			pse[i] = index;
			stack.push(i);
		}
		
		return pse;
	}

	/*
	 * T = O(2n)
	 * S = O(n)
	 */
	private static int[] nextSmallerElement(int[] arr) {
		
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int[] nse = new int[n];
		
		for(int i = n-1; i >= 0; i--) {
			int index = n;
			if(!stack.isEmpty()) {
				index = stack.peek();
				while(arr[index] >= arr[i]) {
					stack.pop();
					if(stack.isEmpty()) {
						index = n;
						break;
					}
					index = stack.peek();
				}
			}
			nse[i] = index;
			stack.push(i);
		}
		
		return nse;
	}
	
}
