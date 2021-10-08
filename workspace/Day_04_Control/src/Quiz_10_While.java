import java.util.*;

public class Quiz_10_While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 구구단 출력 프로그램

		while (true) {
			System.out.println("=== 구구단 출력 프로그램 ===");
			System.out.println("2 ~ 9단 중 선택 : ");
			int dan = Integer.parseInt(sc.nextLine());
			int num = 0;

			if (1 < dan && dan < 10) {
				while (num++ < 10) {
					System.out.println(dan + " * " + num + " = " + dan * num);
				}
			} else {
				System.out.println("구구단 범위를 다시 확인하세요.");
			}
		}
	}
}
