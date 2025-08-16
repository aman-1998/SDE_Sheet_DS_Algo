package practice.dsa.sheet.multithreading;

import java.util.concurrent.Semaphore;

public class Building_Hydrogen_H2O_1st_Aproach {
	
	public static void main(String[] args) {
		
		H2OPrinter h2oPrinter = new H2OPrinter();
		
		Thread hydrogenThread = new Thread(() -> {
			try {
				h2oPrinter.printHydrogen();
			} catch (InterruptedException e) {
				Thread.currentThread().getName();
			}
		});
		
		Thread oxygenThread = new Thread(() -> {
			try {
				h2oPrinter.printOxygen();
			} catch (InterruptedException e) {
				Thread.currentThread().getName();
			}
		});
		
		hydrogenThread.start();
		oxygenThread.start();
	}
}

class H2OPrinter {
	
	int contHydrogen = 0;
	private Semaphore hydrogenSemaphore = new Semaphore(2);
	private Semaphore oxygenSemaphore = new Semaphore(0);
	
	public void printHydrogen() throws InterruptedException {
		while(true) {
			hydrogenSemaphore.acquire();
			System.out.println("H");
			contHydrogen++;
			if(contHydrogen == 2) {
				oxygenSemaphore.release();
			}
		}
	}
	
	public void printOxygen() throws InterruptedException {
		while(true) {
			oxygenSemaphore.acquire();
			System.out.println("O");
			contHydrogen = 0;
			hydrogenSemaphore.release(2);
		}
	}
}
