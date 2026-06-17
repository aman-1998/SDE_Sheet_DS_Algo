package practice.dsa.sheet.part8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman_Encoding {
	
	public static void main(String[] args) {
		//compression("");
		//compression("a");
		String encodedVal = compression("abbcabdb"); // T = O(n*log n)
		
		System.out.println(encodedVal);
	}
	
	public static String compression(String data) {
		
		int n = data.length();
		
		Map<Character, Integer> freqMap = new HashMap<>();
		
		for(int i = 0; i <= n-1; i++) {
			Integer count = freqMap.get(data.charAt(i));
			if(count == null) {
				freqMap.put(data.charAt(i), 1);
			} else {
				freqMap.put(data.charAt(i), count + 1);
			}
		}
		
		List<Character> charList = new ArrayList<>();
		List<Integer> freqList = new ArrayList<>();
		
		for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			charList.add(entry.getKey());
			freqList.add(entry.getValue());
		}
		
		char[] charArr = new char[charList.size()];
		int[] freqArr = new int[freqList.size()];
		
		for(int i = 0; i <= charList.size() -1; i++) {
			charArr[i] = charList.get(i);
			freqArr[i] = freqList.get(i);
		}
		
		HuffmanNode root = createHuffmanTree(charArr, freqArr);
		
		if(root == null) {
			encodedValue(root, "");
		} else if(root.left == null && root.right == null) {
			encodedValue(root, "0");
		} else {
			encodedValue(root, "");
		}
		
		System.out.println(charCodeMap);
		
		StringBuilder encodedVal = new StringBuilder();
		for(int i = 0; i <= n-1; i++) {
			encodedVal.append(charCodeMap.get(data.charAt(i)));
		}
		
		return encodedVal.toString();
	}
	
	/*
	 * T = O(n*log n)
	 * S = O(n)
	 */
	public static HuffmanNode createHuffmanTree(char[] charArr, int[] freqArr) {
		
		int n = charArr.length;
		
		PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>(Comparator.comparing(node -> node.freq));
		
		for(int i = 0; i <= n-1; i++) {
			minHeap.add(new HuffmanNode(charArr[i], freqArr[i]));
		}
		
		while(minHeap.size() > 1) {
			HuffmanNode node1 = minHeap.poll();
			HuffmanNode node2 = minHeap.poll();
			
			HuffmanNode node3 = new HuffmanNode('#', node1.freq + node2.freq);
			node3.left = node1;
			node3.right = node2;
			
			minHeap.add(node3);
		}
		
		return minHeap.poll();
	}
	
	private static Map<Character, String> charCodeMap = new HashMap<>();
	
	public static void encodedValue(HuffmanNode root, String code) {
		
		if(root == null) {
			return;
		} else if(root.left == null && root.right == null) {
			charCodeMap.put(root.ch, code);
		}
		
		encodedValue(root.left, code+0);
		encodedValue(root.right, code+1);
	}
}

class HuffmanNode {
	
	public char ch;
	public int freq;
	public HuffmanNode left;
	public HuffmanNode right;
	
	public HuffmanNode(char ch, int freq) {
		this.ch = ch;
		this.freq = freq;
	}

	@Override
	public String toString() {
		return "HuffmanNode[ch=" + ch + ", freq=" + freq + "]";
	}
}
