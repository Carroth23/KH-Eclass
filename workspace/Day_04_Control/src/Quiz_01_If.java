import java.util.*;

public class Quiz_01_If {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력값 비교프로그램 ver1.2");
		System.out.println("첫번째 값을 입력해주세요.>");
		int num1 = sc.nextInt();
		System.out.println("두번째 값을 입력해주세요.>");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.println("==== 결 과 ====");
		System.out.println();
		if (num1 > num2) {
			System.out.println("첫 번째 입력한 값이 더 큽니다.");
		} else if (num1 < num2) {
			System.out.println("두 번째 입력한 값이 더 큽니다.");
		} else {
			System.out.println("두 값이 같습니다.");
		}
	}

}
