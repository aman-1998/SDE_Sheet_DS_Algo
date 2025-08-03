package algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Max_Num_Of_Meetings_That_Can_Be_Attended {
	
	public static void main(String[] args) {
		
		//int[][] events = {{1,2}, {2,3}, {3,4}, {1,2}};
		
		int[][] intervals = {{3,5}, {1,2}, {2,4}, {4,5}, {5,6}};
		
		int maxNoOfEvents = max_num_of_meetings_attended(intervals);
		
		System.out.println(maxNoOfEvents);
	}
	
	/*
	 * T = O(n*log n)
	 * S = O(1)
	 */
	private static int max_num_of_meetings_attended(int[][] intervals) {
		
		int n = intervals.length;
		//Arrays.sort(intervals, (int[] event1, int[] event2) -> event1[1] > event2[1] ? 1 : -1);
		Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[1]));
		int max = Integer.MIN_VALUE;
		int count = 1;
		
		int[] prev = intervals[0];
		for(int i = 1; i <= n-1; i++) {
			int[] curr = intervals[i];
			if(curr[0] >= prev[1]) {
				count++;
				prev = curr;
			}
		}
		
		return count; // no. of no overlapping intervals
	}
}
