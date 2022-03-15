package lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class 람다04_function패키지 {
	public static void main(String[] args) {
		int tmp = 0;
		// 자주쓰이는 함수형 인터페이스들은 미리 정의되어있다. java.util
		// 이러면 표준화가 됨
		
		// 매개변수도 없고 반환값도 없음. Runnable
		Runnable r = () -> System.out.println("러너블");
		r.run();
		
		// 매개변수는 없고 반환값만 있음. Supplier
		Supplier<Integer> s = () -> 10;
		System.out.println("서플라이어 : " + s.get());
		
		// 위와 반대로 매개변수는 있고 반환값이 없음.
		Consumer<Integer> c = a -> System.out.println(tmp + a);
		c.accept(10);
		
		// 일반적인 함수. 하나의 값을 받아 하나의 값을 반환.
		Function<Integer, Integer> f = a -> a + 12;
		System.out.println(f.apply(10));
		
		// 조건식표현 함수. 매개변수하나, 반환타입 boolean
		Predicate<Integer> p = a -> a > 10;
		System.out.println(p.test(11));
		
		// 두개의 매개변수만 있고 반환값이 없음
		BiConsumer<String, String> bc = (a, b) -> System.out.println("a 는 : " + a + ", b는 : " + b);
		bc.accept("자바", "자스");
		
		// 두개의 매개변수를 받는 조건식
		BiPredicate<Integer, Integer> bp = (a, b) -> a > b ? true : false;
		System.out.println(bp.test(10, 11));
		
		// 두개의 매개변수를 받고 하나의 결과를 반환(제네릭은 세개네 마지막껀 반환타입이겠지)
		BiFunction<Integer, Integer, String> bf = (a, b) -> a > b ? "a가 큼" : "b가 큼";
		System.out.println(bf.apply(20, 100));
		
		// 매개변수 세개를 받는 함수형 인터페이스 직접 만들어보기
		TriFunction<Integer, Integer, Integer, Integer> tf = (a, b, q) -> a + b - q; 
		System.out.println(tf.apply(20, 10, 5));
		
		// 매개와 반환타입이 일치하는 오퍼레이터 (function의 자손이며 타입이일치해서 하나만 써도 됨.)
		UnaryOperator<Integer> up = a -> a + 10;
		System.out.println(up.apply(20));
	}
	
	// 매개변수 세개를 받는 함수형 인터페이스 직접 만들어보기
	@FunctionalInterface
	interface TriFunction<T, U, V, R>{
		R apply(T t, U u, V v);
	}
	
}
