import java.util.Scanner;

public class Exam_05 {

	public static void main(String[] args) {

//		String a = "Hello";
//		String b = "Hello";
		
//		System.out.println(a == b);
		// �⺻���� Stack�� �ְ�
		// �������� heap�� �ִ�.
		// String a �� ����ִ°� �����Ͱ� ����ִ� ������ �ּҰ� ����ֳ�.
		// �׷��ϱ� �����ڷ������� heap�� �����͸� �����ϰ� Stack�� �� �ּҰ��� ������.
		// �ٵ� String b = new String("Hello");�� ����� Heap�� �ٸ� ������ �� ����.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�޼����� �Է��ϼ���.");
		String msg = sc.nextLine(); // ���������� new String("Apple")��� ����� ����� �Ѵ�.
		
		if (msg == "Apple") {
			System.out.println("�Էµ� �ܾ�� ��� �Դϴ�.");
		}
		// ����� �ȵǴ� ������ ���� �����ó�� new�� ������⶧���� �ּҰ��� �޶���. 
		// ���ڿ������� �ּҰ����� ���ϱ⶧��.
//		�׷��� ���ڿ����� ���Ҷ� 
//		if (msg.equals("Apple")) �� �������� ��. (msg�ȿ� ����ִ� ���ڿ��� "Apple"�� �½��ϱ�.)
	}

}
