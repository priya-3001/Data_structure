package mycode.Recurrsion;

import java.util.*;

public class MainRecurssion {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		printN(10, li);
		//System.out.println(li.toString());
		
		//Sort using recursion
		List<Integer> arr =  new ArrayList<>(Arrays.asList(0,4,2,1,7,5));
		//sort(arr);
		//System.out.println(arr.toString());
		
		//Sort stack recursion
		Stack<Integer> st = new Stack<>();
		st.push(0);st.push(4);st.push(2);st.push(1);st.push(7);st.push(5);
		//sort(st);
		//System.out.println(st.toString());
		
		//Delete middle element from stack
		/*int middle = st.size()/2;
		deleteMiddle(st, middle);
		System.out.println(st.toString());*/
		
		//reverse stack
		/*System.out.println("BEFORE " + st.toString());
		reverse(st);
		System.out.println("AFTER "+st.toString());*/
		
		
		//kthGrammar
		System.out.println("kth grammer " + kthGrammar(2, 1));
	}
	
	private static void reverse(Stack<Integer> st) {
		if(st.isEmpty())
			return;
		int val = st.pop();
		reverse(st);
		insertRevese(st,val);
		return;
	}

	private static void insertRevese(Stack<Integer> st, int val) {
		if(st.isEmpty()) {
			st.add(val);return;}
		int tmp = st.pop();
		insertRevese(st,val);
		st.add(tmp);
		return;
	}

	private static void deleteMiddle(Stack<Integer> st, int middle) {
		if(st.size()-1 == middle) {
			st.pop();return;
		}
		
		int temp = st.pop();
		deleteMiddle(st, middle);
		st.push(temp);
		return;
	}

	public static List<Integer> printN(int n, List<Integer> li) {
		if(n==1) {
			li.add(n);
			return li;
			}
		
		printN(n-1,li);
		li.add(n);
		return li;
		
	}
	//SORT STACK
	 public static void sort(Stack<Integer> stack) {
		 if(stack.size() == 1) {
			 return;
		 }
		 
		 int temp =stack.pop();
		 sort(stack);
		 insert(stack, temp);
		 return;
	 }

	private static void insert(Stack<Integer> stack, int temp) {
		if(stack.size() == 0 || stack.peek() < temp) {
			stack.push(temp);
			return;
		}
		
		 int val = stack.pop();
		 insert(stack,temp);
		 stack.push(val);
		 return;
	}
	
	//SORT ARRAY
	 public static void sort(List<Integer> arr) {
		 if(arr.size() == 1) {
			 return;
		 }
		 
		 int temp = arr.get(arr.size()-1);
		 arr.remove(arr.size()-1);
		 sort(arr);
		 insert(arr, temp);
		 return;
	 }

	private static void insert(List<Integer> arr, int temp) {
		if(arr.size() == 0 || arr.get(arr.size()-1) < temp) {
			arr.add(temp);
			return;
		}
		
		 int val = arr.get(arr.size()-1);
		 arr.remove(arr.size()-1);
		 insert(arr,temp);
		 arr.add(val);
		 return;
	}
	
	//find kth grammer
	 public static int kthGrammar(int n, int k) {
		 if(n==1 && k==1)
			 return 0;
		 List<List<Integer>> list = new ArrayList<>();
		 Queue<Integer> q = new LinkedList<>();
		 q.add(0);
		 for(int i = 1; i<=n;i++) {
			 int size = q.size();
			 List<Integer> newList = new ArrayList<>();
			 for(int j = 0;j<size;j++) {
				 int val = q.poll();
				 newList.add(val);
				 if(val==0) {
					 q.add(0);
					 q.add(1);
				 }
				 else if(val==1){
					 q.add(1);
					 q.add(0);
				 }
			 }
			 list.add(newList);
		 }
		 
	        return list.get(n-1).get(k-1);
	  }
}
