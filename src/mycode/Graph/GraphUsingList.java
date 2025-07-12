package mycode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphUsingList {
	
	ArrayList<GraphNode> nodeList = new ArrayList<>();

	public GraphUsingList(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void addUndirectedNode(int i, int j) {
		nodeList.get(i).neighbours.add(nodeList.get(j));
		nodeList.get(j).neighbours.add(nodeList.get(i));
		
	}
	
	public void bfs() {
		for(GraphNode node : nodeList) {
			if(!node.isVisited) {
			bfsVisit(node);}
		}
	}
	private void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(node);
		node.isVisited = true;
		while(!queue.isEmpty()) {
			
			GraphNode currNode = queue.remove(0);
			System.out.println(currNode.name);
			for(GraphNode nei : currNode.neighbours) {
				if(!nei.isVisited) {
					queue.add(nei);
					nei.isVisited = true;
				}
			}
		}
		
	}
	
	public void dfs() {
		for(GraphNode node : nodeList) {
			if(!node.isVisited) {
			dfsVisit(node);}
		}
	}
	 
	private void dfsVisit(GraphNode node) {
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);
		//node.isVisited = true;
		while(!stack.isEmpty()) {
			GraphNode currNode = stack.pop();
			if(!currNode.isVisited) {
			currNode.isVisited = true;
			System.out.println(currNode.name);
			for(GraphNode nei : currNode.neighbours) {
				if(!nei.isVisited) {
					stack.add(nei);
					//nei.isVisited = true;
				}
			}
		}
		}
	}

	public String toString() {
	    StringBuilder s = new StringBuilder();
	    for (int i = 0; i < nodeList.size(); i++) {
	      s.append(nodeList.get(i).name + ": ");
	      for (int j =0; j < nodeList.get(i).neighbours.size(); j++) {
	        if (j == nodeList.get(i).neighbours.size()-1 ) {
	          s.append((nodeList.get(i).neighbours.get(j).name) );
	        } else {
	          s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
	        }
	      }
	      s.append("\n");
	    }
	    return s.toString();
	  }
	
	public void addDirectedGraph(int i, int j) {
			nodeList.get(i).neighbours.add(nodeList.get(j));
	}
	
	public void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for(GraphNode neighbour : node.neighbours) {
			if(!neighbour.isVisited) {
				topologicalVisit(neighbour, stack);
			}
		}
		
		node.isVisited = true;
		stack.add(node);
	}
	public void topologicalSort() {
		Stack<GraphNode> stack = new Stack<>();
		for(GraphNode node : nodeList) {
			if(!node.isVisited) {
				topologicalVisit(node, stack);
			}
		}
		System.out.print("Topological sort ");
		while(!stack.isEmpty()) {
			System.out.print(" "+ stack.pop().name+" ");
		}
	}
	
	//SSSPP - BFS
	

	public void bfsSSSPVisit(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode curr = queue.remove();
			curr.isVisited = true;
			System.out.print("Path for "+ curr.name  +" : ");
			pathPrint(curr);
			System.out.println();
			for(GraphNode neighbour : curr.neighbours) {
				if(!neighbour.isVisited) {
					neighbour.isVisited = true;
					neighbour.parent = curr;
					queue.add(neighbour);
				}
			}
		}
	}

	private void pathPrint(GraphNode curr) {
		if(curr.parent!=null) {
			pathPrint(curr.parent);
		}
		
		System.out.print("  "+curr.name+"  ");
	}
	
}
