package grade;

abstract public class Grade { // 상속을 해주는 쪽 (부모클래스[상위클래스]) SuperClass
//	abstract : 추상클래스가 됨
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

	abstract public double getBonus(); // 추상 메서드
}
