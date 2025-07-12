package tutorial.linkedlist;

public class MyHashMapUsingLL {
	class MyHashMap {
	    
	    class HashNode{
	        int key;
	        int value;
	        HashNode next;

	        public HashNode(){}

	        public HashNode(int key, int value){
	            this.key = key; this.value = value;
	        }

	    }
	    private HashNode root;
	    public MyHashMap() {
	        root = null;
	    }
	    
	    public void put(int key, int value) {
	        if(root == null){
	            root = new HashNode(key, value);
	        }
	        else{
	            if(containsKey(key)!=null){
	                HashNode tmp = containsKey(key);
	                tmp.value = value;
	            }
	            else{
	                HashNode curr = root;
	                while(curr.next!=null){
	                    curr = curr.next;
	                }
	                curr.next = new HashNode(key,value);
	            }
	        }
	    }

	    public HashNode containsKey(int key) {
	          HashNode curr = root;
	          while(curr!=null){
	            if(curr.key == key){
	                return curr;
	            }
	            curr = curr.next;
	          }
	          return curr;
	    }
	    
	    public int get(int key) {
	         HashNode curr = root;
	          while(curr!=null){
	            if(curr.key == key){
	                return curr.value;
	            }
	            curr = curr.next;
	          }
	          return -1;
	    }
	    
	    public void remove(int key) {
	        if(root == null)
	        return;

	        if(root.key == key){
	            root = root.next;
	            return;
	        }

	         HashNode curr = root.next;
	          HashNode prev = root;

	          while(curr!=null){
	             if(curr.key == key){
	                prev.next = curr.next;
	                break;
	             }
	             prev = curr;
	             curr = curr.next;
	          }

	    }
	}

	/**
	 * Your MyHashMap object will be instantiated and called as such:
	 * MyHashMap obj = new MyHashMap();
	 * obj.put(key,value);
	 * int param_2 = obj.get(key);
	 * obj.remove(key);
	 */
}
