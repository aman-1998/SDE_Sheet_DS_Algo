import java.util.Stack;

public class MinStack_Implementation {

		public static void main(String[] args) {
			
			//MinStackBetterSolution minStack = new MinStackBetterSolution();
			MinStack_2nd minStack = new MinStack_2nd();
			// minStack.push(12);
			// minStack.push(15);
			// minStack.push(17);
			// minStack.push(22);
			// minStack.push(10);
			// minStack.push(12);
			// minStack.push(16);
			// minStack.push(5);
			// System.out.println(minStack.getMin());
			// minStack.push(24);
			// minStack.push(14);
			// minStack.push(9);
			// minStack.pop();
			// minStack.pop();
			// minStack.pop();
			// minStack.pop();
			// System.out.println(minStack.top());
			// minStack.pop();
			// minStack.pop();
			// minStack.pop();
			// minStack.pop();
			// minStack.pop();
			// minStack.pop();
			// minStack.pop();
			
			// // Empty stack
			// minStack.pop();

			minStack.push(-2);
			minStack.push(0);
			minStack.push(-3);
			System.out.println(minStack.getMin());
			minStack.pop();
			System.out.println(minStack.top());
			System.out.println(minStack.getMin());
		}
		
}

/*
 * T = O(1) => All operations
 * S = O(2*n)
 */
class MinStackBetterSolution {
	
	private static class Pair {
		public int val;
		public int min;
		
		public Pair(int val, int min) {
			this.val = val;
			this.min = min;
		}
		
		public String toString() {
			return val + " | " + min;
		}
	}
	
	private Stack<Pair> stack = new Stack<>();
	
	public MinStackBetterSolution() {}
    
    public void push(int val) {
        if(stack.isEmpty()) {
        	stack.push(new Pair(val, val));
        } else {
        	int min = stack.peek().min;
        	if(val < min) {
        		min = val;
        	}
        	stack.push(new Pair(val, min));
        }
    }
    
    public void pop() {
    	Pair popped = stack.pop();
    	System.out.println(popped.val);
    }
    
    public int top() {
    	return stack.peek().val;
    }
    
    public int getMin() {
    	return stack.peek().min;
    }
}

/*
 * T = O(1) => All operations
 * S = O(n)
 */
class MinStack {
	
	private Stack<Integer> stack = new Stack<>();
	
	private int min = Integer.MIN_VALUE;
	
	public MinStack() {}
    
    public void push(int val) {
        if(stack.isEmpty()) {
        	stack.push(val);
        	min = val;
        	return;
        }
        
        if(val < min) {
        	int x = 2*val - min;
        	stack.push(x);
        	min = val;
        } else {
        	stack.push(val);
        }
    }
    
    public void pop() {
    	int x = stack.peek();
        if(x < min) {
        	int popped = min;
        	min = 2*min - x;
        	stack.pop();
        	//System.out.println(popped);
        } else {
        	int popped = stack.pop();
        	//System.out.println(popped);
        }
    }
    
    public int top() {
    	int x = stack.peek();
        if(x < min) {
        	return min;
        } else {
        	return x;
        }
    }
    
    public int getMin() {
        return min;
    }
}


class MinStack_2nd { // Best
	
	private int min = Integer.MAX_VALUE;
	
	private Stack<Integer> stack = new Stack<>();
	
	public void push(int val) {
		if(val < min) {
			int prevMin = min;
			min = val;
			if(!stack.isEmpty()) {
				val = 2*val - prevMin;
			}
		}
		stack.push(val);
	}
	
	public int top() {
		int top = stack.peek();
		if(top < min) {
			return min;
		} else {
			return top;
		}
	}
	
	public int pop() {
		int top = stack.pop();
		if(top < min) {
			int toBepopped = min;
			min = 2*min - top;
			return toBepopped;
		} else {
			return top;
		}
	}
	
	public int getMin() {
		return min;
	}
}

/*
 * LeetCode Version
 * 
 */

class MinStackLeetCode {

    private Stack<Long> stack = new Stack<>();
	
	private long min = Long.MIN_VALUE;
	
	public MinStackLeetCode() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
        	stack.push((long)val);
        	min = val;
        	return;
        }
        
        if(val < min) {
        	long x = 2L*val - min;
        	stack.push(x);
        	min = val;
        } else {
        	stack.push((long)val);
        }
    }
    
    public void pop() {
    	long x = stack.peek();
        if(x < min) {
        	long popped = min;
        	min = 2L*min - x;
        	stack.pop();
        	//System.out.println(popped);
        } else {
        	long popped = stack.pop();
        	//System.out.println(popped);
        }
    }
    
    public int top() {
    	long x = stack.peek();
        if(x < min) {
        	return (int)min;
        } else {
        	return (int)x;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}
