class Data3 {
	int x;
}

public class Ex_06_8 {
	public static void main(String[] args) {
		Data3 d = new Data3();
		d.x = 10;
		
		Data3 d2 = copy(d);
		System.out.println("d.x = " + d.x);
		System.out.println("d2.x = " + d2.x);
		
	}
	static Data3 copy(Data3 d) {
		Data3 tmp = new Data3(); // 객체 tmp 생성
		tmp.x = d.x; // d.x의 값을 tmp.x에 복사.
		return tmp;
	}
}
