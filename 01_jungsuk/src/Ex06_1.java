
class Ex06_1 {
	public static void main(String[] args) {

		Tv t1; // 참조변수 선언
		t1 = new Tv(); // 참조변수 연결
		Tv t2 = new Tv(); // 한줄로 가능
//		t2 = t1; // t2의 리모콘이 날아감 그러므로 기존 t2 인스턴스는 가비지컬렉터에 의해 메모리에서 제거
//		하나의 참조변수는 하나의 객체만 가르킬수 있음.
		
		t1.channel = 7; 	// 멤버변수 사용
		t1.channelDown(); 	// 메서드 사용
		System.out.println("t1 채널은 " + t1.channel + " 채널 입니다.");
		System.out.println("t2 채널은 " + t2.channel + " 채널 입니다.");
	}
}

class Tv {
	// Tv의 속성(멤버변수)
	String color; 	// 색깔
	boolean power; 	// 전원상태(on/off)
	int channel; 	// 채널
	
	void power() {
		power = !power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
}