class Data_1{
	int value;
	// 여긴 컴파일러가 자동으로 기본생성자를 생성해서 에러가 발생하지 않는다.
}

class Data_2{
	int value;
	
	Data_2(){} // 기본 생성자
	Data_2(int x){
		value = x;
	}
}
public class Ex06_11 {
	public static void main(String[] args) {
		Data_1 d1 = new Data_1();
		Data_2 d2 = new Data_2(); // 기본생성자가 없어지고 매개변수가 있는 생성자만 있어서 에러발생. 기본생성자를 추가해주면 해결
	}
}
