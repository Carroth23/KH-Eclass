import java.util.Scanner;

public class Ex03 {

	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		// 이름 : 홍길동
		// 국어 : 100, 영어 : 98, 수학 : 75
		// 합계 : 273, 평균 : 91.00
		System.out.println("성적 관리프로그램 ver2.1");
		System.out.println("===================");
		System.out.print("이 름 : ");
		String name = sc.nextLine();
		System.out.println("===================");
		System.out.print("국 어 : ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영 어 : ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수 학 : ");
		int math = Integer.parseInt(sc.nextLine());
		System.out.println("====================");
		int total = kor + eng + math;
		double avg = total / 3.0;
		System.out.println("합 계 : " + total);
		System.out.printf("평 균 : %.2f%n", avg);
		System.out.println("====================");

		// nextInt는 숫자를 가져간후 엔터키를 남겨둔다.
		// nextInt를 다시 사용한다면 nextInt는 엔터를 무시하므로 괜찮지만
		// nextLine는 버퍼에 남아있는 엔터키를 가져오는데 사용됨으로 X

	}
}