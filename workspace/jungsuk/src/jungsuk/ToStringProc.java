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
	
	// Object클래스의 toString()을 오버라이딩
	// 객체를 문자열로 바꾸는것 = IV값들을 문자열로 바꾸는듯
	public String toString() {
		return "x : " + x + ", y : " + y;
	}
}
