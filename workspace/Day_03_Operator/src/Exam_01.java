
public class Exam_01 {

	public static void main(String[] args) {

		int a = 10;
//		5 = 20; =대입연산다를 기준으로 왼쪽엔 공간만 올수있다.

		int b = 5;
		a += b; // a = a + b;

		a %= b;
		System.out.println(a);
		System.out.println(b);

		System.out.println(a++);
		System.out.println(++a);

	}

}
