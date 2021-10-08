package quizs;
import java.util.*;
public class Quiz_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		
//		System.out.print("1 번째 수 : ");
//		x = sc.nextInt();
//		System.out.print("2 번째 수 : ");
//		y = sc.nextInt();
//		System.out.print("3 번째 수 : ");
//		z = sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + 1 + "번째 수 입력 : ");
			arr[i] = sc.nextInt();
			if (i == arr.length - 1) {
				System.out.println(Arrays.toString(arr));
			}
		}
		
		for (int i = 0; i< arr.length; i++) {
			System.out.println(i +1 + " 번째 수 : " + arr[i]);
		}
		
	}

}