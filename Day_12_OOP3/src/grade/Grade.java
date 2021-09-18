package grade;

public class Grade { // 상속을 해주는 쪽 (부모클래스[상위클래스]) SuperClass
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

	public double getBonus() {
		return this.point * 0.03; // 내용은 다르지만 공통요소는 맞다
	}
}
