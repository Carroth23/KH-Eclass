import java.util.Scanner;

public class Quiz_03_horseGame {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int money = 0;
		while (true) {
			System.out.printf("�渶���ӿ� ���� ���� ȯ���մϴ�.%n");
			System.out.printf("1. ���� ����%n");
			System.out.printf("2. �ܾ� ����%n");
			System.out.printf("3. �ܾ� ��ȸ%n");
			System.out.printf("4. ����%n");
			System.out.printf("�޴��� ������ �ּ��� : %n");
			System.out.printf(">> ");

			int menu = 0;
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 > menu || menu > 4) {
					System.out.println("�޴��� �ٽ� Ȯ���� �ֽʽÿ�." + "\n");
				}
			} catch (Exception e) {
				System.out.println("�޴��� ���� 1 ~ 4������ �Է��� �ֽʽÿ�." + "\n");
			}

			switch (menu) {
			case 1:
				if (money != 0) {
					while (true) {
						System.out.println("�渶���ӿ� ���Ű��� ȯ���մϴ�.");
						System.out.println("1. ��� ����� ������ �� ���� �յ� ��");
						System.out.println("2. �ֱ� �Ѵ޵��� ��ǳ���� ���ָ� ���ƴ� ��");
						System.out.println("3. ���� ���������� ������ �������� ��");
						System.out.println("�����ϰ� ���� ���� ������ �ּ���. >>");

						int horse = 0;
						while (true) {
							try {
								horse = Integer.parseInt(sc.nextLine());
								if (0 < horse && horse < 4) {
									System.out.println(horse + "������ �����ϼ̽��ϴ�.");
									break;
								} else {
									System.out.println("1 ~ 3�� ���� �����Ͽ� �ֽʽÿ�.");
								}
							} catch (Exception e) {
								System.out.println("���ڷ� 1 ~ 3 ������ ��� �ֽʽÿ�.");
							}
						}

						while (true) {

							int bet = 0;
							while (true) {
								System.out.println("�󸶸� ���� �Ͻðڽ��ϱ�?");
								try {
									bet = Integer.parseInt(sc.nextLine());
									break;
								} catch (Exception e) {
									System.out.println("�ݾ��� ���ڷ� �Է��� �ֽʽÿ�.");
								}
							}

							if (money >= bet) {
								int winhorse = ((int) (Math.random() * 3) + 1);

								if (horse == winhorse) {
									System.out.println("���� �մϴ�! ������ ���� ����Ͽ� �ι��� ����� ������ϴ�!");
									money += (bet * 2);
									break;
								} else {
									System.out.println("�ƽ����ϴ�. ������ ���̷� ����� ���ƽ��ϴ�. ���ñݾ��� ȸ���˴ϴ�.");
									money -= bet;
									break;
								}
							} else {
								System.out.println("�ܾ��� �����մϴ�.");
								System.out.println("���� �ִ� ���� ���� �ݾ��� : " + money + "�� �Դϴ�.");
							}
						}
						break;
					}
				} else {
					System.out.println("�ܾ��� ���� ������ �ֽʽÿ�." + "\n");
				}
				break;
			case 2:
				int charge = 0;
				while (true) {
					System.out.println("�󸶸� �����Ͻðڽ��ϱ�? : ");
					try {
						charge = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("�ݾ��� ���ڷ� �Է��� �ֽʽÿ�.");
					}
				}
				money += charge;
				System.out.println(charge + "���� �����Ǿ����ϴ�. ���� �ܾ��� : " + money + "�� �Դϴ�.");
				break;
			case 3:
				System.out.println("���� �ܾ��� : " + money + "�� �Դϴ�.");
				break;
			case 4:
				System.out.println("�渶������ �̿����ּż� �����մϴ�.");
				System.exit(0);
			}
		}

	}
}
