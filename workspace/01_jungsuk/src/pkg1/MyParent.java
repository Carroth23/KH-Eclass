package pkg1;

public class MyParent{
	private 	int prv; // 같은 클래스
				int dft; // 같은 패키지
	protected 	int prt; // 같은 패키지 + 자손(다른 패키지 자손)
	public 		int pub; // 접근 제한 없으
	
	public void printMembers() {
		System.out.println(prv); // ok
		System.out.println(dft); // ok
		System.out.println(prt); // ok
		System.out.println(pub); // ok
	}
}

class MyParentTest {

	public static void main(String[] args) {
		MyParent p = new MyParent();
//		System.out.println(p.prv); // 에러
		System.out.println(p.dft); // ok
		System.out.println(p.prt); // ok
		System.out.println(p.pub); // ok
		
		
	}

}
