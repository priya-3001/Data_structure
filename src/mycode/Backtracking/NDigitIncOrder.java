package mycode.Backtracking;

import java.util.*;

public class NDigitIncOrder {
	
	public static void main(String[] args) {
		List<Integer> result = new ArrayList<>();
		int N = 1;
		int op = 0;
		if(N==1)
			result.add(0);//for single digit add 0 also
		Ndigit(N, op, 0, result);
		System.out.println(result.toString());
	}
	private static void Ndigit(int n, int op, int start, List<Integer> result) {
		
		if(n==1 && op == 9)
			return;
		
		if(n==0) {
			result.add(op); return;
		}
		for(int i = start +1; i<=9; i++) {
			op = op * 10 + i;
			Ndigit(n-1, op, i, result);
			op = op/10;
		}
		
	}
	
}
