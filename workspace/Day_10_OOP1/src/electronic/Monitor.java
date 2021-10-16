package electronic;


// 객체지향
// 초급문법 : 정보은닉 / 캡슐화 / Getter&Setter / Constructor / Static / this
// 중급문법 : 상속 / 추상화 / 다형성 / (컬렉션)



public class Monitor {
	// 지역변수 : 메서드 중괄호{}안에 있는것.
	// 멤버변수 : 클래스 중괄호{}안에 있는것.
	
	String brand; // 멤버변수 IV
	int price;
	
	void powerOn() {
		// 전원 켜기 코드...
	}
	void powerOff() {
		// 전원 끄기 코드...
	}
	
	// 클래스를 구성하는 4가지 요소
	// Member Field
	// Member Method
	
	// Constructor (생성자 메서드)
	// - 반환형을 가질 수 없다.(return data type이 없다)
	// - 이름이 고정되어 있다. (반드시 클래스의 이름과 동일해야 한다.)
	// - 호출 시점이 정해져 있다. (인스턴스가 생성되는 시점에 단 한번 호출된다)
	// - 그 외의 특징은 일반메서드와 모두 동일하다.
	// - 클래스에 보이지않는 기본생성자가 있지만 우리가 생성자를 명시적으로 작성하는 순간 디폴트 컨스트럭터는 지워진다.
	// 생성자의 목적 : 인스턴스의 초기값을 한번에 세팅해 주기 위해.
	
	// Nested Class (얘는 드물게 사용됨)
	
	
	
}