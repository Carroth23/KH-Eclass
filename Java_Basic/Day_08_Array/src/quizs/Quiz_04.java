package quizs;
import java.util.*;
public class Quiz_04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String[] name = new String[3];
		int[] kor = new int[3];
		int[] eng = new int[3];
		
		for (int i = 0; i < name.length; i++) {
			System.out.print(i+1 + " 번째 학생의 이름 : ");
			name[i] = sc.nextLine();
			System.out.print(name[i] + " 학생의 국어 : ");
			kor[i] = Integer.parseInt(sc.nextLine());
			System.out.print(name[i] + " 학생의 영어 : ");
			eng[i] = Integer.parseInt(sc.nextLine());
		}
		
		System.out.println("============ 결 과 ============");
		System.out.println("이름\t국어\t영어\t합계\t평균");
		for (int i = 0; i < name.length; i++) {
			System.out.printf("%s\t%d\t%d\t%3d\t%.1f%n", name[i], kor[i], eng[i], (kor[i] + eng[i]), (kor[i] + eng[i]) / 2.0);
		}
		
	}

}