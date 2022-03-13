package threadM;



public class Ex13_3 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadEx13_3());
		t1.start();
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.printf("소요시간1 : " + (System.currentTimeMillis() - startTime));
	}
}

class ThreadEx13_3 implements Runnable{
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.printf("소요시간2 : " + (System.currentTimeMillis() - Ex13_3.startTime));
	}
}
