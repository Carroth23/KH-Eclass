package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack01 {

	public static void main(String[] args) {
		Stack st = new Stack();
		// Queue는 인터페이스기때문에 구현체를 가져다 써야함.
		Queue qu = new LinkedList();
		st.push("1");
		st.push("2");
		st.push("3");
		
		qu.offer("1");
		qu.offer("2");
		qu.offer("3");
		
		System.out.println("==stack==");
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
		
		System.out.println("==queue==");
		while(!qu.isEmpty()) {
			System.out.println(qu.poll());
		}
	}

}
