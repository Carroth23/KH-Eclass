import java.util.Scanner;

public class Exam_04_Swich {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �����ϼ���.");
		System.out.println("1.���� 2.���� 3.�ٳ���");
		System.out.println(">> ");
		int menu = sc.nextInt();
		
		switch(menu/* ���ڿ��� �����ϴ�. boolean���� �Ұ��� */) {
		case 1:
			// ����ġ�� �ȿ����� ��� ��� ����� �����ϴ�.
			System.out.println("����� ����� Mango");
			break;
		case 2:
			System.out.println("������ ����� Grape");
			break;
		case 3:
			System.out.println("�ٳ����� ����� Banana");
			break;
		default:
		}
		
	}

}
