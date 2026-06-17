package practice.dsa.sheet.part8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Optimal_Merge_Pattern {
	
	public static void main(String[] args) {
		
		char[] file = {'a', 'b', 'c'};
		int[] record = {10, 20, 30};
		
		int totalMovements = movementsAfterMerging(file, record);
		
		System.out.println(totalMovements);
	}
	
	/*
	 * T = O(n*log n)
	 * S = O(n)
	 */
	public static int movementsAfterMerging(char[] file, int[] records) {
		
		HuffmanNode2 root = createHuffmanTree(file, records);
		
		int totalMovements = movements(root, 0, 0);
		
		return totalMovements;
	}
	
	/*
	 * T = O(n*log n)
	 * S = O(n)
	 */
	public static HuffmanNode2 createHuffmanTree(char[] charArr, int[] freqArr) {
		
		int n = charArr.length;
		
		PriorityQueue<HuffmanNode2> minHeap = new PriorityQueue<>(Comparator.comparing(node -> node.records));
		
		for(int i = 0; i <= n-1; i++) {
			minHeap.add(new HuffmanNode2(charArr[i], freqArr[i]));
		}
		
		while(minHeap.size() > 1) {
			HuffmanNode2 node1 = minHeap.poll();
			HuffmanNode2 node2 = minHeap.poll();
			
			HuffmanNode2 node3 = new HuffmanNode2('#', node1.records + node2.records);
			node3.left = node1;
			node3.right = node2;
			
			minHeap.add(node3);
		}
		
		return minHeap.poll();
	}
	
	public static int movements(HuffmanNode2 root, int len, int sum) {
		
		if(root == null) {
			return 0;
		} else if(root.left == null && root.right == null) {
			return len * root.records;
		} 
		int sum1 = movements(root.left, len+1, sum);
		int sum2 = movements(root.right, len+1, sum);
		
		return sum1+sum2;
	}
}

class HuffmanNode2 {
	
	public char filename;
	public int records;
	public HuffmanNode2 left;
	public HuffmanNode2 right;
	
	public HuffmanNode2(char ch, int freq) {
		this.filename = ch;
		this.records = freq;
	}

	@Override
	public String toString() {
		return "HuffmanNode2[filename=" + filename + ", records=" + records + "]";
	}
}
