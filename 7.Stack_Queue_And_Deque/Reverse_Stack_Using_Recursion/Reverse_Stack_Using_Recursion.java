package practice.dsa.sheet.part4;

import java.util.Stack;

public class Reverse_Stack_Using_Recursion {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(7);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(6);
		stack.push(4);
		
		stack.stream().forEach(t -> System.out.print(t + " "));
		
		System.out.println();
		
		stack = reverseStack(stack);
		
		stack.stream().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = O(n*n)
	 * S = O(n)
	 */
	public static Stack<Integer> reverseStack(Stack<Integer> stack) {
		
		if(stack.isEmpty()) {
			return stack;
		}
		
		int top = stack.pop();
		stack = reverseStack(stack);
		return insert(stack, top);
	}
	
	public static Stack<Integer> insert(Stack<Integer> stack, int x) {
		
		if(stack.isEmpty()) {
			stack.push(x);
			return stack;
		}
		
		int top = stack.pop();
		stack = insert(stack, x);
		stack.push(top);
		return stack;
	}
}
