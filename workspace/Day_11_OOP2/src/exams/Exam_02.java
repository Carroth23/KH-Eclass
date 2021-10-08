package exams;

import java.util.Arrays;
import java.util.Scanner;

import classes.Student;

public class Exam_02 {

	public static int inputValidInt(String msg) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print(msg);
				int num = Integer.parseInt(sc.nextLine());
				return num;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է��ؾ� �մϴ�.");
			}
		}
	}

	public static void main(String[] args) {

		// 1. Student Ŭ���� ����
		// - id, name, kor, eng, math
		// - getters / setter / constructor / default constructor / getSum(������ ����) /
		// getAvg(���)
		Scanner sc = new Scanner(System.in);
		int id = 1001; // �л��鿡�� ���������� �ο��� ���� ID ��

		int index = 0;
		Student[] stds = new Student[10];

		while (true) {
			System.out.println("=== �л� ���� �ý��� ===");
			System.out.println("1. �л� ���� �Է�");
			System.out.println("2. �л� ��� ���");
			System.out.println("3. �л� ���� �˻�");
			System.out.println("4. �л� ���� ����"); // ���� ���� - ���̵�� ���ο� ������ �Է¹޾Ƽ� ��� ������ ����
			System.out.println("5. �л� ���� ����"); // ���� ���� - ���������� 1 ~ n���� �����Ͽ� ���
			System.out.println("0. �ý��� ����");
			int menu = inputValidInt(">> ");

			if (menu == 1) {
				System.out.print("�� �� : ");
				String name = sc.nextLine();

				int kor = inputValidInt("�� �� : ");
				int eng = inputValidInt("�� �� : ");
				int math = inputValidInt("�� �� : ");

				// 2. �Է¹��� ��� ���� ID�� Student�ν��Ͻ��� �����ϴ� �ڵ带 �ۼ��ϼ���.
				Student std = new Student(id++, name, kor, eng, math);

				// 3. �ۼ��� Student �ν��Ͻ��� ���α׷� ��ü���� �Ҹ����� �ʰ� ������ ���� �� �ְԲ�,
				// Student �� �迭�� ���������� �����ϴ� �ڵ带 �ۼ��ϼ���.
				stds[index++] = std;

			} else if (menu == 2) {

				// 4. ����� ��� �л��� ������ ȭ�鿡 ����ϼ���.
				for (int i = 0; i < index; i++) {
					System.out.println(stds[i].getId() + "\t" + stds[i].getName() + "\t" + stds[i].getKor() + "\t"
							+ stds[i].getEng() + "\t" + stds[i].getMath() + "\t" + stds[i].getSum() + "\t"
							+ stds[i].getAvg());
				}

			} else if (menu == 3) {
				// �̸����� �˻�
				// �˻��� �л��� �̸��� �Է��� �ּ���.
				// ������ �ش� �л��� �������� �ʽ��ϴ�.
				// �˻��ɽ� ��� ���� ���
				System.out.println("�˻��� �л��� �̸��� �Է��� �ּ���.");
				String name = sc.nextLine();

				boolean existFlag = false;
				for (int i = 0; i < index; i++) {
					if (stds[i].getName().equals(name)) {
						System.out.println(stds[i].getId() + "\t" + stds[i].getName() + "\t" + stds[i].getKor() + "\t"
								+ stds[i].getEng() + "\t" + stds[i].getMath() + "\t" + stds[i].getSum() + "\t"
								+ stds[i].getAvg());
						existFlag = true;
					} /*
						 * else if (i == index - 1) { �̷��͵� ���� System.out.println("�ش� �л� ������ �����ϴ�."); }
						 */
				}
				if (!existFlag) {
					System.out.println("�ش� �̸��� �������� �ʽ��ϴ�.");
				}

			} else if (menu == 4) {
				// ���� ���� - ���̵�� ���ο� ������ �Է¹޾Ƽ� ��� ������ ����
				System.out.println("������ �л�ID�� �Է����ּ���_");
				int idnum = Integer.parseInt(sc.nextLine());

				boolean idFlag = false;
				for (int i = 0; i < index; i++) {
					if (idnum == stds[i].getId()) {
						System.out.println("�˻��� �л��� ���� : " + stds[i].getId() + "\t" + stds[i].getName() + "\t"
								+ stds[i].getKor() + "\t" + stds[i].getEng() + "\t" + stds[i].getMath() + "\t"
								+ stds[i].getSum() + "\t" + stds[i].getAvg());
						System.out.println("������ �̸��� �Է��� �ּ���:");
						stds[i].setName(sc.nextLine());
						stds[i].setKor(inputValidInt("�� �� : "));
						stds[i].setEng(inputValidInt("�� �� : "));
						stds[i].setMath(inputValidInt("�� �� : "));
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						idFlag = true;
					}
				}
				if (!idFlag) {
					System.out.println("�ش� Id�� ��ȸ�Ǵ� �л��� �����ϴ�.");
				}

			} else if (menu == 5) {
				// ���� ���� - ���������� 1 ~ n���� �����Ͽ� ���
			
				
				for (int i = 0; i < index; i++) {
					System.out.println(stds[i].getId() + "\t" + stds[i].getName() + "\t" + stds[i].getKor() + "\t"
							+ stds[i].getEng() + "\t" + stds[i].getMath() + "\t" + stds[i].getSum() + "\t"
							+ stds[i].getAvg());
				}

			} else if (menu == 0) {
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			} else {
				System.out.println("�޴��� �ٽ� Ȯ���ϰ� �Է����ּ���");
			}
		}
	}

}
