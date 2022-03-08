package list;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList02 {
	public static void main(String[] args) {
		ArrayList arr1 = new ArrayList();
		for(int i = 0; i < 5; i++) {
			arr1.add(i);
		}
//		System.out.println(arr1);
//		for(int i = 0; i < arr1.size(); i++) {
//			arr1.remove(i);
//		}
		System.out.println(arr1);
		System.out.println(arr1.size());
		// 뒤에서부터 지워야 성능 이랑 결과가 확실함
		for(int i = arr1.size()-1; i >= 0; i--) {
			arr1.remove(i);
		}
		System.out.println(arr1);
		
		LinkedList lrr = new LinkedList();
	}
}
