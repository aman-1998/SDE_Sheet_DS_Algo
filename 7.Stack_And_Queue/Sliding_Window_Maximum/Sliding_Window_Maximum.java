package algorithms.part4;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Sliding_Window_Maximum {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 3, -1, -3, 5, 3, 7, 1, 6};
		int k = 3;
		
		//int[] arr = {1, 3, -1, -3, 5, 3, 2, 1, 6};
		//int k = 3;
		
		//int[] arr = {1};
		//int k = 1;
		
		int[] res = maxSlidingWindow_Brute_Force(arr, k);
		
		Arrays.stream(res).boxed().forEach(t -> System.out.print(t + " "));
		
		System.out.println();
		
		res = maxSlidingWindow(arr, k);
		
		Arrays.stream(res).boxed().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * Brute Force: For each window find maximum
	 * 
	 * T = O(n-k)*k
	 * S = O(n-k)  (for storing the result itself)
	 */
	public static int[] maxSlidingWindow_Brute_Force(int[] arr, int k) {
        
		if(k == 1) {
			return arr;
		}
		
		int n = arr.length;
		int[] res = new int[n-k+1];
		
		for(int i = 0; i <= n-k; i++) {
			int max = Integer.MIN_VALUE;
			for(int j = i; j < i+k; j++) {
				if(arr[j] > max) {
					max = arr[j];
				}
			}
			res[i] = max;
		}
		
		return res;
	}
	
	/*
	 * Optimized approach
	 * 
	 * T = O(2n)
	 * S = O(n-k) + O(k)  (Deque can have maximum k elements at any moment)
	 */
	public static int[] maxSlidingWindow(int[] arr, int k) {
        
		if(k == 1) {
			return arr;
		}
		
		int n = arr.length;
		int[] res = new int[n-k+1];
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i = 0; i <= n-1; i++) {
			if(deque.isEmpty()) {
				deque.addFirst(i);
			} else {
				int val = deque.peekLast();
				int initialIndexOfWindow = i - k + 1;
				int lastIndexOfWindow = i;
				if(initialIndexOfWindow <= val && val <= lastIndexOfWindow) {
					
					int top = deque.peekFirst();
					while(arr[i] >= arr[top]) {
						deque.pollFirst();
						if(deque.isEmpty()) {
							break;
						}
						top = deque.peekFirst();
					}
					deque.addFirst(i);
					
					if(initialIndexOfWindow >= 0) {
						res[initialIndexOfWindow] = arr[deque.peekLast()];
					}
					
				} else {
					deque.pollLast();
					i--;
				}
			}
		}
		
		return res;
    }
}
