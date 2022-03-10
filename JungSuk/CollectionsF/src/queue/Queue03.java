package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue03 {
	public static void main(String[] args) {
		Queue q = new LinkedList(); // queue는 인터페이스라서 구현체인 linkedlist 사용
		q.offer("1");
		q.offer("2");
		q.offer("3");
		q.offer("4");
		q.offer("5");
		System.out.println(q);
		System.out.println(q.peek());
		q.poll();
		System.out.println(q);
	}
}
