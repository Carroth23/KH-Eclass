package grade;

public class Gold extends/*상속받는다(확장)*/ Grade{ // 자식클래스[하위클래스] Derived Class
	
	public Gold() {}
	public Gold(int id, String name, int point) {
		// 상속을 받았지만 private는 Grade꺼여서 super로 Grade를 부른다(setter는 번거로움)
		super(id, name, point);/*자신의 상위 클래스를 부르는것(super는 생략해도 존재한다)*/
		
//		this.setId(id);
//		this.setName(name);
//		this.setPoint(point);
	}
	
	public double getBonus() { // 메서드 오버라이딩
		return this.getPoint() * 0.03;
	}
	
}