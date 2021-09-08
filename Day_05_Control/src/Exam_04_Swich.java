import java.util.Scanner;

public class Exam_04_Swich {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("과일을 선택하세요.");
		System.out.println("1.망고 2.포도 3.바나나");
		System.out.println(">> ");
		int menu = sc.nextInt();
		
		switch(menu/* 문자열도 가능하다. boolean값은 불가능 */) {
		case 1:
			// 스위치문 안에서도 모든 제어문 사용이 가능하다.
			System.out.println("망고는 영어로 Mango");
			break;
		case 2:
			System.out.println("포도는 영어로 Grape");
			break;
		case 3:
			System.out.println("바나나는 영어로 Banana");
			break;
		default:
		}
		
	}

}
