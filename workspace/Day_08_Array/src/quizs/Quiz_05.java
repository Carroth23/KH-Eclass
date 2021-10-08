package quizs;
import java.util.*;

public class Quiz_05 {
	public static void main(String[] args) {

		// �ߺ������ʴ� 6���� 1 ~ 45������ ���� + ���ʽ� ��ȣ ( �� 7���� ���� )
		// ������ �ζ� ��ȣ ��õ ���α׷�

		int[] lotto = new int[45]; // 45���� ĭ�� ����

		// �ζǹ�ȣ �ʱ�ȭ 1 ~ 45 ���� �������
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}

		// ��� �ζ� ��ȣ ī�� ���徿 ����
		for (int i = 0; i < lotto.length; i++) {
			int j = (int) (Math.random() * 45);
			int tmp = lotto[i];
			lotto[i] = lotto[j];
			lotto[j] = tmp;
		}

		// ��õ��ȣ�� ��õ��ȣ �迭�� ����
		int[] rcmd = new int[6]; // ������ ���ο� 6ĭ�� �迭 ����
		for (int i = 0; i < 6; i++) {
			rcmd[i] = lotto[i];
		}

		// ��õ ��ȣ �迭 ����
		for (int i = 0; i < rcmd.length - 1; i++) {
			for (int j = 0; j < rcmd.length - 1; j++) {
				if (rcmd[j] > rcmd[j + 1]) {
					int tmp = rcmd[j];
					rcmd[j] = rcmd[j + 1];
					rcmd[j + 1] = tmp;
				}
			}
		}

		// ��õ ��ȣ ��ǥ
		System.out.print("������ �ζ� ��ȣ : ");
		for (int i = 0; i < rcmd.length; i++) {
			System.out.print(rcmd[i] + " ");
		}
		System.out.println("���ʽ� ��ȣ : " + lotto[6]);
	}

}
