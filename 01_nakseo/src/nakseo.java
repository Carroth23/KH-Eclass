import java.util.Scanner;

public class nakseo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 1 ~ n 까지의 합 구하기 ===");
		System.out.print("n 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		int i = 0;
		int j = 0;
		while (num > i) {
			++i;
			j += i;
		}
		System.out.println("1 ~ " + num + "까지의 합은" + j + "입니다.");
	}
}
