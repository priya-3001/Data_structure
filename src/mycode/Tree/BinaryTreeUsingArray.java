package mycode.Tree;

public class BinaryTreeUsingArray {

	String[] arr;
	int lastUsedIndex;
	
	public BinaryTreeUsingArray(int size) {
		arr = new String[size+1];
		this.lastUsedIndex = 0;
		System.out.println("Binary tree is created");
	}
	
	public boolean isFull() {
		if(arr.length-1 == lastUsedIndex)
			return true;
		return false;
	}
	
	public void insert(String value) {
		if(!isFull()) {
			arr[++lastUsedIndex] = value;
			System.out.println("Value is inserted successfully");
		}
		else {
			System.out.println("Binary tree is full");
		}
	}
	
	public void preOrder(int index) {
		
		if(index > lastUsedIndex)
			return;
		System.out.print(arr[index] + "  ");
		preOrder(2*index);
		preOrder(2*index+1);
	}
	
	public void postOrder(int index) {
		
		if(index > lastUsedIndex)
			return;
		
		postOrder(2*index);
		postOrder(2*index+1);
		System.out.print(arr[index] + "  ");
	}
	
	public void inOrder(int index) {
		
		if(index > lastUsedIndex)
			return;
		
		inOrder(2*index);
		System.out.print(arr[index] + "  ");
		inOrder(2*index+1);
		
	}
	
	public void levelOrder(int index) {
		
		if(index > lastUsedIndex)
			return;
		
		for(int i = index; i<=lastUsedIndex; i++) {
			System.out.print(arr[i] + "  ");
		}
		
	}
	
	public int search(String value) {
		for(int i =1;i<lastUsedIndex;i++)
		{
			if(arr[i]==value)
			{
				System.out.println("found at location " + i);
			return i;
			}
		}
		System.out.println("not found");return -1;
	}
	
	public void deleteNode(String value) {
		int index = search(value);
		if(index == -1) {
			return;
		}
		arr[index] = arr[lastUsedIndex];
		--lastUsedIndex;
		
		System.out.println("deleted successfully");
	}
	
	public void deleteBT() {
		try {
			arr= null;
			System.out.println("Fully deleted BT successfully");
		} catch (Exception e) {
			System.out.println("Not deleted BT ");
		}
	}
	

}
