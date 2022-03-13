package threadM;

// 쓰레드를 구현하는 방법엔 두가지가 있다.
//1. Thread 클래스를 상속
class MyThread extends Thread{
	public void run() {
		// 작업내용
	}
}

//2. Rennable 인터페이스 구현
class MyThread2 implements Runnable{
	public void run() {
		// 작업내용
	}
}

// 둘다 run()메서드를 구현하는건 같다.(main과 비슷)

public class 쓰레드구현 {
	public static void main(String[] args) {
		
		// 1번 방법의 쓰레드 사용 : 
//		MyThread t1 = new MyThread();
//		t1.start();
		
		// 2번 방법의 쓰레드 사용 : (이게 좀 더 낫다. 다중상속에 자유로움)
//		Runnable r = new MyThread2();
//		Thread t2 = new Thread(r);
//		t2.start();
		// 짧게는 Thread t2 = new Thread(new MyThread2());
		// t1번 t2번중 뭐가 먼저 실행될지는 OS의 스케쥴러가 결정
	}
}