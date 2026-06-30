package practice.dsa.sheet.part8;

public class Huffman_Decoding {
	
	public static void main(String[] args) {
		
		String encodedVal = "10001101001110";
		
		char[] charArr = {'a', 'b', 'c', 'd'};
		int[] freqArr = {2, 4, 1, 1};
		
		HuffmanNode root = Huffman_Encoding.createHuffmanTree(charArr, freqArr);
		
		String decodedVal = decodeValue(root, encodedVal);
		
		System.out.println(decodedVal);
	}
	
	/*
	 * T = O(n)
	 * S = O(1)
	 */
	public static String decodeValue(HuffmanNode root, String encodedVal) {
		
		int n = encodedVal.length();
		
		HuffmanNode curr = root;
		
		StringBuilder res = new StringBuilder();
		
		for(int i = 0; i <= n-1; i++) {
			if(encodedVal.charAt(i) == '0') {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
			
			if(curr.left == null && curr.right == null) {
				res.append(curr.ch);
				curr = root;
			}
		}
		
		return res.toString();
	}
}
