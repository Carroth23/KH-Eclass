import java.util.*;

public class Quiz_02_If {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~100 사이의 숫자를 입력해주세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("=== 결 과 ===");

		// 사용자가 입력한 수가 1 ~ 100 사이의 수인지
		// 아닌지
		if (0 < num && num <= 100) {
			if (num % 2 == 0) {
				System.out.println("짝수 입니다.");
			} else {
				System.out.println("홀수 입니다.");
			}
		} else {
			System.out.println("입력한 수의 범위가 잘 못 되었습니다.");
		}

	}

}