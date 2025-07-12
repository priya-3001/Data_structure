package mycode.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingMain {

	
	
	public static void main(String[] args) {
		int[] arr = {4,13,-20,1,5,9,2,25,16};
		String s = "Eevance session 2";
		//s.trim();
		int n = arr.length;
		QuickSort qs = new QuickSort();
		System.out.println("Before sort : " + Arrays.toString(arr));
		qs.quickSort(arr, 0, arr.length-1);
		System.out.println("After sort : " + Arrays.toString(arr));
		int i=0;
		char[] chrArr = s.toCharArray();
		for( char chr : chrArr ) {
			if((i%2!=0 ) && (chr=='a' || chr=='e' || chr=='i' || chr=='o' || chr=='u'
					|| chr=='A' || chr=='E' || chr=='I' || chr=='O' || chr=='U'))
			{
				chr='*';
				
			}
			if(chr == ' ') {
				continue;
			}
			
			i=i+1;
		}
		System.out.println(chrArr);
		/*System.out.println("Before sort : " + Arrays.toString(arr));
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort(arr);*/
		//InsertionSort.insertionSort(arr);
	//	SelectionSort.selectionSort(arr);
	//	System.out.println("After sort : " +  Arrays.toString(arr));
		
		/*BucketSort bs = new BucketSort(arr);
		bs.bucketSort();
		System.out.println();
		bs.printArray();*/
		
		/*String st= "eremalayalamff";
		
		System.out.println(palindrome(st));
		System.out.println("Before sort : " + Arrays.toString(arr));
		MergeSort ms = new MergeSort();
		ms.divide(arr, 0, arr.length-1);
		
		System.out.println("After sort : " + Arrays.toString(arr));*/
		
	}

	public static String palindrome(String str) {
		for (int i=0;i<str.length();i++) {
			for(int j =str.length()-1;j>i;j--) {
				String subString = str.substring(i,j);
				StringBuilder reverseinput = new StringBuilder();
				reverseinput.append(subString);
				reverseinput.reverse();
			        if(subString.equals(reverseinput))
			        	return subString;
			}
		}
		return null;
	}
}