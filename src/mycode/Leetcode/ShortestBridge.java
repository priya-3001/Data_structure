package mycode.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
	public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    getNodeOfFirstIsland(i, j, grid , q);
                }
        }
        }
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
            for(int i = 0; i<size;i++){
                int[] currNode = q.poll();
                for(int[] dir : direction){
                    int x = currNode[0] + dir[0];
                    int y = currNode[1] + dir[1];
                    if(x<0 || y<0 || x>=grid.length || y >= grid.length ||  grid[x][y]==2)
                        continue;
                    if(grid[x][y] == 1){ 
                        return count;
                    }
                    grid[x][y] = 1;
                }
            }
            count++;
        }
       return -1;
    }

    public void getNodeOfFirstIsland(int i , int j , int[][]grid ,Queue<int[]> q){
        if(i<0 || j<0 || i>=grid.length || j >= grid.length || grid[i][j]==0 || grid[i][j]==2)
            return;
          grid[i][j] = 2;
          q.add(new int[]{i,j});
          getNodeOfFirstIsland(i-1, j, grid , q);
          getNodeOfFirstIsland(i, j-1, grid , q);
          getNodeOfFirstIsland(i+1, j, grid , q);
          getNodeOfFirstIsland(i, j+1, grid , q);
    }

}
