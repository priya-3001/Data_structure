package mycode.Leetcode;

import java.util.*;

public class HighFive {
	
	public static void main(String[] args) {
		int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		int[][] result = highFive(items);
		for(int[] res: result) {
			System.out.println(Arrays.toString(res));
		}
	}
	
	 public static int[][] highFive(int[][] items) {

	        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
	        for(int[] item : items){
	            int id = item[0];
	            int mark = item[1];
	            PriorityQueue<Integer> marklist = map.getOrDefault(id, new PriorityQueue<>());
	            marklist.add(mark);
	            if(marklist.size() > 5)
	            	marklist.poll();
	            map.put(id, marklist);
	        }
	        int size = map.size();int i = 0;
	        int[][] result = new int[size][2];
	        for(Map.Entry<Integer, PriorityQueue<Integer>> entry :map.entrySet()) {
	        	int id = entry.getKey();
	        	PriorityQueue<Integer> marklist = entry.getValue();
	        	int sum = 0;
	        	while(!marklist.isEmpty())
	        		sum += marklist.poll();
	        	int avg = sum/5;
	        	result[i++] = new int[]{id, avg};
	        }
	        return result;
	    }

}
