package interfaceM;

abstract class Unit{
	int x, y;
	abstract void move(int x, int y);
	void stop() {System.out.println("멈춥니다.");}
}

interface Fightable{
	void move(int x, int y); // public abstract가 생략됨
	void attack(Fightable f); // public abstract가 생략됨
}

class Fighter extends Unit implements Fightable{
	public void move(int x, int y) { // public 안쓰면 오버라이딩의 제약조건에 걸린다.
		System.out.println(x + "로 " + y + "로 이동");
	};
	public void attack(Fightable f) {
		System.out.println(f + "를 공격");
	};
	
	Fightable getFightable(){
		Fighter f = new Fighter();
		return f;
	}
}

public class FighterTest {
	public static void main(String[] args) {
		Fighter f2 = new Fighter();
		Fighter q = (Fighter) f2.getFightable();
		Fightable q2 = f2.getFightable();
		
//		Fighter f = new Fighter();
		Fightable f = new Fighter();
		f.move(100, 200);
		f.attack(new Fighter());
//		f.stop();
		
		Unit u = new Fighter();
		u.stop();
		u.move(200, 100);
//		u.attack(Fighter f); Unit리모콘에는 attack이 없다.
	}

}
