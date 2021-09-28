package quizs;
import java.util.Scanner;

public class Quiz_06_Lotto {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int bonus = 0; // ���ʽ� ��ȣ ���庯�� ����
		int bonusCh = 0; // ���ʽ� ��÷ Ȯ�ο� ����
		
		int[] lotto = new int[45]; // �ζ� ��ȣ ������ ���� 45���� �迭�� �̷���� �� ����
		int[] mylotto = new int[45]; // �� ��ȣ�� ���� �����
		
		for (int i = 0; i < lotto.length; i++) { // �� ���� ������ �°� 1 ~ 45��ȣ�� �ʱ�ȭ
			lotto[i] = i + 1;
		}
		for (int i = 0; i < mylotto.length; i++) { // ����ȣ �ʱ�ȭ
			mylotto[i] = i + 1;
		}
		
		System.out.println("========== �ζ� ��÷�ùķ����� ==========ver.324");
		System.out.println("\"��� ���Ź���� �����Ͻðڽ��ϱ�?\"");
		System.out.println("[1. ���� ����]");
		System.out.println("[2. �ڵ� ����]");
		System.out.println("[3. 1�� ��÷�ɶ����� �ڵ�]");
		System.out.print(">>");
		int menu = Integer.parseInt(sc.nextLine());

		switch (menu) {
		case 1:
			System.out.println("�� ����� ���� �������� �ʾҽ��ϴ�.");
			break;
		case 2:
				// �ζǹ�ȣ ����
				for (int i = 0; i < lotto.length * 100; i++) {
					int x = (int) (Math.random() * 45);
					int y = (int) (Math.random() * 45);
					int tmp = lotto[x];
					lotto[x] = lotto[y];
					lotto[y] = tmp;
				}
				
				// �ζǹ�ȣ ����
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						if (lotto[j] > lotto[j + 1]) {
							int tmp = lotto[j];
							lotto[j] = lotto[j + 1];
							lotto[j + 1] = tmp;
						}
					}
				}
				
				// ���� �ζǹ�ȣ ����
				for (int i = 0; i < mylotto.length * 100; i++) {
					int x = (int) (Math.random() * 45);
					int y = (int) (Math.random() * 45);
					int tmp = mylotto[x];
					mylotto[x] = mylotto[y];
					mylotto[y] = tmp;
				}

				// ���� �ζǹ�ȣ ����
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						if (mylotto[j] > mylotto[j + 1]) {
							int tmp = mylotto[j];
							mylotto[j] = mylotto[j + 1];
							mylotto[j + 1] = tmp;
						}
					}
				}
				
				// �ζǹ�ȣ ��ǥ
				System.out.print("������ ��÷��ȣ : ");
				for (int i = 0; i < 7; i++) {
					if (i < 6) { // ���ʽ�
						System.out.printf("%2d, ", lotto[i]);
					} else {
						System.out.printf("���ʽ� %2d%n", lotto[i]);
						bonus = lotto[i]; // ���ʽ� ��ȣ ���� ����
					}
				}

				// ���� ��ȣ ���
				System.out.print("���� ��ȣ��    : ");
				for (int i = 0; i < 6; i++) {
					if (i < 5) {
						System.out.printf("%2d, ", mylotto[i]);
					} else {
						System.out.printf("%2d", mylotto[i]);
					}
				}
				System.out.println("�Դϴ�.");
				
				int cnt = 0; // �ζ� �������� Ȯ�ο� ����
				for (int i = 0; i < 7; i++) { // ��÷ Ȯ�� & ���ʽ� Ȯ��
					for (int j = 0; j < 6; j++) {
						if (lotto[i] == mylotto[j]) {
							cnt++;
						}
						if (bonus == mylotto[j]) {
							bonusCh++;
						}
					}
				}

				// ���� ���� �޼��� ���
				if (bonusCh == 1) {
					System.out.printf("%d�� ����! + ���ʽ� ����!%n", cnt);
				} else {
					System.out.printf("%d�� ����!%n", cnt);
				}

				// ��÷ Ȯ�� �޼��� ���
				if (cnt < 3) {
					System.out.println("�ƽ����ϴ� ���Դϴ�.");
				} else if (cnt == 3) {
					System.out.println("\t\t\t\t\t\t\t���ϵ帳�ϴ� 5���Դϴ�.");
				} else if (cnt == 4) {
					System.out.println("\t\t\t\t\t\t\t����ϳ׿� 4���Դϴ�.");
				} else if (cnt == 5 && bonusCh == 0) {
					System.out.println("\t\t\t\t\t\t\t�Ϳ� 3�� ���ϵ帳�ϴ�.");
				} else if (cnt == 5 && bonusCh == 1) {
					System.out.println("\t\t\t\t\t\t\t2���Դϴ�! ��¥ �ζǱ��Ÿ� �����غ�����");
				} else if (bonusCh == 0 && cnt == 6) {
					System.out.println("\t\t\t\t\t\t\t� ��¥ �ζǻ緯 ������!");
				}
				break;
		case 3:
			int count = 0; // ����Ƚ��
			
			// �ζǹ�ȣ ���� ����
			for (int i = 0; i < lotto.length * 100; i++) {
				int x = (int) (Math.random() * 45);
				int y = (int) (Math.random() * 45);
				int tmp = lotto[x];
				lotto[x] = lotto[y];
				lotto[y] = tmp;
			}

			// �ζǹ�ȣ ����
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (lotto[j] > lotto[j + 1]) {
						int tmp = lotto[j];
						lotto[j] = lotto[j + 1];
						lotto[j + 1] = tmp;
					}
				}
			}
			
			// ��÷�ɶ����� �ݺ�
			wp : while (true) {
				System.out.print("������ ��÷��ȣ : "); // �ζǹ�ȣ ��� �˷��༭ �����
				for (int i = 0; i < 7; i++) {
					if (i < 6) { // ���ʽ�
						System.out.printf("%2d, ", lotto[i]);
					} else {
						System.out.printf("���ʽ� %2d%n", lotto[i]);
						bonus = lotto[i]; // ���ʽ� ��ȣ ���� ����
					}
				}
				
				int cnt2 = 0; // �ζ� �������� Ȯ�ο� ����
				
				// ���� �ζǹ�ȣ ����
				for (int i = 0; i < mylotto.length * 300; i++) {
					int x = (int) (Math.random() * 45);
					int y = (int) (Math.random() * 45);
					int tmp = mylotto[x];
					mylotto[x] = mylotto[y];
					mylotto[y] = tmp;
				}

				// ���� ��ȣ ����
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						if (mylotto[j] > mylotto[j + 1]) {
							int tmp = mylotto[j];
							mylotto[j] = mylotto[j + 1];
							mylotto[j + 1] = tmp;
						}
					}
				}

				// ���� ��ȣ ���
				System.out.print("���� ��ȣ��");
				for (int i = 0; i < 6; i++) { 
					if (i < 5) {
						System.out.printf("%2d, ", mylotto[i]);
					} else {
						System.out.printf("%2d", mylotto[i]);
					}
				}
				System.out.println("�Դϴ�.");
				
				// ��÷Ȯ�� & ���ʽ� Ȯ��
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 6; j++) {
						if (lotto[i] == mylotto[j]) {
							cnt2++;
						}
						if (bonus == mylotto[j]) {
							bonusCh++;
						}
					}
				}
				count++; // ����Ƚ�� ī����
				
				// ���� ���� �޼��� ���
				if (bonusCh == 1) {
					System.out.println(count + "��° ����");
					System.out.printf("%d�� ����! + ���ʽ� ����!%n", cnt2);
				} else {
					System.out.println(count + "��° ����");
					System.out.printf("%d�� ����!%n", cnt2);
				}
				
				// ��÷ �޼��� ���
				if (cnt2 == 3) {
					System.out.println("\t\t\t\t\t\t\t���ϵ帳�ϴ� 5���Դϴ�.");
				} else if (cnt2 == 4) {
					System.out.println("\t\t\t\t\t\t\t����ϳ׿� 4���Դϴ�.");
				} else if (cnt2 == 5 && bonusCh == 0) {
					System.out.println("\t\t\t\t\t\t\t�Ϳ� 3�� ���ϵ帳�ϴ�.");
				} else if (cnt2 == 5 && bonusCh == 1) {
					System.out.println("\t\t\t\t\t\t\t2���Դϴ�! ��¥ �ζǱ��Ÿ� �����غ�����");
				} else if (bonusCh == 0 && cnt2 == 6) {
					System.out.println("\t\t\t\t\t\t\t� ��¥ �ζǻ緯 ������!");
					break wp;
				}
				
			}
		}
	}
}