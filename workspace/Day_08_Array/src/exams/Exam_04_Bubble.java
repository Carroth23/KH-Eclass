package exams;

public class Exam_04_Bubble {

	public static void main(String[] args) {

		int[] arr = { 10, 7, 8, 1, 2, 4, 5, 3, 9, 6 };

		System.out.print("���� �� : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// Bubble ���(n),  n-1���� n-1�� ������ �Ѵ�.
		for (int i = 0; i < arr.length - i; i++) { // n-i(ū���� ������ ������ Ƚ������ ����)
			for (int j = 0; j < arr.length - 1; j++) { // �ٽ� n-1(9�� ����)
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		// ���� �ڵ� - Bubble sort

		System.out.print("���� �� : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
