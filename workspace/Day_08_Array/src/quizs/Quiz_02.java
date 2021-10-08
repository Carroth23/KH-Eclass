package quizs;

public class Quiz_02 {
	public static void main(String[] args) {
		// int형 배열 100 칸 짜리 arr1을 만들고, 1부터 100까지 저장해 보세요.
		// 잘 저장했는지 확인하는 방법

		int[] arr1 = new int[100];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i + 1;
		}

		System.out.println(arr1[0]);
		System.out.println(arr1[99]);

		// int형 배열 100칸짜리 arr2를 만들고, 100부터 1까지 저장해보세요.

		int[] arr2 = new int[100];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = 100 - i;
		}

		System.out.println();
		System.out.println(arr2[0]);
		System.out.println(arr2[99]);
		
		// char형 배열 26칸짜리를 arr3 로 만들고, Z-A 까지 저장해보세요.
		
		char[] arr3 = new char[26];
		
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = (char) ('Z' - i); // 'Z'에서 int i를 빼면 int로 변환되기때문에 char로 다시 형변환.
		}
		
		System.out.println();
		System.out.println(arr3[0]); // Z
		System.out.println(arr3[25]); // A
	}
}
