package practice.dsa.sheet.multithreading;

public class Traffic_Light_Controlled_Intersection_LeetCode {
	
	public static void main(String[] args) {
		
	}
}

class TrafficLight {
	
	private int turn = 1; // 1 for Road A and 2 for Road B
	
	 public synchronized void carArrived(int carId, int roadId, int direction,
	            						 Runnable turnGreen, Runnable crossCar) {
		 
		 if(roadId != turn) {
			 turnGreen.run();
			 turn = 2;
		 }
		 
		 crossCar.run();
	  }
}
