package jungsuk;

public class Ch08_17 {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("메인이 예외처함");
		}
	}
	
	public static void method1() throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("메서드 예외 처리함");
			throw e;
		}
	}

}
