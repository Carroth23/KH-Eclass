package streamM;

import java.util.Random;
import java.util.stream.IntStream;

public class 스트림02스트림만들기_난수 {
	public static void main(String[] args) {
//		IntStream intStream = new Random().ints(); // 무한스트림
//		IntStream intStream = new Random().ints(5); // 갯수제한
//		IntStream intStream = new Random().ints(5, 10); // 범위제한 
		IntStream intStream = new Random().ints(10, 5, 10); // 갯수제한, 범위제한
		intStream.limit(10).forEach(System.out::println);
		
		// 특정범위 정수 스트림
		IntStream intStream2 = IntStream.range(1,  5); // 1, 2, 3, 4
		IntStream intStream3 = IntStream.rangeClosed(1,  5); // 1, 2, 3, 4, 5
	}
}
