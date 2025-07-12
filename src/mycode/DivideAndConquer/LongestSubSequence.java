package mycode.DivideAndConquer;

public class LongestSubSequence {

	//s1: "elephant"; s2: "erepha" : longsubseq : 5; eepha

	private int findLCS(String s1, String s2, int index1, int index2) {
		if(s1.length() == index1 || s2.length() == index2)
			return 0;
		if(s1.charAt(index1)==s2.charAt(index2))
			return 1 + findLCS(s1, s2, index1+1, index2+1);
		
		else
		{
			int op1 = findLCS(s1, s2, index1, index2+1);
			int op2 = findLCS(s1, s2, index1+1, index2);
			return Math.max(op1, op2);
		}
	}
	
	public int findClS(String s1, String s2) {
		return findLCS(s1, s2, 0, 0);
	}
	
}
