package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Time {
	int start;
	int end;
	
	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Attend_All_Meetings {
	
	public static void main(String[] args) {
		int[][] intervals = {{30, 40}, {10, 20}, {15, 25}, {30, 50}};
		//int[][] intervals = {{10, 20}, {30, 40}, {20, 30}, {40, 50}};
		
		if(attendAllMeetings(intervals)) {
			System.out.println("I can attend all meetings");
		} else {
			System.out.println("I can not attend all meetings");
		}
	}
	
	//Space = O(1), Time = O(nlogn) <Better Solution>
		public static boolean attendAllMeetings(int[][] intervals) {
			
			// Sorting 2d matrix
			//Arrays.sort(intervals, (int[] interval1, int[] interval2) -> interval1[1] < interval2[1] ? -1 : 1);
			Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0])); // Better approach to sort than above line
				
			//Compare previous interval's endTime and current interval's startTime
			int prevEndTime = intervals[0][1];
			for(int i=1; i < intervals.length ; i++) {
				
				// if previous meeting is not over and new meeting starts then return false
				if(intervals[i][0] < prevEndTime) {
					return false;
				}
				prevEndTime = intervals[i][1]; // store endTime of current meeting so that we can use it in next iteration
			}
			return true;
		}
	
	//Space = O(n), Time = O(nlogn)
	public static boolean attendAllMeetings2(int[][] intervals) {
		
		List<Time> ll = new LinkedList<Time>();
		// Storing the intervals in LinkedList
		for(int[] interval : intervals) {
			if(interval[1] - interval[0] <= 0) {
				return false;
			}
			ll.add(new Time(interval[0], interval[1]));
		}
		
		ll = ll.stream().sorted(Comparator.comparing(time -> time.end))
				   .collect(Collectors.toList()); // Sorting based on endtime
		
		//Compare previous interval's endTime and current interval's startTime
		int prevEndTime = ll.get(0).end;
		for(int i=1; i < ll.size(); i++) {
			
			// if previous meeting is not over and new meeting starts then return false
			if(ll.get(i).start < prevEndTime) {
				return false;
			}
			prevEndTime = ll.get(i).end; // store endTime of current meeting so that we can use it in next iteration
		}
		return true;
	}
	
}
