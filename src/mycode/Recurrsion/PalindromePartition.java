package mycode.Recurrsion;

import java.util.*;

public class PalindromePartition {
	
	public static void main(String[] args) {
		String s = "aab";
		partition( s);
	}
	public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp =  new ArrayList<>();
        solve(s, 0, temp, result);
        return result;
    }

    public static void solve(String s, int index,  List<String> temp , List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        String tmpStr = "";
        for(int i = index; i<s.length();i++){
            tmpStr += s.charAt(i);
            if(isPalindrome(tmpStr)){
                temp.add(tmpStr);
                solve(s, i+1, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String str){
        int left = 0, right = str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;right--;
        }
        return true;
     }

}
