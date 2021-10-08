public class Ex03 {

	public static void main(String[] args) {
		
		int i1 = 10;
		int i2 = 20;
		float f1 = 3.14f;
		char c1 = 'A';
		char c2 = 'B';
		System.out.println("결과 : " + i1 + i2); // 문자열 + 정수형 = 문자열 + 정수형 = 문자열
		System.out.println("결과 : " + (i1 + i2)); // ()안에서 연산 먼저 처리
		System.out.println("결과 : " + i1 + f1);
		System.out.println("결과 : " + (i1 + f1));
		System.out.println("결과 : " + f1 + c1);
		System.out.println("결과 : " + (f1 + c1));
		System.out.println("결과 : " + c1 + c2);
		System.out.println("결과 : " + (c1 + c2));
	}

}