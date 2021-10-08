package grade;

abstract public class Grade { // ����� ���ִ� �� (�θ�Ŭ����[����Ŭ����]) SuperClass
//	abstract : �߻�Ŭ������ ��
	private int id;
	private String name;
	private int point;
	
	public Grade() {
		super();
	}
	public Grade(int id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	abstract public double getBonus(); // �߻� �޼���
}
