package quizs;
import java.util.*;
public class Quiz_04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] name = new String[3];
		int[] kor = new int[3];
		int[] eng = new int[3];
		
		for (int i = 0; i < name.length; i++) {
			System.out.print(i+1 + " ��° �л��� �̸� : ");
			name[i] = sc.nextLine();
			System.out.print(name[i] + " �л��� ���� : ");
			kor[i] = Integer.parseInt(sc.nextLine());
			System.out.print(name[i] + " �л��� ���� : ");
			eng[i] = Integer.parseInt(sc.nextLine());
		}
		
		System.out.println("============ �� �� ============");
		System.out.println("�̸�\t����\t����\t�հ�\t���");
		for (int i = 0; i < name.length; i++) {
			System.out.printf("%s\t%d\t%d\t%3d\t%.1f%n", name[i], kor[i], eng[i], (kor[i] + eng[i]), (kor[i] + eng[i]) / 2.0);
		}
		
	}

}
