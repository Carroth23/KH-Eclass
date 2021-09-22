class Point3D {
	int x;
	int y;
	Point3D(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x : " + x + " y : " + y;
	}
}

public class OverrideTest {
	public static void main(String[] args) {
		Point3D p = new Point3D(3, 5);
		System.out.println(p);
	}
}
