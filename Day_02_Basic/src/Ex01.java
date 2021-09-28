
public class Ex01 {

	public static void main(String[] args) {
//		byte b = 10;
//		short s = 20;
//		int i = 30;
//		long l = 40L;
//		float f = 3.14f;
//		double d = 5.11;
//		
//		s = b; // b = s ?
//		i = s; // s = i ?
//		l = i; // i = l ?
//		d = f; // f = d ?
		
		byte b = 10;
		short s = 20;
		char c = 'A';
		int i;
		float f;
		long l = 100L;
		
		s = b;
		c = (char)b;
		System.out.println(c);
		s = (short)c;
		c = (char)s;
		i = 100;
		l = 500;
		f = l; // 실수형은 정수형보다 크다.
		f = 5.11f;
	}

}
