package exceptionM;

public class Ex08_12 {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main에서 예외처됨.");
		}
	}
	
	static void method1() throws Exception{
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1에서 예외가 처리됨.");
			throw e;
		}
	}
}
