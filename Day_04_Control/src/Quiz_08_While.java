import java.util.*;

public class Quiz_08_While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력 횟수만큼 Hello Java 출력
		System.out.println("출력 반복 횟수 : ");
		int num = Integer.parseInt(sc.nextLine());

		int i = 0;
		while (i++ < num) {
			System.out.println(i + " : Hello Java");
		}

	}

}
