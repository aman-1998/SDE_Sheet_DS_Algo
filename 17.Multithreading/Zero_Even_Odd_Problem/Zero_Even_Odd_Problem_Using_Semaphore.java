package practice.dsa.sheet.multithreading;

import java.util.concurrent.Semaphore;

public class Zero_Even_Odd_Problem_Using_Semaphore {
	
	public static void main(String[] args) {
		
		ZeroEvenOddPrinter zeroEvenOddPrinter = new ZeroEvenOddPrinter(10);
		
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

class ZeroEvenOddPrinter {
	
	private int limit;
	int current = 0;
	private Semaphore zeroPermits = new Semaphore(1);
	private Semaphore oddPermits = new Semaphore(0);
	private Semaphore evenPermits = new Semaphore(0);
	
	public ZeroEvenOddPrinter(int limit) {
		this.limit = limit;
	}
	
	public void printZero() throws InterruptedException {
		while(current <= limit) {
			zeroPermits.acquire();
			current++;
			
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- 0");
				if(current%2 != 0) {
					oddPermits.release();
				} else {
					evenPermits.release();
				}
			}
		}
		
		if(current > limit) {
			oddPermits.release();
			evenPermits.release();
		}
	}
	
	public void printOdd() throws InterruptedException {
		while(current <= limit) {
			oddPermits.acquire();
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- " + current);
			}
			zeroPermits.release();
		}
		
		if(current > limit) {
			zeroPermits.release();
			evenPermits.release();
		}
	}
	
	public void printEven() throws InterruptedException {
		while(current <= limit) {
			evenPermits.acquire();
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- " + current);
			}
			zeroPermits.release();
		}
		
		if(current > limit) {
			oddPermits.release();
			evenPermits.release();
		}
	}
}