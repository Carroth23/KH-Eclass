import java.util.Scanner;

public class Quiz_02_If {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int money = 3000;
		int coke = 0;
		int soda = 0;
		int tea = 0;
		int $coke = 1000;
		int $soda = 800;
		int $tea = 1500;

		while (true) {

			System.out.println("=== ���Ǳ� �ùķ����� ===");
			System.out.println("������� �����ϼ���.");
			System.out.println("1�ݶ�(" + $coke + ") 2.���̴�(" + $soda + ") 3.�Ž���(" + $tea + ") [0.����ǰȮ��]");
			
			int cho = 0;
			while (true) {
				try {
					cho = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("���ڸ� �Է��� �ּ���.");
				}
			}

			if (cho == 1 && money > 1000) {
				coke++;
				money -= $coke;
				System.out.println("�ݶ� �����߽��ϴ�.");
				System.out.println("�ݶ� + 1");
				System.out.println("������ -1000");
			} else if (cho == 2 && money > 800) {
				soda++;
				money -= $soda;
				System.out.println("���̴ٸ� �����߽��ϴ�.");
				System.out.println("���̴� + 1");
				System.out.println("������ -800");
			} else if (cho == 3 && money > 1500) {
				tea++;
				money -= $tea;
				System.out.println("�Ž����� �����߽��ϴ�.");
				System.out.println("�Ž��� + 1");
				System.out.println("������ -1500");
			} else if (cho == 0) {
				System.out.println("====== ����ǰ ��� ======");
				System.out.printf("������ : %d��%n", money);
				System.out.printf("�ݶ� : %d��%n", coke);
				System.out.printf("���̴� : %d��%n", soda);
				System.out.printf("�Ž��� : %d��%n", tea);
			} else {
				System.out.println("�ܾ��� �����մϴ�.");
				System.out.println("���� �ܾ� : " + money + "��.");
			}

		}
	}

}
