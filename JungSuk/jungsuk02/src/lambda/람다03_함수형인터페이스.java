package lambda;

public class 람다03_함수형인터페이스 {
	public static void main(String[] args) {
//		MyFunction f = new MyFunction() {
//			public int max(int a, int b) { // 오버라이딩 규칙 - 접근제어자는 좁게 못바꾸므로 여기도 public
//				return a > b ? a : b;
//			}
//		};
		
		// 람다식(익명 객체)를 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
		MyFunction f = (a, b) -> a > b ? a : b; // 위에껄 람다식으로
		// 밑의 함수형 인터페이스와 메서드 구조가 같아야함.
		

		int value = f.max(3, 5); // MyFunction에 max()가 있음.
		System.out.println("value = " + value);
	}
}

// 함수형 인터페이스 - 단 하나의 추상 메서드만 선언된 인터페이스
@FunctionalInterface // 안붙여도 되지만 기왕이면 붙여주자(함수형 인터페이스는 단 하나의 추상메서드만 가져야함. 얘가 검사)
interface MyFunction {
	int max(int a, int b); // public abstract 이 생략되어 있음
//	int max2(int a, int b); // 어노테이션에 의해 함수형인지 검사
}
