import java.util.Scanner;

public class Quiz_02_If {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int money = 3000;
		int coke = 0;
		int soda = 0;
		int tea = 0;
		int $coke = 1000;
		int $soda = 800;
		int $tea = 1500;

		while (true) {

			System.out.println("=== 자판기 시뮬레이터 ===");
			System.out.println("음료수를 선택하세요.");
			System.out.println("1콜라(" + $coke + ") 2.사이다(" + $soda + ") 3.매실차(" + $tea + ") [0.소지품확인]");
			
			int cho = 0;
			while (true) {
				try {
					cho = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("숫자를 입력해 주세요.");
				}
			}

			if (cho == 1 && money > 1000) {
				coke++;
				money -= $coke;
				System.out.println("콜라를 구매했습니다.");
				System.out.println("콜라 + 1");
				System.out.println("소지금 -1000");
			} else if (cho == 2 && money > 800) {
				soda++;
				money -= $soda;
				System.out.println("사이다를 구매했습니다.");
				System.out.println("사이다 + 1");
				System.out.println("소지금 -800");
			} else if (cho == 3 && money > 1500) {
				tea++;
				money -= $tea;
				System.out.println("매실차를 구매했습니다.");
				System.out.println("매실차 + 1");
				System.out.println("소지금 -1500");
			} else if (cho == 0) {
				System.out.println("====== 소지품 목록 ======");
				System.out.printf("소지금 : %d원%n", money);
				System.out.printf("콜라 : %d개%n", coke);
				System.out.printf("사이다 : %d개%n", soda);
				System.out.printf("매실차 : %d개%n", tea);
			} else {
				System.out.println("잔액이 부족합니다.");
				System.out.println("현재 잔액 : " + money + "원.");
			}

		}
	}

}
