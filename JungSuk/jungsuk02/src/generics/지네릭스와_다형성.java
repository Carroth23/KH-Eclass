package generics;

import java.util.ArrayList;
import java.util.List;

public class 지네릭스와_다형성 {
	public static void main(String[] args) {
		// Box<T> 지네릭 클래스
		// T 타입변수 또는 매개변수
		// Box 원시타입(raw type)
		
		// 만들때마다 다른 제네릭을 줄 수 있다.
		Box<String> b = new Box<>();
		Box<Integer> b1 = new Box<>();
		// 에러
//		Box<Product> b2 = new Box<Box>();
		
		List<Product> list = new ArrayList<>();
//		list.add(1); // 에러 Product형이 아님
		list.add(new Box()); // Product의 자손은 OK
//		list.add(new Integer(10)); 역시 에러
		list.add(new Product()); // 당연히 가능
		
		Product p = list.get(0); // 0번엔 Box가 들어있지만 조상타입으로 받기 가능
//		Tv bTmp = (Tv)list.get(1); // 형변환 불가.
		Box b2 = (Box)list.get(1); // 형변환 해서 받기 가능 (다형성)
	}
}

// 지네릭 클래스 선언 (T말고 다른문자 써도 상관없음)
class Box<T> extends Product{}
class Product {}
class Tv2{}
