import java.util.Scanner;

public class Quiz_03_horseGame {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int money = 0; // 마이 머니
		int horse = 0; // 선택할 말
		int bet = 0; // 배팅할 금액
		int charge = 0; // 충전 금액
		int menu = 0; // 메뉴선택
		
		while (true) {
			System.out.printf("경마게임에 오신 것을 환영합니다.%n");
			System.out.printf("1. 게임 시작%n");
			System.out.printf("2. 잔액 충전%n");
			System.out.printf("3. 잔액 조회%n");
			System.out.printf("4. 종료%n");
			System.out.printf("메뉴를 선택해 주세요 : %n");
			System.out.printf(">> ");

			// ========== 메뉴 선택 ===========
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (1 > menu || menu > 4) {
					System.out.println("메뉴를 다시 확인해 주십시오." + "\n");
				}
			} catch (Exception e) {
				System.out.println("메뉴는 숫자 1 ~ 4번으로 입력해 주십시오." + "\n");
			}

			switch (menu) {
			case 1:
				if (money != 0) {
					// ========== 경주마 선택 ===========
					while (true) {
						System.out.println("경마게임에 오신것을 환영합니다.");
						System.out.println("1. 우승 경력은 많으나 곧 은퇴를 앞둔 말");
						System.out.println("2. 최근 한달동안 돌풍같은 질주를 펼쳤던 말");
						System.out.println("3. 가장 신참이지만 무섭게 떠오르는 말");
						System.out.println("베팅하고 싶은 말을 선택해 주세요. >>");

						while (true) {
							try {
								horse = Integer.parseInt(sc.nextLine());
								if (0 < horse && horse < 4) {
									System.out.println(horse + "번마를 선택하셨습니다.");
									break;
								} else {
									System.out.println("1 ~ 3번 말중 선택하여 주십시오.");
								}
							} catch (Exception e) {
								System.out.println("숫자로 1 ~ 3 번말을 골라 주십시오.");
							}
						}

						// ========== 금액 베팅 ===========
						while (true) {

							while (true) {
								System.out.println("얼마를 베팅 하시겠습니까?");
								try {
									bet = Integer.parseInt(sc.nextLine());
									break;
								} catch (Exception e) {
									System.out.println("금액을 숫자로 입력해 주십시오.");
								}
							}

							if (money >= bet) {
								int winhorse = ((int) (Math.random() * 3) + 1);

								if (horse == winhorse) {
									System.out.println("축하 합니다! 선택한 말이 우승하여 두배의 상금을 얻었습니다!");
									money += (bet * 2);
									break;
								} else {
									System.out.println("아쉽습니다. 간발의 차이로 우승을 놓쳤습니다. 베팅금액은 회수됩니다.");
									money -= bet;
									break;
								}
							} else {
								System.out.println("잔액이 부족합니다.");
								System.out.println("현재 최대 베팅 가능 금액은 : " + money + "원 입니다.");
							}
						}
						break;
					}
				} else {
					System.out.println("잔액을 먼저 충전해 주십시오." + "\n");
				}
				break;
			case 2:
				while (true) {
					System.out.println("얼마를 충전하시겠습니까? : ");
					try {
						charge = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("금액을 숫자로 입력해 주십시오.");
					}
				}
				money += charge; // ===== 금액 충전 =====
				System.out.println(charge + "원이 충전되었습니다. 현재 잔액은 : " + money + "원 입니다.");
				break;
			case 3:
				System.out.println("현재 잔액은 : " + money + "원 입니다.");
				break;
			case 4:
				System.out.println("경마게임을 이용해주셔서 감사합니다.");
				System.exit(0);
			}
		}

	}
}
