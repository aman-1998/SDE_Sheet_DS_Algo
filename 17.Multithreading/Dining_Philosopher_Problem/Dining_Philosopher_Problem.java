package practice.dsa.sheet.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dining_Philosopher_Problem {
	
	public static void main(String[] args) {
		
		Lock fork1 = new ReentrantLock();
		Lock fork2 = new ReentrantLock();
		Lock fork3 = new ReentrantLock();
		Lock fork4 = new ReentrantLock();
		Lock fork5 = new ReentrantLock();
		
		Thread philosopher1 = new Thread(() -> {
			System.out.println("Philosopher1 is thinking");
			fork1.lock();
				System.out.println("Philosopher1 picked up the left fork");
				fork2.lock();
					System.out.println("Philosopher1 picked up the right fork");
					System.out.println("------------Philosopher1 is eating------------");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				fork2.unlock();
				System.out.println("Philosopher1 put down the right fork");
			fork1.unlock();
			System.out.println("Philosopher1 put down the left fork");
		});
		
		Thread philosopher2 = new Thread(() -> {
			System.out.println("Philosopher2 is thinking");
			fork2.lock();
				System.out.println("Philosopher2 picked up the left fork");
				fork3.lock();
					System.out.println("Philosopher2 picked up the right fork");
					System.out.println("------------Philosopher2 is eating------------");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				fork3.unlock();
				System.out.println("Philosopher2 put down the right fork");
			fork2.unlock();
			System.out.println("Philosopher2 put down the left fork");
		});
		
		Thread philosopher3 = new Thread(() -> {
			System.out.println("Philosopher3 is thinking");
			fork3.lock();
				System.out.println("Philosopher3 picked up the left fork");
				fork4.lock();
					System.out.println("Philosopher3 picked up the right fork");
					System.out.println("------------Philosopher3 is eating------------");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				fork4.unlock();
				System.out.println("Philosopher3 put down the right fork");
			fork3.unlock();
			System.out.println("Philosopher3 put down the left fork");
		});
		
		Thread philosopher4 = new Thread(() -> {
			System.out.println("Philosopher4 is thinking");
			fork4.lock();
				System.out.println("Philosopher4 picked up the left fork");
				fork5.lock();
					System.out.println("Philosopher4 picked up the right fork");
					System.out.println("------------Philosopher4 is eating------------");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				fork5.unlock();
				System.out.println("Philosopher4 put down the right fork");
			fork4.unlock();
			System.out.println("Philosopher4 put down the left fork");
		});
		
		Thread philosopher5 = new Thread(() -> {
			System.out.println("Philosopher5 is thinking");
			fork5.lock();
				System.out.println("Philosopher5 picked up the left fork");
				fork1.lock();
					System.out.println("Philosopher5 picked up the right fork");
					System.out.println("------------Philosopher5 is eating------------");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				fork1.unlock();
				System.out.println("Philosopher5 put down the right fork");
			fork5.unlock();
			System.out.println("Philosopher5 put down the left fork");
		});
		
		philosopher1.start();
		philosopher2.start();
		philosopher3.start();
		philosopher4.start();
		philosopher5.start();
	}
	
}

