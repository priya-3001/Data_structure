package mycode.Queue;

public class QueueLL {

	LinkedList ll ;
	
	public QueueLL() {
		ll = new LinkedList();
	}
	
	public boolean isEmpty() {
		if(ll.head == null)
			return true;
		return false;
		
	}
	
	public void enqueue(int value) {
		if(isEmpty())
			ll.insertInLinkedList(value, 0);
		else
			ll.insertInLinkedList(value, ll.size);
		System.out.println("Insert successful " +value);
	}
	
	public int peek() {
		if(!isEmpty()) {
			return ll.head.value;
		}
		else 
			return -1;
	}
	
	public int dequeue() {
		if(isEmpty())
		{
			System.out.println("Queue is empty ");return -1;
		}
		else {
			int value = ll.head.value;
			ll.deletionOfNode(0);
			System.out.println("delete successful " +value);
			return value;
		}
	}
}
