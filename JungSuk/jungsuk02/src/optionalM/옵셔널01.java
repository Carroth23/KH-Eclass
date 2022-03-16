package optionalM;

import java.util.Optional;

public class 옵셔널01 {
	public static void main(String[] args) {
		// Optional 은 T타입의 객체를 감싸는 래퍼클래스
		// null을 직접다루지 않으려고 주로 사용
		String str = "abc";
		Optional<String> optVal = Optional.of(str);
		Optional<String> optVal2 = Optional.of("abc");
		Optional<String> optVal3 = Optional.of(null); // 널포인터익셉션발생
		Optional<String> optVal4 = Optional.ofNullable(null); // OK
	}
}
