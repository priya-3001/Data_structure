package mycode.Recurrsion;

import java.util.*;

public class WordBreak2 {
	static class TrieNode{
	        Map<Character, TrieNode> children = new HashMap<>();
	        Boolean eof = false;
	    }

	    public static TrieNode root = new TrieNode();
	   
	    public static void add(String word){
	        TrieNode current = root;
	        for(char ch : word.toCharArray()){
	           TrieNode node = current.children.get(ch);
	           if(node == null){
	            node = new TrieNode();
	            current.children.put(ch, node);
	           }
	           current = node;
	        }
	        current.eof = true;
	    }
	    public static List<String> wordBreak(String s, List<String> wordDict) {
	         for(String word : wordDict)
	            add(word);
	        List<String> list = new ArrayList<>();
	        StringBuilder sb = new StringBuilder();
	        dfs(s, 0,  sb, list);
	        return list;
	    }

	    public static void dfs(String s , int idx,  StringBuilder sb, List<String> list){
	        if(idx == s.length()){
	            list.add(sb.toString().trim());
	            return ;
	        }
	           
	        TrieNode curr = root;
	        for(int i = idx; i<s.length();i++){
	            char ch = s.charAt(i);
	        TrieNode node = curr.children.get(ch);
	        if(node == null)
	            break;

	        curr = node;
	        if(curr.eof){
	        	String str = s.substring(idx, i+1);
	            sb.append(str); sb.append(" ");
	            dfs(s, i+1,  sb, list);
	           sb.setLength(sb.length()-(1+str.length()));

	        }

	        }
	    }

	   
	public static void main(String[] args) {
		String s = "pineapplepenapple";
		List<String> wordDict = Arrays.asList("apple","pen","applepen","pine","pineapple");
		List<String> result = wordBreak(s, wordDict);
		System.out.println("Result "+ result.toString());
	}
}
