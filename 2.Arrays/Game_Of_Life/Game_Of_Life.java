package algorithms;

public class Game_Of_Life {
	/*
	 * Truth table used here:-
	 * 
	 * Original State | Final State | Intermediate State
	 * ---------------|-------------|--------------------
	 * 0              |0            |0
	 * 1              |1            |1
	 * 0              |1            |2
	 * 1              |0            |3
	 * 
	 * 
	 * Rules :-
     * For cell value == 1:
     * 1. If no. of living cells is < 2 or < 3 then the cell dies (i.e., becomes 0)
     * 2. If no. of living cells is exactly equals to 2 or 3 then the cell remains alive (i.e., stays 1)
     *
     * For cell value == 0:
     * 1. If no. of living cells is exactly equlas to 3 then the cell become alive (i.e., becomes 1)
     * 2. If no. of living cells is not equal to 3 then the cell remains dead (i.e., stays 0)
     * 
	 */
	public static void main(String[] args) {
		
		int[][] board = {{0, 1, 0},
				         {0, 0, 1},
				         {1, 1, 1},
				         {0, 0, 0}};
		
		gameOfLife(board);
		
		for(int[] arr : board) {
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	/*
	 * T = O(m*n) + O(m*n) = O(m*n)
	 * S = O(1)
	 */
	public static void gameOfLife(int[][] board) {
		
		int m = board.length;
		int n = board[0].length;
		
		for(int i = 0 ; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				int livingNeighbours = countLivingNeighbours(board, i, j);
				if(board[i][j] == 0) {
					if(livingNeighbours == 3) {
						board[i][j] = 2;
					}
				} else {
					if(livingNeighbours != 2 && livingNeighbours != 3) {
						board[i][j] = 3;
					}
				}
			}
		}
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				if(board[i][j] == 2) {
					board[i][j] = 1;
				} else if(board[i][j] == 3) {
					board[i][j] = 0;
				}
			}
		}
	}

	private static int countLivingNeighbours(int[][] board, int i, int j) {
		
		int m = board.length; // rows
		int n = board[0].length; // cols
		
		int livingNeighbours = 0;
		
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		for(int k = 0; k < 8; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			
			if(isValid(x, y, m, n)) {
				if(board[x][y] == 1 || board[x][y] == 3) {
					livingNeighbours++;
				}
			}
		}
		
		return livingNeighbours;
	}

	private static boolean isValid(int x, int y, int m, int n) {
		
		return (x >= 0) && (x < m) && (y >= 0) && (y < n);
	}

}
