
public class Exam_04_Overload {
	
	// 메서드 오버 로딩
	// 메서드 이름이 같아도 매개변수의 타입이 다르거나 갯수가 다르면 서로 같은이름을 인정해준다
	// 메서드 오버로딩은 매개변수의 차이에 의해서만 정해진다.
	public static void func(int a) {
		System.out.println("func1() 입니다.");
	}
	
	public static void func(String a) {
		System.out.println("func2() 입니다.");
	}
	
	public static void func() {
		System.out.println("func3() 입니다.");
	}
	
	public static void main(String[] args) {

		func();
		
		
	}
}
