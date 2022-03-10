package stack;

import java.util.Stack;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println(solution("()(){}()"));
		System.out.println(solution("(({})){[]}()"));
		System.out.println(solution("{{}}{[])"));
	}

	public static boolean solution(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case ')':
				if(st.peek() == '(')st.pop();
				break;
			case '}':
				if(st.peek() == '{')st.pop();
				break;
			case ']':
				if(st.peek() == '[')st.pop();
				break;
			default:
				st.push(s.charAt(i));
			}
		}
		return st.empty();
	}

}
