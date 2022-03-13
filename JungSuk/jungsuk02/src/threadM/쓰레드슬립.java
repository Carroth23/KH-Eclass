package threadM;

public class 쓰레드슬립 {
	public static void main(String[] args) {
		Thread th1 = new Thread(new ThreadEx8_1());
		Thread th2 = new Thread(new ThreadEx8_2());
		
		th1.start();
		th2.start();
		
		try {
			th1.sleep(3000); // th1 이 슬립? 이 아니라 main쓰레드가 슬립됨. (자기자신)
		} catch (Exception e) {}
		System.out.print("main쓰레드 종료");
	}
}

class ThreadEx8_1 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.print("<<th1종료>>");
	}
}

class ThreadEx8_2 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.print("<<th2종료>>");
	}
}
