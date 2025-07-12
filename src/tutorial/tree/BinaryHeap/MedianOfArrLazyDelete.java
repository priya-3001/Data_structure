package tutorial.tree.BinaryHeap;
import java.util.*;

public class MedianOfArrLazyDelete {
	
	class Solution {
	    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    private Map<Integer, Integer> delayed = new HashMap<>();
	    private int maxHeapSize = 0, minHeapSize = 0;

	    public double[] medianSlidingWindow(int[] nums, int k) {
	        int n = nums.length;
	        double[] result = new double[n - k + 1];
	        int left = 0;

	        for (int right = 0; right < n; right++) {
	            add(nums[right]);

	            if (right - left + 1 == k) {
	                // Save median
	                result[left] = getMedian(k);
	                // Remove element going out of window
	                remove(nums[left]);
	                left++;
	            }
	        }
	        return result;
	    }

	    private void add(int num) {
	        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
	            maxHeap.offer(num);
	            maxHeapSize++;
	        } else {
	            minHeap.offer(num);
	            minHeapSize++;
	        }
	        balance();
	    }

	    private void remove(int num) {
	        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

	        if (num <= maxHeap.peek()) {
	            maxHeapSize--;
	        } else {
	            minHeapSize--;
	        }

	        clean(maxHeap);
	        clean(minHeap);
	        balance();
	    }

	    private void balance() {
	        // Balance the sizes of the two heaps
	        if (maxHeapSize > minHeapSize + 1) {
	            minHeap.offer(maxHeap.poll());
	            maxHeapSize--;
	            minHeapSize++;
	            clean(maxHeap);
	        } else if (minHeapSize > maxHeapSize) {
	            maxHeap.offer(minHeap.poll());
	            minHeapSize--;
	            maxHeapSize++;
	            clean(minHeap);
	        }
	    }

	    private void clean(PriorityQueue<Integer> heap) {
	        while (!heap.isEmpty()) {
	            int top = heap.peek();
	            if (delayed.containsKey(top)) {
	                delayed.put(top, delayed.get(top) - 1);
	                if (delayed.get(top) == 0) delayed.remove(top);
	                heap.poll();
	            } else {
	                break;
	            }
	        }
	    }

	    private double getMedian(int k) {
	        if (k % 2 == 1) {
	            return (double) maxHeap.peek();
	        } else {
	            return ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;
	        }
	    }
	}

}
