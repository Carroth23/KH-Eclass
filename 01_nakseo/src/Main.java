
class Parent{
	void parentMethod() {}
}

class Child extends Parent{
	
	void parentMethod() {
		System.out.println("¿Ó");
	}
	void parentMethod(int x) {}
	void parentMethod(long x) {}
}

public class Main {
    public static void main(String[] args) {

    	int[] score = new int[5];
    	System.out.println(score[3]);
    }
}