package practice.dsa.sheet.multithreading;

public class Print_ABC_Using_Three_Threads_Using_turn_variable {
	
	public static void main(String[] args) {
		
		AlphabetPrinter alphabetPrinter = new AlphabetPrinter();
		
		Thread threadA = new Thread(() -> {
			try {
				alphabetPrinter.printA();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "threadA");
		
		
		Thread threadB = new Thread(() -> {
			try {
				alphabetPrinter.printB();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "threadB");
		
		
		Thread threadC = new Thread(() -> {
			try {
				alphabetPrinter.printC();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "threadC");
		
		threadA.start();
		threadB.start();
		threadC.start();
	}
}

class AlphabetPrinter {
	
	private String turn = "A";
	
	public synchronized void printA() throws InterruptedException {
		
		while(true) {
			while(!turn.equals("A")) {
				wait();
			}
			
			System.out.println(Thread.currentThread().getName() + "- A");
			turn = "B";
			notifyAll();
		}
	}
	
	public synchronized void printB() throws InterruptedException {
		
		while(true) {
			while(!turn.equals("B")) {
				wait();
			}
			
			System.out.println(Thread.currentThread().getName() + "- B");
			turn = "C";
			notifyAll();
		}
	}
	
	public synchronized void printC() throws InterruptedException {
		
		while(true) {
			while(!turn.equals("C")) {
				wait();
			}
			
			System.out.println(Thread.currentThread().getName() + "- C");
			turn = "A";
			notifyAll();
		}
	}
}
