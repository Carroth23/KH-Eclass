package threadM;

public class 데몬쓰레드 implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new 데몬쓰레드()); // Runnable 구현한 클래스 넣어줌
		t.setDaemon(true); // 데몬쓰레드로 선언 이게 없다면 프로그램은 꺼지지 않는다.
		t.start(); // 순서가 바뀌면 예외발생

		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			System.out.println(i);
			if (i == 5)
				autoSave = true;
		}
		System.out.println("프로그램을 끕니당");
	}

	public void run() {
		while (true) {

			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {} // 3초마다 체크

			if (autoSave) {
				autoSave();
			}
		}
	}

	public void autoSave() {
		System.out.println("작업파일이 자동저장됨");
	}
}
