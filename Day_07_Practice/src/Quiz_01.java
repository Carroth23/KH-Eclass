import java.util.*;

public class Quiz_01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("=== ���� ���� �� ���� ===");
		int sel = 0;
		while (true) {
			try {
				System.out.println("���ڸ� �����ϼ���(1.���� / 2.���� / 3.��) : ");
				sel = Integer.parseInt(sc.nextLine());
				if (0 < sel && sel < 4) {break;}
				System.out.println("�޴� ������ �ٽ� Ȯ�����ּ���.");
			} catch (Exception e) {System.out.println("�޴��� Ȯ���ϰ� �ٽ� �Է����ּ���.");}
		}
		
		System.out.println("======= ��� =======");
		if (sel == 1) {
			System.out.println("����� ������ �½��ϴ�.");
		} else if (sel == 2) {
			System.out.println("����� ������ �½��ϴ�.");
		} else if (sel == 3) {
			System.out.println("����� ���� �½��ϴ�.");
		}
		
		int ran = (int) (Math.random() * 3 + 1); // ��ǻ�Ͱ� ������ ����
		if (ran == 1) {
			System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
		} else if (ran == 2) {
			System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
		} else if (ran == 3) {
			System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
		}

		System.out.println("====================");
		if ((sel == 1 && ran == 3) || (sel == 2 && ran == 1) || (sel == 3 && ran == 2)) {
			System.out.println("����� �̰���ϴ�!");
		} else if (sel == ran) {
			System.out.println("�����ϴ�.");
		} else {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�!");
		}

	}
}