package mycode.Hashing;

import java.util.LinkedList;

public class DirectChaining {

	public LinkedList<String>[] hashTable;
	public int chainingSize = 5;
	
	@SuppressWarnings("unchecked")
	public DirectChaining(int size) {
		hashTable = new LinkedList[size];
	}
	
	public int modASCII(String word, int M) {
		char[] ch = word.toCharArray();
		int sum =0;
		for(int i =0;i<word.length();i++) {
			sum += ch[i];
		}
		 return sum%M; 
	}
	
	public void insert(String word) {
		int index = modASCII(word, hashTable.length);
		 if(hashTable[index] == null) {
			 hashTable[index] = new LinkedList<>();
			 hashTable[index].add(word);
		 }
		 else {
			 hashTable[index].add(word);
		 }
		 System.out.println("Word : "+word+" Inserted successfully ");
	}
	
	public void display() {
		if(hashTable == null) {
			System.out.println("Hashtable is empty ");
		}
		else {
			System.out.println("----------Hashtable---------");
			for(int i =0;i<hashTable.length;i++) {
				System.out.println("Index : "+i+ " key : "+hashTable[i]);
			}
		}
	}
	
	public boolean search(String word) {
		int index = modASCII(word, hashTable.length);
		if(hashTable[index] != null && hashTable[index].contains(word) ) {
			System.out.println("Word is present at index "+index);return true;
		}
		else {
			System.out.println("Word is not present");return false;}
	}
	
	public void delete(String word) {
		int index = modASCII(word, hashTable.length);
		if(search(word)) {
			hashTable[index].remove(word);
		}
	}
}
