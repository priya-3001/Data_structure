package tutorial.tree.BinaryHeap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MedianOfArr {
	public static void main(String[] args) {
		int[] nums = {1,4,2,3,5,0};
		//double[] res = medianSlidingWindow(nums, 4);
		//System.out.println(Arrays.toString(res));//[1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
		
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
		Comparator<Integer> comp = (o1, o2) -> o2-o1; 
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comp);
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int n : nums) {
			maxHeap.add(n);
			minHeap.add(n);
		}
		while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
		System.out.println();
		while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
	}
	
	
/* Brute - force
	 public static double[] medianSlidingWindow(int[] nums, int k) {
	        double[] result = new double[nums.length-k+1];
	        double median = 0;
	        for(int left = 0; left<=nums.length-k;left++) {
	        	int right = left+k;
	        	int[] subArr = Arrays.copyOfRange(nums, left, right);
	        	Arrays.sort(subArr);
	        	if(k%2==1) {
	        		int mid = k/2;
	        		median = subArr[mid];
	        	}
	        	else {
	        		int mid = k/2;
	        		median = ((double)subArr[mid] + (double)subArr[mid-1])/2.0;
	        	}
	        	
	        		result[left] = median;
	        }
	        return result;
	    }*/
	
	    public double[] medianSlidingWindow(int[] nums, int k) {
	        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
	        PriorityQueue<Integer> right = new PriorityQueue<>(); // Min heap
	        Map<Integer, Integer> delayed = new HashMap<>();
	        double[] result = new double[nums.length - k + 1];

	        int leftSize = 0, rightSize = 0;

	        for (int i = 0; i < nums.length; i++) {
	            int num = nums[i];

	            if (left.isEmpty() || num <= left.peek()) {
	                left.offer(num);
	                leftSize++;
	            } else {
	                right.offer(num);
	                rightSize++;
	            }

	            // Balance the heaps
	            while (leftSize > rightSize + 1) {
	                right.offer(left.poll());
	                leftSize--; rightSize++;
	            }
	            while (rightSize > leftSize) {
	                left.offer(right.poll());
	                rightSize--; leftSize++;
	            }

	            // Remove element that is out of window
	            if (i >= k) {
	                int out = nums[i - k];
	                delayed.put(out, delayed.getOrDefault(out, 0) + 1);
	                if (out <= left.peek()) leftSize--;
	                else rightSize--;

	                // Cleanup top elements
	                while (!left.isEmpty() && delayed.getOrDefault(left.peek(), 0) > 0) {
	                    int top = left.poll();
	                    delayed.put(top, delayed.get(top) - 1);
	                }
	                while (!right.isEmpty() && delayed.getOrDefault(right.peek(), 0) > 0) {
	                    int top = right.poll();
	                    delayed.put(top, delayed.get(top) - 1);
	                }
	            }

	            // Save result
	            if (i >= k - 1) {
	                if (k % 2 == 1) {
	                    result[i - k + 1] = left.peek();
	                } else {
	                    result[i - k + 1] = ((long) left.peek() + (long) right.peek()) / 2.0;
	                }
	            }
	        }

	        return result;
	    }
	}


