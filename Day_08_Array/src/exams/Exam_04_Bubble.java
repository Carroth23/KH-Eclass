package exams;

public class Exam_04_Bubble {

	public static void main(String[] args) {

		int[] arr = { 10, 7, 8, 1, 2, 4, 5, 3, 9, 6 };

		System.out.print("정렬 전 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// Bubble 요소(n),  n-1번을 n-1번 돌려야 한다.
		for (int i = 0; i < arr.length - i; i++) { // n-i(큰수를 끝으로 보내고 횟수에서 제외)
			for (int j = 0; j < arr.length - 1; j++) { // 다시 n-1(9번 돌림)
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		// 정렬 코드 - Bubble sort

		System.out.print("정렬 후 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
