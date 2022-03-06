package abstractM;
abstract class Player1{ // 추상 클래스(미완성 클래서, 미완성 설계도)
	abstract void play(int pos); // 추상 메서드
	abstract void stop(); // 추상 메서드
}

// 추상클래스는 상속을 통해 완성해야 객체 생성가능
class AudioPlayer extends Player1{
	void play(int pos) {System.out.println(pos + " 위치부터 play합니다.");}
	void stop() {System.out.println("재생을 멈춥니다.");} // 하나라도 구현 안하면 에러 혹은 abstract붙여야함.
}
class PlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Player1 ap = new Player1(); // 추상클래스의 객체를 생성
		AudioPlayer ap = new AudioPlayer();
//		Player1 ap = new AudioPlayer(); // 다형성.
		ap.play(3);
	}

}
