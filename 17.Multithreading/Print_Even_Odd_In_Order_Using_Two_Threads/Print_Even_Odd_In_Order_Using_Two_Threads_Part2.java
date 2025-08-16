package multithreading.practice.questions;

public class Print_Even_Odd_In_Order_Using_Two_Threads_Part2 {
	
	public static void main(String[] args) {
		
		Printer1 printer = new Printer1();
		int limit = 10;
		
		Thread evenThread = new Thread(() -> {
			for(int i = 0; i <= limit; i = i+2) {
				try {
					printer.printEven(i);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		
		Thread oddThread = new Thread(() -> {
			for(int i = 1; i <= limit; i = i+2) {
				try {
					printer.printOdd(i);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		
		evenThread.start();
		oddThread.start();
	}
}

class Printer1 {
	
	private boolean oddTurn = false;
	
	public synchronized void printOdd(int i) throws InterruptedException {
		
		while(!oddTurn) {
			wait();
		}
		
		System.out.println(Thread.currentThread().getName() + "- " + i);
		oddTurn = false;
		notify();
	}
	
	public synchronized void printEven(int i) throws InterruptedException {
		
		while(oddTurn) {
			wait();
		}
		
		System.out.println(Thread.currentThread().getName() + "- " + i);
		oddTurn = true;
		notify();
	}
}