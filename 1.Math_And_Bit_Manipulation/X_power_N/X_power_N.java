package algorithms;

public class X_power_N {
	
	public static void main(String[] args) {
		System.out.println(myPow(7, 9));
	}
	
	/*
	 * Recursive Solution
	 * 
	 * T = O(log n) [base = 2]
	 * S = System's internal stack space is used = O(log n) [base = 2]
	 */
	public static double myPower(double x, int n) {
		
		long nn = (long)n;
		nn = nn < 0 ? -1 * nn : nn;
		double ans = power(x, nn);
		if(n < 0) {
			return 1.0/ans;
		}
		
		return ans;
	}
	
	public static double power(double x, long nn) {
        if(nn == 0) {
            return 1;
        } else if(nn % 2 != 0) {
            return x * power(x, nn-1);
        } else {
            return power(x*x, nn/2);
        }
    }
	
/* -------------------------------------------------------------------- */
	
	/*
	 * Iterative Solution
	 * 
	 * T = O(log n) [base = 2]
	 * S = O(1)
	 */
	public static double myPow(double x, int n) {
        long nn = (long)n;
        double ans = 1;
        nn = nn < 0 ? -1 * nn : nn;
        while(nn > 0) {
        	if(nn % 2 != 0) {
                ans = ans * x;
                nn = nn -1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        
        if(n < 0) {
        	return 1.0/ans;
        }
        
        return ans;
    }
}
