import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		// System.in.read(); // �ѱ��ڸ� int������ �Է¹޴´�.
		
		System.out.println("���� �޼����� �̓����ּ���.");
		String str = sc.nextLine(); // �� ������ String������ �Է¹޴´�.
		System.out.println("�Է��� �޼����� : " + str);
	}
}
