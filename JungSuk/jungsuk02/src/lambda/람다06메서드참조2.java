package lambda;

import java.util.function.Function;

public class 람다06메서드참조2 {
	public static void main(String[] args) {
		// Supplier는 입력X, 출력O
//		Supplier<MyClass> s = () -> new MyClass();
//		Supplier<MyClass> s = MyClass::new; // 메서드참조
//		System.out.println(s.get());
		
		// 입력이 생기면 supplier이 아니라 function으로 바뀜
//		Function<Integer, MyClass> f = (i) -> new MyClass(i);
		Function<Integer, MyClass> f = MyClass::new;
		
		MyClass mc = f.apply(100);
		System.out.println(f.apply(100).iv);
		
		// 배열은 처음 만들때 길이를 정해야되니까 function써야댐
//		Function<Integer, int[]> f2 = i -> new int[i];
		Function<Integer, int[]> f2 = int[]::new; // 메서드 참조
		int[] arr = f2.apply(10);
		
		
	}
}

class MyClass{
	int iv;
	
	MyClass(int iv){
		this.iv = iv;
	}
}
