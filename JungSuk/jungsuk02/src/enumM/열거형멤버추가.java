package enumM;

// 열거형에 원하는 값을 넣으려면
enum Direction2 {
	EAST(1), SOUTH(5), WEST(-1), NORTH(10);

	// 프라이빗 파이널
	private final int value; // 정수를 저장할 필드(인스턴스 변수)를 추가

	Direction2(int value) {
		this.value = value;
	} // 생성자를 추가 얘는 프라이빗

	public int getValue() {
		return value;
	} // 지정한 값을 가져올 수 있는 get 생성
}

public class 열거형멤버추가 {
	public static void main(String[] args) {
		System.out.println("열거 사우스 : " + Direction2.SOUTH.getValue());
		System.out.println("클래스 내 열거형 : " + Direction3.EAST);
	}

	enum Direction3 {
		EAST("이스트"), SOUTH(10);
		
		private final int value2;
		private final String strValue;
		Direction3(int value2){
			this.value2 = value2;
			this.strValue = "";
		}
		Direction3(String strValue){
			this.value2 = 0;
			this.strValue = strValue;
		}
		int getValue() {
			return value2;
		}
		String getstrValue() {
			return strValue;
		}
	}

}
