package algorithms;

public class Rotate_Matrix_By_90_Degrees {
	
	public static void main(String[] args) {
		int[][] mat = {{5,1,9,11},
				       {2,4,8,10},
				       {13,3,6,7},
				       {15,14,12,16}};
		
		int n = mat.length;
		
		mat = rotateMatrix(mat);
		
		for(int i = 0; i <= n-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] rotateMatrix(int[][] mat) {
		
		int n = mat.length;
		for(int i = 0; i <= n-2; i++) {
			for(int j = i+1; j <= n-1; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		
		for(int i = 0; i <= n-1; i++) {
			mat[i] = reverse(mat[i], 0, n-1);
		}
		
		return mat;
	}

	private static int[] reverse(int[] arr, int i, int j) {
		
		while(i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		return arr;
	}
}
