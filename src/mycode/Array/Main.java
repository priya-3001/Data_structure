package mycode.Array;

import java.util.*;

public class Main {
	public static void main(String[] args) {
	 
		//int[] num = {1,7,3,6,5,6};
		//System.out.println("Result " + pivotIndex(num));
		String ss = "hello";
		//Character.isAlphabetic(0)
		String[] res = solution("abcde");
		System.out.println(Arrays.toString(res));
	
	}
	
	    class Pair{
	        int first;
	        int second; 
	        public Pair(int f, int s){
	            this.first = f;
	            this.second = s;

	        }
	    }
	    public int largestRectangleArea(int[] heights) {
	        int max = Integer.MIN_VALUE;
	        int[] NSLindex = findNSLIndex(heights);
	        int[] NSRindex = findNSRIndex(heights);
	        for(int i = 0;i<heights.length;i++){
	            int width = NSRindex[i] -NSLindex[i]-1;
	            int  area = width * heights[i];
	            max = Math.max(max, area);
	        }
	        return max;
	    }

	    public int[] findNSLIndex(int[] arr){
	        int[] result = new int[arr.length];
	        Stack<Pair> st = new Stack<>();
	        for(int i =0; i<arr.length;i++){
	           while(!st.isEmpty() && st.peek().first >= arr[i]){
	                st.pop();
	           }
	           result[i] = !st.isEmpty() ? st.peek().second :-1 ;
	           st.push(new Pair(arr[i],i));
	        }
	        return result;
	    }

	    public int[] findNSRIndex(int[] arr){
	        int[] result = new int[arr.length];
	        Stack<Pair> st = new Stack<>();
	        for(int i =arr.length-1; i>=0;i--){
	           while(!st.isEmpty() && st.peek().first >= arr[i]){
	                st.pop();
	           }
	           result[i] = !st.isEmpty()? st.peek().second : arr.length;
	           st.push(new Pair(arr[i],i));
	        }
	        return result;
	    }
	
	
	public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] rightSum = new int[n];
        int[] leftSum = new int[n];
        int sum = 0;
        
        String s = "hellp";
        char ch = s.charAt(1);
        System.out.println("char " + ch);
        
        for(int i = 0;i<n;i++){
            sum += nums[i];
            leftSum[i] = sum;
        }
        sum = 0;
        for(int i = n-1;i>=0;i--){
             sum += nums[i];
            rightSum[i] = sum;
        }

        for(int i = 0; i<n;i++){
            if(leftSum[i]==rightSum[i])
                return i;
        }
        return -1;
    }
	
	public static String[] solution(String s) {
		int size = (int) Math.ceil(s.length()/2.0) ;
	      String[] result = new String[size];int k =0;
	        for(int i =0; i< s.length();i+= 2){
	          if((i+1) < s.length()){
	            result[k++] = s.substring(i, i+2);
	           
	          }
	          else {
	             result[k++] =s.substring(i) + "_";
	          }
	        }
	      return result;
	    }
}
