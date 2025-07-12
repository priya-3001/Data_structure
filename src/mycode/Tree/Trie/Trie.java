package mycode.Tree.Trie;

public class Trie {
	
	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
		System.out.println("Trie node is created");
	}
	
	public void insert(String word) {
		TrieNode current = root;
		for(int i =0;i<word.length();i++) {
			char ch = word.charAt(i);
			TrieNode node = current.child.get(ch);
			if(node == null) {
				node = new TrieNode();
				current.child.put(ch, node);
				
			}
			
			current = node;
		}
		System.out.println("word inserted successfully");
		current.endOfString = true;
		
	}
	
	public boolean search(String word) {
		TrieNode current = root;
		for(int i =0;i<word.length();i++) {
			char ch = word.charAt(i);
			TrieNode node = current.child.get(ch);
			if(node == null) {
				System.out.println("word : "+word+" is not present ");
				return false;
			}
			current = node;
		}
		if(current.endOfString) {
			System.out.println("word : "+word+" is present ");
		}
		else {
			System.out.println("word : "+word+" is not present. But is prefix of other word ");
		}
		
		return current.endOfString;
	}

	public boolean delete(TrieNode parent, String word, int index) {
		char ch = word.charAt(index);
		TrieNode curr = parent.child.get(ch);
		boolean canDelete;
		if(curr.child.size()>1) {
			delete(curr, word, index+1);
			return false;
		}
		
		if(index == word.length()-1 ) {
			if(curr.child.size()>=1) {
				curr.endOfString = false;
			}
			else {
				parent.child.remove(ch);
				return true;
			}
		}
		
		if(curr.endOfString == true) {
			delete(curr, word,index+1);return false;
		}
		
		canDelete = delete(curr, word, index+1);
		
		if(canDelete) {
			parent.child.remove(ch);return true;
		}
		else {
			return false;
		}
	}
	
	public void delete(String word) {
		if(search(word)) {
			delete(root, word, 0);
		}
	}
}
