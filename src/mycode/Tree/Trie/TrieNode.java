package mycode.Tree.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public Map<Character,TrieNode> child;
	public boolean endOfString;
	
	public TrieNode() {
		child = new HashMap<>();
		endOfString = false;
	}

}
