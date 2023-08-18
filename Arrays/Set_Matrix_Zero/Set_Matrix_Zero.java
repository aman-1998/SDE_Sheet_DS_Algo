package algorithms;

/*
 * Given a matrix if an element in the matrix is 0 then 
 * you will have to set its entire column and row to 0 
 * and then return the matrix.
 */

public class Set_Matrix_Zero {
	
	public static void main(String[] args) {
		int[][] a = {{4,5,7,2},
					 {3,6,0,4},
					 {0,8,4,2},
					 {6,7,0,0},
					 {0,8,9,4}};
		
		a = setZeroes(a);
		
		for(int[] i : a) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] setZeroes(int[][] a) {
		
		int m = a.length; // no. of rows
		int n = a[0].length; // no. of columns
		int colTop = 1; // 1 means there is no zero in 1st column (i.e. a[i][0])
		
		for(int i=0; i <= m-1; i++) {
			for(int j=0; j <= n-1; j++) {
				if(a[i][j] == 0) {
					if(j==0) {
						colTop = 0;
					} else {
						if(i == 0) {
							a[0][0]=0;
						} else {
							a[i][0] = 0;
							a[0][j] = 0;
						}
					}
				}
			}
		}
		
		// Iterate from last
		for(int i = m-1; i >= 0; i--) {
			for(int j = n-1; j >= 0; j--) {
				if(i==0 && j==0) {
					if(colTop == 0) {
						a[i][j] = 0;
					}
				} else if(j == 0) {
					if(colTop == 0) {
						a[i][j] = 0;
					}
				} else if(i == 0) {
					if(a[0][0] == 0) {
						a[i][j] = 0;
					}
				} else {
					//If either of a[i][0] or a[0][j] is zero then make a[i][j] 0
					if(a[i][0]==0 || a[0][j]==0) {
						a[i][j] = 0;
					}
				}
			}
		}
		
		return a;
		
	}
}
