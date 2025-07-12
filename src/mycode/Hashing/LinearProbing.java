package mycode.Hashing;

import java.util.ArrayList;

public class LinearProbing {

	String[] hashTable;
	
	int usedCell;
	
	public LinearProbing(int size) {
		hashTable = new String[size];
		usedCell = 0;
	}
	
	public double loadFactor() {
		return usedCell *1.0/hashTable.length;
	}
	
	public int modASCII(String word, int M) {
		char[] ch = word.toCharArray();
		int sum =0;
		for(int i =0;i<word.length();i++) {
			sum += ch[i];
		}
		 return sum%M; 
	}
	
	public void rehashFun(String word) {
		ArrayList<String> data = new ArrayList<>();
		
		for(String s : hashTable)
			data.add(s);
		
		data.add(word);
		hashTable = new String[2*hashTable.length];
		
		for(String str : data)
			insert(str);
		
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
	
	 
	
	public void insert(String word) {
		Double lf = loadFactor();
		if(lf>=0.75) {
			rehashFun(word);
		}
		else {
			int index = modASCII(word, hashTable.length);
			for(int i=index;i<index+hashTable.length;i++) {
				int newIndex = i % hashTable.length;
				if(hashTable[newIndex] ==null) {
					hashTable[newIndex] = word;
					System.out.println(word+ " word  is inserted successfully at  "+newIndex);break;
				}
				else {
					System.out.println(newIndex+ " index  is occupied checking for other space  ");
				}
			}
		}
		usedCell++;
	}
	
	public boolean search(String word) {
		int index = modASCII(word, hashTable.length);
		for(int i=index;i<index+hashTable.length;i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex]!=null && hashTable[newIndex].equals(word)) {
				System.out.println(word+ " word  is present at  "+newIndex);
				return true;
			}
		}
		
		System.out.println(word+ " word  is not present ");
		return false;
	}
	
	public void delete(String word) {
		int index = modASCII(word, hashTable.length);
		for(int i=index;i<index+hashTable.length;i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex]!=null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex]=null;
				System.out.println(word+ " word  is deleted from  "+newIndex);
				return ;
			}
		}
	}
}
