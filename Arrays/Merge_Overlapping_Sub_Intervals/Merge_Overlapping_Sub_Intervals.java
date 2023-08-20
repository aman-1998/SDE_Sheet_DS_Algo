package algorithms;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given an array of intervals, merge all the overlapping intervals and return an 
 * array of non-overlapping intervals.
 */

public class Merge_Overlapping_Sub_Intervals {
	
	public static void main(String[] args) {
		
		int[][] arr = {{1, 3},
					   {2, 6},
					   {2, 4},
					   {8, 9},
					   {8, 10},
					   {9, 11},
					   {15, 18},
					   {16, 17}};
		
		arr = mergeOverLappingSubIntervals(arr);
		
		// No overlapping sub-intervals
		for(int[] i : arr) {
			System.out.println(i[0] +", "+ i[1]);
		}
	}
	
	/*
	 * T = O(n), S = O(n)
	 */
	public static int[][] mergeOverLappingSubIntervals(int[][] arr) {
		
		//Arrays.sort(arr, (int[] i1, int[] i2) -> i1[0] < i2[0] ? -1 : 1);
		Arrays.sort(arr, Comparator.comparing((int[] interval) -> interval[0])); // Better approach to sort than above line

		int  n = arr.length; // no. of rows
		int[][] nonOverLappingSubIntervals = new int[n][2]; // In worst case it's length can be n i.e., when every interval is non-overlapping
		
		// Consider first element as my first non-overlapping interval
		int start = arr[0][0];
		int end = arr[0][1];
		
		int count = 0;
		
		for(int i=0; i < n; i++) {
			//Check if starting time of current interval falls in the range of current non-overlapping interval
			if(arr[i][0] >= start && arr[i][0] <= end) {
				// update the length of interval
				if(arr[i][1] > end) {
					end = arr[i][1];
				}
			} else {
				// save the current non-overlapping interval
				nonOverLappingSubIntervals[count][0] = start;
				nonOverLappingSubIntervals[count][1] = end;
				count++;
				
				// Consider new interval as non-overlapping interval
				start = arr[i][0];
				end = arr[i][1];
			}
		}
		
		// Save the last found non-overlapping interval
		nonOverLappingSubIntervals[count][0] = start;
		nonOverLappingSubIntervals[count][1] = end;
		count++;
		
		nonOverLappingSubIntervals = trim(nonOverLappingSubIntervals, count);
		
		return nonOverLappingSubIntervals;
	}
	
	public static int[][] trim(int[][] arr, int noOfElements) {
		int[][] trimmedArray = new int[noOfElements][2];
		int count = 0;
		while(count != noOfElements) {
			//System.out.println(arr[count][0] +", "+ arr[count][1]);
			trimmedArray[count][0] = arr[count][0];
			trimmedArray[count][1] = arr[count][1];
			count++;
		}
		return trimmedArray;
	}
	
}
