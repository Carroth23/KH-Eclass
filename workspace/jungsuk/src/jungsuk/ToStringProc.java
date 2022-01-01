package jungsuk;

public class ToStringProc {
	public static void main(String[] args) {
		Proc c = new Proc();
		
		System.out.println(c);
	}
}

class Proc {
	public int x = 10;
	public String y = "하이";
	
	public String toString() {
		return "x : " + x + ", y : " + y;
	}
}
