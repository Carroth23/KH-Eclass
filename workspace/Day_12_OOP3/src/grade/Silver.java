package grade;

public class Silver extends Grade { // �ڽ�Ŭ����[����Ŭ����] Derived Class
	
	public Silver() {}
	public Silver(int id, String name, int point) {
		super(id, name, point);
	}
	
	public double getBonus() {
		return this.getPoint() * 0.02;
	}
}
