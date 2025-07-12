package mycode.Recurrsion;

import java.util.*;

public class ArrStringSubsetRecurrsion {
 
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	      ArrayList<Integer> li = new ArrayList<>();
	      /*solve(arr, 0, result, li);
	      for(ArrayList<Integer> list : result)
	    	  System.out.println(list.toString());*/
	      
	      //Subset/Subsequence of string 
	      String s = "a1B2";
	      List<String> strResult = new ArrayList<>();
	     /* solve(s, 0, " ", strResult);
	      for(String str : strResult)
	    	  System.out.println(str);*/
	      
	      //Substring in str 
	     /* solve(s, 0, 0, strResult);
	      for(String str : strResult)
	    	  System.out.println(str);*/
	      
	      //Permutation with space
	      //ip : s = "abc" o/p : [abc, a_bc, a_b_c, ab_c]
	     // solveWithSpace(s, 0,"", strResult);
	      //System.out.println(strResult.toString());
	      
	      //
	      
	    //Permutation with  cases
	      //ip : s = "abc" o/p : [abc, abC, aBc, aBC, Abc, AbC, ABc, ABC]
	     // solveWithCase(s, 0,s, strResult);
	     // System.out.println(strResult.toString());
	      
	      //
	      
	    //Permutation with  letter and digits
	      //ip : s = "a1B2" o/p : [a1B2, A1B2, A1b2, a1b2]
	      Set<String> strResult1 = new HashSet<>();
	      solveWithCaseAndDigit(s, 0,"", strResult1);
	      System.out.println(strResult1.toString());
	      
	      //
	      
	}
	
	//STRING SUBSTRING
	public static void solve(String s, int start, int end, List<String> result ){
		if(end == s.length())
		{
			return;
		}
		if(start > end) {
			solve(s, 0, end+1, result);
		}
		else {
			result.add(s.substring(start, end+1));
			solve(s, start+1, end, result);
		}
	}
	
	//ARRAY SUBSET
	public static void solve(int arr[], int index, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> li ){
        if(index == arr.length){
            result.add(new ArrayList<>(li));
            return;
        }
        
        li.add(arr[index]);
        solve(arr, index+1, result, li);
        li.remove(li.size()-1);
        solve(arr, index+1, result, li);
        
    }
	//STRING SUBSET/SUBSEQUENCE
	public static void solve(String s, int index, String op ,  List<String> result ){
        if(index == s.length()){
            result.add(op);
            return;
        }
        
        String op1 = op;
        String op2 = op + s.charAt(index);
        solve(s, index+1, op1, result);
        solve(s, index+1, op2, result);
        
    }
	
	//PERMUTATION with space
	public static void solveWithSpace(String s, int index, String op ,  List<String> result ){
        if(index == s.length()-1){
            result.add(op+s.charAt(index));
            return;
        }
        
        String op1 = op + s.charAt(index);
        String op2 = op + s.charAt(index) + "_";
        solveWithSpace(s, index+1, op1, result);
        solveWithSpace(s, index+1, op2, result);
        
    }
	
	//PERMUTATION with case change
	public static void solveWithCase(String s, int index, String op ,  List<String> result ){
		if(index == s.length()) {
			result.add(op);
			return;
		}
		String op1 = op;
		char ch = s.charAt(index);
		String op2 = op;
		if(index > 0)
			op2 = op2.substring(0,index) + Character.toUpperCase(ch) + op2.substring(index+1);
		else
			op2 = Character.toUpperCase(ch) + op2.substring(index+1);
		solveWithCase(s,index+1, op1, result);
		solveWithCase(s,index+1, op2, result);
	}
	
	private static void solveWithCaseAndDigit(String s, int index, String op, Set<String> result) {
		if(index == s.length()) {
			result.add(op);
			return;
		}
		char ch = s.charAt(index);
		String op1 = op;
		String op2 = op;
		if(Character.isLetter(ch)) {
			op1 = op1 + Character.toLowerCase(ch);
			op2 = op2 + Character.toUpperCase(ch);
		}
		else {
			op1 = op1 + ch;
			op2 = op2 + ch;
		}
		solveWithCaseAndDigit(s,index+1, op1, result);
		solveWithCaseAndDigit(s,index+1, op2, result);
	}
}
