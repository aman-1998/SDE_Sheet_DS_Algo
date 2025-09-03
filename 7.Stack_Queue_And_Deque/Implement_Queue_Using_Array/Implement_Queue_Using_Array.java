package practice.dsa.sheet.part4;

public class Implement_Queue_Using_Array {
	
	public static void main(String[] args) {
		
		MyCustomQueue queue = new MyCustomQueue(7);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		queue.display();
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		queue.display();
		
		queue.add(6);
		queue.add(7);
		queue.add(8);
		queue.add(9);
		
		queue.display();
		
		try {
			queue.add(10);
		} catch(Exception  ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		queue.display();
		
		queue.add(10);
		queue.add(11);
		
		queue.display();
		
		queue.add(12);
		
		queue.display();
		
		try {
			queue.add(13);
		} catch(Exception  ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		queue.display();
		
		try {
			System.out.println(queue.remove());
		} catch(Exception  ex) {
			System.out.println(ex.getMessage());
		}
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		queue.display();
	}
	
}

class MyCustomQueue {
	
	private int capacity;
	private int[] arr;
	private int start = -1;
	private int end = -1;
	private int count = 0;
	
	public MyCustomQueue(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
	}
	
	public void add(int data) {
		
		if(count == capacity) {
			throw new RuntimeException("Queue is full");
		}
		end++;
		end = end % capacity;
		arr[end] = data;
		count++;
		if(start == -1) {
			start = 0;
		}
	}
	
	public int remove() {
		
		if(count == 0) {
			throw new RuntimeException("Queue is empty");
		}
		
		int val = arr[start];
		start++;
		start = start % capacity;
		count--;
		
		if(count == 0) {
			start = -1;
			end = -1;
		}
		
		return val;
	}
	
	public void display() {
		
		if(start == -1 && end == -1) {
			System.out.println("Queue is empty");
			return;
		}
		
		int p = start;
		int q = end;
		
		while(p != q) {
			p = p % capacity;
			System.out.print(arr[p] + " ");
			p++;
		}
		System.out.print(arr[p % capacity] + " ");
		
		System.out.println(" | start : " + start + ", end = " + end + ", count = " + count);
	}
}
