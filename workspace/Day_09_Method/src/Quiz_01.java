
public class Quiz_01 {
	
	public static String test(String str) {
		if (str.equals("���")) { // String�� ���Ҷ� equals ���
			return "Apple";
		} else if (str.equals("����")){
			return "Grape";
		} else {
			return "None";
		}
	}
	
	public static int myRand(int min, int max) {
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
	public static void main(String[] args) {

		// "���" �� �����ϸ�, "Apple"�� return �ϰ�
		// "����" �� �����ϸ�, "Grape"�� return �ϴ� �޼��� test�� ���弼��
		// "���"�� "����"�� �ƴϸ� "None"�� return!
		
		System.out.println(test("���"));
		
		System.out.println(myRand(10, 20)); // 10 ~ 20������ ����
		
	}
}
