package practice.dsa.sheet.part10;

/*
 * Link : https://www.youtube.com/watch?v=FWAIf_EVUKE
 * 
 * Rules :
 * 1. There is a 9x9 matrix. and it is then divided into nine 3x3 matrices.
 * 2. A number can appear only once in the entire row.
 * 3. A number can appear only once in the entire column.
 * 4. A  number can appear only once in it's own 3x3 matrix.
 */
public class Sudoku_Solver {
	
	public static void main(String[] args) {
		
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						  {'6','.','.','1','9','5','.','.','.'},
						  {'.','9','8','.','.','.','.','6','.'},
						  {'8','.','.','.','6','.','.','.','3'},
						  {'4','.','.','8','.','3','.','.','1'},
						  {'7','.','.','.','2','.','.','.','6'},
						  {'.','6','.','.','.','.','2','8','.'},
						  {'.','.','.','4','1','9','.','.','5'},
						  {'.','.','.','.','8','.','.','7','9'}};
		
		solveSudoku(board);
		
		for(int i = 0; i <= 8; i++) {
			for(int j = 0; j <= 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	/*
	 * T = O(1)
	 * S = O(1)
	 */
	public static void solveSudoku(char[][] board) {
		
		solve(board);
	}
	
	public static boolean solve(char[][] board) {
        
		boolean isEmptySpaceLeft = false;
		
		for(int i = 0; i <= 8; i++) {
			for(int j = 0; j <= 8; j++) {
				if(board[i][j] == '.') {
					
					isEmptySpaceLeft = true;
							
					char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
					for(char num : nums) {
						if(isPlaceable(board, i, j, num)) {
							board[i][j] = num;
							boolean check = solve(board);
							if(check) {
								return true;
							}
							board[i][j] = '.';
						}
					}
					
					return false;
				}
			}
		}
		
		if(!isEmptySpaceLeft) {
			return true;
		}
		
		return false;
    }
	
	public static boolean isPlaceable(char[][] board, int row, int col, int num) {
		
		for(int i = 0; i <= 8; i++) {
			if(board[row][i] == num) {
				return false;
			}
		}
		
		for(int i = 0; i <= 8; i++) {
			if(board[i][col] == num) {
				return false;
			}
		}
		
		int x = row - (row % 3);
		int y = col - (col % 3);
		
		for(int i = x; i <= x+2; i++) {
			for(int j = y; j <= y+2; j++) {
				if(board[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
}
