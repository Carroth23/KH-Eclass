
public class Exam_01_01 {

	public static int minus(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
	
	public static int mply(int num1, int num2) {
		return num1 * num2; // �̰͵� ����
	}
	
	public static double divide(int num1, int num2) {
		double result = (double)num1 / num2;
		return result;
	}
	
	public static int bigger(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else if (num1 < num2) {
			return num2;
		} else /*else if�� �ۼ��� ����(�ƹ��͵� ���� �ȵɼ��ִٰ� ��ǻ�ʹ� ������.)*/{
			return 0;
		}
	}
	
	public static void/*���ϰ� ����(����Ÿ�Կ��� void ��밡��)*/ hello()/*�Ű����� ����*/ {
		System.out.println("Hello Java");
	}
	
	public static void main(String[] args) {
		// �� ������ ���ڰ����� ���� �޾�, ������ ����� int�� return�ϴ� minus �޼��� �����.
		System.out.println(minus(10, 5));

		// �� ������ ���ڷ� ���� �޾�, ������ ����� int�� return �ϴ� mply �޼��� �����
		System.out.println(mply(10, 5));
		
		// �� ������ ���ڷ� ���� �޾�, �������� ����� double�� return �ϴ� divide �޼��� �����
		System.out.printf("%.2f%n", divide(10, 3));
		System.out.printf("%.2f%n", tmp(10, 3));
		
		// �� ������ ���ڷ� ���� �޾�, �� ū ���� int �� return �ϴ� bigger �޼��� �����
		// ��, �� ���� ���� ��� 0 �� return
		System.out.println(bigger(20, 20));
		
		//���ڰ��� ����, return���� ���� hello�޼��� �����
		//�޼��尡 ����Ǹ� "Hello Java" ��� ���
		hello();
	}

	public static double tmp(int num1, double num2) { // �ؿ� �ۼ��� ����
		return (double)num1 / num2;
	}
	
}
