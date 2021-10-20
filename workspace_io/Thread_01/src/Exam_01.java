
// Thread 사용 방법 Steps
// 1. Thread 클래스를 상속받는 사용자 정의 클래스를 생성한다.
// 2. Thread 로부터 상속받은 public void run 메서드를 오버라이드하여 병렬처리 코드를 작성한다.
// 3. 작성된 클래스로 인스턴스를 생성한다.
// 4. 생성된 인스턴스로부터 start method를 호출한다.

class Worker extends Thread{ // 추상클래스가 아니며 매개변수가 없는 기본생성자가 존재한다는걸 알 수 있다.
	public void run() { // 왼쪽 초록색화살표보면 오버라이딩 된걸 알수있음
		for (int i = 0; i < 100; i++) {
			System.out.print(i + " ");
		}
	}
}

public class Exam_01 {

	public static void main(String[] args) {
		
		// Thread = 작업의 단위
		// Thread = 병렬처리와 비슷.(동시에 처리되는 코드)
		// 위에서 아래로 떨어지는 코드흐름을 스레드라고 부름.(코드를 실행시키는 작업의 단위.)
		// 지금까지는 싱글쓰레드
		// 쓰레드를 여러개붙이면 멀티쓰레드
		// 프로세스 : 하드디스크에 있는 프로그램을 램에 로딩한 상태(현재 실행중인 프로그램)
		
		Worker w = new Worker();
		w.start();
		for (int i = 0; i < 100; i++) {
			System.out.print(i + " ");
		}
		
//		for (int i = 0; i < 100; i++) {
//			System.out.println(i);
//		}
		
	}

}
