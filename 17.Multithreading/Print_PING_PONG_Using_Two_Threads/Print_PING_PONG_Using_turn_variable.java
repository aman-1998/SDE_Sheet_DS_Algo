package practice.dsa.sheet.multithreading;

public class Print_PING_PONG_Using_turn_variable {
	
	public static void main(String[] args) {
		
		PingPongPrinter pingPongPrinter = new PingPongPrinter(5);
		
		Thread thread1 = new Thread(() -> {
			try {
				pingPongPrinter.printPing();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		
		Thread thread2 = new Thread(() -> {
			try {
				pingPongPrinter.printPong();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		
		thread1.start();
		thread2.start();
	}
}

class PingPongPrinter {
	
	private int limit;
	private int count = 0;
	private boolean pongTurn = false;
	
	public PingPongPrinter(int limit) {
		this.limit = limit;
	}
	
	public synchronized void printPing() throws InterruptedException {
		while(count < limit) {
			while(pongTurn) {
				wait();
			}
			
			if(count < limit) {
				System.out.println("PING ");
				count++;
				pongTurn = true;
				notifyAll();
			}
		}
	}
	
	public synchronized void printPong() throws InterruptedException {
		while(count < limit) {
			while(!pongTurn) {
				wait();
			}
			
			if(count <  limit) {
				System.out.println("PONG ");
				count++;
				pongTurn = false;
				notifyAll();
			}
		}
	}
}
