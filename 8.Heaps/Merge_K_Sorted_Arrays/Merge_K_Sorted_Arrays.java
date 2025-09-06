package practice.dsa.sheet.part5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Arrays {
	
	public static void main(String[] args) {
		
		int[][] mat = {{2, 8, 9, 11, 14},
					   {3, 7, 8, 12, 15},
					   {1, 5, 10, 11, 18},
					   {5, 8, 15, 17, 19}};
		
		ArrayList<Integer> mergedSortedArr = mergeKArrays(mat);
		
		mergedSortedArr.stream().forEach(t -> System.out.print(t + " | "));
	}
	
	/*
	 * T = O(k*n*log k) ; k = no. of rows, n = no. of columns
	 * S = O(k)
	 */
	public static ArrayList<Integer> mergeKArrays(int[][] mat) {
        
		int k = mat.length;
		
		PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparing(node -> node.val));
		
		for(int i = 0; i <= k-1; i++) { // T = O(k*log k)
			Node node = new Node(mat[i][0], 0, mat[i]);
			minHeap.add(node);
		}
		
		ArrayList<Integer> output = new ArrayList<>();
		while(!minHeap.isEmpty()) { // T = O((k*n-k)*2*log k) + O(k*log k)
			Node deleted = minHeap.poll();
			output.add(deleted.val);
			if(deleted.index < deleted.arr.length - 1) {
				Node toBeAdded = new Node(deleted.arr[deleted.index + 1], deleted.index + 1, deleted.arr);
				minHeap.add(toBeAdded);
			}
		}
		
		return output;
    }
}

class Node {
	
	public int val;
	public int index;
	public int[] arr;
	
	public Node(int val, int index, int[] arr) {
		this.val = val;
		this.index = index;
		this.arr = arr;
	}
}
