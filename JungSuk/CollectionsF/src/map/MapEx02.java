package map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx02 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", 90);
		map.put("김자바", 100);
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry e = (Entry) it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}
		
		System.out.println("참가자 명단 : " + map.keySet());
		System.out.println("점수들 : " + map.values());
		
		Collection values = map.values();
		it = values.iterator();
		int sum = 0;
		while(it.hasNext()) {
			int i = (int)it.next();
			sum += i;
		}
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (float)sum / set.size());
		System.out.println("최고점 : " + Collections.max(values));
	}

}
