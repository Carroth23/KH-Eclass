import java.util.*;

public class Ex02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 여러자리 숫자 두 개를 입력받아
		// 덧셈한 결과를 출력하는 프로그램을 작성하세요.

		System.out.println("첫번째 숫자를 입력해 주세요.");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("두번째 숫자를 입력해 주세요.");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.println("덧셈한 결과는 : " + (num1 + num2) + " 입니다.");
	}

}