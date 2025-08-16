package multithreading.practice.questions;

public class Print_1_To_N_In_Order_Using_Three_Threads {
	 
	public static void main(String[] args) {
		
		int limit = 20;
		NumberPrinter numberPrinter = new NumberPrinter(limit);
		
		Thread thread1 = new Thread(() -> {
			try {
				numberPrinter.print(0);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "thread1");
		
		Thread thread2 = new Thread(() -> {
			try {
				numberPrinter.print(1);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "thread2");
		
		Thread thread3 = new Thread(() -> {
			try {
				numberPrinter.print(2);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

/*
 * We will increase the sequence one by one and check which thread is eligible to
 * print it. Thread which is eligible to print that particular number will print
 * and other threads will go to waiting state.
 */
class NumberPrinter {
	
	private int limit;
	private int current = 0;
	
	public NumberPrinter(int limit) {
		this.limit = limit;
	}
	
	public synchronized void print(int remainder) throws InterruptedException {
		
		while(current <= limit) {
			while(current <= limit && current % 3 != remainder) {
				wait();
			}
			
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- " + current);
				current++;
				notifyAll();
			}
			
		}
	}
}

