import java.util.*;

public class Exam_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int a;
//		int b;
//		int c;
//		int d; // ������ �뷮���� ������ ���� �ϳ��ϳ� �� ���� ���־�� �Ѵ�.
		
		// �迭�� ������.
		// new�� ���� ��������°� Heap�޸𸮿� �����.
//		int[] arr; // 1. �迭 ����� ���� ù ��° ���� : Heap�޸𸮿� �����Ǵ� �迭�� �ּҸ� ������ "��������" ����
//		new int[4];// 2. �迭 ����� ���� �� ��° ���� : �������� �迭�� Heap ���ٰ� �����ϴ� ����
		
		int[] arr = new int[4]; // ����
		int[] arr2 = {10, 20, 30, 40}; // �ϳ��� ����
		
		
		for (int i = 0; i < 4; i++) { // for���� �̿��� �迭�� ���.
			System.out.println(arr2[i]);
		}
		
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
//		arr[4] = 50; �ε����� ��� �����߻�
		// [����] �迭�� �ε��� = �迭�� �ε����� 0������ ����.
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println(arr[3-3]);
		int a = 2;
		System.out.println(arr[a]); // ���ȣ �ȿ� ���ڰ� �´ٸ�(�ε��� ���̶��) �����ϴ�.
		System.out.println(arr[(int)(Math.random() * 4)]);
//		System.out.println(arr[sc.nextInt()]);
	}
}
// offset : ���������κ��� �󸶳� �������°�?