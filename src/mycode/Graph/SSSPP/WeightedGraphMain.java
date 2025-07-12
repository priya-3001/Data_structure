package mycode.Graph.SSSPP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//import mycode.Graph.GraphNode;

public class WeightedGraphMain {

	public static void main(String[] args) {
		WeightedNode g1 = new WeightedNode("A", 0);
		WeightedNode g2 = new WeightedNode("B", 1);
		WeightedNode g3 = new WeightedNode("C", 2);
		WeightedNode g4 = new WeightedNode("D", 3);
		//WeightedNode g5 = new WeightedNode("E", 4);
		//WeightedNode g6 = new WeightedNode("F", 5);
		//WeightedNode g7 = new WeightedNode("G", 6);
		
		ArrayList<WeightedNode> graphList = new ArrayList<>();
		graphList.add(g1);
		graphList.add(g2);
		graphList.add(g3);
		graphList.add(g4);
		//graphList.add(g5);
		//graphList.add(g6);
		//graphList.add(g7);
		
		/*WeightedGraph graph = new WeightedGraph(graphList);
		graph.addWeightedNode(0, 1, 2);
		graph.addWeightedNode(0, 2, 5);
		graph.addWeightedNode(1, 2, 6);
		graph.addWeightedNode(1, 3, 1);
		graph.addWeightedNode(1, 4, 3);
		graph.addWeightedNode(2, 5, 8);
		graph.addWeightedNode(2, 4, 4);
		graph.addWeightedNode(4, 6, 9);
		graph.addWeightedNode(5, 6, 7);*/
		
		WeightedGraph graph2 = new WeightedGraph(graphList);
		graph2.addWeightedNode(0, 3, 1);
		graph2.addWeightedNode(0, 1, 8);
		graph2.addWeightedNode(1, 2, 1);
		graph2.addWeightedNode(2, 0, 4);
		graph2.addWeightedNode(3, 1, 2);
		graph2.addWeightedNode(3, 2, 9);
//		System.out.println("Print dijkstra from source A");
//		graph.dijkstra(graphList.get(0));
		
		//System.out.println("Print bellman from source A");
		//graph.bellman(graphList.get(0));
		System.out.println("Print Floydd ");
		//graph2.floydd();
		//int staticvar = graph.staticVariable;
		//System.out.println(staticvar);
		
		//int[] pri = {1,2,87,87,87,2,1};
		//System.out.println(candy(pri));
		
		int[][] intervals = {
	            {4, 4},
	            {0, 1},
	            {3, 2},
	            {2, 3}
	            
	        };
		merge(intervals);
	}
	public static int[][] merge(int[][] intervals) {
        int size = intervals.length;
        int[][] result = new int[size][2];
        int index = 0;
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));
        int prevstart = intervals[0][0];
        int prevend = intervals[0][1];
        result[0][0] = prevstart;
        result[0][1] = prevend;
        for(int i = 1;i<size;i++){
        	if(prevend >= intervals[i][0] ) {
        		prevend = Math.max(prevend, intervals[i][1]);
        	}
        	else {
        		++index;
        		result[index][0] = intervals[i][0];
                result[index][1] = intervals[i][1];
        	}
        }
        
        return Arrays.copyOf(result, index + 1);
    }
	private static void updateList(int index, int start, int end, int[][] result) {
         result[index][0] = start;
         result[index][1] = end;
	}
	
	public static int candy(int[] ratings) {
		int size = ratings.length;
        int[] count = new int[size];int sum =0;
        for(int i = 0;i<size;i++) {
        	if(i-1 <0 && ratings[i] > ratings[i+1]) {
        		count[i] = 2;
        	}
        	else if(i+1 > size-1 && ratings[i-1] < ratings[i]) {
        		count[i] = 2;
        	}
        	else if(i-1 >= 0 && i+1 < size && ratings[i-1] <= ratings[i] &&  ratings[i] >= ratings[i+1]) {
        		if(count[i-1]==1)
        			count[i] = 2;
        		else
        			count[i] = 1;
        	}
        	else
        		count[i] = 1;
        }
        
        for(int i : count) {
        	sum+=i;
        }
        		return sum;
    }
	public static int lengthOfLongestSubstring(String s) {
		int max = Integer.MIN_VALUE;
		int start = 0;
		Map<Character,Integer> map = new HashMap<>();
		for(int end =0;end<s.length();end++) {
			char currChar = s.charAt(end);
			if(map.containsKey(currChar) && map.get(currChar) >=start) {
				start = map.get(currChar)+1;
			}
			map.put(currChar, end);
			max =  Math.max(max, end-start+1);
		}
		/*char[] chars = s.toCharArray();
		ArrayList<Character> visited = new ArrayList<>();
		for(int i =0;i<chars.length;i++) {
			if(visited.contains(chars[i]) ) {
				max = Math.max(max, visited.size());
				int index = visited.indexOf(chars[i]);
				visited.subList(0, index+1).clear();
				}
				visited.add(chars[i]);
		}
		max = Math.max(max, visited.size());*/
		return max;
        
    }
	 public static int hammingWeight(int n) {
	        int count = 0;

	        while(n>1){
	            int rem = n%2;
	            if(rem == 1)
	            count++;
	            n = n/2;
	        }
	        if(n==1)
	        	count++;
	        return count;
	    }
}
