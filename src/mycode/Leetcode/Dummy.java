package mycode.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Dummy {

	static class Pair{
		Double key;
		int value;
		public Pair(Double k, int v) {
			this.key = k;
			this.value = v;
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		//int[] result = topKFrequent( nums, 2);
		//System.out.println(Arrays.toString(result));
		int[][] points = {{3,3},{5,-1},{-2,4}};
		//int[][] res = kClosest(points, 2);
//		for(int[] r : res) {
//			 System.out.println(Arrays.toString(r));
//		}
//		double res = Math.log10(0);
//		if(res == Double.NEGATIVE_INFINITY)
//			System.out.println(res);
//		
		  List<Integer> dist = new ArrayList<>();
/*   	Collections.fill(dist, 1);
		  Queue<Integer> ll = new LinkedList<>();
    	Stack<Integer> s = new Stack<>();
    	Queue<Integer> s1 = new LinkedList<>(); ArrayList<Integer> s2 = new ArrayList<>();
    	ArrayDeque<Integer> s3  = new ArrayDeque<>();
    	int re = kthFactor(12,3);*/
    	
    	//merge interval : 
    	int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    	int[][] result = merge(intervals);
    	for(int[] res : result)
    		System.out.println(Arrays.toString(res));
	}
	
	public static int[][] merge(int[][] intervals) {
		int size = intervals.length;
		int[][] result = new int[size][2];
		int index = 1;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]);
			}
		});
		//Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int prevstart = intervals[0][0];
		int prevend = intervals[0][1];
		result[0][0] = prevstart;
		result[0][1] = prevend;
		for (int i = 1; i < size; i++) {
			int prevIntEnd = result[index - 1][1];
			if (prevIntEnd >= intervals[i][0]) {

				prevIntEnd = Math.max(prevIntEnd, intervals[i][1]);
				result[index - 1][1] = prevIntEnd;
			} else {

				result[index][0] = intervals[i][0];
				result[index][1] = intervals[i][1];
				index++;
			}
		}

		return Arrays.copyOf(result, index);

	}
	
	    public static int kthFactor(int n, int k) {
	        List<Integer> list = new ArrayList<>();
	        for(int i = 1; i*i<=n;i++){
	            if(n%i==0){
	                list.add(i);
	                if((n/i)!=i)
	                 list.add(n/i);
	            }
	        }
	        Collections.sort(list);
	        return list.get(k-1);
	    }
	
	
	public int[] maxSubArrayWithIndices(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        int start = 0, end = 0, tempStart = 0;
        for (int i = 1; i < nums.length; i++) {
            if (currSum + nums[i] < nums[i]) {
                currSum = nums[i];
                tempStart = i;
            } else {
                currSum += nums[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{start, end, maxSum}; // Return indices and max sum
    }
	 public static int[][] kClosest(int[][] points, int k) {
		 
		 	PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Double.compare(b.key, a.key) );
		 	Double[] distance = new Double[points.length];
		 	for(int i = 0;i<points.length;i++)
		 	{
		 		double x = points[i][0];
		 		double y = points[i][1];
		 		Double dist = Math.sqrt(x*x + y*y);
		 		pq.add(new Pair(dist, i));
		 		
		 		if(pq.size()>k)
		 			pq.poll();
		 	}
		 	int[][] result = new int[k][2];int i = 0;
		 	while(!pq.isEmpty()) {
		 		Pair p = pq.poll();
		 		int index = p.value;
		 		result[i][0] = points[index][0];
		 		result[i][1] = points[index][1];
		 		i++;
		 	}
		 	
	        return result;
	    }
	
	public void frequencySort() {
		int[] nums = {1,1,1,2,2,3};
		
		Map<Integer, Integer> map = new HashMap<>();
    	map.put(1,2);
    	map.put(3,3);
    	map.put(2,3);
    	map.put(4,4);
    	
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // increasing frequency
            } else {
                return b - a;         // decreasing value
            }
        });
        
        
		
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
		 Comparator<Map.Entry<Integer, Integer>> comp = (a,b) -> {
	            if(a.getValue() != b.getValue()) return a.getValue() - b.getValue();
	            else return b.getKey() - a.getKey();
				
	            
	        };
	  
	        
	    Collections.sort(entryList , comp);
	    int[] result = new int[15];int i = 0;
	    for (Map.Entry<Integer, Integer> entry : entryList) {
	    	int key = entry.getKey();
	    	int count = entry.getValue();
	    	while(count>0) {
	    		result[i++] = key; count--;
	    	}
           
       }
	    System.out.println(Arrays.toString(result));
		
	}
	
	
	
	 public static int[] topKFrequent(int[] nums, int k) {
	        int[] result = new int[k];
	        Map<Integer,Integer> map = new HashMap<>();
	        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue() -b.getValue());
	        for(int i = 0 ; i< nums.length;i++) {
	        if(map.containsKey(nums[i])) {
	        	map.put(nums[i],  map.get(nums[i])+1);
	        }
	        else {
	        	map.put(nums[i], 1);
	        }
	        }
	        
	       
	        
	        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
	        	pq.add(m);
	        	if(pq.size()>k)
	        		pq.poll();
	        }
	        int i = 0;
	        while(!pq.isEmpty()) {
	        	result[i++] = pq.poll().getKey();
	        }
	        return result;
	    }
	
	/*static void dummy() {
    	PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> b.getKey() - a.getKey());
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, 7);
    	map.put(1,6);
    	map.put(1,8);
    	map.put(2,5);
    	map.put(2,9);
    	pq.addAll(map.entrySet());
    	/*while(!pq.isEmpty()) {
    		Map.Entry<Integer, Integer> ele = pq.poll();
    		System.out.println(" Result key " + ele.getKey() + " value "+ ele.getValue());
    	}
    	
    	PriorityQueue<Pair> pqPair = new PriorityQueue<>((a,b)-> b.key - a.key);
    	pqPair.add(new Pair(0,7));
    	pqPair.add(new Pair(1,6));
    	pqPair.add(new Pair(1,8));
    	pqPair.add(new Pair(2,5));
    	pqPair.add(new Pair(2,9));
    	
    	while(!pqPair.isEmpty()) {
    		Pair ele = pqPair.poll();
    		System.out.println(" Result key " + ele.key + " value "+ ele.value);
    	}
    	
    }*/
}
