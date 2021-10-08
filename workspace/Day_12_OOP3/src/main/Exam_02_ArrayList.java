package main;

import java.util.ArrayList;

public class Exam_02_ArrayList {
	public static void main(String[] args) {

		// Object : 자바에 존재하는 모든클래스의 최고 조상
		
		
		
		
		ArrayList arr = new ArrayList();
		// 입력
		arr.add("Hello");
		arr.add("Java");
		arr.add("World");
		arr.add(123);
		
		arr.size();
		
		// 출력
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println("----------------------------");
		
		// 삭제
		arr.remove(0);
		
		// 출력
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
//		System.out.println(arr.get(2)); 존재하지 않음
		System.out.println("----------------------------");
		
		// 삽입
		arr.add(0, "Good");
		
		// 출력
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println("----------------------------");
		
		// 데이터 개수에 제한 없음(메모리가 허가 하는 한)
		arr.add("Hello");
		arr.add("Java");
		arr.add("World");
		arr.add("Hello");
		arr.add("Java");
		arr.add("World");
		arr.add("Hello");
		arr.add("Java");
		arr.add("World");
		
		
		
		
	}
}