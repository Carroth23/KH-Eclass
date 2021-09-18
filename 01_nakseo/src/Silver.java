
public class Silver {

	private int id;
	private String name;
	private int point;

	// »ý¼ºÀÚ(constructor)
	public Silver (){}
	public Silver (int id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}
	
	// Getter & Setter
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
		return point * 0.02;
	}
	
	
	
}
