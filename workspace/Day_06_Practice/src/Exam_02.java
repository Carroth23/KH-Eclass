import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// ���� ó��
		
		System.out.println("���ڸ� �Է��ϼ��� : ");
		
		try {
			int num = Integer.parseInt(sc.nextLine()); // ������ �߻��Ұ����� ����Ǵ� �ڵ�
		} catch (Exception e) { // catch�� ������ �߻��� �̷��� óġ�ϼ��� ��� ����, ������ �����ʴ´ٸ� ���¼� ģ��.
			System.out.println("�Է��� ���� ���ڰ� �ƴմϴ�.");
		}
		
//		System.out.println("�Է��� ���ڴ� " + num + " �Դϴ�."); // num�� try�� ���������� ������ ���⼱ ��� �Ұ�
		
	}
}
