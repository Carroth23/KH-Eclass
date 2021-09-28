import java.util.Scanner;

public class Exam_03_Try {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("=== ���� ���α׷� ===");

		while (true) {
			System.out.println(); // �ٹٲ�
			System.out.println("������ �Է� (+, -, *, /) : ");
			String oper = sc.nextLine(); // �Է°� ����

			if (!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/")) {
				// ������ �̿��� ���� ������ �����
				System.out.println("���⿡ ���õ� �����ڰ� �ƴմϴ�.");
				System.out.println(); // �ٹٲ�

				System.out.println("������ �����Ͻðڽ��ϱ�? Y/N"); // ������ ���� ������
				String qes1 = sc.nextLine();
				if (qes1.equals("y") || qes1.equals("Y")) {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}
				continue; // �ٽý���
			}
			
			int num1 = 0;
			int num2 = 0;

//			while (true) { �̷��� ���� �� ������, �̷��� ����ڰ� �����ϴ�.
//				try {
//					System.out.println("ù ��° ���� �Է� : ");
//					num1 = Integer.parseInt(sc.nextLine());
//
//					System.out.println("�� ��° ���� �Է� : ");
//					num2 = Integer.parseInt(sc.nextLine());
//					break;
//				} catch (Exception e) {
//					System.out.println("���ڸ� Ȯ�����ּ���.");
//					continue;
//				}
//			}
			
			while (true) {
				try {
					System.out.println("ù ��° ���� �Է� : ");
					num1 = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("���ڸ� �Է��� �ּ���.");
//					continue; // ��Ƽ���� ��� �ȴ�. ������ ���� �ö󰡱� ����.
				}
			}
			
			while (true) {
				try {
					System.out.println("�� ��° ���� �Է� : ");
					num2 = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("���ڸ� �Է��� �ּ���.");
				}
			}
			
			
			System.out.println(); // �ٹٲ�
			System.out.println("====== �� �� ======");
			System.out.println();

			switch (oper) {
			case "+":
				System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
				break;
			case "-":
				System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
				break;
			case "*":
				System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
				break;
			case "/":
				System.out.printf("%d / %d = %.1f%n", num1, num2, ((double) num1 / num2));
				break;
			}

			System.out.println("������ �����Ͻðڽ��ϱ�? Y/N"); // ������ ���� ������
			String qes2 = sc.nextLine();
			if (qes2.equals("y") || qes2.equals("Y")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	}
}
