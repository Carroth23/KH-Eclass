package main;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Menu;
import manager.Manager;

public class Main {
	public static void main(String[] args) {

		int seq = 1001;
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();

		while (true) {
			System.out.println("== 카페 메뉴 관리 ==");
			System.out.println("1. 신규 메뉴 등록");
			System.out.println("2. 메뉴 목록 출력");
			System.out.println("3. 메뉴 정보 삭제");
			System.out.println("4. 시스템 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();

			if (menu.equals("1")) {
//				System.out.print("메뉴 이름 : ");
//				String name = sc.nextLine();
//
//				System.out.print("메뉴 가격 : ");
//				int price = Integer.parseInt(sc.nextLine());
//
//				Menu m = new Menu(seq++, name, price);
//				manager.addMenu(m);

				manager.addMenu(new Menu(seq++, "Americano", 1000));
				manager.addMenu(new Menu(seq++, "Cafe Latte", 2000));
				manager.addMenu(new Menu(seq++, "Cafe Mocha", 3000));
				manager.addMenu(new Menu(seq++, "Orange Juice", 4000));

			} else if (menu.equals("2")) {
				ArrayList<Menu> menus = manager.getMenus();
				System.out.println("메뉴번호\t메뉴이름\t메뉴가격");
				for (Menu m : menus) {
					System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPrice());
				}
			} else if (menu.equals("3")) {

				ArrayList<Menu> menus = manager.getMenus();
				System.out.println("메뉴번호\t메뉴이름\t메뉴가격");
				for (Menu m : menus) {
					System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPrice());
				}

				System.out.print("삭제할 항목의 ID : ");
				int target = Integer.parseInt(sc.nextLine());

				manager.deleteMenu(target);
			} else if (menu.equals("4")) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("메뉴를 다시 확인하세요.");
			}
		}

	}
}