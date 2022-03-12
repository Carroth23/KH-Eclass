package enumM;

enum Nums{ HI, BYE, MAMA}
enum Toos{
	QWE(10), ASD(22), ZXC(12344);
	
	private final int value;
	Toos(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
}

public class 열거형복습 {
	public static void main(String[] args) {
		System.out.println(Nums.BYE);
		System.out.println(" ---- ---- 값 지정 ---- ----");
		System.out.println(Toos.QWE);
		System.out.println(Toos.QWE.getValue());
		System.out.println(Toos.ASD.getValue());
	}
}
