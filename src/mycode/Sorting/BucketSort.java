package mycode.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
	
	int[] arr;
	
	public BucketSort(int[] arr) {
		this.arr = arr;
	}
	
	public void printArray(){
		System.out.println("Array : " + Arrays.toString(arr));
	}
	
	
	public void printBuckets(ArrayList<Integer>[] buckets) {
		
		for (int i = 0 ; i<buckets.length;i++) {
			System.out.println("Print bucket : " + i);
			for (Integer value : buckets[i]) {
				System.out.print(value + " ");
			}
		}
	}
	
	public void bucketSort() {
		int numberOfBuckets = (int)Math.ceil(Math.sqrt((float)arr.length));
		
		int max = Integer.MIN_VALUE;
		for(Integer val : arr) {
			if(val > max)
				max = val;
		}
		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
		
		for(int i = 0 ; i<buckets.length;i++)
			buckets[i] = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			int bucketIndex = (int) Math.ceil(((float) arr[i] * numberOfBuckets)/(float) max );
			buckets[bucketIndex-1].add(arr[i]);
			
		}
		System.out.println("Print buckets before sort : " );
		printBuckets(buckets);
		
		for(ArrayList<Integer> bucket : buckets)
			Collections.sort(bucket);
		
		System.out.println("Print buckets after sort : " );
		printBuckets(buckets);
		
		int index =0;
		for(ArrayList<Integer> bucket : buckets) {
			for(Integer val : bucket) {
				arr[index++] = val;
			}
		}
		
		
	}

}
