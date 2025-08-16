package practice.dsa.sheet.multithreading;

public class Traffic_Light_Controlled_Intersection {
	
	public static void main(String[] args) {
		
		TraffLight trafficLight = new TraffLight();
		
		Runnable roadARunnable = () -> {
			try {
				trafficLight.turnLightGreenRoadA();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};
		
		Runnable roadBRunnable = () -> {
			try {
				trafficLight.turnLightGreenRoadB();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};
		
		Thread car4OnRoadB = new Thread(roadBRunnable);
		Thread car1OnRoadA = new Thread(roadARunnable);
		Thread car3OnRoadA = new Thread(roadARunnable);
		Thread car5OnRoadB = new Thread(roadBRunnable);
		Thread car6OnRoadB = new Thread(roadBRunnable);
		Thread car2OnRoadA = new Thread(roadARunnable);
		
		car4OnRoadB.start();
		car1OnRoadA.start();
		car3OnRoadA.start();
		car5OnRoadB.start();
		car6OnRoadB.start();
		car2OnRoadA.start();
	}
}

class TraffLight {
	
	private String turn = "A";
	
	public synchronized void turnLightGreenRoadA() throws InterruptedException {
		while(!turn.equalsIgnoreCase("A")) {
			wait();
		}
		
		System.out.println("Light turned green on Road A");
		System.out.println("Cars on Road A can travel from North to South and South to North");
		turn = "B";
		notifyAll();
	}
	
	public synchronized void turnLightGreenRoadB() throws InterruptedException {
		while(!turn.equalsIgnoreCase("B")) {
			wait();
		}
		
		System.out.println("Light turned green on Road B");
		System.out.println("Cars on Road B can travel from East to West and West to East");
		turn = "A";
		notifyAll();
	}
}
