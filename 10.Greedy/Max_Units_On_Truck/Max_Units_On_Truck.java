package practice.dsa.sheet.part8;

import java.util.Arrays;
import java.util.Comparator;

public class Max_Units_On_Truck {
	
	public static void main(String[] args) {
		
		int[][] boxTypes = {{5,10}, {2,5}, {4,7}, {3,9}};
		
		int truckSize = 10;
		
		int maxUnits = maximumUnits(boxTypes, truckSize);
		
		System.out.println(maxUnits);
	}
	
	/*
	 * Fractional Knapsack
	 * 
	 * T = O(n*log n) ; n = no. of box types
	 * S = O(1)
	 */
	public static int maximumUnits(int[][] boxTypes, int truckSize) {
        
		int n = boxTypes.length;
		
		Arrays.sort(boxTypes, Comparator.comparing((int[] boxType) -> boxType[1]).reversed());
		
		int maxUnitsOnTruck = 0;
		int currNoOfBoxes = 0;
		
		int i = 0;
		while(truckSize - currNoOfBoxes > 0 && i < n) {
			
			int noOfBoxes = Math.min(truckSize - currNoOfBoxes, boxTypes[i][0]);
			
			maxUnitsOnTruck = maxUnitsOnTruck + noOfBoxes*boxTypes[i][1];
			
			currNoOfBoxes = currNoOfBoxes + noOfBoxes;
			
			i++;
		}
		
		return maxUnitsOnTruck;
    }
}
