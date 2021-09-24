
public class Ex_07_02 {
	public static void main(String[] args) {
		
		
	}
}

class Point {
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Point4D extends Point {
	int z;
	
	Point4D(int x, int y, int z){
		super(x, y);
		this.z = z;
	}
	
}
