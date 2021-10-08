package quizs;
import java.util.Scanner;

public class Quiz_06_Lotto {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int bonus = 0; // 보너스 번호 저장변수 생성
		int bonusCh = 0; // 보너스 당첨 확인용 변수
		
		int[] lotto = new int[45]; // 로또 번호 저장을 위한 45개의 배열로 이루어진 방 생성
		int[] mylotto = new int[45]; // 내 번호를 위해 재생성
		
		for (int i = 0; i < lotto.length; i++) { // 각 방의 순서에 맞게 1 ~ 45번호를 초기화
			lotto[i] = i + 1;
		}
		for (int i = 0; i < mylotto.length; i++) { // 내번호 초기화
			mylotto[i] = i + 1;
		}
		
		System.out.println("========== 로또 당첨시뮬레이터 ==========ver.324");
		System.out.println("\"어떠한 구매방식을 선택하시겠습니까?\"");
		System.out.println("[1. 수동 구매]");
		System.out.println("[2. 자동 구매]");
		System.out.println("[3. 1등 당첨될때까지 자동]");
		System.out.print(">>");
		int menu = Integer.parseInt(sc.nextLine());

		switch (menu) {
		case 1:
			System.out.println("이 기능은 아직 구현되지 않았습니다.");
			break;
		case 2:
				// 로또번호 섞기
				for (int i = 0; i < lotto.length * 100; i++) {
					int x = (int) (Math.random() * 45);
					int y = (int) (Math.random() * 45);
					int tmp = lotto[x];
					lotto[x] = lotto[y];
					lotto[y] = tmp;
				}
				
				// 로또번호 정렬
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						if (lotto[j] > lotto[j + 1]) {
							int tmp = lotto[j];
							lotto[j] = lotto[j + 1];
							lotto[j + 1] = tmp;
						}
					}
				}
				
				// 나의 로또번호 섞기
				for (int i = 0; i < mylotto.length * 100; i++) {
					int x = (int) (Math.random() * 45);
					int y = (int) (Math.random() * 45);
					int tmp = mylotto[x];
					mylotto[x] = mylotto[y];
					mylotto[y] = tmp;
				}

				// 나의 로또번호 정렬
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						if (mylotto[j] > mylotto[j + 1]) {
							int tmp = mylotto[j];
							mylotto[j] = mylotto[j + 1];
							mylotto[j + 1] = tmp;
						}
					}
				}
				
				// 로또번호 발표
				System.out.print("오늘의 당첨번호 : ");
				for (int i = 0; i < 7; i++) {
					if (i < 6) { // 보너스
						System.out.printf("%2d, ", lotto[i]);
					} else {
						System.out.printf("보너스 %2d%n", lotto[i]);
						bonus = lotto[i]; // 보너스 번호 따로 저장
					}
				}

				// 나의 번호 출력
				System.out.print("나의 번호는    : ");
				for (int i = 0; i < 6; i++) {
					if (i < 5) {
						System.out.printf("%2d, ", mylotto[i]);
					} else {
						System.out.printf("%2d", mylotto[i]);
					}
				}
				System.out.println("입니다.");
				
				int cnt = 0; // 로또 맞은개수 확인용 변수
				for (int i = 0; i < 7; i++) { // 당첨 확인 & 보너스 확인
					for (int j = 0; j < 6; j++) {
						if (lotto[i] == mylotto[j]) {
							cnt++;
						}
						if (bonus == mylotto[j]) {
							bonusCh++;
						}
					}
				}

				// 맞은 개수 메세지 출력
				if (bonusCh == 1) {
					System.out.printf("%d개 적중! + 보너스 적중!%n", cnt);
				} else {
					System.out.printf("%d개 적중!%n", cnt);
				}

				// 당첨 확인 메세지 출력
				if (cnt < 3) {
					System.out.println("아쉽습니다 꽝입니다.");
				} else if (cnt == 3) {
					System.out.println("\t\t\t\t\t\t\t축하드립니다 5등입니다.");
				} else if (cnt == 4) {
					System.out.println("\t\t\t\t\t\t\t희귀하네요 4등입니다.");
				} else if (cnt == 5 && bonusCh == 0) {
					System.out.println("\t\t\t\t\t\t\t와우 3등 축하드립니다.");
				} else if (cnt == 5 && bonusCh == 1) {
					System.out.println("\t\t\t\t\t\t\t2등입니다! 진짜 로또구매를 생각해보세요");
				} else if (bonusCh == 0 && cnt == 6) {
					System.out.println("\t\t\t\t\t\t\t어서 진짜 로또사러 가세요!");
				}
				break;
		case 3:
			int count = 0; // 도전횟수
			
			// 로또번호 섞고 고정
			for (int i = 0; i < lotto.length * 100; i++) {
				int x = (int) (Math.random() * 45);
				int y = (int) (Math.random() * 45);
				int tmp = lotto[x];
				lotto[x] = lotto[y];
				lotto[y] = tmp;
			}

			// 로또번호 정렬
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (lotto[j] > lotto[j + 1]) {
						int tmp = lotto[j];
						lotto[j] = lotto[j + 1];
						lotto[j + 1] = tmp;
					}
				}
			}
			
			// 당첨될때까지 반복
			wp : while (true) {
				System.out.print("오늘의 당첨번호 : "); // 로또번호 계속 알려줘서 희망고문
				for (int i = 0; i < 7; i++) {
					if (i < 6) { // 보너스
						System.out.printf("%2d, ", lotto[i]);
					} else {
						System.out.printf("보너스 %2d%n", lotto[i]);
						bonus = lotto[i]; // 보너스 번호 따로 저장
					}
				}
				
				int cnt2 = 0; // 로또 맞은개수 확인용 변수
				
				// 나의 로또번호 섞기
				for (int i = 0; i < mylotto.length * 300; i++) {
					int x = (int) (Math.random() * 45);
					int y = (int) (Math.random() * 45);
					int tmp = mylotto[x];
					mylotto[x] = mylotto[y];
					mylotto[y] = tmp;
				}

				// 나의 번호 정렬
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						if (mylotto[j] > mylotto[j + 1]) {
							int tmp = mylotto[j];
							mylotto[j] = mylotto[j + 1];
							mylotto[j + 1] = tmp;
						}
					}
				}

				// 나의 번호 출력
				System.out.print("나의 번호는");
				for (int i = 0; i < 6; i++) { 
					if (i < 5) {
						System.out.printf("%2d, ", mylotto[i]);
					} else {
						System.out.printf("%2d", mylotto[i]);
					}
				}
				System.out.println("입니다.");
				
				// 당첨확인 & 보너스 확인
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 6; j++) {
						if (lotto[i] == mylotto[j]) {
							cnt2++;
						}
						if (bonus == mylotto[j]) {
							bonusCh++;
						}
					}
				}
				count++; // 도전횟수 카운팅
				
				// 맞은 개수 메세지 출력
				if (bonusCh == 1) {
					System.out.println(count + "번째 구매");
					System.out.printf("%d개 적중! + 보너스 적중!%n", cnt2);
				} else {
					System.out.println(count + "번째 구매");
					System.out.printf("%d개 적중!%n", cnt2);
				}
				
				// 당첨 메세지 출력
				if (cnt2 == 3) {
					System.out.println("\t\t\t\t\t\t\t축하드립니다 5등입니다.");
				} else if (cnt2 == 4) {
					System.out.println("\t\t\t\t\t\t\t희귀하네요 4등입니다.");
				} else if (cnt2 == 5 && bonusCh == 0) {
					System.out.println("\t\t\t\t\t\t\t와우 3등 축하드립니다.");
				} else if (cnt2 == 5 && bonusCh == 1) {
					System.out.println("\t\t\t\t\t\t\t2등입니다! 진짜 로또구매를 생각해보세요");
				} else if (bonusCh == 0 && cnt2 == 6) {
					System.out.println("\t\t\t\t\t\t\t어서 진짜 로또사러 가세요!");
					break wp;
				}
				
			}
		}
	}
}