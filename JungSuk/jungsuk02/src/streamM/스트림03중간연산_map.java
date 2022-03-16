package streamM;

import java.io.File;
import java.util.stream.Stream;

public class 스트림03중간연산_map {
	public static void main(String[] args) {
		// 파일 베열
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"),
				new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")
		};
		
		// 파일스트림
		Stream<File> fileStream = Stream.of(fileArr);
		
		// map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<String> fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(System.out::println); // 모든 파일의 이름을 출력
		
		fileStream = Stream.of(fileArr); // 스트림 다시 생성
		
		fileStream.map(File::getName) // Stream<File> -> Stream<String>
			.filter(s -> s.indexOf('.') != -1) // 확장자가 없는것은 제외
			.peek(s -> System.out.printf("filenema=%s%n", s)) // 스트림을 소모하지 않고 확인
			.map(s -> s.substring(s.indexOf('.')+1)) // 확장자만 추출
			.peek(s -> System.out.printf("extension=%s%n", s))
			.distinct()								// 중복 제거
			.forEach(System.out::println);			// JAVABAKTXT
		
		System.out.println();
	}
}
