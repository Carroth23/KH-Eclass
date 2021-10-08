import java.util.*;

public class Quiz_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int bestScore = 100;

		while (true) { // 메뉴선택창.
			System.out.println("== Up & Down Game ==");
			int menu = 0; // 선택한 메뉴

			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print(">");
			while (true) {
				try {
					menu = Integer.parseInt(sc.nextLine());
					if (0 < menu && menu < 4) {
						break;
					}
					System.out.println("메뉴를 다시 확인해 주세요");
				} catch (Exception e) {
					System.out.println("메뉴는 숫자로 입력해주세요.");
				}
			}

			switch (menu) { // 게임프로그램 코드
			case 1:
				System.out.println("<<  Game Start  >>");
				int ran = ((int) (Math.random() * (100 - 1 + 1) + 1));
				System.out.println(ran); // 게임 빨리끝내려고 그냥 출력해버림

				int player = 0;
				int input = 0;
				while (true) {
					while (true) {
						try {
							System.out.print("1 ~ 100 입력 : ");
							input = Integer.parseInt(sc.nextLine());
							if (1 <= input && input <= 100) {
								break;
							}
							System.out.println("1 ~ 100을 입력해 주세요");
						} catch (Exception e) {
							System.out.println("숫자를 입력해 주세요.");
						}
					}

					if (ran > input) {
						player++;
						System.out.println("<<  U P  >>");
					} else if (ran < input) {
						player++;
						System.out.println("<< D O W N >>");
					} else {
						player++;
						System.out.println("<<  정답  >>");
						if (player < bestScore) {
							bestScore = player;
						}
						break;
					}
				}
				continue;

			case 2:
				System.out.println("현재 최고기록은 " + bestScore + " 입니다.");
				continue;

			case 3:
				System.out.println("게임을 종료합니다.");
//				System.exit(0);
				break; // switch문을 나가고
			}
			break; // 전체 while문을 나간다.
		}
	}
}
