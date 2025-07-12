package mycode.Queue;

public class LinearQueueArray {
	int[] arr;
	int beginning;
	int top;
	
	public LinearQueueArray(int size) {
		arr = new int[size];
		beginning = -1;
		top = -1;
	}

	public boolean isEmpty() {
		if(beginning == -1)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(top == arr.length-1)
			return true;
		else
			return false;
					
	}
	
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("Queue is full");
		}
		else {
			if(beginning == -1)
			{
				beginning =0;
				++top;
				arr[top]=value;
				System.out.println("Value "+value+" inserted successfully");
			}
			else {
				++top;
				arr[top]=value;
				System.out.println("Value "+value+" inserted successfully");
			}
		}
	}
	
	public int peek() {
		if(isEmpty())
		{
			System.out.println("Queue is empty");return -1;
		}
		else {
			return arr[beginning];
		}
	}
	
	public int dequeue() {
		if(isEmpty())
		{
			System.out.println("Queue is empty");return -1;
		}
		else {
			int result = arr[beginning];
			beginning++;
			if(beginning>top) {
				beginning = top =-1;
			}
			System.out.println("Deleted value "+result);
			return result;
		}
	}
	
}
