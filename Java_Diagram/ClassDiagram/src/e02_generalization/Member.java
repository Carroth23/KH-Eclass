package e02_generalization;

public class Member {
	
	// Generalization ( 일반화 )
	// 상속에 의해 만들어지는 클래스 관계
	// 화살표는 실선 비어있는 삼각헤드
	// 자식이 부모를 향해 화살표가 생긴다.
	
	private int id;
	private String name;
	private double point;
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
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public Member(int id, String name, double point) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
	}
	public Member() {
		super();
	}
	
}
