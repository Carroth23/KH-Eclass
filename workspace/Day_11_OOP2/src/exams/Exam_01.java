package exams;

import java.util.Arrays;

import classes.Contact;

public class Exam_01 {
	public static void main(String[] args) {

		// Contact
		// 숫자 id
		// name
		// Contact
		// getter / setter / constructor / default constructor

		// 1001 / Susan / 01012341234
		// 1002 / Tom / 01091233219

//		Contact c1 = new Contact(1001, "Susan", "01012341234");
//		Contact c2 = new Contact();
//		c2.setId(1002);
//		c2.setName("Tom");
//		c2.setContact("01091233219");
//		Contact c3 = new Contact(1003, "Jack", "01015242314");

		Contact[] contacts = new Contact[] { // 객체 배열
				new Contact(1001, "Susan", "01012341234"),
				new Contact(1002, "Tom", "01012341234"),
				new Contact(1003, "Jack", "01012341234"),
				new Contact(1004, "Tom", "45684643245"),
				new Contact(1005, "Jane", "010456484321")
		};
		
//		for (int i = 0; i < contacts.length; i++) {
//			System.out.println(contacts[i].getId() + " : " + contacts[i].getName() + " : " + contacts[i].getContact());
//		}
		
		// 이름이 Tom인 사람의 연락처를 검색해서 출력
		for (int i = 0; i < contacts.length; i++) {
			if (contacts[i].getName().equals("Tom")) {
				System.out.println(contacts[i].getName() + " : " + contacts[i].getContact());
			}
		}
		
		System.out.println();
		
		System.out.println(contacts[2].getId() + " : " + contacts[2].getContact());
		// 아이디가 1003번 사람을 찾아서 전화번호를 01011112222로 수정해보세요.
		for (int i = 0; i < contacts.length; i++) {
			if (contacts[i].getId() == 1003){
				contacts[i].setContact("01011112222");
			}
		}
		
		for (int i = 0; i < contacts.length; i++) {
			if (contacts[i].getId() == 1003) {
				System.out.println(contacts[i].getName() + " : " + contacts[i].getContact());
			}
		}
		
		
		
		
		
		
		
//		Contact[] contacts = new Contact[3];
//		
//		contacts[0] = c1;
//		contacts[1] = c2;
//		contacts[2] = c3;
		
//		System.out.println("아이디 : " + con1.getId() + " 이름 : " + con1.getName() + " 번호 : " + con1.getContact());
//		System.out.println("아이디 : " + con2.getId() + " 이름 : " + con2.getName() + " 번호 : " + con2.getContact());
//		System.out.println("아이디 : " + con3.getId() + " 이름 : " + con3.getName() + " 번호 : " + con3.getContact());

	}

}