package algorithms;

public class Jump_Game_Using_Iteration_Best_Approach {
	
	public static void main(String[] args) {
		
		//int[] arr = new int[] {1, 3, 2, 0, 1};
		
		//int[] arr = new int[] {1, 2, 1, 0, 2};
		
		//int[] arr = new int[] {2, 3, 1, 1, 4};
		
		//int[] arr = new int[] {3, 2, 1, 0, 4};
		
		int[] arr = new int[] {0, 2, 1, 3, 4};
		
		boolean possible = jumpGame(arr);
		
		System.out.println(possible);
	}
	
	public static boolean jumpGame(int[] arr) {
		
		int n = arr.length;
		int reachable = 0;
		
		for(int i = 0; i <= n-1; i++) {
			
			if(i > reachable) {
				return false;
			}
			
			if(reachable >= n) {
				break;
			}
			
			if(i + arr[i] > reachable) {
				reachable = i + arr[i];
			}
		}
		return true;
	}
	
}
