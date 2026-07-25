package practice.dsa.sheet.part8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Number_Of_Island {
	
	public static void main(String[] args) {
		
		char[][] grid = {{'1','1','0','0','0'},
				         {'1','1','0','0','0'},
				         {'0','0','1','0','0'},
				         {'0','0','0','1','1'}};
		
		int count = numIslands_using_BFS(grid);
		//int count = numIslands_using_Disjointset(grid);
		
		System.out.println(count);
	}
	
	/*
	 * T = O(rows*cols) + O(rows*cols) = O(rows*cols)
	 * S = O(rows*cols)
	 */
	public static int numIslands_using_BFS(char[][] grid) {
        
		int rows = grid.length;
		int cols = grid[0].length;
		
		int[][] visited = new int[rows][cols];
		
		int count = 0;
		for(int i = 0; i <= rows-1; i++) {
			for(int j = 0; j <= cols-1; j++) {
				if(grid[i][j] == '1' && visited[i][j] == 0) {
					count++;
					BFS(grid, visited, i, j);
				}
			}
		}
		
		return count;
	}
	
	private static void BFS(char[][] grid, int[][] visited, int i, int j) {
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(i,j));
		visited[i][j] = 1;
		
		while(!queue.isEmpty()) {
			List<Integer> popped = queue.poll();
			// x, y-1
			// x, y+1
			// x-1, y
			// x+1, y
			int[] dx = {0, 0, -1, 1};
			int[] dy = {-1, 1, 0, 0};
			for(int k = 0; k <= 3; k++) {
				int adjx = popped.get(0) + dx[k];
				int adjy = popped.get(1) + dy[k];
				if(isValid(rows, cols, adjx, adjy) && grid[adjx][adjy] == '1' && visited[adjx][adjy] == 0) {
					visited[adjx][adjy] = 1;
					queue.add(Arrays.asList(adjx, adjy));
				}
			}
		}
	}

	/*
	 * T = O(rows*cols) + O(rows*cols) = O(rows*cols)
	 * S = O(rows*cols)
	 */
	public static int numIslands_using_Disjointset(char[][] grid) {
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		DisjointSet ds = new DisjointSet(rows*cols); // O(n)
		
		int[][] visited = new int[rows][cols];
		
		int count = 0;
		
		for(int i = 0; i <= rows-1; i++) {
			for(int j = 0; j <= cols-1; j++) {
				if(grid[i][j] == '1' && visited[i][j] == 0) {
					visited[i][j] = 1;
					count++;
					
					// x, y-1
					// x, y+1
					// x-1, y
					// x+1, y
					int[] dx = {0, 0, -1, 1};
					int[] dy = {-1, 1, 0, 0};
					for(int k = 0; k <= 3; k++) {
						int adjx = i + dx[k];
						int adjy = j + dy[k];
						if(isValid(rows, cols, adjx, adjy) && visited[adjx][adjy] == 1) {
							int nodeVal = i*cols + j;
							int adjNodeVal = adjx*cols + adjy;
							if(ds.findSet(nodeVal) != ds.findSet(adjNodeVal)) {
								count--;
								ds.unionBySize(nodeVal, adjNodeVal);
							}
						}
					}
				}
			}
		}
		
		return count;
	}
	
	private static boolean isValid(int rows, int cols, int adjr, int adjc) {
		
		if(adjr < 0 || adjr >= rows || adjc < 0 || adjc >= cols) {
			return false;
		}
		
		return true;
	}
}
