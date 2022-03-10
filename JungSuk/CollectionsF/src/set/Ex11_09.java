package set;

import java.util.*;

public class Ex11_09 {

	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "4", "4", "4"};
		Set set = new HashSet();
		for(int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]);
		}
		System.out.println(set);
		// set은 순서 유지 X, 중복 X
		
		
		Iterator lt = set.iterator();
		while(lt.hasNext()) {
			System.out.println(lt.next());
		}
		
	}

}
