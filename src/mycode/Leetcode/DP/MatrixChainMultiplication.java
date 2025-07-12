package mycode.Leetcode.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MatrixChainMultiplication {
	
	public static void main(String[] args) {
		int arr[] = {2, 1, 3, 4};
		//int result = matrixMultiplication(arr);
		//System.out.println("Result " + result);
		dummy();
	}
	
	static int matrixMultiplication(int arr[]) {
        // code here
        int[][] dp = new int[201][201];
        for(int[] d : dp )
        {
            Arrays.fill(d,-1);
        }
        return solve(arr, 1, arr.length-1, dp);
    }
    
    static int solve(int[] arr, int i , int j , int[][] dp){
        if(i >= j)
        return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j-1; k++){
            int tmpAns = solve(arr, i, k, dp) + solve(arr, k+1, j, dp) +
                            arr[i-1] * arr[k] * arr[j];
            min = Math.min(min, tmpAns);
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    static void dummy() {
    	PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> b.getKey() - a.getKey());
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, 7);
    	map.put(1,6);
    	map.put(1,8);
    	map.put(2,5);
    	map.put(2,9);
    	pq.addAll(map.entrySet());
    	while(!pq.isEmpty()) {
    		Map.Entry<Integer, Integer> ele = pq.poll();
    		System.out.println(" Result key " + ele.getKey() + " value "+ ele.getValue());
    	}
    }
}
