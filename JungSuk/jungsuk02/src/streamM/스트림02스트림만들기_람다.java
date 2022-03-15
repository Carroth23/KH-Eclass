package streamM;

import java.util.stream.Stream;

public class 스트림02스트림만들기_람다 {
	public static void main(String[] args) {
		// iterate를 이용한 초기값설정 람다스트림 0부터 시작
		// iterate(T seed, UnaryOperator f) 단항연산자
		Stream<Integer> intStream = Stream.iterate(0, n -> n + 2);
		intStream.limit(10).forEach(System.out::println);
		
		// generate(Supplier s) : 주기만 하는것 입력x, 출력O
		Stream<Integer> oneStream = Stream.generate(()->1);
		oneStream.limit(10).forEach(System.out::println);;
		
		
		// 파일을 소스로하는 스트림
//		Stream<Path> Files.list(Path dir)
		
		// 비어있는 스트림 생성
		Stream emptyStream = Stream.empty(); // empty()는 빈 스트림을 생성해서 반환함.
	}
}
