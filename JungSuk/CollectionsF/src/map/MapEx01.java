package map;

import java.util.HashMap;
import java.util.Scanner;

public class MapEx01 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "12345");
		// 같은 키값이라면 밑에껄로 덮어씌워진다.
		System.out.println(map.entrySet());
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("id와 pw를 입력해주세요.");
			System.out.print("id : ");
			String id = sc.nextLine().trim();
			if(!map.containsKey(id)) {
				System.out.println("입력하신 id는 존재하지 않습니다.");
				continue;
			}
			
			System.out.print("pw : ");
			String pw = sc.nextLine().trim();
			System.out.println();
			
			// id키값에 해당하는 value가 오게됨.
			if(!(map.get(id).equals(pw))) {
				System.out.println("비밀번호가 일치하지않습니다.");
			} else {
				System.out.println("로그인 성공");
				break;
			}
		}
	}
}
