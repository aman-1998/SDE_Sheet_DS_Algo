package practice.dsa.sheet.part5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class K_Pairs_With_Smallest_Sums {
	
	public static void main(String[] args) {
		
		int[] arr1 = {1, 7, 11};
		int[] arr2 = {2, 4, 6};
		int k = 3;
		
		List<List<Integer>> output = kSmallestPairs_Best(arr1, arr2, k);
		
		output.stream().forEach(pair -> System.out.println(pair));
	}
	
	/*
	 * Brute Force approach : using one MaxHeap
	 * 
	 * T = O(k + m*n*log k)
	 * S = O(2k)
	 */
	public static List<List<Integer>> kSmallestPairs_BF(int[] arr1, int[] arr2, int k) {
        
		int m = arr1.length;
		int n = arr2.length;
		
		PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(Comparator.comparing((List<Integer> list) -> list.get(0)+list.get(1)).reversed());
		
		for(int i = 0; i <= m-1; i++) { // T = O(m*n*log k)
			for(int j = 0; j <= n-1; j++) {
				maxHeap.add(Arrays.asList(arr1[i], arr2[j]));
				if(maxHeap.size() > k) {
					maxHeap.poll();
				}
			}
		}
		
		List<List<Integer>> output = new ArrayList<>();
		for(List<Integer> list : maxHeap) { // O(k)
			output.add(list);
		}
		
		return output;
    }
	
	/*
	 * if min = min(m, k)
	 * 
	 * T = O(min*log min) + O(k*log min) = O(k*log min)
	 * 
	 * S = O(min)
	 */
	public static List<List<Integer>> kSmallestPairs_Best(int[] arr1, int[] arr2, int k) {
		
		int m = arr1.length;
		int n = arr2.length;
		
		PriorityQueue<IndexNode> minHeap = new PriorityQueue<>(Comparator.comparing(node -> arr1[node.arr1Index] + arr2[node.arr2Index]));
		
		int min = Integer.MAX_VALUE;
		if(k < m) {
			min = k;
		} else {
			min = m;
		}
		
		for(int i = 0; i <= min-1; i++) { // T = O(min*log min) 
			minHeap.add(new IndexNode(i, 0));
		}
		// heapSize = min(m, k) = min
		 
		
		List<List<Integer>> output = new ArrayList<>();
		while(!minHeap.isEmpty()) { // T = O(k*2*log min) 
			IndexNode deleted = minHeap.poll();
			output.add(Arrays.asList(arr1[deleted.arr1Index], arr2[deleted.arr2Index]));
			
			if(output.size() == k) {
				break;
			}
			
			if(deleted.arr2Index < n-1) {
				IndexNode toBeAdded = new IndexNode(deleted.arr1Index, deleted.arr2Index + 1);
				minHeap.add(toBeAdded);
			}
		}
		
		return output;
	}
	
}

class IndexNode {
	
	public int arr1Index;
	
	public int arr2Index;
	
	public IndexNode(int arr1Index, int arr2Index) {
		this.arr1Index = arr1Index;
		this.arr2Index = arr2Index;
	}

	@Override
	public String toString() {
		return "(" + arr1Index + ", " + arr2Index + ")";
	}
}
