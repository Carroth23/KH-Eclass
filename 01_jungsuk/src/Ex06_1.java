
class Ex06_1 {
	public static void main(String[] args) {

		Tv t1; // �������� ����
		t1 = new Tv(); // �������� ����
		Tv t2 = new Tv(); // ���ٷ� ����
//		t2 = t1; // t2�� �������� ���ư� �׷��Ƿ� ���� t2 �ν��Ͻ��� �������÷��Ϳ� ���� �޸𸮿��� ����
//		�ϳ��� ���������� �ϳ��� ��ü�� ����ų�� ����.
		
		t1.channel = 7; 	// ������� ���
		t1.channelDown(); 	// �޼��� ���
		System.out.println("t1 ä���� " + t1.channel + " ä�� �Դϴ�.");
		System.out.println("t2 ä���� " + t2.channel + " ä�� �Դϴ�.");
	}
}

class Tv {
	// Tv�� �Ӽ�(�������)
	String color; 	// ����
	boolean power; 	// ��������(on/off)
	int channel; 	// ä��
	
	void power() {
		power = !power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
}