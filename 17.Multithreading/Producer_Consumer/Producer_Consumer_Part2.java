package multithreading.practice.questions;

import java.util.LinkedList;
import java.util.Queue;

public class Producer_Consumer_Part2 {
	
	public static void main(String[] args) {
		
		SharedBuffer sharedBuffer = new SharedBuffer(5);
		
		Thread producerThread = new Thread(() -> {
			try {
				int value = 1;
				while(true) {
					sharedBuffer.produce(value);
					value++;
					Thread.sleep(2000);
				}
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		});
		
		Thread consumerThread = new Thread(() -> {
			try {
				while(true) {
					int val = sharedBuffer.consume();
					Thread.sleep(3000);
				}
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		});
		
		producerThread.start();
		consumerThread.start();
	
	}
}

class SharedBuffer {
	
	private Queue<Integer> queue = new LinkedList<>();
	private int capacity = 0;
	
	public SharedBuffer(int capacity) {
		this.capacity = capacity;
	}
	
	public synchronized void produce(int value) throws InterruptedException {
		while(queue.size() == capacity) {
			System.out.println("Can't produce as queue is full. Going to waiting state");
			wait();
		}
		
		queue.add(value);
		System.out.println(value + " added in queue");
		notify(); // notifies the waiting consumer-thread
	}
	
	public synchronized int consume() throws InterruptedException {
		while(queue.isEmpty()) {
			System.out.println("Can't consume as queue is empty. Going to waiting state");
			wait();
		}
		
		int val = queue.poll();
		System.out.println(val + " is consumed");
		notify(); // notifies the waiting producer-thread
		return val;
	}
}

/*
 * We can do like this as well
 * 
class Producer implements Runnable {
	
	@Override
	public void run() {
		
	}
}

class Consumer implements Runnable {
	
	@Override
	public void run() {
		
	}
}
*/
