package mycode.Queue;

import java.util.Arrays;

public class QueueMain {
	public static void main(String[] args) {
	
		/*LinearQueueArray la = new LinearQueueArray(2);
		
		la.enqueue(1);
		la.enqueue(2);
		System.out.println(" Queue " + Arrays.toString(la.arr));
		la.dequeue();
		la.enqueue(3);
		
		CircularQueue ca = new CircularQueue(2);
		
		ca.enqueue(1);
		ca.enqueue(2);
		System.out.println(" Queue " + Arrays.toString(ca.arr));
		ca.dequeue();
		ca.enqueue(3);*/
		
		QueueLL ql = new QueueLL();
		ql.enqueue(1);
		ql.enqueue(2);
		ql.enqueue(3);
		ql.dequeue();
		ql.dequeue();
		ql.dequeue();
		ql.dequeue();
		
		String expression = "";
		if(expression == null || expression.isEmpty()){
            
        }
		int st = 3;
		int[] size ;
		size =new int[] {st, st ,st};
		System.out.println("Arr "+Arrays.toString(size));
	}
}
