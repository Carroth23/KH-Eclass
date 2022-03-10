package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue02 {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();
		
		st.push("1");
		st.push("2");
		st.push("3");
		
		q.offer("1");
		q.offer("2");
		q.offer("3");
		
		System.out.println("==stack==");
		while(!st.empty()) {
			System.out.println(st.pop());
		}
		System.out.println("==queue");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
