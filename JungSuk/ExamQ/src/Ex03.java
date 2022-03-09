class Outer{
	static class Inner{
		int iv = 100;
	}
}


public class Ex03 {
	public static void main(String[] args) {
		Outer ot = new Outer();
		Outer.Inner li = new Outer.Inner();
		System.out.println(li.iv);
	}
}
