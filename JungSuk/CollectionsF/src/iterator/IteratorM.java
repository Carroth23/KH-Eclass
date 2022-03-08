package iterator;

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
	}

}
