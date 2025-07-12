package mycode.Array;

import java.util.Arrays;

public class ArrayMain {
	public static void main(String[] args) {
		/*SingleDimension sda = new SingleDimension(3);
		sda.insert(0, 10);
		sda.insert(1, 20);
		sda.insert(2, 30);
		sda.insert(3, 40);
		System.out.println(" Array " + Arrays.toString(sda.arr));*/
		
		int[][] s2d = new int[3][2];
		s2d[0][0]= 1;
		s2d[0][1]= 2;
		s2d[1][0]= 3;
		s2d[1][1]= 4;
		s2d[2][0]= 5;
		s2d[2][1]= 6;
		
		TwoDimArray sda2 = new TwoDimArray(3,2);
		sda2.insert(0, 0, 1);
		sda2.insert(0, 1, 2);
		sda2.insert(1, 0, 3);
		sda2.insert(1, 1, 4);
		sda2.insert(2, 0, 5);
		sda2.insert(2, 1, 6);
		
		System.out.println(Arrays.deepToString(sda2.arr));
		sda2.access(0, 4);
		sda2.access(0, 1);
		
		sda2.traverse();
		sda2.search(3);
		sda2.search(9);
		sda2.delete(0, 0);
		sda2.traverse();
	}
	
}
