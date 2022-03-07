package exceptionM;

public class Proc {
	public static void main(String[] args) {
//		throw new Exception(); // 체크드예와 예외처리필수
		throw new RuntimeException(); // 언체크드예외 try catch없어도 컴파일되긴함
	}

}
