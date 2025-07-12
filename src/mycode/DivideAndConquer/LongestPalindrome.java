package mycode.DivideAndConquer;

public class LongestPalindrome {
	//Time : 3^m ; m is length of string
	private int findLPS(String s, int start, int end) {
		if(start>end)
			return 0;
		if(start == end)
			return 1;
		int count1=0;
		
		if(s.charAt(start)==s.charAt(end))
			count1 = 2 + findLPS(s, start+1, end-1);
		
		int count2 =  findLPS(s, start+1, end);
		int count3 =  findLPS(s, start, end-1);
		
		return Math.max(count1, Math.max(count2, count3));
	}
	
	public  int findLPS(String s) {
		return findLPS(s, 0, s.length()-1);
	}

}
