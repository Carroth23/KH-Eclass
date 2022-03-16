package streamM;

import java.util.stream.IntStream;

public class 스트림03중간연산 {
	public static void main(String[] args) {
		// 중간연산 - 연산 결과가 스트림
		// 스트림 자르기 - skip(), limit()
//		Stream<T> skip(long n) 앞에서부터 n개 건너뛰기
//		Stream<T> limit(long maxSize) maxSize 이후의 요소는 잘라내기
		IntStream intStream = IntStream.rangeClosed(1, 10); // 1 ~ 10스트림 생성
		intStream.skip(3).limit(5).forEach(System.out::print);
		System.out.println();
		
		// 스트림 요소 걸러내기 - filter(), distinct()
//		Stream<T> filter(Fredicate<? super T> predicate) 조건에 맞지않는 요소 제거
//		Stream<T> distinct() 중복제거
		IntStream intStream2 = IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6);
		intStream2.distinct().forEach(System.out::print);
		System.out.println();
		IntStream intStream3 = IntStream.rangeClosed(1, 10);
		intStream3.filter(i -> i % 2 == 0).forEach(System.out::print);
		System.out.println();
		
		// 스트림 정렬 - sorted()
//		Stream<T> sorted() 스트림 요소의 기본 정렬
//		Stream<T> sorted(Comparator<? super T> comparator) // 지정된 comparator로 정렬
		IntStream intStream4 = IntStream.of(2, 1, 4, 5, 3, 6, 9, 8, 7);
		intStream4.sorted().forEach(System.out::print);
	}
}
