import java.util.*;

public class Quiz_03_If {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ���α׷� ����
		System.out.println("���� �������α׷� ver2.1");
		System.out.println("===================");
		System.out.print("�� �� : ");
		String name = sc.nextLine();

		// ���� �Է¶�
		System.out.println("===================");
		System.out.print("�� �� : ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("�� �� : ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("�� �� : ");
		int math = Integer.parseInt(sc.nextLine());

		// �հ� ��¶�
		System.out.println("====================");
		int total = kor + eng + math;
		double avg = total / 3.0;

		// indentation - �鿩���� / ����� : Auto Indent = ctrl + i

		String lev = "D";
		if (avg >= 95) {
			lev = "A+";
		} else if (avg >= 90) {
			lev = "A";
		} else if (avg >= 80) {
			lev = "B";
		} else if (avg >= 70) {
			lev = "C";
		}

		System.out.println("�� �� : " + total);
		System.out.printf("�� �� : %.2f%n", avg);
		System.out.println("�� �� : " + lev);
		System.out.println("====================");

	}

}
