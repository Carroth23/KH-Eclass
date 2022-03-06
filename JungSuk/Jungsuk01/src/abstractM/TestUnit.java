package abstractM;

abstract class TestUnit {
	// 여기서 바꾸면 상속받은 자손들도 다바뀜. 변경이 용이함.
	// 단계별로 상속해주면 관리가 더 편하다.
	int x, y;
	abstract void move(int x, int y);
	void stop() {}
}

class Marine extends TestUnit{
	void move(int x, int y) {System.out.println(x + "이동 " + y + "정지");}
	void stimPack() {System.out.println("스팀팩 작동");}
}

class Tank extends TestUnit{
	void move(int x, int y) {System.out.println(x + "탱크 이동" + y + "정지");}
}

class DropShip extends TestUnit{
	void move(int x, int y) {System.out.println("드랍쉽 이동불가");}
	
	public static void main(String[] args) {
//		TestUnit[] ta = {new Marine(), new Tank(), new DropShip()}; 밑에와 같은 뜻
		// 객체배열 : 참조변수 묶은것.
		TestUnit[] ts = new TestUnit[3];
		ts[0] = new Marine();
		ts[1] = new Tank();
		ts[2] = new DropShip();
		for(int i = 0; i < 3; i++) {
			ts[i].move(100, 200);
		}
	}
}