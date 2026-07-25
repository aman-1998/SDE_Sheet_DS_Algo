package practice.dsa.sheet.part8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Number_Of_Distinct_Island {
	
public static void main(String[] args) {
		
		char[][] grid = {{'1','1','0','1','1'},
				         {'1','0','0','0','0'},
				         {'0','0','0','1','1'},
				         {'1','1','0','1','0'}};
		
		int count = numDistinctIslands_using_BFS(grid);
		
		System.out.println(count);
	}
	
	/*
	 * T = O(rows*cols) + O(rows*cols) = O(rows*cols)
	 * S = O(rows*cols)
	 */
	public static int numDistinctIslands_using_BFS(char[][] grid) {
        
		int rows = grid.length;
		int cols = grid[0].length;
		
		int[][] visited = new int[rows][cols];
		
		Set<List<List<Integer>>> set = new HashSet<>();
		
		for(int i = 0; i <= rows-1; i++) {
			for(int j = 0; j <= cols-1; j++) {
				if(grid[i][j] == '1' && visited[i][j] == 0) {
					BFS(grid, visited, set, i, j);
				}
			}
		}
		
		return set.size();
	}
	
	private static void BFS(char[][] grid, int[][] visited, Set<List<List<Integer>>> set, int i, int j) {
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(i,j));
		visited[i][j] = 1;
		
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(0, 0));
		
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
					
					list.add(Arrays.asList(adjx - i, adjy - j));
				}
			}
			
			set.add(list);
		}
	}

	private static boolean isValid(int rows, int cols, int adjr, int adjc) {
		
		if(adjr < 0 || adjr >= rows || adjc < 0 || adjc >= cols) {
			return false;
		}
		
		return true;
	}
}
