package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue01 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		System.out.println("help입렵 = 도움말");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(">>");
			try {
				String input = sc.nextLine().trim();
				if(input.equals("")) continue;
				
				if(input.equalsIgnoreCase("history")) {
					int i = 0;
					save(input);
					LinkedList ls = (LinkedList)q;
					
					for(int j = 0;j <ls.size(); j++) {
						System.out.println((j+1) + " : " + ls.get(j));
					}
				} else {
					save(input);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static void save(String input) {
		if(!"".equals(input)) {
			q.offer(input);
		}
		if(q.size() > MAX_SIZE) {
			q.poll();
		}
	}

}
