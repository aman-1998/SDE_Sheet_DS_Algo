package algorithms;

public class Clear_Nth_bit_Of_a_Number {
	
	public static void main(String[] args) {
        
        int num = -37;
        System.out.println("Binary representation of " + num + ": " + convertToBinary(num));
        int n = 4;

        int result = clearNthBitFromLeft(num, n);
        System.out.println("Number after clearing " + n + "th bit from left: " + result + " in binary: " + convertToBinary(result));
    }

    public static int clearNthBitFromLeft(int num, int n) {
        int mask = 1 << (32 - n);
        return num & ~mask;
    }

    public static String convertToBinary(int n) {
        StringBuilder sb = new StringBuilder();
		String bit;
		for(int i=0; i <= 31; i++) {
			bit = (n & (1 << i)) != 0 ? "1" : "0";
			sb = sb.append(bit);
		}
		
		return sb.reverse().toString();
    }
}
