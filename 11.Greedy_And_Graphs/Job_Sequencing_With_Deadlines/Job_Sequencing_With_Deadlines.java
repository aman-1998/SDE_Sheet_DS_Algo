package practice.dsa.sheet.part8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Job_Sequencing_With_Deadlines {
	
	public static void main(String[] args) {
		
		int[] profit = {200, 180, 190, 300, 120, 100};
		int[] deadline = {5, 3, 3, 2, 4, 2};
		
		int maxProfit = jobSequencing_2nd(profit, deadline);
		
		System.out.println(maxProfit);
	}
	
	/*
	 * T = O(n*log n) + O(n) + O(n*maxDeadline) = O(n*maxDeadline)
	 * S = O(n) + O(maxDeadline)
	 */
	public static int jobSequencing(int[] profit, int[] deadline) {
		
		int n = profit.length;
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparing((Pair pair) -> pair.profit).reversed());
		
		int maxDeadline = 0;
		for(int i = 0; i <= n-1; i++) { // T = O(n*log n)
			maxHeap.add(new Pair(profit[i], deadline[i]));
			
			if(deadline[i] > maxDeadline) {
				maxDeadline = deadline[i];
			}
		}
		
		int[] timeLine = new int[maxDeadline];
		Arrays.fill(timeLine, -1); // T = O(n)
		
		int maxProfit = 0;
		
		for(int i = 0; i <= n-1; i++) { // T = O(n*maxDeadline)
			Pair popped = maxHeap.poll();
			for(int j = popped.time-1; j >= 0; j--) {
				if(timeLine[j] == -1) {
					timeLine[j] = popped.profit;
					maxProfit += popped.profit;
					break;
				}
			}
		}
		
		return maxProfit;
	}
	
	/*
	 * T = O(3*n) + O(n*maxDeadline) = O(n*maxDeadline)
	 * S = O(2n) + O(maxDeadline)
	 */
	public static int jobSequencing_2nd(int[] profit, int[] deadline) {
		
		int n = profit.length;
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparing((Pair pair) -> pair.profit).reversed());
		
		List<Pair> list = new ArrayList<>();
		int maxDeadline = 0;
		for(int i = 0; i <= n-1; i++) { // T = O(n)
			list.add(new Pair(profit[i], deadline[i]));
			if(deadline[i] > maxDeadline) {
				maxDeadline = deadline[i];
			}
		}
		
		maxHeap.addAll(list); // T = O(n)
		
		int[] timeLine = new int[maxDeadline];
		Arrays.fill(timeLine, -1); // T = O(n)
		
		int maxProfit = 0;
		
		for(int i = 0; i <= n-1; i++) { // T = O(n*maxDeadline)
			Pair popped = maxHeap.poll();
			for(int j = popped.time-1; j >= 0; j--) {
				if(timeLine[j] == -1) {
					timeLine[j] = popped.profit;
					maxProfit += popped.profit;
					break;
				}
			}
		}
		
		return maxProfit;
	}  
}

class Pair {
	
	public int profit;
	public int time;
	
	public Pair(int profit, int time) {
		this.profit = profit;
		this.time = time;
	}
	
	public String toString() {
		return "Pair[profit="+profit+", time="+time+"]";
	}
}