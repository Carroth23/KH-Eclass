package e04_dependency;

public class Human {
	// Dependency ( 의존 )
	// A 클래스가 B 클래스를 내부적으로 사용하는 관계
	// 점선에 열려있는 삼각 헤드
	// 뭘로 의존하는지 모를때 << local >> 이런식으로 지역변수로 의존한다는거 알려줄수도있음

	public Fire makeFire() {
		return new Fire();
	}
	
	public void cooking1(Fire f) {
		
	}
	
	public void cooking2() {
		Fire f = new Fire();
	}
}
