package mycode.Leetcode.DP;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String s1 = "ABCDEHC";
		String s2 = "AQCYDEHP";
		//Recursive
		//int result = LCS(s1,s2,s1.length(), s2.length(),sb);
		//System.out.println("Result "+result + " string "+sb.toString());
		//TOP-DOWN
		/*int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n+1][m+1];
		for(int[] d : dp) Arrays.fill(d, -1);*/
		
		//int result = LCSTD(s1,s2,s1.length(), s2.length(),dp,sb);
		//getSubString(s1,s2,dp,sb);
		
		//System.out.println("Result "+result + " string "+getSubString(s1,s2,dp,sb));
		
		//Bottom - Up
		//int result = LCSBU(s1,s2,s1.length(), s2.length(),sb);
		
		//System.out.println("Result "+result + " string "+sb.toString());
		
		//Longest Common Substring
		
		//int res = longestCommonSubstring(s1,s2, s1.length(), s2.length());
		//System.out.println("Result "+res );
		
		//Bottom - Up
		/*String result = longestCommonSubstringBU(s1,s2,s1.length(), s2.length(),sb);
				
		System.out.println("Result "+result );*/
		
		//recurssion
		/*int result = longestCommonSubstring(s1,s2,0, 0,0);
		System.out.println("Result "+result );*/
		
		//Shortest Common SuperSequence
		
		/*String s3 = "geek";
		String s4 = "eke";
		
		int common = LCSBU(s3,s4,s3.length(),s4.length(),sb);
		int lenSCS = s3.length()+s4.length() - common;
		System.out.println("Result " + lenSCS);*/
		
		//PRINT SCS
		String s3 = "acbcf";
		String s4 = "abcdaf";
		int n = s3.length();
		int m = s4.length();
		int[][] dp = new int[n+1][m+1];
		for(int[] d : dp) Arrays.fill(d, -1);
		int common = LCSTD(s3,s4,s3.length(),s4.length(),dp);
		//System.out.println("Result " + printSCS(s3, s4, dp, sb));
		
		
		
		//Min num of Insetion And deletion
		/*String word1 = "sea";
		String word2 = "eat";
		int lcs = LCS(word1, word2);
        int result =  word1.length() - lcs + word2.length() - lcs;
       System.out.println("Result " + result);	*/
       
     //Min num of Insetion And deletion And replace
		/*String word1 = "INTENSION";
		String word2 = "EXECUTION";
		int n = word1.length() ;
        int m = word2.length();
        int deletion = 0, insert = 0, replace = 0;
        int lcs = LCS(word1, word2);
        while(n != m){
        if(n > m){
            deletion = n-m; n -= deletion;
        }
        if(n<m){
            insert = m-n; n+= insert;
        }
        }
        if(n==m){
            replace = n - lcs;
        }
        int result =insert+ deletion+ replace;
        System.out.println("Result " + result);*/
       
	}
	
	private static String getSubString(String s1, String s2, int[][] dp, StringBuilder sb) {
		int n = s1.length();
		int m = s2.length();
		
		while(n>0 && m>0 ) { 
			if(s1.charAt(n-1) == s2.charAt(m-1))
			{
				sb.append(s1.charAt(n-1));
				n--;m--;
			}
			else if(dp[n-1][m] > dp[n][m-1])
				n--;
			else
				m--;
			
		}
		return sb.reverse().toString();
	}

	//Recurrsive
	public static int LCS(String x, String y, int n, int m, StringBuilder sb) {
		if(n == 0 || m ==0) {
			return 0;
		}
		
		if(x.charAt(n-1) == y.charAt(m-1)) {
			return 1 + LCS(x,y,n-1,m-1,sb);
		}
		else {
			return Math.max(LCS(x,y,n-1,m,sb),LCS(x,y,n,m-1,sb));
		}
	}
	
	//Top Down
		public static int LCSTD(String x, String y, int n, int m, int[][] dp) {
			if(n == 0 || m ==0) {
				return 0;
			}
			
			if(dp[n][m] != -1) return dp[n][m];
			if(x.charAt(n-1) == y.charAt(m-1)) {
				dp[n][m]= 1 + LCSTD(x,y,n-1,m-1,dp);
			}
			else {
				dp[n][m] = Math.max(LCSTD(x,y,n-1,m,dp),LCSTD(x,y,n,m-1,dp));
			}
			
			return dp[n][m];
		}
		
	//Bottom Up
	public static int LCSBU(String x, String y, int n, int m, StringBuilder sb) {
		int[][] dp = new int[n+1][m+1];
		
		
		for(int i = 0; i <= n ; i++) {
			for(int j = 0; j<=m; j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
				else {
					if(x.charAt(i-1) == y.charAt(j-1)) {
						sb.append(x.charAt(i-1));
						dp[i][j] = 1 + dp[i-1][j-1];
					}
					else {
						dp[i][j] =  Math.max(dp[i][j-1], dp[i-1][j]);
					}
				}
			}
		}
		return dp[n][m];
	}
	
	//Bottom Up
		public static String longestCommonSubstringBU(String x, String y, int n, int m, StringBuilder sb) {
			int[][] dp = new int[n+1][m+1];
			
			int max = 0, endPos = 0;
			for(int i = 0; i <= n ; i++) {
				for(int j = 0; j<=m; j++) {
					if(i==0 || j==0)
						dp[i][j] = 0;
					else {
						if(x.charAt(i-1) == y.charAt(j-1)) {
							dp[i][j] = 1 + dp[i-1][j-1];
							max = Math.max(dp[i][j], max);
							endPos = i;
						}
						else {
							dp[i][j] = 0;
						}
					}
				}
			}
			  return x.substring(endPos - max, endPos);
		}
	
	//Longest Common substring : Recurrsive
		public static int longestCommonSubstring(String x, String y, int n, int m, int count) {
			if(n == x.length() || m == y.length()) {
				return count;
			}
			
			int best = count;
			if(x.charAt(n) == y.charAt(m)) {
				 best = Math.max(best, longestCommonSubstring(x, y, n + 1, m + 1, count + 1));
			}
			else {
				best = Math.max(best, longestCommonSubstring(x, y, n + 1, m , 0));
				best = Math.max(best, longestCommonSubstring(x, y, n , m + 1, 0));
				
			}
			return best;
		}
		
		
		//Min Insertion and deletion 
		 public static int LCS(String word1, String word2){
		        int n = word1.length();
		        int m = word2.length();

		        int[][] dp = new int[n+1][m+1];

		        for(int i = 0 ;i<=n;i++){
		            for(int j = 0; j<=m; j++){
		                if(i ==0 || j==0)
		                {
		                    dp[i][j] = 0;
		                }
		                else{
		                    if(word1.charAt(i-1)==word2.charAt(j-1))
		                        dp[i][j] = 1 + dp[i-1][j-1];
		                
		                    else
		                         dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
		                
		                }
		            }
		        }
		        return dp[n][m];
		    }
		 
		 private static String printSCS(String s1, String s2, int[][] dp, StringBuilder sb) {
				int n = s1.length();
				int m = s2.length();
				
				while(n>0 && m>0 ) { 
					if(s1.charAt(n-1) == s2.charAt(m-1))
					{
						sb.append(s1.charAt(n-1));
						n--;m--;
					}
					else if(dp[n-1][m] > dp[n][m-1])
					{ 
						sb.append(s1.charAt(n-1));
						n--;
					}
					
					else {
						sb.append(s2.charAt(m-1));
						m--;
					}
					
				}
				 while(n>0)
				 {
					 sb.append(s1.charAt(n-1));n--;
				 }
				 while(m>0)
				 {
					 sb.append(s2.charAt(m-1));m--;
				 }
				return sb.reverse().toString();
			}

}
