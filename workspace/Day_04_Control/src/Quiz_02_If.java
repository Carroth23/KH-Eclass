import java.util.*;

public class Quiz_02_If {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~100 ������ ���ڸ� �Է����ּ��� : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("=== �� �� ===");

		// ����ڰ� �Է��� ���� 1 ~ 100 ������ ������
		// �ƴ���
		if (0 < num && num <= 100) {
			if (num % 2 == 0) {
				System.out.println("¦�� �Դϴ�.");
			} else {
				System.out.println("Ȧ�� �Դϴ�.");
			}
		} else {
			System.out.println("�Է��� ���� ������ �� �� �Ǿ����ϴ�.");
		}

	}

}