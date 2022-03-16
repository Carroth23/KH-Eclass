package test;

public abstract class Car {
	
	public void defaultFunction() {} 
	// 그림에는 리턴이 아예 없음 그렇다면 생성자인데 따로 클래스를 만들어서 상속시키고 여기서 생성자를? 그렇다기엔 대문자가 아니고 다이어그램상에 표기도 안됨
	protected abstract void specialFunction(); // Car는 이탤릭 - 추상
	
//	public Car() {super();}
	
}
