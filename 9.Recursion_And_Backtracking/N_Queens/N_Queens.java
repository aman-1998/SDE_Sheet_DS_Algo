package practice.dsa.sheet.part10;

import java.util.ArrayList;
import java.util.List;
/*
 * Rules of attack :
 * 1. Queen can attack any other queen in the same row
 * 2. Queen can attack any other queen in the same column
 * 3. Queen can attack any other queen diagonally (entire diagonal)
 */
public class N_Queens {
	
	public static void main(String[] args) {
		
		int n = 4;
		
		List<List<String>> res = solveNQueens(n);
		
		res.stream().forEach((List<String> list) -> System.out.println(list));
	}
	
	/*
	 * We have n queens. In first row we can place 1 queen out n choices.
	 * In 2nd row, we can select 1 queen out of n-1 choices
	 * In 3rd row we can select 1 queen out of n-2 choices
	 * an so on....
	 * So, n x (n-1) x (n-2) x (n-3) x .... x 3 x 2 x 1 = n!
	 * 
	 * To check if a queen can be placed or not it takes O(n) time
	 * 
	 * Also, after finding 1 solution we deep-copy it to result.So, if we
	 * have k solution time taken is O(k * n^2)
	 * 
	 * T = O(n! * n) +  O(k * n^2)
	 * 	 = O(n* n!)
	 * 
	 * S = O(n) + O(n^2)  [O(n) for system stack and O(^2) for board]
	 */
	public static List<List<String>> solveNQueens(int n) {
        
		List<List<String>> result = new ArrayList<>();
		List<StringBuilder> boardSb = new ArrayList<>();
		
		for(int i = 0; i <= n-1; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j <= n-1; j++) {
				sb.append('.');
			}
			boardSb.add(sb);
		}
		
		solve(n, 0, boardSb, result);
		
		return result;
    }

	private static void solve(int n, int row, 
							  List<StringBuilder> boardSb,
							  List<List<String>> result) {
		
		if(row == n) {
			
			List<String> board = new ArrayList<>();
			for(int j = 0; j <= n-1; j++) {
				StringBuilder sb = boardSb.get(j);
				board.add(sb.toString());
			}
			
			result.add(new ArrayList<>(board));
			return;
		}
		
		for(int col = 0; col <= n-1; col++) {
			if(isPlaceable(boardSb, row, col)) {
				boardSb.get(row).setCharAt(col, 'Q');
				solve(n, row+1, boardSb, result);
				boardSb.get(row).setCharAt(col, '.');
			}
		}
	}

	private static boolean isPlaceable(List<StringBuilder> boardSb, int row, int col) {
		
		int n = boardSb.size();
		
		if(row == 0) {
			return true;
		}
		
		// Check entire row
		for(int i= 0; i <= n-1; i++) {
			if(boardSb.get(row).charAt(i) != '.') {
				return false;
			}
		}
		
		// Check entire column
		for(int i= 0; i <= n-1; i++) {
			if(boardSb.get(i).charAt(col) != '.') {
				return false;
			}
		}
		
		int[] dx = {-1, -1, 1, 1};
		int[] dy = {-1, 1, 1, -1};
		int i = row;
		int j = col;
		while(i+dx[0] >= 0 && j+dy[0] >= 0) {
			if(boardSb.get(i+dx[0]).charAt(j+dy[0]) != '.') {
				return false;
			}
			i = i+dx[0];
			j = j+dy[0];
		}
		
		i = row;
		j = col;
		while(i+dx[1] >= 0 && j+dy[1] < n) {
			if(boardSb.get(i+dx[1]).charAt(j+dy[1]) != '.') {
				return false;
			}
			i = i+dx[1];
			j = j+dy[1];
		}
		
		i = row;
		j = col;
		while(i+dx[2] < n && j+dy[1] < n) {
			if(boardSb.get(i+dx[2]).charAt(j+dy[2]) != '.') {
				return false;
			}
			i = i+dx[2];
			j = j+dy[2];
		}
		
		i = row;
		j = col;
		while(i+dx[3] < n && j+dy[3] >= 0) {
			if(boardSb.get(i+dx[3]).charAt(j+dy[3]) != '.') {
				return false;
			}
			i = i+dx[3];
			j = j+dy[3];
		}
		
		return true;
	}

}
