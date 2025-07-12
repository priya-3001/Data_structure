package tutorial.linkedlist;

import java.util.*;

public class LRUCache {

    class ListNode{
        int val;
        int key;
        ListNode prev, next;
        public ListNode(){}
        public ListNode(int key, int value){this.key = key; this.val = value;}
        
    }

    Map<Integer, ListNode> map ;
    ListNode head, tail;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
       
    }
    
    public int get(int key) {
        ListNode curr = map.get(key);
        int result = -1;
        if(curr != null){
        result = curr.val;
        remove(curr);
        insertInFront(key,result);
       }
        return result;
    }

     public void remove(ListNode node) {
        map.remove(node.key);
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
         node.prev = null;
        node.next = null;
     }

     public void insertInFront(int key, int value) {
        
        ListNode newNode = new ListNode(key, value);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
         map.put(key,newNode);
     }

    
    public void put(int key, int value) {

      

        if(map.containsKey(key)){
          remove(map.get(key));
           
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insertInFront(key,value);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
