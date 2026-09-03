package practice.dsa.sheet.part10;

public class Tower_Of_Hanoi {
	
	private static int count = 0;
	
	public static void main(String[] args) {
		
		int n = 3;
		
		int count = towerOfHanoi(n , 's', 'd', 'a');
		
		System.out.println(count);
	}
	
	/*
	 * T(n) = T(n-1) + T(n-1) + O(1)
     *		= 2T(n-1) + O(1)
     *
	 * So, T = O(2^n)
	 * 
	 * S = O(n)   [O(n) because of system stack]
	 */
    public static int towerOfHanoi(int n, int src, int dest, int aux) {
        
        solve(n, src, dest, aux);
        
        return count;
    }
    
    private static void solve(int n, int src, int dest, int aux) {

		if(n == 1) {
			count++;
			//System.out.println("Move 1 disc from " + src + " to " + dest);
			return;
		}

		solve(n-1, src, aux, dest);
		solve(1, src, dest, aux);
		solve(n-1, aux, dest, src);
	}
	
}
