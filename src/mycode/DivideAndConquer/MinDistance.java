package mycode.DivideAndConquer;

public class MinDistance {
	// time : 2^m+n ; space : m+n
	public int minDistance(int[][] arr, int row, int col) {
		if(row == -1 || col == -1)
			return Integer.MAX_VALUE;
		if(row == 0 && col ==0)
			return arr[0][0];
		
		int minDist1 = minDistance(arr, row, col-1);
		int minDist2 = minDistance(arr, row-1, col);
		int minDist = Integer.min(minDist1, minDist2);
		return arr[col][row] + minDist;
	}

}
