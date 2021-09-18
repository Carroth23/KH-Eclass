package main;

import java.util.Scanner;

import grade.Gold;
import grade.Silver;
import manager.Manager;

public class Main {

	public static void main(String[] args) {
		
		// 상속(IS-A 상속관계)의 목적
		// 특정 클래스의 기능을 나의 클래스에도 상속받아 사용하기 위함.
		// 다형성의 성질을 이용하기 위해서
		// 코드 중복도를 낮추기 위해서.

		// 회원관리 시스템의 치명적인 문제점 3가지
		// 1. 코드 중복도가 높다. 					- 상속 문법을 통해 해결
		// 2. 코드 결합도가 높다. (유지 보수에 불리) 	- 다형성 문법을 통해 해결
		// 3. 저장소 문제 (배열의 크기같은것)			- Collection Framework 해결
		
		Manager manager = new Manager();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("== 회원 관리 시스템 ==");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 목록 출력");
			System.out.println("3. 시스템 종료");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				manager.addMember(new Gold(1001, "Tom", 1000));
				manager.addMember(new Silver(1002, "Jack", 2000));
				manager.addMember(new Silver(1003, "Susan", 2000));
				manager.addMember(new Gold(1004, "Jane", 4000));

			} else if (menu == 2) {

				Gold[] goldMembers = manager.getGoldMembers();
				for (int i = 0; i < manager.getGoldIndex(); i++) {
					System.out.println(goldMembers[i].getId() + "\t" + goldMembers[i].getName() + "\t"
							+ goldMembers[i].getPoint() + "\t" + goldMembers[i].getBonus());
				}

				Silver[] silverMembers = manager.getSilverMembers();
				for (int i = 0; i < manager.getSilverIndex(); i++) {
					System.out.println(silverMembers[i].getId() + "\t" + silverMembers[i].getName() + "\t"
							+ silverMembers[i].getPoint() + "\t" + silverMembers[i].getBonus());
				}

			} else if (menu == 3) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("메뉴를 다시 확인하세요.");
			}

		}

	}

}
