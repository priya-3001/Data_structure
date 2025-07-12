package mycode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LargestInKSwap {
	public static void main(String[] args) {
		String s = "4551711527";int k = 3;
		long[] result = new long[1];
		result[0] = Long.MIN_VALUE;
		//permuteSwap(s.toCharArray(), result, 0, k);
		//System.out.println(result[0]);
		//String s1 = String.valueOf(result[0]);
		
		//670:
		System.out.println(" Result "+ maximumSwap(98368));
	}

	private static void permuteSwap(char[] arr, long[] result, int start, int k) {
		if(k==0 || start == arr.length-1) {
			Long val =Long.parseLong(new String(arr));
			result[0] = Math.max(result[0], val);
			return;
		}
		
		long max =  Long.MIN_VALUE;
		for(int i = start+1;i<arr.length;i++) {
			max = Math.max(max, arr[i] - '0');
		}
		//if max is same as current element - no need to swap
		if ((arr[start]-'0') >= max) {
			permuteSwap(arr, result, start + 1, k);
	       
	    }
		
		if((arr[start]-'0') < max) {
			for(int i = start+1;i<arr.length;i++) {
				if((arr[i] - '0') == max) {//find index where max is present
					swap(arr, start, i);
					permuteSwap(arr, result, start+1, k-1);
					swap(arr, start, i);
				}
			}
		}
		
	}

	private static void swap(char[] ipArr, int index, int i) {
		char tmp = ipArr[index];
		ipArr[index] = ipArr[i];
		ipArr[i] = tmp;
		}
	
	//670. Maximum Swap
	    public  static int maximumSwap(int num) {
	        List<Integer> numList = new ArrayList<>();int k = 2;
	        int max = Integer.MIN_VALUE;

	        while(num!=0){
	            int rem = num % 10;
	            numList.add(rem);
	            num /= 10;
	        }
	        for(int i = numList.size()-1;i>=0;i--){
	            int num1 = numList.get(i);int maxnum = numList.get(i);
	            for(int j = i-1; j>=0;j--){
	               maxnum = Math.max(maxnum, numList.get(j));
	            }
	            if(maxnum > num1 ){
	                   for(int j = i-1; j>=0;j--){
	                    if(maxnum == numList.get(j)){
	                        swap(numList, i, j);
	                        max = Math.max(max, convertInteger(numList));
	                    	swap(numList, i, j);//backtrack
	                    }
	                   
	                   }
	                  break;
	            }
	        }
	    return max;
	    }
	    public static void swap(List<Integer> list, int i , int j){
	        int temp = list.get(i);
	        list.set(i,list.get(j));
	        list.set(j,temp);
	        
	    }
	    public static Integer convertInteger(List<Integer> list){
	        int num = 0;
	        for(int i = list.size()-1;i>=0;i--)
	        num = num * 10 + list.get(i);
	        return num;
	    }

}
