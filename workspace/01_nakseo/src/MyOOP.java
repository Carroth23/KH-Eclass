class MyOOP1{
	int x;
	int y;
	
	
	MyOOP1 (int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "x : " + x + ", y : " + y;
	}
}

public class MyOOP{
	public static void main(String[] args) {
		MyOOP1 p = new MyOOP1(3, 5);
		System.out.println(p);
	}
	
}
