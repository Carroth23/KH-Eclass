package electronic;
// 정보은닉 규칙
// 1. 멤버변수는 되도록 private 붙이기
// 2. 외부에 노출될 필요없는것들은 private으로 가려라
// 클래스 개발자의 안정성 및 클래스 사용자의 편의성을 취할 수 있음.
// 캡슐화

// 접근제한자
// private / default (package)접근제한자 위치에 아무것도 안쓰면 디폴트 / protected / public

// 필드를 private하게 막아놓고 이 필드를 제어할수있는 method를 public으로 열어둬라

// private 변수를 제어하기 위해 만드는 public 메서드의 생성규칙은
// 입력을 하는 메서드의 경우 이름을 set로(ex: public void setChannel(int chn)) set으로 시작하는 메서드는 매개변수가 있어야 한다.
// 내보내는 메서드는 get(ex: public int getChannel() )로 시작
public class Tv {
	
	private int channel;
	private int volume;
// Getters / Setters
// 밑에것들이 게터스 세터스

	public void setChannel(int cha) { //입력받는 set 입력받아야 하므로 매개변수가 필요
		channel = cha;
	}
	public int getChannel() { //내보내는 get 내보내야 하므로 리턴값 필요
		return channel;
	}
	
	
	public void setVolume(int vol) {
		volume = vol;
	}
	public int getVolume() {
		return volume;
	}
	
//	public void setChannel(int channel) {
//		this.channel = channel; this(자기참조변수) 는 멤버변수를 가르키게 도와준다.
//												정확히는 생성된 인스턴스 자기 자신의 주소를 가지고 있다
//	}
	
	
	public void channelUp() { // 프라이빗인 채널을 제어하는 퍼블릭 메서드
		if(channel < 1000) {
			channel++;
		}
	}

	public void channelDown() {
		channel--;
	}
	
	
	private void powerOn() {}
	public void powerOff() {}
}