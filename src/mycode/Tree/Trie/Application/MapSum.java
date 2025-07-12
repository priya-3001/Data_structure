package mycode.Tree.Trie.Application;

import java.util.*;

public class MapSum {
    
    class TrieNode{
        Map<Character, TrieNode> children;
        public int sum ;
        public TrieNode(){
            children = new HashMap<>();
            sum = 0;
        }
    }
    
    private TrieNode root;    
    private Map <String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key,0);
        map.put(key,val);
        TrieNode currNode = root;
        for(char ch : key.toCharArray()){
            TrieNode node = currNode.children.get(ch);
            if(node == null){
                node = new TrieNode();
                currNode.children.put(ch, node);
            }
            node.sum += delta;
            currNode = node;
        }
    }
    
    public int sum(String prefix) {
         TrieNode currNode = root;
         StringBuilder sb = new StringBuilder();
         sb.append('c');
        for(char ch : prefix.toCharArray()){
             TrieNode node = currNode.children.get(ch);
            if(node == null){
                return 0;
            }
            currNode = node;
        }
        return currNode.sum;
        
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */