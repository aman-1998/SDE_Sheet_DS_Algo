package practice.dsa.sheet.multithreading;

import java.util.concurrent.Semaphore;

public class Print_ABC_Using_Three_Threads_Using_Semaphore {
	
	public static void main(String[] args) {
		
		LetterPrinter letterPrinter = new LetterPrinter();
		
		Thread threadA = new Thread(() -> {
			try {
				letterPrinter.printA();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "threadA");
		
		
		Thread threadB = new Thread(() -> {
			try {
				letterPrinter.printB();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "threadB");
		
		
		Thread threadC = new Thread(() -> {
			try {
				letterPrinter.printC();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "threadC");
		
		threadA.start();
		threadB.start();
		threadC.start();
	}
}

class LetterPrinter {
	
	private Semaphore permitsForA = new Semaphore(1);
	private Semaphore permitsForB = new Semaphore(0);
	private Semaphore permitsForC = new Semaphore(0);
	
	public void printA() throws InterruptedException {
		
		while(true) {
			permitsForA.acquire();
			System.out.println(Thread.currentThread().getName() + "- A");
			permitsForB.release();
		}
	}
	
	public void printB() throws InterruptedException {
		
		while(true) {
			permitsForB.acquire();
			System.out.println(Thread.currentThread().getName() + "- B");
			permitsForC.release();
		}
	}
	
	public void printC() throws InterruptedException {
		
		while(true) {
			permitsForC.acquire();
			System.out.println(Thread.currentThread().getName() + "- C");
			permitsForA.release();
		}
	}
}
