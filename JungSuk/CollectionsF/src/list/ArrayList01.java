package list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList01 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		// ArrayList에는 객체만 저장 가능
		// autoboxing에 의해 기본형이 참조형으로 자동 변환
		list1.add(5);
		// 원랜 이렇게 저장
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		// index 1 ~ 4(4는 포함X)를 뽑아 새로운 리스트 생성
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		
		// 정렬되서 저장이 되나봄
//		Collections.sort(list1);
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		
		list2.add("b");
		list2.add("c");
		list2.add(3, "d"); // 위치 지정 추가
		System.out.println("list2 : " + list2);
		
		// 변경
		list2.set(3, "DD");
		System.out.println("list2 : " + list2);
		// add 는 뒤로 밀리고 set은 변경
		
		System.out.println("list1에서 0의 index : " + list1.indexOf(0));
		
		// index, 객체로도 삭제가능(new Integer(1) 이렇게하면 숫자 1이 사라짐.)
		list1.remove(0);
		System.out.println(list1);
		
		
		
		
		
		
	}
}
