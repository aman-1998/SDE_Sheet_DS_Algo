package algorithms.part4;

import java.util.Stack;

public class Queue_Using_Two_Stacks {
	
	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		
		System.out.println(queue.empty());
		
		System.out.println(queue.peek());
		
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		
		queue.push(5);
		
		System.out.println(queue.pop());
		
		queue.push(6);
		
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}

class MyQueue {
	
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {
        
    }
    
    // T = O(1)
    public void push(int x) {
        stack1.push(x);
    }
    
    // T = O(n)
    public int pop() {
        if(stack2.isEmpty()) {
        	while(!stack1.isEmpty()) {
        		int val = stack1.pop();
        		stack2.push(val);
        	}
        }
        
        return stack2.pop();
    }
    
    // T = O(n)
    public int peek() {
    	if(stack2.isEmpty()) {
        	while(!stack1.isEmpty()) {
        		int val = stack1.pop();
        		stack2.push(val);
        	}
        }
    	return stack2.peek();
    }
    
    // T = O(1)
    public void removeAll() {
        stack1.clear();
        stack2.clear();
    }
    
    // T = O(1)
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

