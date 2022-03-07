package exceptionM;

public class Ex8_6 {

	public static void main(String[] args) {
		try {
//			Exception e = new Exception("고의발생");
//			throw e;
			throw new Exception("고의발생");
		} catch (Exception e) {
			System.out.println("에러 메세지 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 정상 종료");
	}

}
