package mycode.Leetcode;

import java.util.*;

public class DijkstraAlgo {
	    class Pair implements Comparable<Pair>{
	        int node; 
	        int dist;
	        public Pair(int node, int dist){
	            this.node = node;
	            this.dist = dist;
	        }
	        
	        public int compareTo(Pair o){
	            if(this.dist == o.dist)
	                return this.node - o.node;
	            return this.dist - o.dist;
	        }
	        
	    /*@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Pair pair = (Pair) o;
	        return this.dist == pair.dist && this.node == pair.node;
	    }*/
	    
	    @Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Pair other = (Pair) obj;
	    return node == other.node;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(node);
	}
	    }
	    
	    //Using TreeSet
	     public int[] dijkstra(int V, int[][] edges, int src) {
	          List<List<Pair>> graph = new ArrayList<>();
	          for(int i = 0; i<V ; i++)
	          graph.add(new ArrayList<>());
	          
	          for(int[] edge : edges){
	              int u = edge[0]; int v = edge[1]; int w = edge[2];
	              graph.get(u).add(new Pair(v,w));
	              graph.get(v).add(new Pair(u,w));
	          }
	          
	          int[] dist = new int[V];
	          Arrays.fill(dist, Integer.MAX_VALUE);
	          
	          dist[src] = 0;
	          TreeSet<Pair> set = new TreeSet<>();
	          set.add(new Pair(src, dist[src]));
	          while(!set.isEmpty()){
	              Pair p = set.pollFirst();
	              int currNode = p.node ;
	              int currWt = p.dist ;
	              
	              for(Pair neighbor : graph.get(currNode)){
	                  int adjNode = neighbor.node;
	                  int adjWt = neighbor.dist;
	                  if(dist[adjNode] > currWt + adjWt ){
	                      set.remove(new Pair(adjNode,adjWt));
	                      dist[adjNode] =  currWt + adjWt ;
	                      set.add(new Pair(adjNode, dist[adjNode]));
	                  }
	              }
	          }
	          return dist;
	     }
	    //Using PQ
	   /* public int[] dijkstra(int V, int[][] edges, int src) {
	        // code here
	        List<List<Pair>> graph = new ArrayList<>();
	        for(int i = 0; i<V;i++)
	            graph.add(new ArrayList<>());
	            
	        for(int[] edge : edges){
	            int u = edge[0];int v = edge[1];int w = edge[2];
	            graph.get(u).add(new Pair(v,w));
	            graph.get(v).add(new Pair(u,w));//undirected
	        }
	        
	       int[] dist = new int[V];
	       Arrays.fill(dist, Integer.MAX_VALUE);
	       
	       dist[src] = 0;
	       PriorityQueue<Pair> pq = new PriorityQueue<>();
	       pq.add(new Pair( src,dist[src]));
	    
	    while(!pq.isEmpty()){
	        int currDist = pq.peek().dist; 
	        int currNode = pq.peek().node; 
	        pq.poll();
	        List<Pair> neighbors = graph.get(currNode);
	        for(int i = 0; i<neighbors.size();i++){
	            int adjNode = neighbors.get(i).node;
	            int adjWt = neighbors.get(i).dist;
	            
	            if(dist[adjNode] > currDist+adjWt){
	                dist[adjNode] = currDist+adjWt;
	                pq.add(new Pair(adjNode, dist[adjNode]));
	            }
	        }
	    }
	    return dist;
	        
	    }*/
	}
	

