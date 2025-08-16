package practice.dsa.sheet.multithreading;

public class Zero_Even_Odd_Problem_Using_turn_variable {
	
	public static void main(String[] args) {
		
		ZeroOddEvenPrinter zeroEvenOddPrinter = new ZeroOddEvenPrinter(10);
		
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

class ZeroOddEvenPrinter {
	
	private int limit;
	int current = 0;
	private String turn = "zero";
	
	public ZeroOddEvenPrinter(int limit) {
		this.limit = limit;
	}
	
	public synchronized void printZero() throws InterruptedException {
		while(current <= limit) {
			while(!turn.equalsIgnoreCase("zero")) {
				wait();
			}
			
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- 0");
				current++;
				if(current%2 != 0) {
					turn = "odd";
				} else {
					turn = "even";
				}
				
				notifyAll();
			}
		}
		
		if(current > limit) {
			turn = "even";
			notifyAll();
			turn = "odd";
			notifyAll();
		}
	}
	
	public synchronized void printOdd() throws InterruptedException {
		while(current <= limit) {
			while(!turn.equalsIgnoreCase("odd")) {
				wait();
			}
			
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- " + current);
			}
			turn = "zero";
			notifyAll();
		}
		
		if(current > limit) {
			turn = "zero";
			notifyAll();
			turn = "even";
			notifyAll();
		}
	}
	
	public synchronized void printEven() throws InterruptedException {
		while(current <= limit) {
			while(!turn.equalsIgnoreCase("even")) {
				wait();
			}
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- " + current);
			}
			turn = "zero";
			notifyAll();
		}
		
		if(current > limit) {
			turn = "zero";
			notifyAll();
			turn = "odd";
			notifyAll();
		}
	}
}