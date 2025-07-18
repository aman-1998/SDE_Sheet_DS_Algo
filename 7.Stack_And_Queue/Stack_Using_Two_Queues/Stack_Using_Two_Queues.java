package algorithms.part4;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_Using_Two_Queues {
	
	public static void main(String[] args) {
		Stack stack = new Stack();
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

class MyStack {
	
	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();
	
	// T= O(n)
	public void push(int x) {
		if(queue1.isEmpty()) {
			queue1.add(x);
			while(!queue2.isEmpty()) {
				int val = queue2.poll();
				queue1.add(val);
			}
		} else if(queue2.isEmpty()) {
			queue2.add(x);
			while(!queue1.isEmpty()) {
				int val = queue1.poll();
				queue2.add(val);
			}
		}
	}
	
	// T= O(1)
	public int pop() {
		if(!queue1.isEmpty()) {
			return queue1.poll();
		} else if(!queue2.isEmpty()) {
			return queue2.poll();
		}
		return Integer.MIN_VALUE;
	}
	
	// T= O(1)
	public int top() { // peek()
		if(!queue1.isEmpty()) {
			return queue1.peek();
		} else if(!queue2.isEmpty()) {
			return queue2.peek();
		}
		return Integer.MIN_VALUE;
	}
	
	// T= O(1)
	public void removeAll() {
		queue1.clear();
		queue2.clear();
	}
	
	// T= O(1)
	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}
}