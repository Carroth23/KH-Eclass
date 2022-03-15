package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class 람다04_책예제 {
	public static void main(String[] args) {
		// 매개변수X 반환값1개
		Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;
		// 매개변수1 반환값X
		Consumer<Integer> c = i -> System.out.print(i + ", ");
		// 매개변수1 조건식반환boolean
		Predicate<Integer> p = i -> i % 2 == 0;
		// 매개변수1 반환1
		Function<Integer, Integer> f = i -> i / 10 * 10;
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list); // list를 랜덤값으로 채움. 10개
		System.out.println(list);
		printEvenNum(p, c, list);
		
		System.out.println(doSomething(f, list));
		
	}
	
	static <T> List<T> doSomething(Function<T, T> f, List<T> list){
		List<T> newList = new ArrayList<>(list.size());
		for(T i : list) {
			newList.add(f.apply(i));
		}
		return newList;
	}
	
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.print("]");
		System.out.println();
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i = 0; i < 10; i++) {
			list.add(s.get());
		}
	}
}
