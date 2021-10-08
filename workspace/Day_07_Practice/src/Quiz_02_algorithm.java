import java.util.*;

public class Quiz_02_algorithm {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int comscore = 0;
		int playerscore = 0;

		menu: while (true) { // 메뉴선택창.
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
				System.out.println("정답 : " + ran); ///////// 주석 제거시 정답 동시출력 //////

				int input = 0;
				int upcom = 100;
				int downcom = 1;
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
						System.out.println("<<  U P  >>");
					} else if (ran < input) {
						System.out.println("<< D O W N >>");
					} else {
						System.out.println("<<  정답  >>");
						playerscore++;
						break;
					}

					while (true) {
						int dom = ((int) (Math.random() * (upcom - downcom + 1) + downcom));
						System.out.println("컴퓨터의 숫자 : " + dom);
						if (ran > dom) {
							downcom = dom + 1;
						} else if (ran < dom) {
							upcom = dom - 1;
						} else if (ran == dom) {
							System.out.println("컴퓨터가 정답입니다!");
							comscore++;
							continue menu;
						}
						break;
					}
				}
				continue;

			case 2:
				System.out.println("나의 승리횟수 : " + playerscore);
				System.out.println("컴퓨터의 승리횟수 : " + comscore);
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
