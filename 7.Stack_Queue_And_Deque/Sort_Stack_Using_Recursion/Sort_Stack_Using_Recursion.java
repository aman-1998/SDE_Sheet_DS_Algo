package practice.dsa.sheet.part4;

import java.util.Stack;

/*
 * Video : https://www.youtube.com/watch?v=XNAv8NrAwng
 */
public class Sort_Stack_Using_Recursion {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		stack = sortStack(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	/*
	 * T = O(n*n)
	 * S = O(n)
	 */
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return stack;
		}
		
		int x = stack.pop();
		stack = sortStack(stack);
		return insert(stack, x);
	}

	private static Stack<Integer> insert(Stack<Integer> stack, int x) {
		if(stack.isEmpty()) {
			stack.push(x);
			return stack;
		}
		
		int top = stack.peek();
		if(top <= x) {
			stack.push(x);
		} else {
			top = stack.pop();
			stack = insert(stack, x);
			stack.push(top);
		}
		
		return stack;
	}
}
