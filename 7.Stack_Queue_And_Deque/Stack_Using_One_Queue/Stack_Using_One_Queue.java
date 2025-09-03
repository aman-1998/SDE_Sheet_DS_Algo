package algorithms.part4;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_Using_One_Queue {
	
	public static void main(String[] args) {
		
		DemoStack stack = new DemoStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		System.out.println(stack.pop());
		
		stack.push(7);
		
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.top());
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.top());
		
		stack.removeAll();
		
		System.out.println(stack.pop());
		
		System.out.println(stack.isEmpty());
	}
	
}


class DemoStack {
	
	Queue<Integer> queue = new LinkedList<>();
	
	// T= O(n)
	public void push(int x) {
		queue.add(x);
		int size = queue.size();
		for(int i = 1; i <= size-1; i++) {
			int val = queue.poll();
			queue.add(val);
		}
	}
	
	// T= O(1)
	public int pop() {
		Integer val = queue.poll();
		if(val == null) {
			return Integer.MIN_VALUE; // queue is empty
		}
		return val;
	}
	
	// T= O(1)
	public int top() { // peek()
		Integer val = queue.peek();
		if(val == null) {
			return Integer.MIN_VALUE; // queue is empty
		}
		return val;
	}
	
	// T= O(1)
	public void removeAll() {
		queue.clear();
	}
	
	// T= O(1)
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
