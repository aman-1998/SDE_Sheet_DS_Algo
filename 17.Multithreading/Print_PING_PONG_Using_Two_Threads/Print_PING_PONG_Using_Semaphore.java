package practice.dsa.sheet.multithreading;

import java.util.concurrent.Semaphore;

public class Print_PING_PONG_Using_Semaphore {
	
	public static void main(String[] args) {
		
		PingPongPrinterUsingSemaphore pingPongPrinter = new PingPongPrinterUsingSemaphore(10);
		
		Thread thread1 = new Thread(() -> {
			try {
				pingPongPrinter.printPing();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "thread1");
		
		Thread thread2 = new Thread(() -> {
			try {
				pingPongPrinter.printPong();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "thread2");
		
		thread1.start();
		thread2.start();
	}
}

class PingPongPrinterUsingSemaphore {
	
	private int limit;
	private int count = 0;
	
	private Semaphore pingSemaphore = new Semaphore(1);
	private Semaphore pongSemaphore = new Semaphore(0);
	
	public PingPongPrinterUsingSemaphore(int limit) {
		this.limit = limit;
	}
	
	public void printPing() throws InterruptedException {
		while(count < limit) {
			pingSemaphore.acquire();
			if(count < limit) {
				System.out.println(Thread.currentThread().getName() + " - PING");
			}
			count++;
			pongSemaphore.release();
		}
	}
	
	public void printPong() throws InterruptedException {
		while(count < limit) {
			pongSemaphore.acquire();
			if(count < limit) {
				System.out.println(Thread.currentThread().getName() + " - PONG");
			}
			count++;
			pingSemaphore.release();
		}
	}
}
