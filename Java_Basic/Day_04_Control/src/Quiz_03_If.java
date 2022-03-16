import java.util.*;

public class Quiz_03_If {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 프로그램 시작
		System.out.println("성적 관리프로그램 ver2.1");
		System.out.println("===================");
		System.out.print("이 름 : ");
		String name = sc.nextLine();

		// 점수 입력란
		System.out.println("===================");
		System.out.print("국 어 : ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영 어 : ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수 학 : ");
		int math = Integer.parseInt(sc.nextLine());

		// 합계 출력란
		System.out.println("====================");
		int total = kor + eng + math;
		double avg = total / 3.0;

		// indentation - 들여쓰기 / 내어쓰기 : Auto Indent = ctrl + i

		String lev = "D";
		if (avg >= 95) {
			lev = "A+";
		} else if (avg >= 90) {
			lev = "A";
		} else if (avg >= 80) {
			lev = "B";
		} else if (avg >= 70) {
			lev = "C";
		}

		System.out.println("합 계 : " + total);
		System.out.printf("평 균 : %.2f%n", avg);
		System.out.println("성 적 : " + lev);
		System.out.println("====================");

	}

}