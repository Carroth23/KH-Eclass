import java.util.*;
public class Quiz_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		while (true) {
			System.out.printf("숫자 입력 : ");
			int num = sc.nextInt();
			sum += num;
			if (num == 0) {break;}
		}
		System.out.println("입력된 숫자의 총 합은 " + sum);
		
	}
}
