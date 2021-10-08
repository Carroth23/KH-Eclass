import java.util.*;

public class Quiz_01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		System.out.println("***ATM 시뮬레이터***");
		
		while(true) {
			System.out.println("****************");
			System.out.println("1. 잔액조회");
			System.out.println("2. 입금하기");
			System.out.println("3. 출금하기");
			System.out.println("4. 종료하기");
			System.out.println(">> ");
			
			int num = 0;
			while (true) {
				try {
					num = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("메뉴 숫자를 확인해주세요.");
				}
			}
			
			switch (num) {
			case 1:
				System.out.println("현재 보유중인 잔액은 " + sum + "원 입니다.");
				break;
			case 2:
				System.out.println("얼마를 입금하시겠습니까?");
				
				int put = 0;
				while (true) {
					try {
						put = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("숫자를 입력해 주세요.");
					}
				}
				sum += put;
				System.out.println(put + "원이 입금 되었습니다.");
				break;
			case 3:
				System.out.println("얼마를 출금하시겠습니까?");
				
				int out = 0;
				while (true) {
					try {
						out = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("숫자를 입력해 주세요.");
					}
				}
				if (sum >= out) {
					sum -= out;
					System.out.println(out + "원이 출금되었습니다.");
				} else {
					System.out.println("잔액이 부족합니다. 잔액을 확인해주십시오.");
				}
				break;
			case 4:
				System.out.println("프로그램을 종료하겠습니다.");
//				break; // 혹은 브레이크와 while문에 이름을 줘서 while을 나갈수도 있다.
				 System.exit(0); // 으로도 종료시켜버릴수 있다.
			default:
				System.out.println("메뉴를 다시 확인해주세요");
			}
//			if (num == 4) // 이것도 종료의 한 방법
//				break;
		}
		
	}
}
