package list;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysProc {
	public static void main(String[] args) {
		// ArrayList는 동기화처리가 안되어있다.
		// Vector은 동기화처리되어있음
		int[] arr = {0,1,2,3,4};
		
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list.size());
		list.remove(new Integer(5));
		System.out.println(list.size());
		
		// 리스트 지울땐 되도록 뒤에서부터 지워야댐
	}
}
