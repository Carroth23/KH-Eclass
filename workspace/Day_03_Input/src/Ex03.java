import java.util.Scanner;

public class Ex03 {

	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		// �̸� : ȫ�浿
		// ���� : 100, ���� : 98, ���� : 75
		// �հ� : 273, ��� : 91.00
		System.out.println("���� �������α׷� ver2.1");
		System.out.println("===================");
		System.out.print("�� �� : ");
		String name = sc.nextLine();
		System.out.println("===================");
		System.out.print("�� �� : ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("�� �� : ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("�� �� : ");
		int math = Integer.parseInt(sc.nextLine());
		System.out.println("====================");
		int total = kor + eng + math;
		double avg = total / 3.0;
		System.out.println("�� �� : " + total);
		System.out.printf("�� �� : %.2f%n", avg);
		System.out.println("====================");

		// nextInt�� ���ڸ� �������� ����Ű�� ���ܵд�.
		// nextInt�� �ٽ� ����Ѵٸ� nextInt�� ���͸� �����ϹǷ� ��������
		// nextLine�� ���ۿ� �����ִ� ����Ű�� �������µ� �������� X

	}
}