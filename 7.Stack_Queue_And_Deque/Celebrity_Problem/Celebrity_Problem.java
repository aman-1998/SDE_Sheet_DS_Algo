package practice.dsa.sheet.part4;

public class Celebrity_Problem {
	
	public static void main(String[] args) {
		
		int[][] mat = {{0, 1, 1, 0}, 
					   {0, 0, 0, 0}, 
					   {1, 1, 0, 0}, 
					   {0, 1, 1, 0}};
		
		int celebrity = findCelebrity_best(mat);
		System.out.println(celebrity);
	}
	
	/*
	 * T = O(2n*n)
	 * S = O(1)
	 */
	public static int findCelebrity_BF(int[][] mat) {
		
		int n = mat.length;
		for(int i = 0; i <= n-1; i++) {
			int countKonowMe = 0;
			for(int j = 0; j <= n-1; j++) {
				if(i != j && mat[j][i] == 1) {
					countKonowMe++;
				}
			}
			
			if(countKonowMe == n-1) {
				int countIKnow = 0;
				for(int j = 0; j <= n-1; j++) {
					if(mat[i][j] != 0) {
						countIKnow++;
					}
				}
				
				if(countIKnow == 0) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	/*
	 * T = O(3n)
	 * S = O(1)
	 */
	public static int findCelebrity_better(int[][] mat) {
		
		int n = mat.length;
		int top = 0;
		int down = n-1;
		
		while(top < down) {
			if(mat[top][down] == 0) {
				down--;
			} else {
				top++;
			}
		}
		
		int countIKnow = 0;
		for(int i = 0; i <= n-1; i++) {
			if(mat[top][i] != 0) {
				countIKnow++;
			}
		}
		
		if(countIKnow == 0) {
			int countKnowMe = 0;
			for(int i = 0; i <= n-1; i++) {
				if(i != top && mat[i][top] == 1) {
					countKnowMe++;
				}
			}
			
			if(countKnowMe == n-1) {
				return top;
			}
		}
		
		return -1;
	}
	
	/*
	 * T = O(2n)
	 * S = O(1)
	 */
	public static int findCelebrity_best(int[][] mat) {
		
		int n = mat.length;
		int top = 0;
		int down = n-1;
		
		while(top < down) {
			if(mat[top][down] == 0) {
				down--;
			} else {
				top++;
			}
		}
		
		for(int i = 0; i <= n-1; i++) {
			if(mat[top][i] == 0) {
				if(i == top && mat[i][top] == 0) {
					// valid
				} else if(i != top && mat[i][top] == 1) {
					// valid
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		}
		
		return top;
	}
}
