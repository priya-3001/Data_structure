package mycode.Tree.Trie.Application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
	
	  class TrieNode{

	        Map<Character,TrieNode> children;
	        Boolean eof;
	        
	        public TrieNode(){
	             children = new HashMap<>();
	            eof = false;
	        }
	        
	    }
	    
	    private TrieNode root = new TrieNode();
	    
	    
	    public String replaceWords(List<String> dictionary, String sentence) {
	        for(String dic : dictionary){
	            insert(dic);
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(String str : sentence.split(" ")){
	            sb.append(getRoot(str)).append(" ");
	        }
	        
	        return sb.toString().trim();
	    }
	    
	    public String getRoot(String str){
	    	 TrieNode current = root;
	    	    StringBuilder sb = new StringBuilder();

	    	    for (char ch : str.toCharArray()) {
	    	        TrieNode node = current.children.get(ch);
	    	        if (node == null) {
	    	            return str;  // No prefix match found
	    	        }
	    	        sb.append(ch);
	    	        if (node.eof) {
	    	            return sb.toString();  // Found shortest root
	    	        }
	    	        current = node;
	    	    }

	    	    return str;
	    }
	    
	    public void insert(String word){
	        TrieNode current = root;
	        for(char ch : word.toCharArray()){
	        TrieNode node = current.children.get(ch);
	            if(node==null){
	                node = new TrieNode();
	                current.children.put(ch,node); 
	            }
	             current = node;
	        }
	        current.eof = true;
	            
	    
	    }
	    
	    
}
