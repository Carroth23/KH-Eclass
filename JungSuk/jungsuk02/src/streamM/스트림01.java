package streamM;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 스트림01 {
	public static void main(String[] args) {
		// 스트림 : 다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것
		// 스트리은 1.스트림 만들기, 2.중간연산(0번~여러번), 3.최종연산(0번~1번) 으로 진행된다.
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> intStream = list.stream(); // 컬렉션
		Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"}); // 배열
		Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);	// 람다
		Stream<Double> randomStream = Stream.generate(Math::random); // 람다
		IntStream intStream2 = new Random().ints(5); // 난수 스트림(크기가 5)
		
		
		// 중간 연산 - 연산결과가 스트림인 연산. 반복적으로 적용 가능
		// 최종 연산 - 연산결과가 스트림이 아닌 연산. 단 한번만 적용가능(스트림의 요소를 소모)
		String[] strArr = {"dd", "aaa", "CC", "cc", "b"};
		Stream<String> stream = Stream.of(strArr); // 문자열 배열이 소스인 스트림
//		Stream<String> filteredStream = stream.filter(); // 걸러내기(중간)
		Stream<String> distinctedStream = stream.distinct(); // 중복제거(중간)
//		Stream<String> sortedStream = stream.sort(); // 정렬(중간)
		Stream<String> limitedStream = stream.limit(5); // 스트림 자르기 (중간)
		int total = (int) stream.count(); // 요소 개수 세기 (최종)
		
		// 스트림의 특징 : 	원본변경X 읽기만 함.
		//			 	Iterator처럼 일회용이다.
		//				최종연산 전까지 중간연산이 수행되지 않는다. - 지연된 연산
		//				작업을 내부 반복으로 처리한다.
		//				작업을 병렬로 처리가능 - 병렬스트림(.parallel() 해주면 병렬스트림으로 변환됨.)
		//				기본형 스트림 - IntStream, LongStream... 오토박싱&언박싱의 비효율 제거
		
	}
}
