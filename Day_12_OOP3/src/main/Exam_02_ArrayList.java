package main;

import java.util.ArrayList;

public class Exam_02_ArrayList {
	public static void main(String[] args) {

		// Object : �ڹٿ� �����ϴ� ���Ŭ������ �ְ� ����
		
		
		
		
		ArrayList arr = new ArrayList();
		// �Է�
		arr.add("Hello");
		arr.add("Java");
		arr.add("World");
		arr.add(123);
		
		arr.size();
		
		// ���
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println("----------------------------");
		
		// ����
		arr.remove(0);
		
		// ���
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
//		System.out.println(arr.get(2)); �������� ����
		System.out.println("----------------------------");
		
		// ����
		arr.add(0, "Good");
		
		// ���
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println("----------------------------");
		
		// ������ ������ ���� ����(�޸𸮰� �㰡 �ϴ� ��)
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
