package mycode.Graph;

import java.util.ArrayList;

public class GraphNode {
	
	public String name;
	
	public int index;
	
	public ArrayList<GraphNode> neighbours = new ArrayList<>();
	
	public boolean isVisited = false;
	
	public GraphNode parent;

	public GraphNode(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	

}
