package iteratorM;

import java.util.*;

public class IteratorM {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator lt = list.iterator();
		while(lt.hasNext()) {
			System.out.println(lt.next());
		}
		
		HashSet set = new HashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		
		Iterator li2 = set.iterator();
		while(li2.hasNext()) {
			System.out.println(li2.next());
		}
	}

}
