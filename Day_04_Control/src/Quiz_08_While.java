import java.util.*;

public class Quiz_08_While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �Է� Ƚ����ŭ Hello Java ���
		System.out.println("��� �ݺ� Ƚ�� : ");
		int num = Integer.parseInt(sc.nextLine());

		int i = 0;
		while (i++ < num) {
			System.out.println(i + " : Hello Java");
		}

	}

}
