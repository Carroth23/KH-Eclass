import java.util.*;
public class Quiz_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		while (true) {
			System.out.printf("���� �Է� : ");
			int num = sc.nextInt();
			sum += num;
			if (num == 0) {break;}
		}
		System.out.println("�Էµ� ������ �� ���� " + sum);
		
	}
}
