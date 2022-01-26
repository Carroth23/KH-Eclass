package jungsuk;

public class RandomProc {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			int ran = (int) (Math.random() * (9999 - 1000)) + 1000;
			System.out.println(ran);
		}
	}
}
