
public class Exam_04_Overload {
	
	// �޼��� ���� �ε�
	// �޼��� �̸��� ���Ƶ� �Ű������� Ÿ���� �ٸ��ų� ������ �ٸ��� ���� �����̸��� �������ش�
	// �޼��� �����ε��� �Ű������� ���̿� ���ؼ��� ��������.
	public static void func(int a) {
		System.out.println("func1() �Դϴ�.");
	}
	
	public static void func(String a) {
		System.out.println("func2() �Դϴ�.");
	}
	
	public static void func() {
		System.out.println("func3() �Դϴ�.");
	}
	
	public static void main(String[] args) {

		func();
		
		
	}
}
