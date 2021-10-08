package main;

import java.util.ArrayList;
import java.util.Scanner;

import grade.Gold;
import grade.Grade;
import grade.Ruby;
import grade.Silver;
import manager.Manager;

public class Main {
	public static void main(String[] args) {

		// ����� ����
		// Ư�� Ŭ������ ����� ���� Ŭ�������� ��ӹ޾� ����ϱ� ����.
		// ������ ������ �̿��ϱ� ���ؼ�
		// �ڵ� �ߺ����� ���߱� ���ؼ�.

		// ȸ������ �ý����� ġ������ ������ 3����
		// 1. �ڵ� �ߺ����� ����. - ��� ������ ���� �ذ�
		// 2. �ڵ� ���յ��� ����. (���� ������ �Ҹ�) - ������ ������ ���� �ذ�
		// 3. ����� ���� - Collection Framework �ذ�

		Manager manager = new Manager();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=== ȸ�� ���� �ý��� ===");
			System.out.println("1. �ű� ȸ�� ���");
			System.out.println("2. ȸ�� ��� ���");
			System.out.println("3. �ý��� ����");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				manager.addMember(new Gold(1001, "Tom", 1000));
				manager.addMember(new Silver(1002, "Jack", 2000));
				manager.addMember(new Silver(1003, "Susan", 3000));
				manager.addMember(new Gold(1004, "Jane", 4000));
				manager.addMember(new Ruby(1005, "Pake", 5000));
			} else if (menu == 2) {
				ArrayList members = manager.getMembers();
				for(int i = 0; i < members.size(); i++) {
					System.out.println(
							((Grade)members.get(i)).getId() + "\t" +
							((Grade)members.get(i)).getName() + "\t" +
							((Grade)members.get(i)).getPoint() + "\t" +
							((Grade)members.get(i)).getBonus()
						);
				}
//					System.out.println(manager.getMembers() + "\t");
			} else if (menu == 3) {
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			} else {
				System.out.println("�޴��� �ٽ� Ȯ���ϼ���.");
			}
		}
	}
}
