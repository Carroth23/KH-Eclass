import java.util.*;

public class Quiz_02_algorithm {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int comscore = 0;
		int playerscore = 0;

		menu: while (true) { // �޴�����â.
			System.out.println("== Up & Down Game ==");
			int menu = 0; // ������ �޴�

			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print(">");
			while (true) {
				try {
					menu = Integer.parseInt(sc.nextLine());
					if (0 < menu && menu < 4) {
						break;
					}
					System.out.println("�޴��� �ٽ� Ȯ���� �ּ���");
				} catch (Exception e) {
					System.out.println("�޴��� ���ڷ� �Է����ּ���.");
				}
			}

			switch (menu) { // �������α׷� �ڵ�
			case 1:
				System.out.println("<<  Game Start  >>");
				int ran = ((int) (Math.random() * (100 - 1 + 1) + 1));
				System.out.println("���� : " + ran); ///////// �ּ� ���Ž� ���� ������� //////

				int input = 0;
				int upcom = 100;
				int downcom = 1;
				while (true) {
					while (true) {
						try {
							System.out.print("1 ~ 100 �Է� : ");
							input = Integer.parseInt(sc.nextLine());
							if (1 <= input && input <= 100) {
								break;
							}
							System.out.println("1 ~ 100�� �Է��� �ּ���");
						} catch (Exception e) {
							System.out.println("���ڸ� �Է��� �ּ���.");
						}
					}

					if (ran > input) {
						System.out.println("<<  U P  >>");
					} else if (ran < input) {
						System.out.println("<< D O W N >>");
					} else {
						System.out.println("<<  ����  >>");
						playerscore++;
						break;
					}

					while (true) {
						int dom = ((int) (Math.random() * (upcom - downcom + 1) + downcom));
						System.out.println("��ǻ���� ���� : " + dom);
						if (ran > dom) {
							downcom = dom + 1;
						} else if (ran < dom) {
							upcom = dom - 1;
						} else if (ran == dom) {
							System.out.println("��ǻ�Ͱ� �����Դϴ�!");
							comscore++;
							continue menu;
						}
						break;
					}
				}
				continue;

			case 2:
				System.out.println("���� �¸�Ƚ�� : " + playerscore);
				System.out.println("��ǻ���� �¸�Ƚ�� : " + comscore);
				continue;

			case 3:
				System.out.println("������ �����մϴ�.");
//				System.exit(0);
				break; // switch���� ������
			}
			break; // ��ü while���� ������.
		}
	}
}
