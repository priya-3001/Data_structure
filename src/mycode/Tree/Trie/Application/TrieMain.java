package mycode.Tree.Trie.Application;

import java.util.Arrays;
import java.util.List;

public class TrieMain {

	public static void main(String[] args) {
		ReplaceWords rw = new ReplaceWords();
		String str  = "the cattle was rattled by the battery";
		List<String> list = Arrays.asList("cat","bat","rat");
		System.out.println(" Result "+ rw.replaceWords(list, str));
	}
}
