package mycode.DivideAndConquer;

public class NumberFactor {
// number of ways to get N from {1,3,4}
	public int waysTogetN(int n) {
		if(n==0 || n==1 || n==2)
			return 1;
		if(n==3)
			return 2;//{3};{1,1,1}
		int sub1 = waysTogetN(n-1);
		int sub2 = waysTogetN(n-3);
		int sub3 = waysTogetN(n-4);
		
		return sub1+sub2+sub3;
	}
}
