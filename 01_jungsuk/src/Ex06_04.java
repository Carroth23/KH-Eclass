
public class Ex06_04 {
	public static void main(String[] args) {

		MyMath mn = new MyMath();
		long result1 = mn.add(10L, 5L);
		System.out.println("두 값 더하기 : " + result1);
		System.out.println("두 값 더하기 : " + mn.add(5, 10));
		mn.printGugudan(1);
	}

}

class MyMath {
	void printGugudan(int dan) {
		if (!(2 <= dan && dan <= 9)) {
			return; // 입력받은 단이 2~9가 아니면, 메서드 종료하고 돌아가기
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