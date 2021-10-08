import java.util.*;

public class Quiz_02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 계산기 프로그램 ===");
		
		while (true) {
			System.out.println(); // 줄바꿈
			System.out.println("연산자 입력 (+, -, *, /) : ");
			String oper = sc.nextLine(); // 입력값 저장

			if (!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/")) {
				// 연산자 이외의 값을 누르면 재시작
				System.out.println("보기에 제시된 연산자가 아닙니다.");
				System.out.println(); // 줄바꿈
				
				System.out.println("연산을 종료하시겠습니까? Y/N"); // 더할지 말지 퀘스쳔
				String qes1 = sc.nextLine();
				if (qes1.equals("y") || qes1.equals("Y")) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				continue; // 다시시작
			}
			
			System.out.println("첫 번째 숫자 입력 : ");
			int num1 = Integer.parseInt(sc.nextLine());
			
			System.out.println("두 번째 숫자 입력 : ");
			int num2 = Integer.parseInt(sc.nextLine());
			
			System.out.println(); // 줄바꿈
			System.out.println("====== 결 과 ======");
			System.out.println();

			switch (oper) {
			case "+":
				System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
				break;
			case "-":
				System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
				break;
			case "*":
				System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
				break;
			case "/":
				System.out.printf("%d / %d = %.1f%n", num1, num2, ((double)num1 / num2));
				break;
			}
			
			System.out.println("연산을 종료하시겠습니까? Y/N"); // 더할지 말지 퀘스쳔
			String qes2 = sc.nextLine();
			if (qes2.equals("y") || qes2.equals("Y")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
