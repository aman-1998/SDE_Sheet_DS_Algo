package practice.dsa.sheet.multithreading;

import java.util.concurrent.Semaphore;

public class Building_Hydrogen_H2O_2nd_Aproach {
	
	public static void main(String[] args) {
		
		HHOPrinter hhoPrinter = new HHOPrinter();
		
		Thread hydrogenThread = new Thread(() -> {
			try {
				hhoPrinter.printHydrogen();
			} catch (InterruptedException e) {
				Thread.currentThread().getName();
			}
		});
		
		Thread oxygenThread = new Thread(() -> {
			try {
				hhoPrinter.printOxygen();
			} catch (InterruptedException e) {
				Thread.currentThread().getName();
			}
		});
		
		hydrogenThread.start();
		oxygenThread.start();
	}
}

class HHOPrinter {
	
	private Semaphore hydrogenSemaphore = new Semaphore(2);
	private Semaphore oxygenSemaphore = new Semaphore(0);
	
	public void printHydrogen() throws InterruptedException {
		while(true) {
			hydrogenSemaphore.acquire();
			System.out.println("H");
			oxygenSemaphore.release();
		}
	}
	
	public void printOxygen() throws InterruptedException {
		while(true) {
			//oxygenSemaphore.acquire();
			//oxygenSemaphore.acquire();
			oxygenSemaphore.acquire(2);
			System.out.println("O");
			hydrogenSemaphore.release(2);
		}
	}
}
