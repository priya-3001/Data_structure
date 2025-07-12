package mycode.Tree.Trie;

public class TrieMain {
	
	public static void main(String[] args) {
		Trie tr = new Trie();
		tr.insert("API");
		tr.insert("APIS");
		tr.insert("APPLE");
		tr.delete("API");
		//tr.search("API");
	}
	
}
