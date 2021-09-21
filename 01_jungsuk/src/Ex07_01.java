class Tv {
	boolean power; // 전원상태 On/Off
	int channel; // 채널
	
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class SmartTv extends Tv{
	boolean caption;
	void displayCaption(String text) {
		if (caption) {
			System.out.println(text);
		}
	}
}
class Ex07_01 {
	public static void main(String[] args) {
		SmartTv stv = new SmartTv();
		stv.channel = 10;
		stv.channelUp();
		System.out.println(stv.channel);
		stv.displayCaption("Hello, Java");
		stv.caption = true;
		stv.displayCaption("Hello, Eve");
	}
}
