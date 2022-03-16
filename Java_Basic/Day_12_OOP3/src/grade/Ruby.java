package grade;

public class Ruby extends Grade {
	public Ruby() {}
	public Ruby(int id, String name, int point) {
		super(id, name, point);
	}
	
	public double getBonus() {
		return this.getPoint() * 0.04;
	}
}
