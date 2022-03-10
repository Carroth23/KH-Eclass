package stack;

import java.util.Stack;

public class Stack03 {

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push("1");
		st.push("2");
		st.add("3");
		System.out.println(st);
		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st);
	}

}
