
public class Ex01 {
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		boolean result;
		int result2;
		result2 = x + y; // result2 = 30
		System.out.println(x + " + " + y + " = " + result2); // 30
		x = y = 2; // x, y를 2로 초기화
		System.out.println("x = " + x++ + ", y = " + ++y); // x = 2, y = 3 y는 전위형이므로 +1
		System.out.println("x = " + x + ", y = " + y); // x = 3, y = 3 후위형이었던 x를 +1
		y = 10; // y를 10으로 초기화
		result = !(((x > y) || (y == x)) || ((x != y) && (x < y))); // x = 3, y = 10
		System.out.println(result); // false
	}
}
