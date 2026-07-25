package practice.dsa.sheet.part8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Flood_Fill {
	
	public static void main(String[] args) {
		
		int[][] image = {{1, 1, 1},
						 {1, 1, 0},
						 {1, 0, 1}};
		
		int sr = 1;
		int  sc = 1;
		int color = 2;
		
//		int[][] image = {{0, 0, 0},
//				         {0, 0, 0}};
//		
//		int sr = 0;
//		int  sc = 0;
//		int color = 0;
		
		image = floodFill_Using_DFS(image, sr, sc, color);
		
		for(int[] arr : image) {
			for(int i = 0; i <= arr.length-1; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 * Using BFS
	 * 
	 * T = O(m*n)
	 * S = O(m*n)
	 * 
	 */
	public static int[][] floodFill_Using_BFS(int[][] image, int sr, int sc, int color) {
        
		int m = image.length;
		int n = image[0].length;
		
		int initialColor = image[sr][sc];
		image[sr][sc] = color;
		
		if(initialColor == color) {
			return image;
		}
		
		Queue<List<Integer>> queue = new LinkedList<>();
		
		queue.add(Arrays.asList(sr, sc));
		
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
				if(isValid(m, n, adjx, adjy) && image[adjx][adjy] == initialColor) {
					image[adjx][adjy] = color;
					queue.add(Arrays.asList(adjx, adjy));
				}
			}
		}
		
		return image;
    }
	
	private static boolean isValid(int m, int n, int adjx, int adjy) {
		if(adjx < 0 || adjx >= m || adjy < 0 || adjy >= n) {
			return false;
		}
		return true;
	}
	
	//===================================================================
	
	/*
	 * Using DFS
	 * 
	 * T = O(m*n)
	 * S = O(m*n)
	 * 
	 */
	public static int[][] floodFill_Using_DFS(int[][] image, int sr, int sc, int color) {
		
		int initialColor = image[sr][sc];
		
		if(initialColor == color) {
			return image;
		}
		
		solve(image, sr, sc, initialColor, color);
		
		return image;
	}

	private static void solve(int[][] image, int sr, int sc, int initialColor, int color) {
		
		int m = image.length;
		int n = image[0].length;
		
		image[sr][sc] = color;
		
		//(x, y)
		//(x-1, y)
		//(x+1, y)
		//(x, y-1)
		//(x, y+1)
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0 ,-1, 1};
		for(int i = 0; i <= 3; i++) {
			int adjx = sr + dx[i];
			int adjy = sc + dy[i];
			if(isValid(m, n, adjx, adjy) && image[adjx][adjy] == initialColor) {
				solve(image, adjx, adjy, initialColor, color);
			}
		}
	}
	
	
}
