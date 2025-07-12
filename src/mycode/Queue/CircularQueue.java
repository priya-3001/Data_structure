package mycode.Queue;

public class CircularQueue {

	int[] arr;
	int beginning;
	int top;
	int size;
	public CircularQueue(int size) {
		arr = new int[size];
		beginning = -1;
		top = -1;
		this.size =size;
	}

	public boolean isEmpty() {
		if(beginning == -1)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(top == size-1 && beginning ==0)
			return true;
		else if(top==beginning-1)
			return true;
		else
			return false;
					
	}
	
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("Queue is full");
		}
		else {
			if(isEmpty())
			{
				beginning =0;
				++top;
				arr[top]=value;
				System.out.println("Value "+value+" inserted successfully");
			}
			else if(top==size-1){
				top=0;
				arr[top]=value;
				System.out.println("Value "+value+" inserted successfully");
			}
			
			else{
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
			arr[beginning]=0;
			if(beginning==top ) {
				beginning = top =-1;
			}
			else if(beginning==size-1) {
				beginning = 0;
			}
			else {
				beginning++;
			}
			System.out.println("Deleted value "+result);
			return result;
		}
	}
}
