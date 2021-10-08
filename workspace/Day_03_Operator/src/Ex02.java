public class Ex02 {

	public static void main(String[] ar) {
		int a = 10;
		int b = 20;
		System.out.println(++a == 10 && b++ == 20); // 숏컷연산으로 인해 &&뒤의 b++는 연산하지않음
		System.out.println(a + " : " + b); // 그러므로 b는 증가되지않은 20으로 출력.
	}
}