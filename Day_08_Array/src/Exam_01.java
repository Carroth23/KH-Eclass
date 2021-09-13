import java.util.*;

public class Exam_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int a;
//		int b;
//		int c;
//		int d; // 변수를 대량으로 생성할 때는 하나하나 다 선언 해주어야 한다.
		
		// 배열은 참조형.
		// new를 통해 만들어지는건 Heap메모리에 저장됨.
//		int[] arr; // 1. 배열 사용을 위한 첫 번째 문법 : Heap메모리에 생성되는 배열의 주소를 저장할 "참조변수" 생성
//		new int[4];// 2. 배열 사용을 위한 두 번째 문법 : 실질적인 배열을 Heap 에다가 생성하는 문법
		
		int[] arr = new int[4]; // 둘중
		int[] arr2 = {10, 20, 30, 40}; // 하나만 가능
		
		
		for (int i = 0; i < 4; i++) { // for문을 이용해 배열값 출력.
			System.out.println(arr2[i]);
		}
		
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
//		arr[4] = 50; 인덱스를 벗어나 에러발생
		// [숫자] 배열의 인덱스 = 배열의 인덱스는 0번부터 시작.
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println(arr[3-3]);
		int a = 2;
		System.out.println(arr[a]); // 대괄호 안에 숫자가 온다면(인덱스 값이라면) 가능하다.
		System.out.println(arr[(int)(Math.random() * 4)]);
//		System.out.println(arr[sc.nextInt()]);
	}
}
// offset : 기준점으로부터 얼마나 떨어졌는가?