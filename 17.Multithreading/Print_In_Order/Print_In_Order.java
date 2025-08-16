package practice.dsa.sheet.multithreading;

public class Print_In_Order {
	
	public static void main(String[] args) {
		
		Foo foo = new Foo();
		
		Thread thread1 = new Thread(() -> {
			try {
				foo.printFirst();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();;
			}
		});
		
		Thread thread2 = new Thread(() -> {
			try {
				foo.printSecond();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();;
			}
		});
		
		Thread thread3 = new Thread(() -> {
			try {
				foo.printThird();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();;
			}
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

class Foo {
	
	private String turn = "first";
	
	public synchronized void printFirst() throws InterruptedException {
		while(!turn.equalsIgnoreCase("first")) {
			wait();
		}
		
		System.out.println("first");
		turn = "second";
		notifyAll();
	}
	
	public synchronized void printSecond() throws InterruptedException {
		while(!turn.equalsIgnoreCase("second")) {
			wait();
		}
		
		System.out.println("second");
		turn = "third";
		notifyAll();
	}

	public synchronized void printThird() throws InterruptedException {
		while(!turn.equalsIgnoreCase("third")) {
			wait();
		}
		
		System.out.println("third");
	}
}
