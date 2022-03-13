package threadM;

public class Ex13_1 {
	public static void main(String[] args) {
		ThreadEx_1 t1 = new ThreadEx_1();
		
		Thread t2 = new Thread(new ThreadEx_2());
		
		t1.start();
		t2.start();
	}
}

class ThreadEx_1 extends Thread {
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.print(1);
		}
	}
}

class ThreadEx_2 implements Runnable {
	public void run() {
		for(int i = 0; i < 500; i++) {
			// Thread.currentThread() - 현재 실행중인 쓰레드를 반환
			System.out.print(2);
		}
	}
}
