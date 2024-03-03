package bitwise;

import java.util.Scanner;

public class Bitwise
{
	public static void main(String[] args) {
		/*
		 * 1. & -- Bitwise AND (0 => masking bit; 1 => unmasking bit)
		 * 2. | -- Bitwise OR (1 => masking bit; 0 => unmasking bit)
		 * 3. ~ -- Bitwise NOT (1's complement)
		 * 4. ^ -- Bitwise XOR (1 => toggling bit; 0 => unmasking bit)
		 * 5. << -- Bitwise left-shift (empty places are filled with zeroes)
		 * 6. >> -- Bitwise Logical right-Shift (empty places are filled with most significant bit)
		 * 7. >>> -- Bitwise Arithmetic right-shift (empty places are filled with zeroes)
		 */
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter any integer: ");
		int input = in.nextInt();
		Bitwise_N1 ob = new Bitwise_N1();
		System.out.print("n = "+ob.integerToBinaryPrint(input));
		
		//We want to clear nth bit from right side (use of &)
		System.out.print("\nEnter the position which you want to clear: ");
		int n = in.nextInt();
		int temp1 = -2 << (n-1);
		int temp2 = ((1 << 31) - 1) >> (32-n);
		int mask = temp1 | temp2;
		System.out.println("\nmask = "+ob.integerToBinaryPrint(mask));
		int modified_input = input & mask;
		System.out.println("Modified input = "+ob.integerToBinaryPrint(modified_input)+" = "+modified_input);
		
		//We want to know whether nth bit is set or clear (use of &)
		System.out.print("\nEnter the the position which you want to determine: ");
		n = in.nextInt();
		mask = 1 << (n-1);
		int bit = (input & mask) != 0 ? 1 : 0;
		System.out.println("Bit at "+n+" position = "+bit);
		
		//We want to set nth bit for n (use of |)
		System.out.print("\nEnter the position which you want to set: ");
		n = in.nextInt();
		mask = 1 << (n-1);
		modified_input = input | mask;
		System.out.println("Modified input = "+ob.integerToBinaryPrint(modified_input)+" = "+modified_input);
		
		//We want to toggle nth bit
		System.out.print("\nEnter the position which you want to toggle: ");
		n = in.nextInt();
		mask = 1 << (n-1);
		modified_input = input ^ mask;
		System.out.println("Modified input = "+ob.integerToBinaryPrint(modified_input)+" = "+modified_input);
	
		//Encryption Decryption
		System.out.print("\nEnter the information: ");
		int information = in.nextInt();
		System.out.print("\nEnter the mask: ");
		mask = in.nextInt();
		int encrypted_value = information ^ mask;
		System.out.println("Encrypted value = "+encrypted_value);
		int decrypted_value = encrypted_value ^ mask;
		System.out.println("Decrypted value = "+decrypted_value);
		
		//XOR of two same integer is 0
		temp1 = 141421;
		temp2 = 141421;
		int res = temp1 ^ temp2;
		System.out.println("XOR of two same integer = "+res);
		
		int a = 10;
		int b = 4;
		System.out.println("Difference = " + (a-b));
		System.out.println("Diffference = " + (a + ~b + 1));
		
		int x = 16;
		System.out.println("Quotient = " + (x/2));
		System.out.println("Quotient = " + (x >> 1));
		
		System.out.println("Product = " + (x*2));
		System.out.println("Product = " + (x << 1));
		
		System.out.println("Power = " + (int)Math.pow(2, x));
		System.out.println("Power = " + (1 << x));
		
		in.close();
	}
	
	public String integerToBinaryPrint(int input)
	{
		int mask, bit;
		String binary = "";
		for(int i = 31; i >= 0; i--)
		{
			mask = 1 << i;
			bit = (input & mask) == 0 ? 0 : 1;
			binary = binary + bit;
		}
		return binary;
	}
}