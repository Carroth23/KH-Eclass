
public class Ex02 {

	public static void main(String[] args) {
		
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		
		b = (byte)i; // 담겨있는 값 100이 byte의 유효범위이지만 int값 자체가 커서 안됨
		ch = (char)b;
		short s = (short)ch;
		float f = (float)l; // 캐스팅 없어도 됨
		i = (int)ch; // 캐스팅 없어도 됨
	}

}
