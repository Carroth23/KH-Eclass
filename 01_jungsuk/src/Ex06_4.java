
public class Ex06_4 {
	public static void main(String[] args) {

		MyMath mn = new MyMath();
		long result1 = mn.add(10L, 5L);
		System.out.println("�� �� ���ϱ� : " + result1);
		System.out.println("�� �� ���ϱ� : " + mn.add(5, 10));
		mn.printGugudan(1);
	}

}

class MyMath {
	void printGugudan(int dan) {
		if (!(2 <= dan && dan <= 9)) {
			return; // �Է¹��� ���� 2~9�� �ƴϸ�, �޼��� �����ϰ� ���ư���
		}
		
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d%n", dan, i, dan * i);
		}
	}
	
	long add(long a, long b) {
		return a + b;
	}

	long subtract(long a, long b) {
		return a - b;
	}

	long multiply(long a, long b) {
		return a * b;
	}

	double divide(double a, double b) {
		return a / b;
	}

	int mm(int a, int b) {
		return a > b ? a : b;
	}
}