import java.util.*;

public class Quiz_02_While {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int money = 3000;
		int coke = 0;
		int soda = 0;
		int tea = 0;

		while (true) {

			System.out.println("=== ���Ǳ� �ùķ����� ===");
			System.out.println("������� �����ϼ���.");
			System.out.println("1�ݶ�(1000) 2.���̴�(800) 3.�Ž���(1500) [0.����ǰȮ��]");
			int cho = Integer.parseInt(sc.nextLine());

			switch (cho) {
			case 1:
				if (money > 1000) {
					System.out.println("�ݶ� �����߽��ϴ�.");
					System.out.println("�ݶ� +1");
					System.out.println("������ -1000");
					coke += 1;
					money -= 1000;
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				break;
			case 2:
				if (money > 800) {
					System.out.println("���̴ٸ� �����߽��ϴ�.");
					System.out.println("���̴� +1");
					System.out.println("������ -800");
					soda += 1;
					money -= 800;
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				break;
			case 3:
				if (money > 1500) {
					System.out.println("�Ž����� �����߽��ϴ�.");
					System.out.println("�Ž��� +1");
					System.out.println("������ -1500");
					tea += 1;
					money -= 1500;
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
				}
				break;
			case 0:
				System.out.println("===== ����ǰ ��� =====");
				System.out.println("������ : " + money + "��");
				System.out.println("�ݶ� : " + coke + "��");
				System.out.println("���̴� : " + soda + "��");
				System.out.println("�Ž��� : " + tea + "��");
			}
		}
	}
}
