package list;

import java.util.Arrays;

public class ArraysM {

	public static void main(String[] args) {
		int[] arr = {1, 5, 2, 4, 3};
		System.out.println("arr : " + Arrays.toString(arr));
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		System.out.println("arr2 : " + Arrays.toString(arr2));
		int[] arr3 = new int[8];
		Arrays.fill(arr3, 6);
		System.out.println("arr3 : " + Arrays.toString(arr3));
		
		Arrays.sort(arr);
		System.out.println("sort arr : " + Arrays.toString(arr));
		int index = Arrays.binarySearch(arr, 2);
		System.out.println(index);
	}

}
