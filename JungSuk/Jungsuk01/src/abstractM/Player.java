package abstractM;
// 추상메서드를 가지고 있는 클래스 = 추상클래스
abstract public class Player {
	boolean pause;
	int currentPos;
	
	Player(){
		pause = false;
		currentPos = 0;
	}
	
	// 추상메서드는 구현의 강제성을 가짐.
	// 추상메서드 = 구현부가 없는 메서드
	abstract void play();
	abstract void stop();
}
