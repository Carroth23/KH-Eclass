
public class Quiz_03 {
	
	public static int countA(String str) {
		int count = 0;
//		1�� ���		
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == 'A'){
//				count++;
//			}
//		}
//		return count;
//	}
	
//		2�� ���
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length/*�迭�� length�� ()�� ����.*/; i++) {
			if (arr[i] == 'A') {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {

		String str = "ASDFSGGFGHFGFDGFGGDSFGDSEWERHGSGAAAAHFDGSDFGDSFTGHJHJGHJKJHGKJLOIUYTTRJGNCVBVCBDFG";

		
		int count = countA(str); // ���޹��� str ���� ���ڿ����� ���ĺ� A�� ������ ī�����ؼ� return �ϴ� �޼���
		System.out.println("���ĺ� A�� ������ : " + count);
	}
}
