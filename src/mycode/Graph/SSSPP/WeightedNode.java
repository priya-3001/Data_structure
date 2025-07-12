package mycode.Graph.SSSPP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class WeightedNode implements Comparable<WeightedNode> {

	
	public String name;
	
	public int index;
	
	public int distance;
	
	public ArrayList<WeightedNode> neighbours = new ArrayList<>();
	
	public boolean isVisited = false;
	
	public WeightedNode parent;
	
	public Map<WeightedNode, Integer> weightMap = new HashMap<>();

	public WeightedNode(String name, int index) {
		this.name = name;
		this.index = index;
		distance = Integer.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	

	@Override
	public int compareTo(WeightedNode o) {
		// TODO Auto-generated method stub
		return this.distance - o.distance;
	}
	
}
