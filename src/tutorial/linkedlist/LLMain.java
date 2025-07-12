package tutorial.linkedlist;

public class LLMain {
	
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }

	public static void main(String[] args) {
		 	
		
		//1290 : Find decimal of binary
			ListNode list = new ListNode(1);
	        list.next = new ListNode(0);
	        list.next.next = new ListNode(1);
	        
	        int res = getDecimalValue(list);
	        System.out.println("Result " + res);
	}
	
	public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
	
	public static int getDecimalValue(ListNode head) {
        ListNode curr = head;
        int num = curr.val;
        while(curr.next!=null){
            curr = curr.next;
            num = num << 1;
            num += curr.val;
        }
        return num;
    }
}
