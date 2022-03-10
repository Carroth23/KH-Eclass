package generics;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex01 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList();
		list.add(new Student("자바왕", 1, 10));
		list.add(new Student("홍길동", 1, 11));
		list.add(new Student("김길동", 2, 10));
		
		Iterator<Student> it = list.iterator();
		
		while(it.hasNext()) {
			Student s = (Student)it.next();
			System.out.println(it.next().name);
		}
	}

}

class Student{
	String name;
	int ban;
	int no;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Student(String name, int ban, int no) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
