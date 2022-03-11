package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList();
		list.add(new Student("자바왕", 1, 10, 1, 1, 1));
		list.add(new Student("홍길동", 1, 11, 1, 1, 1));
		list.add(new Student("김길동", 2, 10, 1, 1, 1));
		
		// Iterator도 제네릭클라스
		Iterator<Student> it = list.iterator();
		
		while(it.hasNext()) {
							// 형변환 없이 가능
			System.out.println(it.next().name);
		}
		
		HashMap<String, Student> map = new HashMap<>();
		map.put("자바왕", new Student("자바왕", 1, 1, 100, 100, 100));
		
		// 제네릭사용으로 인해 형변환 없이 바로 꺼내기 가능
		Student s = map.get("자바왕");
		
		System.out.println(map);
		System.out.println(map.get("자바왕").name);
	}

}

class Student{
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
