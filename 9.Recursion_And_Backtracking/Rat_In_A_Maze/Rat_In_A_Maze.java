package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.List;

public class Rat_In_A_Maze {
	
	public static void main(String[] args) {
		
		int[][] maze = {{1, 0, 0, 0},
				        {1, 1, 0, 1},
				        {1, 1, 0, 0},
				        {0, 1, 1, 1}};
		
		List<String> res = ratInMaze(maze);
		
		res.stream().forEach(path -> System.out.println(path));
	}
	
	/*
	 * T = 4^(m*n)
	 * S = O(m*n)  [System Stack = O(m*n), visited array = O(m*n)]
	 */
	public static List<String> ratInMaze(int[][] maze) {
		
		int m = maze.length;
		int n = maze[0].length;
		
		if(maze[0][0] == 0 || maze[m-1][n-1] == 0) {
			return new ArrayList<>();
		}
		
		List<String> result = new ArrayList<>();
		StringBuilder path = new StringBuilder();
		
		int[][] visited = new int[m][n];
		
		visited[0][0] = 1;
		
		solve(maze, visited, 0, 0, path, result);
		
		return result;
    }
	
	public static void solve(int[][] maze, int[][] visited, int x, int y, 
						     StringBuilder path, List<String> result) {
		
		int m = maze.length;
		int n = maze[0].length;
		
		if(x == m-1 && y == n-1) {
			result.add(path.toString());
			return;
		}
		
		int[] dx = {1, 0, 0, -1};
		int[] dy = {0, -1, 1, 0};
		
		for(int i = 0; i <= 3; i++) {
			int adjx = x + dx[i];
			int adjy = y + dy[i];
			if(isValid(maze, adjx, adjy) 
					&& maze[adjx][adjy] == 1
					&& visited[adjx][adjy] == 0) {
				
				if(i == 0) {
					path.append('D');
				} else if(i == 1) {
					path.append('L');
				} else if(i == 2) {
					path.append('R');
				} else {
					path.append('U');
				}
				
				visited[adjx][adjy] = 1;
				
				solve(maze, visited, adjx, adjy, path, result);
				
				path.deleteCharAt(path.length()-1);
				
				visited[adjx][adjy] = 0;
			}
		}
	}

	private static boolean isValid(int[][] maze, int adjx, int adjy) {
		
		int m = maze.length;
		int n = maze[0].length;
		
		if(adjx >= 0 && adjx < m && adjy >= 0 && adjy < n) {
			return true;
		}
		
		return false;
	}
}
