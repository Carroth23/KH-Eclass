package grade;

public class Silver extends Grade { // 자식클래스[하위클래스] Derived Class
	
	public Silver() {}
	public Silver(int id, String name, int point) {
		super(id, name, point);
	}
	
	public double getBonus() {
		return this.getPoint() * 0.02;
	}
}
