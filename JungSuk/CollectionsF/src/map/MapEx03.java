package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapEx03 {
	public static void main(String[] args) {
		String[] data = { "A", "K", "A", "K", "D", "K" };
		
		HashMap<String, Integer> map = new HashMap();
		
		for (int i = 0; i < data.length; i++) {
			if(map.containsKey(data[i])) {
				int value = map.get(data[i]);
				map.put(data[i], value + 1);
			} else {
				map.put(data[i], 1);
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			System.out.println();
		}
	}
}
