import java.util.*;

public class Quiz_01_If {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�Է°� �����α׷� ver1.2");
		System.out.println("ù��° ���� �Է����ּ���.>");
		int num1 = sc.nextInt();
		System.out.println("�ι�° ���� �Է����ּ���.>");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.println("==== �� �� ====");
		System.out.println();
		if (num1 > num2) {
			System.out.println("ù ��° �Է��� ���� �� Ů�ϴ�.");
		} else if (num1 < num2) {
			System.out.println("�� ��° �Է��� ���� �� Ů�ϴ�.");
		} else {
			System.out.println("�� ���� �����ϴ�.");
		}
	}

}
