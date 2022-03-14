package threadM;

public class 동기화 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx13();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class Account2{
	private int balance = 1000; // private해줘야 동기화가 의미있음
	
	public synchronized int getBalance() { // 여기도 동기화 해주는게 맞는듯
		return balance;
	}
	
	public synchronized void withdraw(int money) { // 메서드 동기화(임계영역)
		if(balance >= money) {
			balance -= money;
		}
	}
}

class RunnableEx13 implements Runnable{
	Account2 acc = new Account2();
	
	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300중 임의로 출금
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balane : " + acc.getBalance());
		}
	}
}