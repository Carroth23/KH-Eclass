package quizs;

public class Quiz_02 {
	public static void main(String[] args) {
		// int�� �迭 100 ĭ ¥�� arr1�� �����, 1���� 100���� ������ ������.
		// �� �����ߴ��� Ȯ���ϴ� ���

		int[] arr1 = new int[100];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i + 1;
		}

		System.out.println(arr1[0]);
		System.out.println(arr1[99]);

		// int�� �迭 100ĭ¥�� arr2�� �����, 100���� 1���� �����غ�����.

		int[] arr2 = new int[100];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = 100 - i;
		}

		System.out.println();
		System.out.println(arr2[0]);
		System.out.println(arr2[99]);
		
		// char�� �迭 26ĭ¥���� arr3 �� �����, Z-A ���� �����غ�����.
		
		char[] arr3 = new char[26];
		
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = (char) ('Z' - i); // 'Z'���� int i�� ���� int�� ��ȯ�Ǳ⶧���� char�� �ٽ� ����ȯ.
		}
		
		System.out.println();
		System.out.println(arr3[0]); // Z
		System.out.println(arr3[25]); // A
	}
}
