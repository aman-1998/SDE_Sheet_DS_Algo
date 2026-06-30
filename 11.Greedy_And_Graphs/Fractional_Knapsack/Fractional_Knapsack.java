package practice.dsa.sheet.part8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Fractional_Knapsack {
	
	public static void main(String[] args) {
		
		int[] profit = {2, 28, 25, 18, 9};
		
		int[] weight = {1, 4, 5, 3, 3};
		
		double maxProfit = maxProfit_2nd(profit, weight, 14);
		
		System.out.println(maxProfit);
	}
	
	/*
	 * Using maxHeap
	 * 
	 * T = O(n*log n)
	 * S = O(n)
	 */
	public static double maxProfit_1st(int[] profit, int[] weight, int capacity) {
		
		PriorityQueue<ObjInfo> maxHeap  = new PriorityQueue<>(Comparator.comparing((ObjInfo info) -> info.profitPerWeight).reversed());
		
		int n = profit.length;
		
		for(int i = 0; i <= n-1; i++) {
			maxHeap.add(new ObjInfo(profit[i], weight[i], (double)profit[i]/weight[i]));
		}
		
		double maxProfit = 0;
		int currWeight = 0;
		
		while(!maxHeap.isEmpty() && currWeight != capacity) {
			
			ObjInfo info = maxHeap.poll();
			
			if(currWeight + info.weight > capacity) {
				maxProfit = maxProfit + ((double)info.profit / info.weight) * (capacity - currWeight);
				currWeight = capacity;
			} else {
				maxProfit = maxProfit + info.profit;
				currWeight = currWeight + info.weight;
			}
		}
		
		return maxProfit;
	}
	
	/*
	 * Using Sorting
	 * 
	 * T = o(n*log n)
	 * S = O(n)
	 */
	public static double maxProfit_2nd(int[] profit, int[] weight, int capacity) {
		
		int n = profit.length;
		
		List<ObjInfo> objList = new ArrayList<>();
		
		for(int i = 0; i <= n-1; i++) {
			objList.add(new ObjInfo(profit[i], weight[i], (double)profit[i]/weight[i]));
		}
		
		Collections.sort(objList, Comparator.comparing((ObjInfo info) -> info.profitPerWeight).reversed());
		
		double maxProfit = 0;
		int currWeight = 0;
		
		int i = 0;
		while(currWeight != capacity) {
			if(currWeight + objList.get(i).weight > capacity) {
				maxProfit = maxProfit + ((double)objList.get(i).profit / objList.get(i).weight) * (capacity - currWeight);
				currWeight = capacity;
			} else {
				maxProfit = maxProfit + objList.get(i).profit;
				currWeight = currWeight + objList.get(i).weight;
			}
			
			i++;
		}
		
		return maxProfit;
	}
}

class ObjInfo {
	
	public int profit;
	public int weight;
	public double profitPerWeight;
	
	public  ObjInfo(int profit, int weight, double profitPerWeight) {
		this.profit = profit;
		this.weight = weight;
		this.profitPerWeight = profitPerWeight;
	}

	@Override
	public String toString() {
		return "ObjInfo [profit=" + profit + ", weight=" + weight + ", profitPerWeight=" + profitPerWeight + "]";
	}
	
}
