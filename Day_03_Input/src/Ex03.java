import java.util.Scanner;
public class Ex03 {
	
	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		// 이름 : 홍길동
		// 국어 : 100, 영어 : 98, 수학 : 75
		// 합계 : 273, 평균 : 91.00
		System.out.println("이름을 입력해 주세요.>");
		String name = sc.nextLine();
		System.out.println("국어 성적을 입력해 주세요.>");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("영어 성적을 입력해 주세요.>");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.println("수학 성적을 입력해 주세요.>");
		int num3 = Integer.parseInt(sc.nextLine());
		
		int sum = num1 + num2 + num3;
		double per = (num1 + num2 + num3) / 3;
		
		System.out.println("성적 관리프로그램 ver2.1");
		System.out.println("===================");
		System.out.println("이 름 : " + name);
		System.out.println("===================");
		System.out.println("국 어 : " + num1);
		System.out.println("영 어 : " + num2);
		System.out.println("수 학 : " + num3);
		System.out.println("===================");
		System.out.println("합 계 : " + sum);
		System.out.printf("평 균 : %.2f%n", per);
		System.out.println("===================");
	}
}