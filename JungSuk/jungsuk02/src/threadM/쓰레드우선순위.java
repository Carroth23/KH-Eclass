package threadM;

public class 쓰레드우선순위 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadEx6_1());
		Thread t2 = new Thread(new ThreadEx6_2());
		
		t1.setPriority(9);
		t2.setPriority(1);
		
		System.out.println("Priority of t1(-) : " + t1.getPriority());
		System.out.println("Priority of t2(|) : " + t2.getPriority());
		
		t1.start();
		t2.start();
	}
}

class ThreadEx6_1 implements Runnable {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
			for (int x = 0; x < 100000; x++)
				;
		}
	}
}

class ThreadEx6_2 implements Runnable {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
			for(int x = 0; x < 100000; x++);
		}
	}
}
