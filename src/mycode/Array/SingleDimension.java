package mycode.Array;

public class SingleDimension {
	
	int[] arr = null;
	
	public SingleDimension(int size) {
		arr = new int[size];
		for(int i=0;i<size;i++)
			arr[i] =Integer.MIN_VALUE;
		System.out.println("Successfully created");
	}

	public void insert( int index,int value) {
		try {
			if(arr[index]==Integer.MIN_VALUE)
				arr[index]=value;
			System.out.println("Successfully inserted");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index");
		}
	}
	
	public void search(int value) {
		
		
	}
}
