package tutorial.linkedlist;

public class MyHashSet {
	
	    class ListNode {
	        int val;
	        ListNode next;
	        public ListNode(){}
	        public ListNode(int val){
	            this.val = val;
	        }
	    }
	    ListNode root;
	    public MyHashSet() {
	       root = null;
	    }
	    
	    public void add(int key) {
	        if(root == null)
	            root = new ListNode(key);
	        else if (!contains(key)){
	            ListNode curr = root;
	            while(curr.next!=null)
	                curr = curr.next;
	            curr.next = new ListNode(key);
	        }
	    }
	    
	    public void remove(int key) {
	        if(root == null)
	            return;

	        if(root.val == key){
	            root = root.next;return;
	        }
	         ListNode curr = root.next;
	         ListNode prev =  root;
	         while(curr!=null){
	             if(curr.val == key){
	                prev.next = curr.next;
	                 break;
	             }
	             prev = curr;
	             curr = curr.next;
	         }
	         
	    }
	    
	    public boolean contains(int key) {
	         ListNode curr = root;
	         while(curr!=null){
	            if(curr.val==key)
	                return true;
	            curr = curr.next;
	         }
	         return false;
	    }
	}

	/**
	 * Your MyHashSet object will be instantiated and called as such:
	 * MyHashSet obj = new MyHashSet();
	 * obj.add(key);
	 * obj.remove(key);
	 * boolean param_3 = obj.contains(key);
	 */

