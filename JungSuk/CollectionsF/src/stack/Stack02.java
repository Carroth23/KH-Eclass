package stack;

import java.util.Stack;

public class Stack02 {

	public static void main(String[] args) {
		Stack st = new Stack();
		String str = "(1+2)(2*3) == ((22)-3)";
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				st.push(ch);
			}
			if(ch == ')') {
				st.pop();
			}
		}
		if(st.empty()) {
			System.out.println("짝맞음");
		} else {
			System.out.println("짝안맞음");
		}
	}

}
