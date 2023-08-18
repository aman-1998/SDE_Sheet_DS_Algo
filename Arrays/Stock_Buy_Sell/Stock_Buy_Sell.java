package practice;

public class Stock_Buy_Sell {
	
	public static int buyDay, sellDay;
	
	public static void main(String[] args) {
		
		int[] arr = {7, 1, 5, 3, 6, 4};
		//int [] arr = {7, 6, 4, 3, 1};
		//int [] arr = {7, 6};
		//int [] arr = {6, 7};
		//int [] arr = {6};
		//int maxProfit = maxProfit_BruteForce(arr);
		int maxProfit = maxProfit(arr);
		System.out.println("Max profit = " + maxProfit);
		System.out.println("Buy day = " + buyDay + " | Sell Day = " + sellDay);
	}
	
	/*
	 * Brute Force approach
	 * T = O(n^2)
	 */
	public static int maxProfit_BruteForce(int[] arr) {
		
		int n = arr.length;
		
		int maxProfit = Integer.MIN_VALUE; // -(infinity)
		
		for(int i = 0; i < n; i++) {
			int buyDayPrice = arr[i];
			for(int j = i; j < n; j++) {
				int sellDayPrice = arr[j];
				int profit = sellDayPrice - buyDayPrice;
				if(profit > maxProfit) {
					maxProfit = profit;
					sellDay = j;
					buyDay = i;
				}
			}
		}
		
		return maxProfit;
	}
	
	/*
	 * T = O(n)
	 */
	public static int maxProfit(int[] arr) {
		
		int n = arr.length;
		
		int maxProfit = Integer.MIN_VALUE;
		int minSoFar = arr[0];
		
		for(int i = 0; i < n; i++) {
			
			int sellDayPrice = arr[i];
			int buyDayPrice = minSoFar;
			int profit = sellDayPrice - buyDayPrice;
			
			if(profit > maxProfit) {
				maxProfit = profit; 
				sellDay = i;
			}
			
			if(arr[i] < minSoFar) {
				minSoFar = arr[i];
				buyDay = i;
			}
		}
		
		return maxProfit;
	}
}
