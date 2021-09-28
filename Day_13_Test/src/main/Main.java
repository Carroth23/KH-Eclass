package main;

import java.util.ArrayList;
import java.util.Scanner;

import student.Student;
import studentManager.StudentManager;

class Input {
	Scanner sc = new Scanner(System.in);

	public String name() {
		System.out.println("�̸��� �Է��ϼ��� : ");
		return sc.nextLine();
	}

	public int kor() {
		System.out.println("���� ������ �Է��ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}

	public int eng() {
		System.out.println("���� ������ �Է��ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}

	public int math() {
		System.out.println("���� ������ �Է��ϼ��� : ");
		return Integer.parseInt(sc.nextLine());
	}

}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Input input = new Input();
		StudentManager manager = new StudentManager();

		ArrayList members = manager.getStudent();
		int id = 1001;
		while (true) {
			System.out.println("=== �л� ���� �ý��� ===");
			System.out.println("1. �л� ���� �Է�"); // �й�(1001���� 1�� ����) / �̸� / ��, ��, ��
			System.out.println("2. �л� ��� ���");
			System.out.println("3. �л� ���� �˻�");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("0. �ý��� ����.");
			System.out.println("���Ͻô� �޴���ȣ�� �Է��� �ּ���._");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				String name = input.name();
				int kor = input.kor();
				int eng = input.eng();
				int math = input.math();
				Student std = new Student(id++, name, kor, eng, math);
				manager.addStudent(std);

			} else if (menu == 2) {
				for (int i = 0; i < members.size(); i++) {
					System.out.println(((Student) members.get(i)).getNumber() + "\t"
							+ ((Student) members.get(i)).getName() + "\t" + ((Student) members.get(i)).getKor() + "\t"
							+ ((Student) members.get(i)).getEng() + "\t" + ((Student) members.get(i)).getMath() + "\t"
							+ ((Student) members.get(i)).getSum() + "\t" + ((Student) members.get(i)).getAvg());
				}

			} else if (menu == 3) {
				System.out.println("ã���ô� �л��� �̸��� �����ּ���.");
				String findName = sc.nextLine();
				boolean nameflag = false;
				for (int i = 0; i < members.size(); i++) {
					if (findName.equals(((Student) members.get(i)).getName())) {
						System.out.println(((Student) members.get(i)).getNumber() + "\t"
								+ ((Student) members.get(i)).getName() + "\t" + ((Student) members.get(i)).getKor()
								+ "\t" + ((Student) members.get(i)).getEng() + "\t"
								+ ((Student) members.get(i)).getMath() + "\t" + ((Student) members.get(i)).getSum()
								+ "\t" + ((Student) members.get(i)).getAvg());
						nameflag = !false;
					}

					if (nameflag == false && i == members.size() - 1) {
						System.out.println("�Է��Ͻ� �̸��� �л��� �������� �ʽ��ϴ�.");
					}
				}
			} else if (menu == 4) {
				System.out.println("������ �л��� �й��� �����ּ���.");
				boolean nameflag = false;
				int findNumber = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < members.size(); i++) {
					if (findNumber == ((Student) members.get(i)).getNumber()) {
						String name = input.name();
						int kor = input.kor();
						int eng = input.eng();
						int math = input.math();
						((Student) members.get(i)).setName(name);
						((Student) members.get(i)).setKor(kor);
						((Student) members.get(i)).setEng(eng);
						((Student) members.get(i)).setMath(math);
						nameflag = !false;
					}
					if (nameflag == false && i == members.size() - 1) {
						System.out.println("�Է��Ͻ� �̸��� �л��� �������� �ʽ��ϴ�.");
					}
				}
			} else if (menu == 5) {
				System.out.println("������ �л��� �й��� �����ּ���");
				boolean nameflag = false;
				int findNumber = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < members.size(); i++) {
					if (findNumber == ((Student) members.get(i)).getNumber()) {
						members.remove(i);
						System.out.println("�����Ͻ� �л��� ������ �����߽��ϴ�.");
						nameflag = !false;
					}

					if (nameflag == false && i == members.size() - 1) {
						System.out.println("�������� �ʴ� �л��Դϴ�.");
					}
				}
			} else if (menu == 0) {
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			}
		}
	}

}
