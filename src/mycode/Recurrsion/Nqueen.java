package mycode.Recurrsion;

import java.util.*;

public class Nqueen {

	 public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = nQueen(4);
		
		System.out.println(result.toString());
	}
	
	public static ArrayList<ArrayList<Integer>> nQueen(int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> temp  = new ArrayList<>();
		int[][] mat = new int[n][n];
		solve(mat,n,0, result, temp);
		return result;
    }

	private static void solve(int[][] mat, int n,int col,  ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
		if(col == n) {
			result.add(new ArrayList<>(temp));return;
		}
		
		for(int row = 0; row<n;row++) {
			if(isSafeCell(row, col, mat, n)) {
				mat[row][col] = 1;
				temp.add(row+1);
				solve(mat,n,col+1, result, temp);
				mat[row][col] = 0;
				temp.remove(temp.size()-1);
			}
		}
	}

	private static boolean isSafeCell(int row, int col, int[][] mat, int n) {
		//left side
		int colIdx = col-1;
		while(colIdx >=0) {
			if(mat[row][colIdx] == 1)
				return false;
			colIdx--;
		}
		
		//diagonal upside [row-1][col-1]
		colIdx = col-1;int rowIdx = row-1;
		while(colIdx >=0 && rowIdx >=0 ) {
			if(mat[rowIdx][colIdx] == 1)
				return false;
			colIdx--;rowIdx--;
		}
		
		//diagonal downside [row+1][col-1]
		colIdx = col-1;rowIdx = row+1;
		while(colIdx >=0 && rowIdx < n ) {
			if(mat[rowIdx][colIdx] == 1)
				return false;
			colIdx--;rowIdx++;
		}
		
		return true;
	}
}
