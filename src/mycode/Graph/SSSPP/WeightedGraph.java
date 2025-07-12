package mycode.Graph.SSSPP;

import java.util.ArrayList;
import java.util.PriorityQueue;

import mycode.Graph.GraphNode;

public class WeightedGraph {
	
	ArrayList<WeightedNode> nodeList = new ArrayList<>();
	
	public static int staticVariable = 10;
	int[][] v ;
	
	public WeightedGraph(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
		v = new int[nodeList.size()][nodeList.size()];
	}
	
	public void addWeightedNode(int i, int j, int weight) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.neighbours.add(second);
		first.weightMap.put(second, weight);
		
	}
	
	private void pathPrint(WeightedNode curr) {
		if(curr.parent!=null) {
			pathPrint(curr.parent);
		}
		
		System.out.print("  "+curr.name+"  ");
	}
	
	public void dijkstra(WeightedNode node) {
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		node.distance = 0;
		queue.addAll(nodeList);
		while(!queue.isEmpty()) {
			WeightedNode current = queue.remove();
			for(WeightedNode neighbour : current.neighbours) {
				if(queue.contains(neighbour)) {
					int newDistance = current.distance + current.weightMap.get(neighbour);
					if(neighbour.distance > newDistance) {
						neighbour.distance = newDistance;
						neighbour.parent = current;
						queue.remove(neighbour);
						queue.add(neighbour);
					}
				}
			}
		}
		
		for(WeightedNode nodeToVisit : nodeList) {
			System.out.print("Node " + nodeToVisit.name + " distance: "+nodeToVisit.distance + " Path : ");
			pathPrint(nodeToVisit);
			System.out.println();
		}
		
	}

	public void bellman(WeightedNode source) {
		source.distance = 0;
		for(int i =0;i<nodeList.size();i++) {
			for(WeightedNode node : nodeList) {
				for(WeightedNode neighbour : node.neighbours) {
					int newdistance = node.distance + node.weightMap.get(neighbour);
					if(neighbour.distance > newdistance) {
						neighbour.distance = newdistance;
						neighbour.parent = node;
					}
				}
			}
		}
		
		for(WeightedNode nodeToVisit : nodeList) {
			System.out.print("Node " + nodeToVisit.name + " distance: "+nodeToVisit.distance + " Path : ");
			pathPrint(nodeToVisit);
			System.out.println();
		}
		
		System.out.println("Check -ve cycle in graph");
		for(WeightedNode node : nodeList) {
			for(WeightedNode neighbour : node.neighbours) {
				int newdistance = node.distance + node.weightMap.get(neighbour);
				if(neighbour.distance > newdistance) {
					System.out.println("cycle found ");
					return;
				}
			}
		}
		
		System.out.println("Cycle not found ");
	}
	
	public void floydd() {
		int size = nodeList.size();
		
		//matrix creation
		for(int i =0;i<size;i++) {
			WeightedNode first = nodeList.get(i);
			for(int j=0;j<size;j++) {
				WeightedNode second = nodeList.get(j);
				if(i==j) {
					v[i][j] =0;
				}
				else if(first.weightMap.containsKey(second)) {
					v[i][j] = first.weightMap.get(second);
				}
				else {
					v[i][j] = Integer.MAX_VALUE/10;
				}
			}
		}
		//Find distance
		for(int k =0;k<size;k++) {
			System.out.println("Printing matrix via " + nodeList.get(k)+" ");
			for(int i =0;i<size;i++) {
				for(int j =0;j<size;j++) {
					if(v[i][j] > v[i][k] + v[k][j])
						v[i][j] = v[i][k] + v[k][j];
				}
			}
			printing();
		}
				
		//printing
		
		//printing();
	}
	public void printing() {
		int size = nodeList.size();
		for(int i =0;i<size;i++) {
			WeightedNode first = nodeList.get(i);
			System.out.println("Printing distance for node : " + first.name );
			for(int j=0;j<size;j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}
}
