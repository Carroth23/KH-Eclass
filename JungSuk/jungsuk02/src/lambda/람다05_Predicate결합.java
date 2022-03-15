package lambda;

import java.util.function.Predicate;

public class 람다05_Predicate결합 {
	public static void main(String[] args) {
		// 여러개의 Predicate를 결합할 수 있다.
		// 연산자 이용 and(), or() , negate() <-얘는 not임
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i%2 == 0;
		Predicate<Integer> notP = p.negate(); // i >= 100과 같다
		
		// 100 <= i && i < 200 || i % 2 == 0
		Predicate<Integer> all = notP.and(q).or(r);
		// 100 <= i && (i < 200 || i % 2 == 0)
		Predicate<Integer> all2 = notP.and(q.or(r));
		
		// 이게 true인 이유 = 마지막 ||연산에 true가 걸림
		System.out.println(all.test(2));
		System.out.println(all2.test(2)); // false
	}
}
