package set;

import java.util.HashSet;
import java.util.Set;

public class Ex01 {
	public static void main(String[] args) {
		Object[] objarr = {"1", new Integer(1), "2", "2", "3", "4"};
		Set set = new HashSet();
		
		for(int i = 0; i < objarr.length; i++) {
			set.add(objarr[i]);
		}
		
		System.out.println(set);
		System.out.println(set.contains(1));
	}
}
