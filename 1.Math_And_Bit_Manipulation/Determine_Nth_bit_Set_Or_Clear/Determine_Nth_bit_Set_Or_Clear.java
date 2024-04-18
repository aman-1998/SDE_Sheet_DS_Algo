package algorithms;

public class Determine_Nth_bit_Set_Or_Clear {
	
	public static void main(String[] args) {
		
		int input = 3234;
		System.out.print("input = ");
		printBits(input); // Just for seeing input
		
		int n = 6;
		determine_nth_bit_set_or_clear_from_right(input, n);
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
	private static void determine_nth_bit_set_or_clear_from_right(int input, int n) {
		
		int mask = 1 << (n-1);
		if((input & mask) == 0) {
			System.out.println(n + "th bit is " + 0);
		} else {
			System.out.println(n + "th bit is " + 1);
		}
	}
}
