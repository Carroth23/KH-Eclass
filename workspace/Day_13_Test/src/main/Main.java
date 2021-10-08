package main;

import java.util.ArrayList;
import java.util.Scanner;

import student.Student;
import studentManager.StudentManager;

class Input {
	Scanner sc = new Scanner(System.in);

	public String name() {
		System.out.println("이름을 입력하세요 : ");
		return sc.nextLine();
	}

	public int kor() {
		System.out.println("국어 성적을 입력하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

	public int eng() {
		System.out.println("영어 성적을 입력하세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

	public int math() {
		System.out.println("수학 성적을 입력하세요 : ");
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
			System.out.println("=== 학생 관리 시스템 ===");
			System.out.println("1. 학생 정보 입력"); // 학번(1001부터 1씩 증가) / 이름 / 국, 영, 수
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 시스템 종료.");
			System.out.println("원하시는 메뉴번호를 입력해 주세요._");
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
				System.out.println("찾으시는 학생의 이름을 적어주세요.");
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
						System.out.println("입력하신 이름의 학생은 존재하지 않습니다.");
					}
				}
			} else if (menu == 4) {
				System.out.println("수정할 학생의 학번을 적어주세요.");
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
						System.out.println("입력하신 이름의 학생은 존재하지 않습니다.");
					}
				}
			} else if (menu == 5) {
				System.out.println("삭제할 학생의 학번을 적어주세요");
				boolean nameflag = false;
				int findNumber = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < members.size(); i++) {
					if (findNumber == ((Student) members.get(i)).getNumber()) {
						members.remove(i);
						System.out.println("선택하신 학생의 정보를 삭제했습니다.");
						nameflag = !false;
					}

					if (nameflag == false && i == members.size() - 1) {
						System.out.println("존재하지 않는 학생입니다.");
					}
				}
			} else if (menu == 0) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}
		}
	}

}
