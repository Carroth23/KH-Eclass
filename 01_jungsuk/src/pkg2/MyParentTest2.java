package pkg2;

import pkg1.MyParent;

//import pkg1.MyParent;

class MyChild extends pkg1.MyParent {
	public void printMembers() {
//		System.out.println(prv); // ���� Ŭ������ �ƴ�
//		System.out.println(dft); // ���� ��Ű���� �ƴ�
		System.out.println(prt); // �ٸ���Ű������ �ڼ�
		System.out.println(pub); // ���Ѿ���
	}
}
public class MyParentTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyParent p = new MyParent();
//		System.out.println(p.prv); // ���� �ٸ� Ŭ����
//		System.out.println(p.dft); // ���� �ٸ� ��Ű��
//		System.out.println(p.prt); // ���� �ٸ���Ű���� �ٸ� Ŭ����
		System.out.println(p.pub); // ok
	}

}
