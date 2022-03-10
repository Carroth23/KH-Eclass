package set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SetSort {

	public static void main(String[] args) {
		Set set = new HashSet();

		for (int i = 0; set.size() < 11; i++) {
			int num = (int) (Math.random() * 45) + 1;
			set.add(num);
		}
		
		// set은 정렬기능이 없기때문에 list형식으로 바꿔서 정렬
		List list = new LinkedList(set);
		Collections.sort(list);
		System.out.println(list);
	}

}
