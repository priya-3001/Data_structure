package mycode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphMain {
	
	

	public static void main(String[] args) {
		GraphNode g1 = new GraphNode("A", 0);
		GraphNode g2 = new GraphNode("B", 1);
		GraphNode g3 = new GraphNode("C", 2);
		GraphNode g4 = new GraphNode("D", 3);
		GraphNode g5 = new GraphNode("E", 4);
		GraphNode g6 = new GraphNode("F", 5);
		GraphNode g7 = new GraphNode("G", 6);
		GraphNode g8 = new GraphNode("H", 7);
		
		ArrayList<GraphNode> graphList = new ArrayList<>();
		graphList.add(g1);
		graphList.add(g2);
		graphList.add(g3);
		graphList.add(g4);
		graphList.add(g5);
		graphList.add(g6);
		graphList.add(g7);
		//graphList.add(g8);
		GraphUsingMatrix gMatrix = new GraphUsingMatrix(graphList);
		GraphUsingList gList = new GraphUsingList(graphList);
		
		/*gMatrix.addUndirectedNode(0, 1);
		gMatrix.addUndirectedNode(0, 2);
		gMatrix.addUndirectedNode(2, 3);
		gMatrix.addUndirectedNode(2, 4);
		gMatrix.addUndirectedNode(4, 5);
		gMatrix.addUndirectedNode(5, 6);
		gMatrix.addUndirectedNode(3, 5);
		gMatrix.addUndirectedNode(1, 3);
		gMatrix.addUndirectedNode(1, 6);
		
		gList.addUndirectedNode(0, 1);
		gList.addUndirectedNode(0, 2);
		gList.addUndirectedNode(2, 3);
		gList.addUndirectedNode(2, 4);
		gList.addUndirectedNode(4, 5);
		gList.addUndirectedNode(5, 6);
		gList.addUndirectedNode(3, 5);
		gList.addUndirectedNode(1, 3);
		gList.addUndirectedNode(1, 6);*/
		
		//topological sort
		
		/*gMatrix.addDirectedGraph(0, 2);
		gMatrix.addDirectedGraph(2, 4);
		gMatrix.addDirectedGraph(4, 7);
		gMatrix.addDirectedGraph(4, 5);
		gMatrix.addDirectedGraph(5, 6);
		gMatrix.addDirectedGraph(1, 2);
		gMatrix.addDirectedGraph(1, 3);
		gMatrix.addDirectedGraph(3, 5);
		
		gList.addDirectedGraph(0, 2);
		gList.addDirectedGraph(2, 4);
		gList.addDirectedGraph(4, 7);
		gList.addDirectedGraph(4, 5);
		gList.addDirectedGraph(5, 6);
		gList.addDirectedGraph(1, 2);
		gList.addDirectedGraph(1, 3);
		gList.addDirectedGraph(3, 5);
		
		
		gList.topologicalSort();
		gMatrix.topologicalSort();*/
		//System.out.println(" Graph using List\n " + gList.toString());
		//gMatrix.dfs();
		//System.out.println(" Graph using Matrix \n" + gMatrix.toString());
		//gMatrix.bfs();
		
		//BFS - SSSPP
		
		/*gList.addUndirectedNode(0, 1);
		gList.addUndirectedNode(0, 2);
		gList.addUndirectedNode(1, 3);
		gList.addUndirectedNode(1, 6);
		gList.addUndirectedNode(2, 3);
		gList.addUndirectedNode(2, 4);
		gList.addUndirectedNode(3, 5);
		gList.addUndirectedNode(4, 5);
		gList.addUndirectedNode(5, 6);
		gList.bfsSSSPVisit(graphList.get(0));*/
		
		gMatrix.addUndirectedNode(0, 1);
		gMatrix.addUndirectedNode(0, 2);
		gMatrix.addUndirectedNode(1, 3);
		gMatrix.addUndirectedNode(1, 6);
		gMatrix.addUndirectedNode(2, 3);
		gMatrix.addUndirectedNode(2, 4);
		gMatrix.addUndirectedNode(3, 5);
		gMatrix.addUndirectedNode(4, 5);
		gMatrix.addUndirectedNode(5, 6);
		gMatrix.bfsSSSPVisit(graphList.get(0));
		
		//
		/*char[][] arr =  {
		                {'1','1','1','1','0'},
		                {'1','1','0','1','0'},
		                {'1','1','0','0','0'},
		                {'0','0','0','0','0'}
		              };
		
		GraphMain main = new GraphMain();
		System.out.println("Num of island "+main.numIslands(arr));*/
		
	}
	
	 public int orangesRotting(int[][] grid) {
		  int result =-1;
	        Queue<int[]> queue = new LinkedList<>();
	        int row = grid.length;
	        int col = grid[0].length;
	        
	        for(int i = 0; i < row;i++) {
	        	for(int j = 0; j<col;j++) {
	        		if(grid[i][j]==2)
	        			queue.add(new int[] {i,j});
	        	}
	        }
	        
	        while(!queue.isEmpty()) {
	        	int n = queue.size();
	        	result++;
	        	for(int k =0;k<n;k++) {
	        		int[] index = queue.poll();
	        		int i = index[0];
	        		int j = index[1];
	        		//down
	        		if(j+1 < col && grid[i][j+1] == 1) {
	        			grid[i][j+1] = 2;
	        			queue.add(new int[] {i,j+1});
	        		}
	        		//up
	        		if(j-1 >=0  && grid[i][j-1] == 1) {
	        			grid[i][j-1] = 2;
	        			queue.add(new int[] {i,j-1});
	        		}
	        		//left
	        		if(i-1  >=0 && grid[i-1][j] == 1) {
	        			grid[i-1][j] = 2;
	        			queue.add(new int[] {i-1,j});
	        		}
	        		//right
	        		if(i+1 < row && grid[i+1][j] == 1) {
	        			grid[i+1][j] = 2;
	        			queue.add(new int[] {i+1,j});
	        		}
	        	}
	        	
	        }
	        for(int i = 0; i < row;i++) {
	        	for(int j = 0; j<col;j++) {
	        		if(grid[i][j]==1)
	        			return -1;
	        	}
	        }
	        
	        return Math.max(0, result);
	  }
	 
	 public int numIslands(char[][] grid) {
	       int res = 0;
	       
	       int row = grid.length;
	       int col = grid[0].length;
	        
	        for(int i = 0; i < row;i++) {
	        	for(int j = 0; j<col;j++) {
	        		if(grid[i][j]=='1') {
	        			grid[i][j]='0';
	        			res++;
	        			island(i, j,grid);
	        	}
	        }
	        }
	        
	       return res;
	    }

	private void island(int a, int b, char[][] grid ) {
		int row = grid.length;
	    int col = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a,b});
		 while(!queue.isEmpty()) {
	        	
	        		int[] index = queue.poll();
	        		int i = index[0];
	        		int j = index[1];
	        		//down
	        		if(j+1 < col && grid[i][j+1] == '1') {
	        			grid[i][j+1] = '0';
	        			queue.add(new int[] {i,j+1});
	        		}
	        		//up
	        		if(j-1 >=0  && grid[i][j-1] == '1') {
	        			grid[i][j-1] = '0';
	        			queue.add(new int[] {i,j-1});
	        		}
	        		//left
	        		if(i-1  >=0 && grid[i-1][j] == '1') {
	        			grid[i-1][j] = '0';
	        			queue.add(new int[] {i-1,j});
	        		}
	        		//right
	        		if(i+1 < row && grid[i+1][j] == '1') {
	        			grid[i+1][j] = '0';
	        			queue.add(new int[] {i+1,j});
	        		}
	        	}
	        	
	        }
	
}
