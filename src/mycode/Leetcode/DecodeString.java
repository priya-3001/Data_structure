package mycode.Leetcode;

import java.util.Stack;

public class DecodeString {
	
	public static void main(String[] args) {
		String s = "2[abc]3[cd]ef";
		
		System.out.println(decodeString(s));
	}
	
 public static String decodeString(String s) {
		 
		 Stack<Integer> numberStack = new Stack<>();
		 Stack<String> charStack = new Stack<>();
		 int num = 0;
		 String str = "";
		 for(int i = 0; i<s.length(); i++) {
			 Character ch = s.charAt(i);
			 if(Character.isDigit(ch)) {
				num = num*10 + ch - '0';
			 }
			 else if(ch == '[') {
				 numberStack.push(num);
				 charStack.push(str);
				 num = 0; 
				 str = "";
			 }
			 else if(ch ==']') {
				 StringBuilder sb = new StringBuilder(charStack.pop());
				 Integer count = numberStack.pop();
				 
				 for(int l = 1; l<=count; l++) {
					sb.append(str); 
				 }
				 
				 str = sb.toString();
			 }
			 else {
				 str += ch;
			 }
		 }
		 return str;
		 
 }
//this will only work for single digit
	/* public static String decodeString(String s) {
		 
		 Stack<Character> numberStack = new Stack<>();
		 Stack<Character> charStack = new Stack<>();
		 
		 for(int i = 0; i<s.length(); i++) {
			 char ch = s.charAt(i);
			 
			 if(Character.isDigit(ch)) {
				 numberStack.push(ch);
			 }
			 else if(ch == ']') {
				 String decodedString = charStack.pop().toString();
				 while(charStack.peek() != '[') {
					 decodedString = charStack.pop() + decodedString ;
				 }
				 charStack.pop();
				 Integer num = numberStack.pop() - '0';
				 String subDecodedString = "";
				 for(int j = 1; j<=num; j++) {
					 subDecodedString += decodedString;
				 }
				 
				 for(Character c : subDecodedString.toCharArray()) {
					 charStack.push(c);
				 }
				 
				 
			 }
			 else {
				 charStack.push(ch);
			 }
		 }
 		StringBuilder sb = new StringBuilder();
 		while(!charStack.isEmpty()) {
 			sb.append(charStack.pop());
 		}
 		 
	        return   sb.reverse().toString();
	    }*/
}
