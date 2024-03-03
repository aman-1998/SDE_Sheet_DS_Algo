package algorithms;

public class Determine_If_N_Is_A_Power_Of_2 {
	
	public static void main(String[] args) {
		
		//int n = 256;
		int n = 411;
		boolean check = is_Power_Of_2(n);
		System.out.println(check);
	}
	
	/*
	 * T = O(1)
	 * S = O(1)
	 */
	private static boolean is_Power_Of_2(int n) {
		
		long m = (long)n;

        if(m == 0) {
            return false;
        }

        return (m & (m-1)) == 0 ? true : false;
	}
}
