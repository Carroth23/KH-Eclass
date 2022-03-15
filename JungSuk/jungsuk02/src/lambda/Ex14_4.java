package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex14_4 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) list.add(i);
		
		// list 모든요소 출력 forEach사용
		list.forEach(i -> System.out.print(i + ", "));
		System.out.println();
		
		// list에서 2 또는 3의 배수 제거
		list.removeIf(i -> i%2==0 || i%3==0);
		System.out.println(list);
		
		// list의 각 요소에 10을 곱
		list.replaceAll(i -> i * 10);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		// map의 모든 요소를 {k, v}형식으로 출력
		map.forEach((k, v) -> System.out.print("{" + k + "," + v + "}"));
		System.out.println();
		// 이전엔 이터레이터로 출력했었음.
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
