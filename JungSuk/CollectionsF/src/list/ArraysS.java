package list;

import java.util.Arrays;

public class ArraysS {

	public static void main(String[] args) {
		int[] arr = new int[6];
		arr[0] = 3;
		arr[1] = 5;
		arr[2] = 1;
		arr[3] = 2;
		arr[4] = 4;
		arr[5] = 6;
		System.out.println(Arrays.toString(arr));
		
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = Arrays.copyOfRange(arr2, 0, 2);
		System.out.println(Arrays.toString(arr3));
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr2);
		int[] arr4 = new int[6];
		Arrays.fill(arr4, 3);
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.equals(arr, arr2));
	}

}
