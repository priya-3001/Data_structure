package mycode.Array;

public class TwoDimArray {
	
	int[][] arr = null;

	public TwoDimArray(int row, int col) {
		arr = new int[row][col];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = Integer.MIN_VALUE;
			}
		}
	}
	
	public void insert(int row, int col, int value) {
		try {
			if(arr[row][col] == Integer.MIN_VALUE) {
				arr[row][col] = value;
				System.out.println("Inserted successfully");
			}
			else {
				System.out.println("Cell is already occupied");
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("invalid index");
		}
	}
	
	public void access(int row, int col) {
		try {
			System.out.println("value " +arr[row][col]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("invalid index");
		}
	}
	
	public void traverse() {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j] + " ");
				
			}
			System.out.println();
		}
	}
	
	public void search(int val) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == val) {
					System.out.print("Found");
					return;
				}
			}
		}
		System.out.print("Not Found");
	}
	
	public void delete(int row , int col) {
		try {
			arr[row][col] = Integer.MIN_VALUE;
			System.out.println("Deleted ");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("invalid index");
		}
	}
}
