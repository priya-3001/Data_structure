package mycode.Leetcode;

import java.util.ArrayDeque;
import java.util.*;

public class PredictWinner {
	public static void main(String[] args) {
		int[] nums = {1,5,2};
		//System.out.println("Winner player 1 " + predictTheWinner(nums));
		
		//2375. Construct Smallest Number From DI String
		String ip = "IIIDIDDD";
		String result = smallestNumber(ip);
		System.out.println("Result " + result);
		StringBuilder sb = new StringBuilder()
	}
	
	 public static String smallestNumber(String pattern) {
	        List<Integer> list = new ArrayList<>();
	        int nums = 1;
	        Stack<Integer> stack = new Stack<>();
	        for(int i = 0; i<=pattern.length();i++) {
	        	stack.add(nums);nums++;
	        	if(i==pattern.length()|| pattern.charAt(i)=='I') {
	        		while(!stack.isEmpty())
	        			list.add(stack.pop());
	        	}
	        }
	       
	        
	        StringBuilder sb = new StringBuilder();
	        for(Integer num : list) {
	        	sb.append(num);
	        }
			return sb.toString();
	    }
	public static boolean predictTheWinner(int[] nums) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int player2 = 0;
        for(int num : nums)
        {	player2 += num;
        	dq.add(num);
        }
        int[] player1 = new int[1];
        solve(dq , player1, 1);
        player2 -= player1[0];
        
        return player1[0]>=player2 ? true : false;
    }
	private static int solve(ArrayDeque<Integer> dq , int[] p1, int turn) {
		if(dq.isEmpty())
			return 0;
		
		if(turn%2==1)
		{	
			int first = dq.peekFirst();
			int include1 =  dq.pollFirst() + solve(dq, p1, turn+1);
			dq.addFirst(first);
			int last = dq.peekLast();
			int include2 = dq.pollLast() + solve(dq, p1, turn+1);
			dq.addLast(last);
			p1[0] = Math.max(p1[0], Math.max(include1, include2));
			return p1[0] ;
			
		}
		else {
			int first = dq.peekFirst();
			int include1 =  dq.pollFirst() + solve(dq, p1, turn+1);
			dq.addFirst(first);
			int last = dq.peekLast();
			int include2 = dq.pollLast() + solve(dq, p1, turn+1);
			dq.addLast(last);
			return Math.min(include1, include2);
		}
		
	}

}
