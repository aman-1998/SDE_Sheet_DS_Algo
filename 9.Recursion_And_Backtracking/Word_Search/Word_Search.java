package practice.dsa.sheet.part10;
/*
 * Link : https://www.youtube.com/watch?v=whyax_vB8xY
 */
public class Word_Search {
	
	public static void main(String[] args) {
		
		String word = "SEE";
		
		char[][] board = {{'A', 'B', 'C', 'E'},
						  {'S', 'F', 'C', 'S'},
						  {'A', 'D', 'E', 'E'}};
		
		boolean check = exist(board, word);
		
		System.out.println(check);
	}
	
	/*
	 * T = O(m x n x 4 x 3^(L-1)) 
	 *   = o(m x n x 3^L) ; m = no. of rows, n = no. of columns, L = word length
	 *   
	 * S = O(L) ; [Max depth of system stack]
	 */
	public static boolean exist(char[][] board, String word) {
        
		int m = board.length;
		int n = board[0].length;
		
		int index = 0;
		
		for(int i = 0; i <= m-1; i++) {
			for(int j = 0; j <= n-1; j++) {
				boolean check = solve(board, word, i, j, index);
				if(check) {
					return true;
				}
			}
		}
		
		return false;
    }
	
	public static boolean solve(char[][] board, String word, int x, int y, int index) {
		
		if(index == word.length()) {
			return true;
		}
		
		if(isValid(board, x, y) 
				&& board[x][y] == word.charAt(index)
				&& board[x][y] != '$') {
			
			char originalValue = board[x][y];
			board[x][y] = '$';
			
			int[] dx = {1, 0, 0, -1};
			int[] dy = {0, -1, 1, 0};
			
			for(int k = 0; k <= 3; k++) {
				int adjx = x + dx[k];
				int adjy = y + dy[k];
				
				boolean check = solve(board, word, adjx, adjy, index+1);
				if(check) {
					return true;
				}
			}
			
			board[x][y] = originalValue;
		}
		
		return false;
    }

	private static boolean isValid(char[][] board, int x, int y) {
		
		int m = board.length;
		int n = board[0].length;
		
		if(x >= 0 && x < m && y >= 0 && y < n) {
			return true;
		}
		
		return false;
	}
}
