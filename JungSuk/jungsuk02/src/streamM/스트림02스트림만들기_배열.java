package streamM;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 스트림02스트림만들기_배열 {
	public static void main(String[] args) {
//		Stream<String> strStream = Stream.of("a", "b", "c");
		Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});
		strStream.forEach(System.out::println);
		
		// 기본형스트림 숫자관련 메서드들이 좀더 많음
		int[] intArr = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArr);
//		intStream.forEach(System.out::println);
		System.out.println("count=" + intStream.count());
	}
}
