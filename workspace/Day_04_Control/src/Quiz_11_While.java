import java.util.*;
public class Quiz_11_While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		=== 1~n������ �� ���ϱ�===
//		n �Է� : 100
//		1~100������ ���� 5050�Դϴ�.
		
		System.out.println("=== 1 ~ n ������ �� ���ϱ� ===");
		System.out.println("n �Է� : ");
		int num = Integer.parseInt(sc.nextLine());
		int sum = 1;
		int i = 1;
		while (i++ < num) {
			sum += i;
		}
		System.out.printf("1 ~ %d ������ ���� %d �Դϴ�.", num, sum);
		
	}

}
