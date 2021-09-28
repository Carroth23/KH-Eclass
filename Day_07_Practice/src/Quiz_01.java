import java.util.*;

public class Quiz_01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("=== 가위 바위 보 게임 ===");
		int sel = 0;
		while (true) {
			try {
				System.out.println("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
				sel = Integer.parseInt(sc.nextLine());
				if (0 < sel && sel < 4) {break;}
				System.out.println("메뉴 범위를 다시 확인해주세요.");
			} catch (Exception e) {System.out.println("메뉴를 확인하고 다시 입력해주세요.");}
		}
		
		System.out.println("======= 결과 =======");
		if (sel == 1) {
			System.out.println("당신은 가위를 냈습니다.");
		} else if (sel == 2) {
			System.out.println("당신은 바위를 냈습니다.");
		} else if (sel == 3) {
			System.out.println("당신은 보를 냈습니다.");
		}
		
		int ran = (int) (Math.random() * 3 + 1); // 컴퓨터가 생성한 난수
		if (ran == 1) {
			System.out.println("컴퓨터는 가위를 냈습니다.");
		} else if (ran == 2) {
			System.out.println("컴퓨터는 바위를 냈습니다.");
		} else if (ran == 3) {
			System.out.println("컴퓨터는 보를 냈습니다.");
		}

		System.out.println("====================");
		if ((sel == 1 && ran == 3) || (sel == 2 && ran == 1) || (sel == 3 && ran == 2)) {
			System.out.println("당신이 이겼습니다!");
		} else if (sel == ran) {
			System.out.println("비겼습니다.");
		} else {
			System.out.println("컴퓨터가 이겼습니다!");
		}

	}
}