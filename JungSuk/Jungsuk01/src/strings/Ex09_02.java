package strings;

public class Ex09_02 {
	public static void main(String[] args) {
		
	}
}

class Point3D {
	int x, y, z;

	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	Point3D() {
		this(0, 0, 0);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point3D) {
			Point3D p = (Point3D)obj;
			return p.x == this.x && p.y == this.y && p.z == this.z;
		}
		return false;
	}
	
	public String toString() {
		return "["+x+","+y+","+z+"]";
	}
}