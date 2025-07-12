package mycode.Leetcode;

import java.util.Arrays;

public class SurroundedRgn {
	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','O','X'}};
		//solve(board);
		String sq = "hello";
		
		int x = 121;
		char[][] bool1 = new char[3][3];
		Character[][] bool2 = new Character[3][3];
		Integer s = Integer.parseInt("56");
		Integer.valueOf("24");
//		for(char[] bool : bool1) {s
//			System.out.println(Arrays.toString(bool));
//		}
		System.out.println("Result "+ s);
		
	}
	
	 public static boolean isPalindrome(int x) {
	        int reverse = reverse(x);   
	        return reverse == x;
	    }

	     public static int reverse(int x) {
	        int newNum = 0;
	        while(x!=0){
	            int rem = x%10;
	            newNum = newNum * 10 + rem;
	            x /= 10;
	        }
	        return newNum;
	     }
	
	  public static void solve(char[][] board) {
	        
		  int n = board.length;
		  int m = board[0].length;
		  
		  boolean[][] visited = new boolean[n][m];
		  
		 int[] rowWise = {0,n-1};
		for(int a : rowWise) {
			for(int j = 0;j<m;j++) {
				if(	board[a][j] == 'O' && !visited[a][j]) {
					dfs(a,j,board, visited);
				}
			}
		}	
			int[] colWise = {0,m-1};
			for(int b : colWise) {
				for(int j = 0;j<n;j++) {
					if(	board[j][b] == 'O' && !visited[j][b]) {
						dfs(j,b,board, visited);
					}
				}}
			
			for(int i =0; i<n;i++) {
				for(int j = 0; j<m;j++) {
					if(board[i][j] == 'O' && !visited[i][j]) {
						board[i][j] = 'X';
					}
				}
			}
			
			
	   }
	  
	  
	  
	private static void dfs(int x, int y, char[][] board, boolean[][] visited) {
		if(x<0 || y<0 || x>=board.length || y >= board[0].length || visited[x][y] || board[x][y] == 'X')
			return;
		
		visited[x][y] = true;
		dfs(x-1,y,board,visited);
		dfs(x,y-1,board,visited);
		dfs(x+1,y,board,visited);
		dfs(x,y+1,board,visited);
	}

	private static boolean canflip(int i, int j, char[][] board) {
		int[][] direction = {{1,0},{0,1},{0,-1},{-1,0}};
		
		
		if((i == 0 || j==board[0].length-1 ) && board[i][j] == 'O')
			return false;
		
		if((i == 0 || j==board[0].length-1 ) && board[i][j] == 'X')
			return true;
		
		for(int[] dir : direction) {
			int x = i + dir[0];
			int y = j + dir[1];
			  
			if(board[x][y] == 'O') {
				return canflip(x,y,board);
			}
			
		}
		
		return true;
	}
}
