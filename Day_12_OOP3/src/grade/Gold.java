package grade;

public class Gold extends/*��ӹ޴´�(Ȯ��)*/ Grade{ // �ڽ�Ŭ����[����Ŭ����] Derived Class
	
	public Gold() {}
	public Gold(int id, String name, int point) {
		// ����� �޾����� private�� Grade������ super�� Grade�� �θ���(setter�� ���ŷο�)
		super(id, name, point);/*�ڽ��� ���� Ŭ������ �θ��°�(super�� �����ص� �����Ѵ�)*/
		
//		this.setId(id);
//		this.setName(name);
//		this.setPoint(point);
	}
	
	public double getBonus() { // �޼��� �������̵�
		return this.getPoint() * 0.03;
	}
	
}
