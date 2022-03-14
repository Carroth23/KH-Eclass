package lambda;

public class 람다01 {
	public static void main(String[] args) {
		// 함수 : 클래스에 독립적
		// 메서드 : 클래스에 종속적
		
		// 사실 람다식은 객체였던것이었던것이다...
		// Object 리모콘으로 max를 호출 못함.
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a: b;
			}
		};
		
	}
	
	//1
//	(a, b) -> a > b ? a : b
//			
//	//2
//	(name, i) -> System.out.println(name+"="+i)
//	
//	//3
//	x -> x * x
//	
//	//4
//	() -> (int)(Math.random() * 6)
}
