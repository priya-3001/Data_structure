package mycode.Tree.BinaryHeap;

public class BinaryHeap {

	int arr[];
	int sizeOfArray;
	
	int swapIndex = 0;
	
	public BinaryHeap(int size) {
		arr = new int[size];
		this.sizeOfArray = 0;
		System.out.println("Created Binary Heap");
		
	}
	 
	public boolean isEmpty() {
		if(sizeOfArray==0)
			return true;
		
	return false;
	}
	
	public Integer peek() {
		if(isEmpty())
		{
			System.out.println("Node not found");
			return null;
		}
		return arr[0];
	}
	
	public Integer sizeBH(){
		return this.sizeOfArray  ;
	}
	
	public void levelOrder() 
	{
		for(int i =0;i<sizeOfArray;i++) {
			System.out.print(arr[i] + "  ");
		}
	}
	
	public void insert(int val, String type) {
		if(sizeOfArray>=arr.length)
		{
			System.out.println("BH is full");return;
		}
		arr[sizeOfArray]= val;
		heapifyBottomToTop(sizeOfArray, type);
		++sizeOfArray;
		System.out.println("value inserted");
	}
	
	public void heapifyBottomToTop(int index, String type) {
		
		if(index<=0) {
			return;
		}
		int parent = (index-1)/2;
		
		if(type == "Min") {
			
			if(arr[index] < arr[parent]) {
				swap(parent,index,arr);
			}
		}
		else if(type == "Max") {
			
			if(arr[index] > arr[parent]) {
				swap(parent,index,arr);
			}
		}
		
		heapifyBottomToTop(parent, type);
	}
	
	public int extractRoot(String type) {
		if(isEmpty()) {
			return -1;
		}
		int extractedVal = arr[0];
		arr[0] = arr[sizeOfArray-1];
		sizeOfArray--;
		heapifyTopToBottom(0, type );
		System.out.println("Extract root "+extractedVal );
		return extractedVal;
	} 
	
	private void heapifyTopToBottom(int index, String type) {
		int leftIndex = 2*index +1;
		int rightIndex = 2*index+2;
		
		if(leftIndex>sizeOfArray) {return;}
		
		if(type == "Max") {
			//if node having left child
			if(sizeOfArray ==leftIndex) {
				if(arr[index]<arr[leftIndex])
				{
					swap(index,leftIndex,arr);
				}
				return;
			}
			//with two child - find which child has max value.
			else {
				if(arr[leftIndex] < arr[rightIndex])
					swapIndex = rightIndex;
				else
					swapIndex = leftIndex;
				
				if(arr[swapIndex]>arr[index])
					swap(swapIndex,index,arr);
			}
			
			
		}
		else if(type == "Min") {
			//if node having left child
			if(sizeOfArray ==leftIndex) {
				if(arr[index]>arr[leftIndex])
				{
					swap(index,leftIndex,arr);
				}
				return;
			}
			//with two child - find which child has max value.
			else {
				if(arr[leftIndex] > arr[rightIndex])
					swapIndex = rightIndex;
				else
					swapIndex = leftIndex;
				
				if(arr[swapIndex]<arr[index])
					swap(swapIndex,index,arr);
			}
		}
		heapifyTopToBottom(swapIndex, type);
	}

	public void swap(int left, int right, int[] arr) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public void deleteBH(){
		arr = null;
		System.out.println("BH deleted successfully");
	}
	
}
