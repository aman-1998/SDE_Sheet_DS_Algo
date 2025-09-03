package practice.dsa.sheet.part1;

public class Positive_Fraction_Addition_As_Array {
	
	public static void main(String[] args) {
		
		int[] frac1 = {5, 6};
		int[] frac2 = {9, 14};
		
		int[] output = addFraction(frac1, frac2);
		
		System.out.println(output[0] + ", " + output[1]);
	}
	
	public static int[] addFraction(int[] frac1, int[] frac2) {
		
		int lcm = frac1[1] * frac2[1] / gcd(frac1[1], frac2[1]);
		
		int tempNumerator = (lcm/frac1[1])*frac1[0] + (lcm/frac2[1])*frac2[0];
		
		int tempDenomenator = lcm;
		
		int x = gcd(tempNumerator, tempDenomenator);
		
		return new int[] {tempNumerator/x, tempDenomenator/x};
	}
	
	public static int gcd(int a, int b) {
		
		if(b == 0) {
			return a;
		}
		
		return gcd(b, a % b);
	}
}
