package practice.dsa.sheet.part1;

public class Determine_If_N_Is_A_Power_Of_4 {
	
	public static void main(String[] args) {
		
		int n = 16;
		
		boolean check = isPowerOfFour(n);
		
		System.out.println(check);
	}
	
	/*
	 * If n is a power of 4, then n is also power of 2.
     *
	 * First check is n is power of 2 or not (there is only one 1 in its binary representation)
	 * Then check no. of zeroes from right had side. If no. of zeroes are even then return true.
	 * 
	 * T = O(1)
	 * S = O(1)
	 */
	public static boolean isPowerOfFour(int n) {
        
        if(n == 0) {
            return false;
        }

        if((n & (n-1)) != 0) {
            return false;
        }

        int count = 0;
        for(int i = 0; i <= 31; i++) {
            int mask = 1 << i;
            if((n & mask) == 0) {
                count++;
            } else {
                break;
            }
        }

        if(count % 2 == 0) {
            return true;
        }

        return false;
    }
}
