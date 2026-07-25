package practice.dsa.sheet.part7;

public class Surrounded_Regions {
	
	public static void main(String[] args) {
		
		char[][] board = {{'X', 'X', 'X', 'X', 'X'},
				          {'X', 'O', 'O', 'X', 'O'},
				          {'X', 'X', 'O', 'X', 'O'},
				          {'X', 'O', 'X', 'O', 'X'},
				          {'O', 'O', 'X', 'X', 'X'}};
		
		surroundedRegions(board);
		
		for(char[] arr : board) {
			for(char x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 * Here, I am using DFS but I can also use BFS
	 * 
	 * T = O(2m + 2n) + O(m*n) = O(m*n)
	 * S = O(m*n)
	 */
	public static void surroundedRegions(char[][] board) {
		
		int m = board.length;
		int n = board[0].length;
		
		int[][] visited = new int[m][n];
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if((i == 0 || i == m-1 || j == 0 || j == n-1) && board[i][j] == 'O') {
					DFS(board, visited, i, j);
				}
			}
		}
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if(board[i][j] == 'O' && visited[i][j] == 0) {
					board[i][j] = 'X';
				}
			}
		}
		
		// return board;
	}
	
	/*
	 * T = O(m*n)
	 */
	private static void DFS(char[][] board, int[][] visited, int i, int j) {
		
		int m = board.length;
		int n = board[0].length;
		
		visited[i][j] = 1;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0 ,-1, 1};
		
		for(int k = 0; k <= 3; k++) {
			int adjx = i + dx[k];
			int adjy = j + dy[k];
			if(isValid(m, n, adjx, adjy) 
					&& board[adjx][adjy] == 'O' 
					&& visited[adjx][adjy] == 0) {
				
				DFS(board, visited, adjx, adjy);
				
			}
		}
	}
	
	private static boolean isValid(int m, int n, int adjx, int adjy) {
		if(adjx < 0 || adjx >= m || adjy < 0 || adjy >= n) {
			return false;
		}
		return true;
	}
}
