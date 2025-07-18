package mycode.Sorting;

public class QuickSort {
	
	public void quickSort(int arr[], int left, int right) {
		if(left<right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
	}

	private int partition(int[] arr, int left, int right) {
		int pivot = right;
		int i = left-1;
		for(int j = left; j<=right; j++) {
			if(arr[j] <= arr[pivot]) {
				i++;
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j] = temp;
			}
		}
		return i;
	}

}
