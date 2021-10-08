package main;

class A{
	public void funcA() {
		System.out.println("funcA 입니다.");
	}
}

class B extends A{
	public void funcA() {
		System.out.println("funcB입니다.");
	}
}

public class Exam_01_Polymorph {
	public static void main(String[] args) {
		// 다형성 : 클래스간 상속관게에서만 발현되는 서로 다른 타입의 값을 가질 수 있는 성질
		// 규칙 : 상위클래스 참조변수는 자신을 상속받는 하위클래스 인스턴스의 주소를 저장할 수 있다.
		
		
		
		A a = new B(); // up casting
		a.funcA();
//		a = new A();
//		((B)a).funcB(); // down casting
	}
}