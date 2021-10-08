import java.util.*;
public class Exam_02_break {
	public static void main(String[] args) {
		
		// 1 부터 10까지 출력하는 for문
		System.out.println("=== 1 ~ 10까지 출력하기 ===");
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}
		
	}
}
