import java.util.Scanner;

public class Exam_01_If {
	public static void main(String[] args) {
		// if - else�� (���� �б⹮)
		// true, false���� ��ȯ�Ѵ�.

		Scanner sc = new Scanner(System.in);

		System.out.println("����� �����ϴ� ������ �����ϼ���.");
		System.out.println("1.��� 2.�ٳ��� 3.����");
		System.out.print(">> ");
		int menu = Integer.parseInt(sc.nextLine());

		if/* ���࿡ �޴����� ���� 1�� ���ٸ� */ (menu == 1) {
			System.out.println("����� ����� Apple �Դϴ�.");
		} else if/* �׷����ʴٸ� ���࿡ */ (menu == 2) {
			System.out.println("�ٳ����� ����� Banana �Դϴ�.");
			System.out.println("�׸��� ���־��.");
		} else if (menu == 3) {
			System.out.println("������ ����� Grape �Դϴ�.");
		} else/* �׷��� �ʴٸ�(else�� if���� �پ�� ��밡��) *else���� ������ ����. */ {
			System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
		}
	}
}