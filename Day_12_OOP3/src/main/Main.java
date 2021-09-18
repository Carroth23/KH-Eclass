package main;

import java.util.Scanner;

import grade.Gold;
import grade.Silver;
import manager.Manager;

public class Main {

	public static void main(String[] args) {
		
		// ���(IS-A ��Ӱ���)�� ����
		// Ư�� Ŭ������ ����� ���� Ŭ�������� ��ӹ޾� ����ϱ� ����.
		// �������� ������ �̿��ϱ� ���ؼ�
		// �ڵ� �ߺ����� ���߱� ���ؼ�.

		// ȸ������ �ý����� ġ������ ������ 3����
		// 1. �ڵ� �ߺ����� ����. 					- ��� ������ ���� �ذ�
		// 2. �ڵ� ���յ��� ����. (���� ������ �Ҹ�) 	- ������ ������ ���� �ذ�
		// 3. ����� ���� (�迭�� ũ�ⰰ����)			- Collection Framework �ذ�
		
		Manager manager = new Manager();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("== ȸ�� ���� �ý��� ==");
			System.out.println("1. �ű� ȸ�� ���");
			System.out.println("2. ȸ�� ��� ���");
			System.out.println("3. �ý��� ����");
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
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			} else {
				System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
			}

		}

	}

}
