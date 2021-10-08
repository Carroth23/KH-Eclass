import java.util.*;
public class Quiz_11_While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		=== 1~n까지의 합 구하기===
//		n 입력 : 100
//		1~100까지의 합은 5050입니다.
		
		System.out.println("=== 1 ~ n 까지의 합 구하기 ===");
		System.out.println("n 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		int sum = 1;
		int i = 1;
		while (i++ < num) {
			sum += i;
		}
		System.out.printf("1 ~ %d 까지의 합은 %d 입니다.", num, sum);
		
	}

}
