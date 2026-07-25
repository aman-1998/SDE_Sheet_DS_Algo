package practice.dsa.sheet.part7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Distance_Of_Nearest_One_For_Each_Cell {
	
	public static void main(String[] args) {
		 
		int[][] mat = {{0, 0, 0}, 
					   {0, 1, 0}, 
					   {1, 0, 1}};
		
		mat = updateMatrix(mat);
		
		for(int[] arr : mat) {
			for(int i = 0; i <= arr.length-1; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		
	}
	
	/*
	 * T = O(m*n)
	 * S = O(m*n)
	 */
	public static int[][] updateMatrix(int[][] mat) {
        
		int m = mat.length;
		int n = mat[0].length;
		
		// automatically initialized with 0
		int[][] visited = new int[m][n];
		
		Queue<List<Integer>> queue = new LinkedList<>();
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if(mat[i][j] == 1) {
					visited[i][j] = 1;
					mat[i][j] = 0;
					queue.add(Arrays.asList(i, j, 0));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			List<Integer> popped = queue.poll();
			//(x, y)
			//(x-1, y)
			//(x+1, y)
			//(x, y-1)
			//(x, y+1)
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0 ,-1, 1};
			for(int i = 0; i <= 3; i++) {
				int adjx = popped.get(0) + dx[i];
				int adjy = popped.get(1) + dy[i];
				if(isValid(m, n, adjx, adjy) && visited[adjx][adjy] == 0) {
					visited[adjx][adjy] = 1;
					mat[adjx][adjy] = popped.get(2)+1;
					queue.add(Arrays.asList(adjx, adjy, popped.get(2)+1));
				}
			}
		}
		
		return mat;
    }
	
	private static boolean isValid(int m, int n, int adjx, int adjy) {
		if(adjx < 0 || adjx >= m || adjy < 0 || adjy >= n) {
			return false;
		}
		return true;
	}
}

class Distance_Of_Nearest_Zero_For_Each_Cell {
	
	public static void main(String[] args) {
		 
		int[][] mat = {{0, 0, 0}, 
					   {0, 1, 0}, 
					   {1, 1, 1}};
		
		mat = updateMatrix(mat);
		
		for(int[] arr : mat) {
			for(int i = 0; i <= arr.length-1; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		
	}
	
	/*
	 * T = O(m*n)
	 * S = O(m*n)
	 */
	public static int[][] updateMatrix(int[][] mat) {
        
		int m = mat.length;
		int n = mat[0].length;
		
		// automatically initialized with 0
		int[][] visited = new int[m][n];
		
		Queue<List<Integer>> queue = new LinkedList<>();
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if(mat[i][j] == 0) {
					visited[i][j] = 1;
					queue.add(Arrays.asList(i, j, 0));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			List<Integer> popped = queue.poll();
			//(x, y)
			//(x-1, y)
			//(x+1, y)
			//(x, y-1)
			//(x, y+1)
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0 ,-1, 1};
			for(int i = 0; i <= 3; i++) {
				int adjx = popped.get(0) + dx[i];
				int adjy = popped.get(1) + dy[i];
				if(isValid(m, n, adjx, adjy) && visited[adjx][adjy] == 0) {
					visited[adjx][adjy] = 1;
					mat[adjx][adjy] = popped.get(2)+1;
					queue.add(Arrays.asList(adjx, adjy, popped.get(2)+1));
				}
			}
		}
		
		return mat;
    }
	
	private static boolean isValid(int m, int n, int adjx, int adjy) {
		if(adjx < 0 || adjx >= m || adjy < 0 || adjy >= n) {
			return false;
		}
		return true;
	}
}
