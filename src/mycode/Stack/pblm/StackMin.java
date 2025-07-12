package mycode.Stack.pblm;

public class StackMin {
	 
	StackMinNode head;
	StackMinNode min;

	  public StackMin() {
	    head = null;
	    min = null;
	  }

	  public int min() {
	    if(min==null){
	        return -1;
	    }
	    else{
	        return min.value;
	    }
	  }

	  public void push(int value) {
		  StackMinNode newNode = new StackMinNode(value,null);
		  StackMinNode newMinNode = new StackMinNode(value,null);
	    if(head==null){
	        head = newNode;
	        min = new StackMinNode(value,null);
	    }
	    else{
	        newNode.next = head;
	        head = newNode;
	        if(min.value > value)
	        {
	        	newMinNode.next = min;
	        	min = newMinNode;
	        }
	        else {
	        	 StackMinNode curr = min;
	        	 while(curr.next!=null) {
	        		 curr = curr.next;
	        	 }
	        }
	    }
	  }

	  public int pop() {
	    if(head==null){
	        return -1;
	    }
	    
	    int value = head.value;
	    head = head.next;
	    return value;
	    
	  }
}
