package set;

import java.util.HashSet;
import java.util.Iterator;

public class ChaKyoHab {

	public static void main(String[] args) {
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet kyo = new HashSet();
		HashSet cha = new HashSet();
		HashSet hab = new HashSet();
		
		setA.add("1"); setA.add("2"); setA.add("3");
		setA.add("4"); setA.add("5");
		
		setB.add("4"); setB.add("5"); setB.add("6");
		setB.add("7"); setB.add("8");
		
		Iterator it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(setB.contains(tmp)) {
				kyo.add(tmp);
			}
		}
//		setA.retainAll(setB); // 교집합
//		setA.addAll(setB); // 합집합
		setA.removeAll(setB); // 차집합
		System.out.println(setA);
	}

}
