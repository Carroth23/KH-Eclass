package main;

class A{
	public void funcA() {
		System.out.println("funcA �Դϴ�.");
	}
}

class B extends A{
	public void funcA() {
		System.out.println("funcB�Դϴ�.");
	}
}

public class Exam_01_Polymorph {
	public static void main(String[] args) {
		// ������ : Ŭ������ ��Ӱ��Կ����� �����Ǵ� ���� �ٸ� Ÿ���� ���� ���� �� �ִ� ����
		// ��Ģ : ����Ŭ���� ���������� �ڽ��� ��ӹ޴� ����Ŭ���� �ν��Ͻ��� �ּҸ� ������ �� �ִ�.
		
		
		
		A a = new B(); // up casting
		a.funcA();
//		a = new A();
//		((B)a).funcB(); // down casting
	}
}
