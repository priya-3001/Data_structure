package mycode.DivideAndConquer;

public class StringReplace {

	//S1 : tables , s2 : trhees we have find min operation to make s2 == s1
	// replace r<==>a, h<==>b, e<==>l. min op : 3 Time  3^m
	private int findMinOperation(String s1, String s2, int i1,int i2) {
		if(s1.length() == i1)
			return s2.length()-i2;
		if(s2.length() == i2)
			return s1.length()-i1;
		if(s1.charAt(i1)==s2.charAt(i2))
			return findMinOperation(s1, s2, i1+1, i2+1);
		
		int deleteOp = 1 + findMinOperation(s1, s2, i1+1, i2);
		int insertOp = 1 + findMinOperation(s1, s2, i1, i2+1);
		int replaceOp = 1 + findMinOperation(s1, s2, i1+1, i2+1);
		
		return Math.min(deleteOp, Math.min(insertOp, replaceOp));
	}
	
	public int findMinOperation(String s1, String s2) {
		return findMinOperation(s1, s2,0 ,0);
	}
}
