package mycode.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DetectCycleInUndirectedGraph {
	
	public static void main(String[] args) {
		int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
		System.out.println("Result " + isCycle(4,edges));
	}
	
	static class Pair{
		Integer node; 
		Integer parent;
		
		public Pair(Integer node, Integer parent) {
			this.node = node;
			this.parent = parent;
		}
	}
	
	 public static boolean isCycle(int V, int[][] edges) {
	        List<List<Integer>> graph = new ArrayList<>(V);
	        boolean[] visited = new boolean[V];
	        Boolean result = false;
	        
	        for (int i = 0; i < V; i++) {
	            graph.add(new ArrayList<>());
	        }

	        // Build undirected graph
	        for (int[] edge : edges) {
	            graph.get(edge[0]).add(edge[1]);
	            graph.get(edge[1]).add(edge[0]); // undirected
	        }
	        
	        for(int i = 0; i<V;i++) {
	        	if(!visited[i]) {
		        	 if (checkCycle(i, V, graph, visited)) {
	                return true;
	            }	        }
	        
	       
	    }
	        return result;
	 }

	private static Boolean checkCycle(int i, int v, List<List<Integer>> graph, boolean[] visited) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(i, -1));
		visited[i] = true;
		while(!queue.isEmpty()) {
			Integer node = queue.peek().node;
			Integer parentNode = queue.peek().parent;
			
			queue.poll();
			
			List<Integer> neighbours = graph.get(node);
			for(Integer neighbour : neighbours) {
				if(!visited[neighbour]) {
					visited[neighbour] = true;
					queue.add(new Pair(neighbour,node));
				}
				else {
					if(neighbour!= parentNode)
						return true;
				}
			}
		}
		 
		return false;
	}

	
}
