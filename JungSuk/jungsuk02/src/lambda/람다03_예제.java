package lambda;

@FunctionalInterface // 함수형 인터페이스
interface MyFunction2{
	void run(); // public abstract void run();
		// 요게 이름?
}

public class 람다03_예제 {
	static void execute(MyFunction2 f) { // 매개변수의 타입이 MyFunction2인 메서드
		f.run();		// 결국 람다식을 매개변수로 받는거와 같음
	}
	
	static MyFunction2 getMyFunction2() { // 반환타입이 MyFunction2인 메서드
//		MyFunction2 f = () -> System.out.println("f3.run()");
//		return f;
		return () -> System.out.println("f3.run()");
	}
	
	public static void main(String[] args) {
		// 람다식으로 MyFunction2의 run()을 구현
		MyFunction2 f1 = () -> System.out.println("f1.run()");
		
		MyFunction2 f2 = new MyFunction2() { // 익명클래스로 run()을 구현
			public void run() { // public 필수 오버라이딩 조건.
				System.out.println("f2.run()");
			}
		};
		
		MyFunction2 f3 = getMyFunction2();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( () -> System.out.println("run()") );
	}
}
