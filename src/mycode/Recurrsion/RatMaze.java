package mycode.Recurrsion;

import java.util.*;

public class RatMaze {
	    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
	    private static final int MAX = 1000000;
	    private List<List<int[]>> allPaths = new ArrayList<>();

	    static class Tuple{
	    	String name; 
	    	int xDir; 
	    	int yDir; 
	    	public Tuple(String name, int x, int y) {
	    		this.name = name;
	    		this.xDir = x;this.yDir = y;
	    	}
	    	public String toString() {
				return name;
	    		
	    	}
	    }
	    public static void main(String[] args) {
	    	int mat[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
	    	ArrayList<String> result = ratInMaze(mat);
	    	System.out.println(result.toString());
		}
	    public static ArrayList<String> ratInMaze(int[][] maze) {
	    	
	    	//0 - blocked, 1 - not blocked
	    	List<Tuple> visited = new ArrayList<>();
	    	List<List<Tuple> > result = new ArrayList<>();
	    	ArrayList<String> resultPath = new ArrayList<>(); 
	    	List<Tuple> dirs = new ArrayList<>();
	    	dirs.add(new Tuple("U", -1, 0));dirs.add(new Tuple("D", 1, 0));
	    	dirs.add(new Tuple("L", 0, -1));dirs.add(new Tuple("R", 0, 1));
	    	if(maze[0][0] == 1) {
	    	//maze[0][0] = 0;
	    	dfs(maze, 0, 0 , visited,  result , dirs);
	    	}
	    	for(List<Tuple> visitedPath : result) {
	    		StringBuilder sb = new StringBuilder();
	    	    for (Tuple step : visitedPath) {
	    	        sb.append(step.name); // append direction only
	    	    }
	    	    resultPath.add(sb.toString());
	    	}
	    	Collections.sort(resultPath);
	    	return resultPath;
	        // code here
	        
	    }
	    private static void dfs(int[][] maze, int x, int y, List<Tuple> visited,  List<List<Tuple>> result, List<Tuple> dirs) {
	    	if(x == maze.length-1 && y == maze.length-1) {
	    		result.add(new ArrayList<>(visited));
	    		return;
	    	}
	    	
	    	for(Tuple dir: dirs) {
	    		int newx = x + dir.xDir;
	    		int newy = y + dir.yDir;
	    		if(newx>=0 && newx < maze.length && newy>=0 && newy < maze.length 
	    				&& maze[newx][newy] != 0) {
	    			maze[x][y] = 0;
	    			visited.add(dir);
	    			dfs(maze, newx, newy, visited, result, dirs);
	    			//backtrack 
	    			maze[newx][newy] = 1;
	    			visited.remove(visited.size()-1);
	    		}
	    	}
	    	
		}
		public List<List<int[]>> findAllPaths(int[][] blocked, int[] source, int[] target) {
	        Set<String> blockedSet = new HashSet<>();
	        for (int[] b : blocked) {
	            blockedSet.add(b[0] + "," + b[1]);
	        }

	        Set<String> visited = new HashSet<>();
	        List<int[]> currentPath = new ArrayList<>();

	        dfs(source[0], source[1], target, blockedSet, visited, currentPath);

	        return allPaths;
	    }

	    private void dfs(int x, int y, int[] target, Set<String> blockedSet,
	                     Set<String> visited, List<int[]> currentPath) {
	        if (x < 0 || x >= MAX || y < 0 || y >= MAX) return;

	        String key = x + "," + y;
	        if (blockedSet.contains(key) || visited.contains(key)) return;

	        visited.add(key);
	        currentPath.add(new int[]{x, y});

	        if (x == target[0] && y == target[1]) {
	            // Found a complete path — add a copy of it
	            allPaths.add(new ArrayList<>(currentPath));
	        } else {
	            for (int[] d : DIRS) {
	                dfs(x + d[0], y + d[1], target, blockedSet, visited, currentPath);
	            }
	        }

	        // Backtrack
	        visited.remove(key);
	        currentPath.remove(currentPath.size() - 1);
	    }
}

