package threadM;

import javax.swing.JOptionPane;

public class 인터럽트 {
	public static void main(String[] args) {
		ThreadEx9_1 th1 = new ThreadEx9_1();
		th1.start();
		System.out.println("isInterrupted():" + th1.isInterrupted());
		String input = JOptionPane.showInputDialog("아무 값이나 입력 ㄱㄱ.");
		System.out.println("입력하신 값은 " + input + " 입니다.");
		th1.interrupt(); // interrupt를 호출하면 interrupted상태가 true가 됨.
		System.out.println("isInterrupted():" + th1.isInterrupted());
	}
}

class ThreadEx9_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x = 0; x < 2500000000L; x++);
		}
		System.out.println("카운트가 종료되었습니다.");
		System.out.println(interrupted());
		System.out.println(isInterrupted());
	}
}