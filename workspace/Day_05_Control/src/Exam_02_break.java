import java.util.*;
public class Exam_02_break {
	public static void main(String[] args) {
		
		// 1 ���� 10���� ����ϴ� for��
		System.out.println("=== 1 ~ 10���� ����ϱ� ===");
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println(i);
		}
		
	}
}
