import java.util.Scanner;

public class Exam_02_Round {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		double a = 4.56;
		double b = 4.42;
		System.out.println(Math.round(a));
		System.out.println(Math.round(b));
		System.out.println(Math.round(a * 10) / 10.0);
		
		double result = (a > b) ? a : b; // 삼항연산자 (if - else)
		
	}
}