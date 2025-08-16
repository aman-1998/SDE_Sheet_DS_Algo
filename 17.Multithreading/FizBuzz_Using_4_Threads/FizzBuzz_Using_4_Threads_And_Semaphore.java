package practice.dsa.sheet.multithreading;

import java.util.concurrent.Semaphore;

/*
 * For any number x between 1 to n:
 * 
 * Thread1 prints Fizz (for multiple of 3 and not 5)
 * Thread2 prints Buzz (for multiple of 5 and not 3)
 * Thread3 prints FizzBuzz (for multiple of both 3 and 5)
 * Thread4 prints x (if x is not a multiple of 3 & 5)
 */
public class FizzBuzz_Using_4_Threads_And_Semaphore {
	
	public static void main(String[] args) {
		
		FizzBuzzPrinter fizzBuzzPrinter = new FizzBuzzPrinter(10);
		
		Thread thread1 = new Thread(() -> {
			try {
				fizzBuzzPrinter.printFizz();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		
		Thread thread2 = new Thread(() -> {
			try {
				fizzBuzzPrinter.printNumber();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		
		Thread thread3 = new Thread(() -> {
			try {
				fizzBuzzPrinter.printBuzz();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		
		Thread thread4 = new Thread(() -> {
			try {
				fizzBuzzPrinter.printFizzBuzz();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();;
			}
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
	
}

class FizzBuzzPrinter {
	
	private int limit;
	private int current = 1;
	private Semaphore fizzPermits = new Semaphore(0);
	private Semaphore buzzPermits = new Semaphore(0);
	private Semaphore fizzBuzzPermits = new Semaphore(0);
	private Semaphore numberPermits = new Semaphore(1);
	
	public FizzBuzzPrinter(int limit) {
		this.limit = limit;
	}
	
	public void printFizz() throws InterruptedException {
		while(current <= limit) {
			fizzPermits.acquire();
			
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- Fizz ");
				current++;
				if(current%3 == 0 && current%5 != 0) {
					fizzPermits.release();
				} else if(current%5 == 0 && current%3 != 0) {
					buzzPermits.release();
				} else if(current%3 == 0 && current%5 == 0) {
					fizzBuzzPermits.release();
				} else {
					numberPermits.release();
				}
			}
		}
		
		if(current > limit) {
			buzzPermits.release();
			fizzBuzzPermits.release();
			numberPermits.release();
		}
	}
	
	public void printBuzz() throws InterruptedException {
		while(current <= limit) {
			buzzPermits.acquire();
			
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- Buzz ");
				current++;
				if(current%3 == 0 && current%5 != 0) {
					fizzPermits.release();
				} else if(current%5 == 0 && current%3 != 0) {
					buzzPermits.release();
				} else if(current%3 == 0 && current%5 == 0) {
					fizzBuzzPermits.release();
				} else {
					numberPermits.release();
				}
			}
		}
		
		if(current > limit) {
			fizzPermits.release();
			fizzBuzzPermits.release();
			numberPermits.release();
		}
	}
	
	public void printFizzBuzz() throws InterruptedException {
		while(current <= limit) {
			fizzBuzzPermits.acquire();
			
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- FizzBuzz ");
				current++;
				if(current%3 == 0 && current%5 != 0) {
					fizzPermits.release();
				} else if(current%5 == 0 && current%3 != 0) {
					buzzPermits.release();
				} else if(current%3 == 0 && current%5 == 0) {
					fizzBuzzPermits.release();
				} else {
					numberPermits.release();
				}
			}
		}
		
		if(current > limit) {
			fizzPermits.release();
			buzzPermits.release();
			numberPermits.release();
		}
	}
	
	public void printNumber() throws InterruptedException {
		while(current <= limit) {
			numberPermits.acquire();
			
			if(current <= limit) {
				System.out.println(Thread.currentThread().getName() + "- "+current);
				current++;
				if(current%3 == 0 && current%5 != 0) {
					fizzPermits.release();
				} else if(current%5 == 0 && current%3 != 0) {
					buzzPermits.release();
				} else if(current%3 == 0 && current%5 == 0) {
					fizzBuzzPermits.release();
				} else {
					numberPermits.release();
				}
			}
		}
		
		if(current > limit) {
			fizzPermits.release();
			buzzPermits.release();
			fizzBuzzPermits.release();
		}
	}
}
