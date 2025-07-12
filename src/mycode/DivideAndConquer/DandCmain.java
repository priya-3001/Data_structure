package mycode.DivideAndConquer;

public class DandCmain {
public static void main(String[] args) {
	
	/*NumberFactor nf = new NumberFactor();
	System.out.println("Number factor for 5 "+nf.waysTogetN(5));
	System.out.println("Number factor for 8 "+nf.waysTogetN(8));
	System.out.println("Number factor for 2 "+nf.waysTogetN(2));*/
	
	/* house Robber 
	int[] houses = {6,7,1,30,8,2,4};
	HouseRobber hr = new HouseRobber();
	System.out.println("Max amount "+hr.maxAmount(houses));*/
	
	/*StringReplace sr = new StringReplace();
	String s1 = "tables"; String s2 = "tblr";
	System.out.println("String replacer  "+sr.findMinOperation(s1, s2));*/
	
	/*LongestSubSequence ls = new LongestSubSequence();
	String s1 = "elephant";
	String s2 = "erepha";
	System.out.println("String subseq  "+ls.findClS(s1, s2));*/
	
	/*LongestPalindrome lp = new LongestPalindrome();
	String s1 = "WQERT";
	System.out.println("String palin  "+lp.findLPS(s1));*/
	
	int[][] arr = {
			{4,7,8,6,4},
			{6,7,3,9,2},
			{3,8,1,2,4},
			{7,1,7,3,7},
			{2,9,8,9,3}
	};
	
	MinDistance md = new MinDistance();
	System.out.println("Min Distance  "+md.minDistance(arr, arr.length-1, arr[0].length-1));
}
}
