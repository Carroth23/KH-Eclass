import java.util.Scanner;

public class nakseo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 1 ~ n ������ �� ���ϱ� ===");
		System.out.print("n �Է� : ");
		int num = Integer.parseInt(sc.nextLine());
		int i = 0;
		int j = 0;
		while (num > i) {
			++i;
			j += i;
		}
		System.out.println("1 ~ " + num + "������ ����" + j + "�Դϴ�.");
	}
}
