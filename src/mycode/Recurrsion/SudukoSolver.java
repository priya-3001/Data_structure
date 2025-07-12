package mycode.Recurrsion;

import java.util.Arrays;

public class SudukoSolver {
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
		for(char[] b: board) {
			System.out.println(Arrays.toString(b));
		}
		
		
	}
	
	 public static void solveSudoku(char[][] board) {
	        solve(board, 0, 0);
	    }

	private static boolean solve(char[][] board, int row, int col) {
		if(row == 9)
			return true;
		if(col == 9)
			return solve(board, row+1, 0);
		
		if(board[row][col] != '.') {
			return solve(board, row, col+1);
		}
		
		for(char i = '1' ; i<='9';i++) {
			if(isValid(i, row, col, board)) {
				board[row][col] = i;
				if(solve(board, row, col+1)) return true;
				board[row][col] = '.';
				
			}
		}
		
		return false;
	}

	private static boolean isValid(char digit, int row, int col, char[][] board) {
		for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit)
                return false;
        }
		int startx = (row/3)*3;
		int starty = (col/3)*3;
		for(int i = startx; i<startx+3;i++) {
			for(int j = starty; j<starty+3;j++) {
				if(board[i][j] == digit)
					return false;
			}
		}
		return true;
	}
}
