package mycode.Sorting;

public class MergeSort {

	public void divide(int[] arr, int left, int right) {
		if(right>left) {
			int mid = (left+right)/2;//for large value for left and right use left+(right-left)/2;
			divide(arr, left, mid);
			divide(arr,mid+1,right);
			conquer(arr, left, mid, right);
		}
	}

	private void conquer(int[] arr, int left, int mid, int right) {
		int merged[] = new int[right-left+1];
		
		int idx1 = left;
		int idx2 = mid+1;
		int x =0;
		
		while(idx1<=mid && idx2<=right) {
			if(arr[idx1]>arr[idx2]) 
				merged[x++] = arr[idx2++];
			else
				merged[x++] = arr[idx1++];
		}
		
		while(idx1<=mid) {
			merged[x++] = arr[idx1++];
		}
		while(idx2<=right) {
			merged[x++] = arr[idx2++];
		}
		
		for(int i =0,j=left;i<merged.length;i++,j++) {
			arr[j] = merged[i];
		}
	}
}
