package tutorial.linkedlist;

public class MyBrowserHistory {
	class BrowserHistory {

		   class ListNode{
		        String val ;
		        ListNode prev;
		        ListNode next;
		        public ListNode(){}
		        public ListNode(String val){this.val = val;}

		    }
		 
		    private ListNode track;
		    public BrowserHistory(String homepage) {
		        track = new ListNode(homepage);
		        
		    }
		    
		    public void visit(String url) {
		        ListNode curr = track;
		        curr.next = null;

		        ListNode newNode = new ListNode(url);
		        newNode.prev = curr;
		        curr.next = newNode;
		        track = newNode;
		    }
		    
		    public String back(int steps) {
		          ListNode curr = track;
		          while(curr.prev!=null &&  steps-- > 0){
		            curr = curr.prev;
		            
		          }
		          track = curr;
		          return track.val;
		 }
		    
		    public String forward(int steps) {
		        ListNode curr = track;
		         while(curr.next!=null &&  steps-- > 0){
		            curr = curr.next;
		            
		          }
		          track = curr;
		          return track.val;
		        
		    }
		}

		/**
		 * Your BrowserHistory object will be instantiated and called as such:
		 * BrowserHistory obj = new BrowserHistory(homepage);
		 * obj.visit(url);
		 * String param_2 = obj.back(steps);
		 * String param_3 = obj.forward(steps);
		 */
}
