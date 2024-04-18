package algorithms;

import java.util.Scanner;

public class Encryption_Decryption_Using_XOR {
	
	public static void main(String[] args) {
		
		encryption_decryption_using_XOR();
	}
	
	private static void encryption_decryption_using_XOR() {
		
		Scanner in = new Scanner(System.in);
		
		//Encryption Decryption
		System.out.print("Enter the information: ");
		int information = in.nextInt();
		System.out.print("\nEnter the mask: ");
		int mask = in.nextInt();
		int encrypted_value = information ^ mask;
		System.out.println("Encrypted value = "+encrypted_value);
		int decrypted_value = encrypted_value ^ mask;
		System.out.println("Decrypted value = "+decrypted_value);
	}
}
