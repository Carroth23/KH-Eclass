
public class Ex04 {
	public static void main(String[] args) {
		// 1325 와 9327 을 메모리에 저장하고, 두 수를 곱한 결과를 출력하세요.
		int a = 1325;
		int b = 9327;
		System.out.println("1번 문제 답 : " + (a * b));
		
		// 100억과 5000을 더하여 메모리에 저장하고 출력하세요.
		long c = 10000000000L + 5000;
		System.out.println("2번 문제 답 : " + c);
		
		// 'A'와 'B'를 메모리에 저장하여 출력하세요.
		char f = 'A';
		char g = 'B';
		System.out.println(f);
		System.out.print(g);
		// 옆으로 붙여쓰고싶을땐 ln지우는거 말고 이런 방법도 있다. ("" + f + g)
	}
}
