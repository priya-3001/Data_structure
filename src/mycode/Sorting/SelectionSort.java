package mycode.Sorting;

public class SelectionSort {

	static void selectionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int min = i;
			for(int j = i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min = j;
				}
			}
			
			if(i!=min) {
				swap(arr,i,min);
			}
			
		}
	}
	
	private static void swap(int[] arr, int first, int second) {
		int tmp = arr[first];
		arr[first] = arr[second];
		arr[second] = tmp;
	}
}
