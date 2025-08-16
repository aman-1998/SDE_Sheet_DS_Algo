package multithreading.practice.questions;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer_Consumer_Part1 {
	
	public static void main(String[] args) {
		 
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
		
		Thread producerThread = new Thread(new Producer(queue));
		Thread consumerThread = new Thread(new Consumer(queue));
		
		producerThread.start();
		consumerThread.start();
		
	}
}

class Producer implements Runnable {
	
	private ArrayBlockingQueue<Integer> queue;
	
	public Producer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			int value = 1;
			while(true) {
				System.out.println("Added " + value + " to the queue");
				queue.put(value);
				value++;
				Thread.sleep(1000);
			}
		} catch(Exception ex) {
			Thread.currentThread().interrupt();
		}
	}
}

class Consumer implements Runnable {
	
	private ArrayBlockingQueue<Integer> queue;
	
	public Consumer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				int val = queue.take();
				System.out.println(val + " is taken out");
				Thread.sleep(3000);
			}
		} catch(Exception ex) {
			Thread.currentThread().interrupt();
		}
	}
}
