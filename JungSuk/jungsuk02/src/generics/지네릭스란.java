package generics;

import java.util.ArrayList;

public class 지네릭스란 {
	public static void main(String[] args) {
		// 지네릭스란 컴파일시 타입을 체크해주는 기능 JDK1.5이후 도입.
		// 객체의 타입 안정성을 높이고 형변환의 번거로움을 줄여줌.
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add("30"); // String을 추가
		
		// 컴파일은 되지만 실제는 string이 들어있어 에러가 발생.
		Integer i = (Integer)list.get(2); // 컴파일러의 한계
		
		// 실행시 발생하는 에러보다는 컴파일에러가 더 낫다.
		System.out.println(list);
		
		// 난 Integer만 저장하겠다고 해주는게 제너릭
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(10);
		list2.add(new Integer(20));
//		list2.add("30"); // 컴파일 에러발생
		
		int listarr = (int)list.get(0);
		int list2arr = list2.get(0); // 형변환 안해도됨.
		
		String strt = null; // 이건 에러발생가능
		String str = ""; // 이렇게 초기화하는게 더 좋은코드.
	}
}
