package mycode.Recurrsion;

import java.util.*;

public class ValidParenthesis {
	public static void main(String[] args) {
		int n = 3;
		List<String> strList = new ArrayList<>();
		//solve(n, 0, 0 , "", strList);
		//System.out.println(strList.toString());
		
		List<String> output = NBitBinary(3);
		System.out.println(output.toString());
	}

	private static void solve(int n, int open, int close, String op, List<String> res) {
		if(op.length() == 2*n) {
			res.add(op);return;
		}
		if(open < n) {
			solve(n, open+1, close , op+"(", res);
		}
		 if(close<open){
			 solve(n, open, close+1 , op+")", res);
		}
	}
	
	private static List<String> NBitBinary(int N) {
		 List<String> output = new ArrayList<>();
		 solveNBinary(N, 0, 0,"",output);
		 return output;
    }

	private static void solveNBinary(int N, int one, int zero, String op, List<String> output) {
		if(op.length() == N) {
			output.add(op); return;
		}
		if(one < N ) {
			String op1 = op+"1"; solveNBinary(N, one+1, zero,op1,output);
		}
		if(zero < one) {
			String op2 = op+"0";solveNBinary(N,one, zero+1,op2,output);
		}
	}

}
