package electronic;
// �������� ��Ģ
// 1. ��������� �ǵ��� private ���̱�
// 2. �ܺο� ����� �ʿ���°͵��� private���� ������
// Ŭ���� �������� ������ �� Ŭ���� ������� ���Ǽ��� ���� �� ����.
// ĸ��ȭ

// ����������
// private / default (package)���������� ��ġ�� �ƹ��͵� �Ⱦ��� ����Ʈ / protected / public

// �ʵ带 private�ϰ� ���Ƴ��� �� �ʵ带 �����Ҽ��ִ� method�� public���� ����ֶ�

// private ������ �����ϱ� ���� ����� public �޼����� ������Ģ��
// �Է��� �ϴ� �޼����� ��� �̸��� set��(ex: public void setChannel(int chn)) set���� �����ϴ� �޼���� �Ű������� �־�� �Ѵ�.
// �������� �޼���� get(ex: public int getChannel() )�� ����
public class Tv {
	
	private int channel;
	private int volume;
// Getters / Setters
// �ؿ��͵��� ���ͽ� ���ͽ�

	public void setChannel(int cha) { //�Է¹޴� set �Է¹޾ƾ� �ϹǷ� �Ű������� �ʿ�
		channel = cha;
	}
	public int getChannel() { //�������� get �������� �ϹǷ� ���ϰ� �ʿ�
		return channel;
	}
	
	
	public void setVolume(int vol) {
		volume = vol;
	}
	public int getVolume() {
		return volume;
	}
	
//	public void setChannel(int channel) {
//		this.channel = channel; this(�ڱ���������) �� ��������� ����Ű�� �����ش�.
//												��Ȯ���� ������ �ν��Ͻ� �ڱ� �ڽ��� �ּҸ� ������ �ִ�
//	}
	
	
	public void channelUp() { // �����̺��� ä���� �����ϴ� �ۺ� �޼���
		if(channel < 1000) {
			channel++;
		}
	}

	public void channelDown() {
		channel--;
	}
	
	
	private void powerOn() {}
	public void powerOff() {}
}
