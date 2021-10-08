package exams;
import java.util.*;

public class Exam_05 {

	public static void main(String[] args) {

		// 중복되지 않는 수를 만드는 방법.
//		System.out.println((int)(Math.random() * 5 + 1));
//		System.out.println((int)(Math.random() * 5 + 1));
//		System.out.println((int)(Math.random() * 5 + 1));

		// 1 ~ 5 사이의 중복되지 않는 난수 3개 만들기!
		// 카드섞기 알고리즘

		int[] arr = { 1, 2, 3, 4, 5 };

		// 쉬운버전 카드섞기 알고리즘
		for (int i = 0; i < arr.length * 100; i++) {
			int x = (int) (Math.random() * 5); // 0 ~ 4
			int y = (int) (Math.random() * 5); // 0 ~ 4
			int tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}
		System.out.println(arr[0] + " : " + arr[1] + " : " + arr[2]);

	}

}
