package exceptionM;

public class MyException extends Exception{ // RuntimeException을 더 권장. 언체크드예외
	private final int ERROR_CODE;
	
	MyException(String msg, int errCode){ // 생성자
		super(msg);
		this.ERROR_CODE = errCode;
	}
	
	MyException(String msg){ // 생성자. 결국 위에껄 부름.
		this(msg, 100); // error코드 기본값 100으로 초기화
	}
	
	public int getErroCode() {
		return this.ERROR_CODE;
	}
}
