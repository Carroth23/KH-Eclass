import java.util.*;

public class Quiz_12_If {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // ��ĳ�� ���
		System.out.println("�۽����÷� �׽�Ʈ ver2.0");
		System.out.println("�� �׽�Ʈ�� �����ִ� ���� �м��� NATURE�� �Ǹ������ �׽�Ʈ�Դϴ�.");
		System.out.println("��� �ڽ��� ��ȣ�ϴ� ������ ���� �ּ���.>");
		String color = sc.nextLine(); // ������� �Է��� ���ڿ��� ����

		System.out.printf("�����Ͻ� ������ %s �Դϴ�.%n", color);
		double ran = Math.random() * 10; // double�� ������ ����
		int dom = (int) ran - 5; // int������ ĳ�����Ͽ� �Ҽ����ڸ� ���ſ� ���̽� ���̱�

		System.out.print("�м���"); // ���� �м����̸鼭 �޸��� �þ�� ������ ����
		char comma = '.';
		int i = 0;
		while (i++ < 13) {
			System.out.print(comma);
			if (i == 13) {
				System.out.println();
			}
		}

		if (dom == 0) { // �ƹ� ���̳� ������ ���̱�
			System.out.printf("%s ������ �����ϴ� ����� ��ȭ�� ����Դϴ�.%n", color);
			System.out.printf("%s ������ �����ϴ� ������� Ư¡�� ���� ���� �����ϰ� ����ϸ�%n", color);
			System.out.println("�׻� ��Ǭ�ٴ� Ư¡�� �ֽ��ϴ�.");
		} else if (dom == 1) {
			System.out.printf("�׻� Ȱ������ ������ ���� ��� %s ������ �����ϼ̱���.%n", color);
			System.out.printf("%s ������ ��ſ��� �� ������ �Ǹ��� �۽��� �÷��� �ɰ��Դϴ�.", color);
		} else if (dom == 2) {
			System.out.println("������ �ҽ������� �������� ū ���� �ٴ� ���");
			System.out.printf("Ȥ�� %s ������ �������� �����̳���? �׷��ٸ� ���ϼ̽��ϴ�.%n", color);
			System.out.printf("%s ������ ��ſ��� ���� ������ ���ư� ��⸦ �Ҿ�־� �ٰ��Դϴ�.", color);
		} else if (dom == 3) {
			System.out.printf("%s �� ������ �ٷ� ���, �ְ��� ���ջ����� �����ϼ̳׿�!%n", color);
			System.out.println("�����ε� " + color + " ����� �Բ� ���� ���� ��ٸ��ſ���.");
		} else if (dom == 4) {
			System.out.printf("��Ű� �Ϻ��� ��︮���� ������ %s ������ ������ ����� �����ٰ��Դϴ�.%n", color);
			System.out.println("�����ΰ� ������ " + color + " ������ ����� �شٸ�, " + color + " ������ �ְ��� �۽��� �÷��� �ɰ��Դϴ�.");
		} else {
			System.out.printf("�����մϴ�. ����Ʈ ������ ���̱���.!%n%s ����� �Բ���� �����ε� �� �������� ������Դϴ�.", color);
		}
	}

}
