import java.util.Scanner;
public class Ex03 {
	
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		// �̸� : ȫ�浿
		// ���� : 100, ���� : 98, ���� : 75
		// �հ� : 273, ��� : 91.00
		System.out.println("�̸��� �Է��� �ּ���.>");
		String name = sc.nextLine();
		System.out.println("���� ������ �Է��� �ּ���.>");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("���� ������ �Է��� �ּ���.>");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.println("���� ������ �Է��� �ּ���.>");
		int num3 = Integer.parseInt(sc.nextLine());
		
		int sum = num1 + num2 + num3;
		double per = (num1 + num2 + num3) / 3;
		
		System.out.println("���� �������α׷� ver2.1");
		System.out.println("===================");
		System.out.println("�� �� : " + name);
		System.out.println("===================");
		System.out.println("�� �� : " + num1);
		System.out.println("�� �� : " + num2);
		System.out.println("�� �� : " + num3);
		System.out.println("===================");
		System.out.println("�� �� : " + sum);
		System.out.printf("�� �� : %.2f%n", per);
		System.out.println("===================");
	}
}