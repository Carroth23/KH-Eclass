import java.util.*;

public class Exam_01 {

	public static void main(String[] args) {
		// Math.random();
		// ((int)(Math.random() * (최대값 - 최소값 +1) + 최소값)

		Scanner sc = new Scanner(System.in);

		System.out.println("=== 동전 앞 뒤 맞추기 ===");

		while (true) {
			int ran = (int)(Math.random() * 2 + 1);
			System.out.println("숫자를 입력해 주세요 (1.앞면 / 2.뒷면) : ");
			
			int num = 0;
			while (true) {
				try {
					num = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("숫자를 입력해 주세요.");
				}
			}
			
			if (num == ran) {
				System.out.println("맞추셨습니다 ^^");
				System.out.println();
				System.out.println("------------------>restart");
			} else {
				System.out.println();
				System.out.println("땡! 틀렸습니다!");
			}
			
			

		}

	}

}
