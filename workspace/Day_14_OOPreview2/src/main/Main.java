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
			System.out.println("== ī�� �޴� ���� ==");
			System.out.println("1. �ű� �޴� ���");
			System.out.println("2. �޴� ��� ���");
			System.out.println("3. �޴� ���� ����");
			System.out.println("4. �ý��� ����");
			System.out.print(">> ");
			String menu = sc.nextLine();

			if (menu.equals("1")) {
//				System.out.print("�޴� �̸� : ");
//				String name = sc.nextLine();
//
//				System.out.print("�޴� ���� : ");
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
				System.out.println("�޴���ȣ\t�޴��̸�\t�޴�����");
				for (Menu m : menus) {
					System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPrice());
				}
			} else if (menu.equals("3")) {

				ArrayList<Menu> menus = manager.getMenus();
				System.out.println("�޴���ȣ\t�޴��̸�\t�޴�����");
				for (Menu m : menus) {
					System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPrice());
				}

				System.out.print("������ �׸��� ID : ");
				int target = Integer.parseInt(sc.nextLine());

				manager.deleteMenu(target);
			} else if (menu.equals("4")) {
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			} else {
				System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
			}
		}

	}
}
