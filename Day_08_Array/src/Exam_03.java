
public class Exam_03 {
	public static void main(String[] args) {
		
		// SWAP
		
		int a = 10;
		int b = 20;
		int tmp;
		
		tmp = a;
		a = b;
		b = tmp;
		
		// --------------------------------
		int[] arr = {10, 20};
		
		System.out.println(arr[0] + " : " + arr[1]); // 10 : 20
		
		// swap code
		tmp = arr[0];
		arr[0] = arr[1];
		arr[1] = tmp;
		
		System.out.println(arr[0] + " : " + arr[1]); // 20 : 10
		
	}
}
