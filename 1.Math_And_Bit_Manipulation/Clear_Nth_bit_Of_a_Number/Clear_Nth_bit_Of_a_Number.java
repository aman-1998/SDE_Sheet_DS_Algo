package algorithms;

public class Clear_Nth_bit_Of_a_Number {
	
	public static void main(String[] args) {
		
		int input = 242445;
		System.out.print("input = " + input + " = ");
		printBits(input); // Just for seeing input
		
		int n = 30;
		int output = clear_nth_bit_from_left(input, n);
		System.out.print("Output = " + output + " = ");
		printBits(output); // Just for seeing output
	}
	
	private static void printBits(int input) {
		
		String binary = "";
		for(int i = 0; i <= 31; i++) {
			if((input & (1<<i)) == 0) {
				binary = "0" + binary;
			} else {
				binary = "1" + binary;
			}
		}
		System.out.println(binary);
	}

	/*
	 * T = O(1)
	 * S = O(1)
	 */
	private static int clear_nth_bit_from_left(int input, int n) {
		
		int temp1 = -2 << (32-n);
		int temp2 = ((1 << 31)-1) >> (n-1);
		int mask = temp1 | temp2;
		System.out.print("mask = ");
		printBits(mask); // Just for seeing mask
		
		int output = input & mask;
		
		return output;
	}
}
