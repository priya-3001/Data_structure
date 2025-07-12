package mycode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class GraphUsingMatrix {
	
	ArrayList<GraphNode> nodeList = new ArrayList<>();
	int [][] matrix;
	public GraphUsingMatrix(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		matrix = new int[nodeList.size()][nodeList.size()];
	}
	
	public void addUndirectedNode(int i, int j) {
		matrix[i][j] = 1;
		matrix[j][i] = 1;
	}
	
	public void bfs() {
		for(GraphNode node : nodeList) {
			if(!node.isVisited)
				bfsVisited(node);
		}
	}
	
	private void bfsVisited(GraphNode node) {
		LinkedList<GraphNode> list = new LinkedList<>();
		list.add(node);
		while(!list.isEmpty()) {
			GraphNode currNode = list.remove(0);
			currNode.isVisited = true;
			System.out.println(currNode.name + "  ");
			ArrayList<GraphNode> neighbours = getNeighbours(currNode);
			for(GraphNode neighNode : neighbours) {
				if(!neighNode.isVisited) {
					list.add(neighNode);
					neighNode.isVisited = true;
				}
			}
		}
	}

	public void dfs() {
		for(GraphNode node : nodeList) {
			if(!node.isVisited)
				dfsVisited(node);
		}
	}
	
	
	
	private void dfsVisited(GraphNode node) {
		Stack<GraphNode> stack = new Stack<>();
		
		stack.add(node);
		while(!stack.isEmpty()) {
			GraphNode currNode = stack.pop();
			if(!currNode.isVisited) {
			currNode.isVisited = true;
			System.out.println(currNode.name + "  ");
			ArrayList<GraphNode> neighbours = getNeighbours(currNode);
			for(GraphNode neighNode : neighbours) {
				if(!neighNode.isVisited) {
					stack.add(neighNode);
					//neighNode.isVisited = true;
				}
			}
		}
		}
	}

	
	// Recursive DFS
	private void dfsVisitedRec(GraphNode node) {
		 if (node.isVisited) return;
	    node.isVisited = true;
	    System.out.println(node.name + "  ");

	    for (GraphNode neighbor : getNeighbours(node)) {
	        if (!neighbor.isVisited) {
	            dfsVisited(neighbor);  // Recursive call
	        }
	    }
	}
	private ArrayList<GraphNode> getNeighbours(GraphNode currNode) {
		ArrayList<GraphNode> neighbours = new ArrayList<>();
		int nodeIndex = currNode.index;
		for(int i = 0; i<matrix[nodeIndex].length; i++) {
		   if(matrix[nodeIndex][i]==1) {
			   neighbours.add(nodeList.get(i));
		   }
		}	   
		return neighbours;
	}

	public String toString() {
	    StringBuilder s = new StringBuilder();
	    s.append("   ");
	    for (int i = 0; i < nodeList.size(); i++) {
	      s.append(nodeList.get(i).name + " ");
	    }
	    s.append("\n");
	    for (int i = 0; i < nodeList.size(); i++) {
	      s.append(nodeList.get(i).name + ": ");
	      for (int j : matrix[i]) {
	        s.append((j) + " ");
	      }
	      s.append("\n");
	    }
	    return s.toString();
	  }
	
	public void addDirectedGraph(int i, int j) {
		matrix[i][j]=1;
	}

	public void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
	for(GraphNode neighbour : getNeighbours(node)) {
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
			for(GraphNode neighbour : getNeighbours(curr)) {
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
