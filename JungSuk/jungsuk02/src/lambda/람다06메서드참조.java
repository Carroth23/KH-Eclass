package lambda;

import java.util.function.Function;

public class 람다06메서드참조 {
	public static void main(String[] args) {
//		Function<String, Integer> f = s -> Integer.parseInt(s);
//		Function<String, Integer> f = 클래스이름::메서드이름;
		// 어차피 제네릭으로 어떤타입인지 알기때문에 더 간략히 표현가능 = 메서드참조
		Function<String, Integer> f = Integer::parseInt;
		System.out.println(f.apply("100") + 100);
		// 겁나신기하네
		
	}
}
