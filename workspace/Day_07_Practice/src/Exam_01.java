import java.util.*;

public class Exam_01 {

	public static void main(String[] args) {
		// Math.random();
		// ((int)(Math.random() * (�ִ밪 - �ּҰ� +1) + �ּҰ�)

		Scanner sc = new Scanner(System.in);

		System.out.println("=== ���� �� �� ���߱� ===");

		while (true) {
			int ran = (int)(Math.random() * 2 + 1);
			System.out.println("���ڸ� �Է��� �ּ��� (1.�ո� / 2.�޸�) : ");
			
			int num = 0;
			while (true) {
				try {
					num = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("���ڸ� �Է��� �ּ���.");
				}
			}
			
			if (num == ran) {
				System.out.println("���߼̽��ϴ� ^^");
				System.out.println();
				System.out.println("------------------>restart");
			} else {
				System.out.println();
				System.out.println("��! Ʋ�Ƚ��ϴ�!");
			}
			
			

		}

	}

}
