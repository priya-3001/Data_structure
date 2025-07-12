package mycode.Tree.Trie;
/*
public class Trie_Single_Class {
	
	//class Trie_Single_Class {
	    
	    class TrieNode {
	    public Map<Character, TrieNode> children;
	        public boolean endOfString;
	        
	        public TrieNode(){
	            children  = new HashMap<>(); 
	            endOfString = false;
	        }
	        
	    
	    // you might need some extra values according to different cases
	    };
	    
	    TrieNode root ;
	       
	    public Trie() {
	            root = new TrieNode();
	    }
	    
	    public void insert(String word) {
	        TrieNode currentNode = root;
	        for(int i = 0; i< word.length(); i++){
	        char ch =  word.charAt(i);
	            TrieNode node = currentNode.children.get(ch);
	            if(node==null){
	                node = new TrieNode();
	                currentNode.children.put(ch, node);
	            }
	            currentNode = node;
	            
	        }
	        currentNode.endOfString = true;
	       
	    }
	    
	    public boolean search(String word) {
	        TrieNode currentNode = root;
	        for(int i = 0; i< word.length(); i++){
	        char ch =  word.charAt(i);
	            TrieNode node = currentNode.children.get(ch);
	            if(node==null){
	                return false;
	            }
	            else{
	                currentNode = node;
	            }
	        }
	        return currentNode.endOfString;
	        
	        
	    }
	    
	    public boolean startsWith(String prefix) {
	        TrieNode currentNode = root;
	        for(int i = 0; i< prefix.length(); i++){
	        char ch =  prefix.charAt(i);
	            TrieNode node = currentNode.children.get(ch);
	            if(node==null){
	                return false;
	            }
	            else{
	                currentNode = node;
	            }
	        }
	        return true;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */

//}*/
