package mycode.Sorting;

public class BubbleSort {
	
	public void bubbleSort(int[] arr) {
		int size = arr.length;
		for(int i = 0; i<size-1;i++) {
			for(int j =0; j<size-1-i; j++) {
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
			}
		}
		
	}

	private void swap(int[] arr, int first, int second) {
		int tmp = arr[first];
		arr[first] = arr[second];
		arr[second] = tmp;
	}

}
