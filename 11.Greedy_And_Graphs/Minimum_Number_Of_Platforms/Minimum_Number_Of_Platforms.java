package practice.dsa.sheet.part1;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Number_Of_Platforms {
	
	public static void main(String[] args) {
		
		int[] arrival = {900, 945, 955, 1100, 1500, 1800};
		int[] departure = {920, 1200, 1130, 1150, 1900, 2000};
		
		int minPlatforms = minNumOfPlatforms_best(arrival, departure);
		
		System.out.println(minPlatforms);
	}
	
	/*
	 * T = O(m+n) + O((m+n)*log(m+n))
	 *   = O((m+n)*log(m+n))
	 *   
	 * S = O(m+n)
	 * 
	 */
	public static int minNumOfPlatforms_better(int[] arrival, int[] departure) {
		
		int m = arrival.length;
		int n = departure.length;
		
		int[][] times = new int[m+n][2];
		
		for(int i = 0; i <= m-1; i++) {
			times[i][0] = arrival[i];
			times[i][1] = 1; // 1 for arrival
		}
		
		for(int i = 0; i <= n-1; i++) {
			times[n+i][0] = departure[i];
			times[n+i][1] = 0; // 0 for departure
		}
		
		Arrays.sort(times, Comparator.comparing((int[] t) -> t[0]));
		
		int trainsAtEveryTime = 0;
		int max = 0;
		
		for(int i = 0; i <= m+n-1; i++) {
			if(times[i][1] == 1) {
				trainsAtEveryTime++;
			} else {
				trainsAtEveryTime--;
			}
			
			if(trainsAtEveryTime > max) {
				max = trainsAtEveryTime;
			}
		}
		
		return max;
	}
	
	/*
	 * T = O(m*log m) + O(n*log n) + O(m+n)
	 * S = O(1)
	 */
	public static int minNumOfPlatforms_best(int[] arrival, int[] departure) {
		
		int m = arrival.length;
		int n = departure.length;
		
		Arrays.sort(arrival);
		Arrays.sort(departure);
		
		int i = 0;
		int j = 0;
		
		int trainsAtEveryTime = 0;
		int max = 0;
		
		while(i < m && j < n) {
			if(arrival[i] <= departure[j]) {
				trainsAtEveryTime++;
				i++;
			} else {
				trainsAtEveryTime--;
				j++;
			}
			
			if(trainsAtEveryTime > max) {
				max = trainsAtEveryTime;
			}
		}
		
		// No need to iterate j to the end
		
		return max;
	}
}


