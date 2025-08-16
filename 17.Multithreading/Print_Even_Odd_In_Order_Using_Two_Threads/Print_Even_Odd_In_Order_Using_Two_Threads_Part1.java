package multithreading.practice.questions;

public class Print_Even_Odd_In_Order_Using_Two_Threads_Part1 {
	
	public static void main(String[] args) {
		
		Printer printer = new Printer();
		int limit = 10;
		
		Thread evenThread = new Thread(new EvenThread(printer, limit));
		Thread oddThread = new Thread(new OddThread(printer, limit));
		
		evenThread.start();
		oddThread.start();
	}
}

class Printer {
	
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

class EvenThread implements Runnable {

	private Printer printer;
	private int limit;
	
	public EvenThread(Printer printer, int limit) {
		this.printer = printer;
		this.limit = limit;
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i <= limit; i = i+2) {
			try {
				printer.printEven(i);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
}

class OddThread implements Runnable {
	
	private Printer printer;
	private int limit;
	
	public OddThread(Printer printer, int limit) {
		this.printer = printer;
		this.limit = limit;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i <= limit; i = i+2) {
			try {
				printer.printOdd(i);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
}
