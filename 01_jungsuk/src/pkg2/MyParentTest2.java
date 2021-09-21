package pkg2;

import pkg1.MyParent;

//import pkg1.MyParent;

class MyChild extends pkg1.MyParent {
	public void printMembers() {
//		System.out.println(prv); // 같은 클래스가 아님
//		System.out.println(dft); // 같은 패키지가 아님
		System.out.println(prt); // 다른패키지더라도 자손
		System.out.println(pub); // 제한없음
	}
}
public class MyParentTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyParent p = new MyParent();
//		System.out.println(p.prv); // 에러 다른 클래스
//		System.out.println(p.dft); // 에러 다른 패키지
//		System.out.println(p.prt); // 에러 다른패키지의 다른 클래스
		System.out.println(p.pub); // ok
	}

}
