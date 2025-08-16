package practice.dsa.sheet.multithreading;

import java.util.concurrent.Semaphore;

public class Zero_Even_Odd_Problem_Using_Semaphore_Cleaner {
	
	public static void main(String[] args) {
		
		ZEOPrinter zeroEvenOddPrinter = new ZEOPrinter(10);
		
		Thread threadZero = new Thread(() -> {
			try {
				zeroEvenOddPrinter.printZero();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "threadZero");
		
		
		Thread threadEven = new Thread(() -> {
			try {
				zeroEvenOddPrinter.printEven();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "threadEven");
		
		
		Thread threadOdd = new Thread(() -> {
			try {
				zeroEvenOddPrinter.printOdd();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "threadOdd");
		
		threadEven.start();
		threadOdd.start();
		threadZero.start();
	}
}

class ZEOPrinter {
	
	private int limit;
	private Semaphore zeroPermits = new Semaphore(1);
	private Semaphore oddPermits = new Semaphore(0);
	private Semaphore evenPermits = new Semaphore(0);
	
	public ZEOPrinter(int limit) {
		this.limit = limit;
	}
	
	public void printZero() throws InterruptedException {
		for(int i = 0; i <= limit; i++) {
			zeroPermits.acquire();
			System.out.println(Thread.currentThread().getName() + "- 0");
			if((i+1)%2 != 0) {
				oddPermits.release();
			} else {
				evenPermits.release();
			}
		}
	}
	
	public void printOdd() throws InterruptedException {
		for(int i = 1; i <= limit; i+=2) {
			oddPermits.acquire();
			System.out.println(Thread.currentThread().getName() + "- " + i);
			zeroPermits.release();
		}
	}
	
	public void printEven() throws InterruptedException {
		for(int i = 2; i <= limit; i+=2) {
			evenPermits.acquire();
			System.out.println(Thread.currentThread().getName() + "- " + i);
			zeroPermits.release();
		}
	}
}