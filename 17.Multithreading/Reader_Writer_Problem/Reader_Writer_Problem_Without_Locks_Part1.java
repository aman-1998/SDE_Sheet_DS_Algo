package multithreading.practice.questions;

public class Reader_Writer_Problem_Without_Locks_Part1 {
	
	public static void main(String[] args) {
		
		SharedResource sharedResource = new SharedResource();
		
		Thread writer = new Thread(() -> {
			for(int i = 0; i <= 3; i++) {
				sharedResource.writeData("X"+i, "Y"+i);
			}
		});
		
		Runnable readRunnable = () -> {
			for(int i = 0; i <= 5; i++) {
				String[] data = sharedResource.readData();
				System.out.println("key1 = " + data[0] + ", key2 = " + data[1]);
			}
		};
		
		Thread reader1 = new Thread(readRunnable);
		Thread reader2 = new Thread(readRunnable);
		Thread reader3 = new Thread(readRunnable);
		
		writer.start();
		reader1.start();
		reader2.start();
		reader3.start();
		
		/*
		 * If a thread is reading and we allow write in between then: (Read-Write conflict)
		 * 1. Thread1 read the value of key1=2 and then Thread2 changes the value of key1 to 5. Now, Thread1 will
		 *    do some operations based on the earlier read value. But in reality the value is changed. This is an 
		 *    inconsistent behavior. This is called dirty read problem.
		 *    
		 * If a thread is writing and we allow read in between then: (Write-Read conflict)
		 * 1. Let's say initial value of key1 = "A" and key2 = "B". Thread1 is writing the value of 
		 *    key1 to "X1" and key2 to "X2". In between thread2 trying to read the value of key1 and key2.
		 *    It is possible that thread1 reads key1 = "X1" and key2 = "B". There comes inconsistency again because
		 *    write operation is not yet complete and in between someone started reading data.
		 *    
		 * So, we have to solve it using locks. We have two types of locks: ReentrantLock and ReentrantReadWriteLock.
		 * 
		 * In ReentrantLock, if we take lock while writing or reading, then other threads can't read or write using 
		 * the same lock. At a time only one thread will be either reading or writing.
		 * 
		 * In ReentrantReadWriteLock, if we take write-lock while writing, then other threads can't read or write using 
		 * the same lock. But if read-lock is taken while reading then multiple threads can take read lock and read the
		 * data simultaneously. But write-lock can't be taken until read-lock is released.
		 * 
		 * For Write-Read conflict, both ReentrantLock and ReentrantReadWriteLock are equivalent. But for
		 * Read-Write conflict, ReentrantReadWriteLock is more useful and efficient as it allows concurrent
		 * reads by multiple threads.
		 * 
		 */
	}
}

class SharedResource {
	
	private String key1 = "A";
	private String key2 = "B";
	
	public String[] readData() {
		
		String readKey1="", readKey2="";
		System.out.println("Reading the value of key1 and key2...");
		try {
			Thread.sleep(500);
			readKey1 = key1; // read key1
			readKey2 = key2; // read key2
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return new String[] {readKey1, readKey2};
	}
	
	public void writeData(String newKey1, String newKey2) {
		
		System.out.println("Writing the value of key1 and key2...");
	    try {
			Thread.sleep(2000);
			this.key1 = newKey1;
		    this.key2 = newKey2;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
