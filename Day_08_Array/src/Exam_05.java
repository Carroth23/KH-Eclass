import java.util.*;

public class Exam_05 {

	public static void main(String[] args) {

		// �ߺ����� �ʴ� ���� ����� ���.
//		System.out.println((int)(Math.random() * 5 + 1));
//		System.out.println((int)(Math.random() * 5 + 1));
//		System.out.println((int)(Math.random() * 5 + 1));

		// 1 ~ 5 ������ �ߺ����� �ʴ� ���� 3�� �����!
		// ī�弯�� �˰���

		int[] arr = { 1, 2, 3, 4, 5 };

		// ������� ī�弯�� �˰���
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
