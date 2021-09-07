import java.util.Scanner;

public class Exam_01_If {
	public static void main(String[] args) {
		// if - else문 (조건 분기문)
		// true, false만을 반환한다.

		Scanner sc = new Scanner(System.in);

		System.out.println("당신이 좋아하는 과일을 선택하세요.");
		System.out.println("1.사과 2.바나나 3.포도");
		System.out.print(">> ");
		int menu = Integer.parseInt(sc.nextLine());

		if/* 만약에 메뉴안의 값이 1과 같다면 */ (menu == 1) {
			System.out.println("사과는 영어로 Apple 입니다.");
		} else if/* 그렇지않다면 만약에 */ (menu == 2) {
			System.out.println("바나나는 영어로 Banana 입니다.");
			System.out.println("그리고 맛있어요.");
		} else if (menu == 3) {
			System.out.println("포도는 영어로 Grape 입니다.");
		} else/* 그렇지 않다면(else는 if문에 붙어서만 사용가능) *else문은 조건이 없다. */ {
			System.out.println("메뉴를 다시 확인해주세요.");
		}
	}
}