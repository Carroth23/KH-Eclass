package exams;

import java.util.Arrays;

import classes.Contact;

public class Exam_01 {
	public static void main(String[] args) {

		// Contact
		// ���� id
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

		Contact[] contacts = new Contact[] { // ��ü �迭
				new Contact(1001, "Susan", "01012341234"),
				new Contact(1002, "Tom", "01012341234"),
				new Contact(1003, "Jack", "01012341234"),
				new Contact(1004, "Tom", "45684643245"),
				new Contact(1005, "Jane", "010456484321")
		};
		
//		for (int i = 0; i < contacts.length; i++) {
//			System.out.println(contacts[i].getId() + " : " + contacts[i].getName() + " : " + contacts[i].getContact());
//		}
		
		// �̸��� Tom�� ����� ����ó�� �˻��ؼ� ���
		for (int i = 0; i < contacts.length; i++) {
			if (contacts[i].getName().equals("Tom")) {
				System.out.println(contacts[i].getName() + " : " + contacts[i].getContact());
			}
		}
		
		System.out.println();
		
		System.out.println(contacts[2].getId() + " : " + contacts[2].getContact());
		// ���̵� 1003�� ����� ã�Ƽ� ��ȭ��ȣ�� 01011112222�� �����غ�����.
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
		
//		System.out.println("���̵� : " + con1.getId() + " �̸� : " + con1.getName() + " ��ȣ : " + con1.getContact());
//		System.out.println("���̵� : " + con2.getId() + " �̸� : " + con2.getName() + " ��ȣ : " + con2.getContact());
//		System.out.println("���̵� : " + con3.getId() + " �̸� : " + con3.getName() + " ��ȣ : " + con3.getContact());

	}

}