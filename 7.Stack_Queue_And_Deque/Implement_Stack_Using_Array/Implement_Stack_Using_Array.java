
public class Implement_Stack_Using_Array {
    
    public static void main(String[] args) {
        
        MyCustomStack stack = new MyCustomStack(5);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        stack.display();

        stack.pop();
        
        stack.display();
    }
    
}

class MyCustomStack {

    private int capacity = 0;
    private int top = -1;
    private int[] stack = null;

    public MyCustomStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }

    public void push(int val) {
        if(top + 1 == capacity) {
            throw new RuntimeException("Stack is full");
        }
        top++;
        stack[top] = val;
    }

    public int pop() {
        if(top == -1) {
            throw new RuntimeException("Stack is empty");
        }
        int val = stack[top];
        top--;
        return val;
    }

    public void display() {
        for(int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}