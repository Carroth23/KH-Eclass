package streamM;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 스트림04_reduce {
	public static void main(String[] args) {
		String[] strArr = {
				"Inheritance", "Java", "Lambda", "Stream",
				"OptionalDouble", "IntStream", "Count", "Sum"
		};
		
		Stream.of(strArr)
		.parallel()	// 병렬로 돌리기
		.forEachOrdered(System.out::println); // 병렬이지만 순서 유지
//		.forEach(System.out::println);
		
		// 길이가 0인 문자열이 하나도 없냐?
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
		// s로 시작하는 문자열 찾기(병렬처리)
		Optional<String> sWord= Stream.of(strArr).parallel()
									.filter(s -> s.charAt(0) == 'S').findAny();
		
		System.out.println("noEmptyStr = " + noEmptyStr);
		System.out.println("sWord = " + sWord);
		
		// Stream<String>을 IntStream으로 변환			(s) -> s.length()
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

		int count = intStream1.reduce(0, (a, b) -> a + 1);
		int sum = intStream2.reduce(0, (a, b) -> a + b);
		
		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);
		
		System.out.println(max.orElse(0));
		System.out.println(min.getAsInt());
	}
}
