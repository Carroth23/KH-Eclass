import java.util.*;

public class Quiz_02_While {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int money = 3000;
		int coke = 0;
		int soda = 0;
		int tea = 0;

		while (true) {

			System.out.println("=== 자판기 시뮬레이터 ===");
			System.out.println("음료수를 선택하세요.");
			System.out.println("1콜라(1000) 2.사이다(800) 3.매실차(1500) [0.소지품확인]");
			int cho = Integer.parseInt(sc.nextLine());

			switch (cho) {
			case 1:
				if (money > 1000) {
					System.out.println("콜라를 구매했습니다.");
					System.out.println("콜라 +1");
					System.out.println("소지금 -1000");
					coke += 1;
					money -= 1000;
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 2:
				if (money > 800) {
					System.out.println("사이다를 구매했습니다.");
					System.out.println("사이다 +1");
					System.out.println("소지금 -800");
					soda += 1;
					money -= 800;
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 3:
				if (money > 1500) {
					System.out.println("매실차를 구매했습니다.");
					System.out.println("매실차 +1");
					System.out.println("소지금 -1500");
					tea += 1;
					money -= 1500;
				} else {
					System.out.println("잔액이 부족합니다.");
				}
				break;
			case 0:
				System.out.println("===== 소지품 목록 =====");
				System.out.println("소지금 : " + money + "원");
				System.out.println("콜라 : " + coke + "개");
				System.out.println("사이다 : " + soda + "개");
				System.out.println("매실차 : " + tea + "개");
			}
		}
	}
}
