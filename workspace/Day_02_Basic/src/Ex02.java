
public class Ex02 {

	public static void main(String[] args) {
		
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		
		b = (byte)i; // ����ִ� �� 100�� byte�� ��ȿ���������� int�� ��ü�� Ŀ�� �ȵ�
		ch = (char)b;
		short s = (short)ch;
		float f = (float)l; // ĳ���� ��� ��
		i = (int)ch; // ĳ���� ��� ��
	}

}
