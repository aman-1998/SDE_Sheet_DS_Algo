package algorithms.part4;

import java.util.Stack;
import java.util.stream.IntStream;

public class Largest_Rectangle_In_Histogram {
	
	public static void main(String[] args) {
		
		int[] height = {2, 1, 3, 5, 6, 4, 2, 3, 4, 4, 1};
		
		/*
		int[] pse = previousSmallerElement(height);
		int[] nse = nextSmallerElement(height);
		IntStream.of(height).boxed().forEach(t -> System.out.print(t + " "));
		System.out.println();
		IntStream.of(pse).boxed().forEach(t -> System.out.print(t + " "));
		System.out.println();
		IntStream.of(nse).boxed().forEach(t -> System.out.print(t + " "));
		*/
		
		int maxArea = largestRectangleArea_Better(height);
		
		System.out.println(maxArea);
		
		maxArea = largestRectangleArea(height);
		
		System.out.println(maxArea);
	}
	
	/*
	 * Better Solution
	 * 
	 * T = O(5n)
	 * S = O(4n)
	 */
	public static int largestRectangleArea_Better(int[] height) {
		
		int n = height.length;
		int[] pse = previousSmallerElement(height); // T = O(2n)
		int[] nse = nextSmallerElement(height); // T = O(2n)
		int maxArea = Integer.MIN_VALUE;
		for(int i = 0; i <= n-1; i++) { // T = O(n)
			int area = height[i] * (nse[i] - pse[i] - 1);
			if(area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}
	
	/*
	 * T = O(2n)
	 * S = O(2n)
	 */
	public static int[] previousSmallerElement(int[] arr) {
		
		int n = arr.length;
		int[] pse = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i <= n-1; i++) {
			int val = -1;
			if(!stack.isEmpty()) {
				val = stack.peek();
				while(arr[val] >= arr[i]) {
					stack.pop();
					if(stack.isEmpty()) {
						val = -1;
						break;
					}
					val = stack.peek();
				}
			}
			pse[i] = val;
			stack.push(i);
		}
		
		return pse;
	}
	
	/*
	 * T = O(2n)
	 * S = O(2n)
	 */
	public static int[] nextSmallerElement(int[] arr) {
		
		int n = arr.length;
		int[] nse = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = n-1; i >= 0; i--) {
			int val = n;
			if(!stack.isEmpty()) {
				val = stack.peek();
				while(arr[val] >= arr[i]) {
					stack.pop();
					if(stack.isEmpty()) {
						val = n;
						break;
					}
					val = stack.peek();
				}
			}
			nse[i] = val;
			stack.push(i);
		}
		
		return nse;
	}
	
	/*
	 * Best Solution
	 * 
	 * T = O(2n)
	 * S = O(n)
	 * 
	 */
	public static int largestRectangleArea(int[] height) {
		
		int n = height.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = Integer.MIN_VALUE;
		
		for(int  i = 0; i <= n-1; i++) {
			
			while(!stack.isEmpty() && height[stack.peek()] >= height[i]) {
				int nse = i;
				int element = height[stack.pop()];
				int pse = stack.isEmpty() ? -1 : stack.peek();
				
				int area = element * (nse - pse - 1);
				if(area > maxArea) {
					maxArea = area;
				}
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int nse = n;
			int element = height[stack.pop()];
			int pse = stack.isEmpty() ? -1 : stack.peek();
			
			int area = element * (nse - pse - 1);
			if(area > maxArea) {
				maxArea = area;
			}
		}
		
		return maxArea;
	}
}
