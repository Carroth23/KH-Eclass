
public class Exam_01_01 {

	public static int minus(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
	
	public static int mply(int num1, int num2) {
		return num1 * num2; // 이것도 가능
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
		} else /*else if로 작성시 에러(아무것도 실행 안될수있다고 컴퓨터는 생각함.)*/{
			return 0;
		}
	}
	
	public static void/*리턴값 없음(리턴타입에만 void 사용가능)*/ hello()/*매개변수 없음*/ {
		System.out.println("Hello Java");
	}
	
	public static void main(String[] args) {
		// 두 정수를 인자값으로 전달 받아, 뺄셈한 결과를 int로 return하는 minus 메서드 만들기.
		System.out.println(minus(10, 5));

		// 두 정수를 인자로 전달 받아, 곱셈한 결과를 int로 return 하는 mply 메서드 만들기
		System.out.println(mply(10, 5));
		
		// 두 정수를 인자로 전달 받아, 나눗셈한 결과를 double로 return 하는 divide 메서드 만들기
		System.out.printf("%.2f%n", divide(10, 3));
		System.out.printf("%.2f%n", tmp(10, 3));
		
		// 두 정수를 인자로 전달 받아, 더 큰 수를 int 로 return 하는 bigger 메서드 만들기
		// 단, 두 수가 같을 경우 0 을 return
		System.out.println(bigger(20, 20));
		
		//인자값이 없고, return값도 없는 hello메서드 만들기
		//메서드가 실행되면 "Hello Java" 라고 출력
		hello();
	}

	public static double tmp(int num1, double num2) { // 밑에 작성도 가능
		return (double)num1 / num2;
	}
	
}
