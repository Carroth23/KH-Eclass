package main;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Student;
import manager.Manager;

public class Main {
	public static void main(String[] args) {

		int seq = 1001;
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();

		while (true) {
			System.out.println("== �л����� �ý��� ==");
			System.out.println("1. �л� ���� �Է�");
			System.out.println("2. �л� ��� ���");
			System.out.println("3. ����");
			System.out.print(">> ");
			String menu = sc.nextLine();

			if (menu.equals("1")) {

				System.out.println("�л� �̸� : ");
				String name = sc.nextLine();

				System.out.println("���� ���� : ");
				int kor = Integer.parseInt(sc.nextLine());

				System.out.println("���� ���� : ");
				int eng = Integer.parseInt(sc.nextLine());

				Student std = new Student(seq++, name, kor, eng);
				manager.addStudent(std);

			} else if (menu.equals("2")) {
				ArrayList<Student> students = manager.getStudents();
				
				
				for(Student std : students) { // foreach����
		            System.out.println(std.getId() + "\t" + std.getName() + 
		            		"\t" + std.getKor() + "\t" + std.getEng());
				}
				
//				for (int i = 0; i < students.size(); i++) {
//					String name = students.get(i).getName();
//					int kor = students.get(i).getKor();
//					int eng = students.get(i).getEng();
//					
//					System.out.println(name + "\t" + kor + "\t" + eng);
//				}

			} else if (menu.equals("3")) {
				System.out.println("�ý��� ����");
				System.exit(0);
			} else {
				System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
			}
		}

	}
}
