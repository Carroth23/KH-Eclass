import java.util.*;

public class Quiz_10_While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ������ ��� ���α׷�

		while (true) {
			System.out.println("=== ������ ��� ���α׷� ===");
			System.out.println("2 ~ 9�� �� ���� : ");
			int dan = Integer.parseInt(sc.nextLine());
			int num = 0;

			if (1 < dan && dan < 10) {
				while (num++ < 10) {
					System.out.println(dan + " * " + num + " = " + dan * num);
				}
			} else {
				System.out.println("������ ������ �ٽ� Ȯ���ϼ���.");
			}
		}
	}
}
