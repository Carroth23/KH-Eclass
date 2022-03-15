package streamM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class 스트림02스트림만들기_리스트 {
	public static void main(String[] args) {
		// 기본적인 스트림 만들기 . Collection인터페이스의 stream()으로 컬렉션을 스트림으로 변환
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> intStream = list.stream(); // list를 소스로 하는 새로운 스트림 생성
		// 스트림의 모든 요소를 출력
		intStream.forEach(System.out::print); // 12345(최종연산)
//		intStream.forEach(System.out::print); // 에러. 스트림이 이미 닫힘
		
		// 다시 재생성
		intStream = list.stream(); // 스트림은 1회용
		intStream.forEach(System.out::print);
	}
}
