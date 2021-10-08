
public class Quiz_03 {
	
	public static int countA(String str) {
		int count = 0;
//		1번 방법		
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == 'A'){
//				count++;
//			}
//		}
//		return count;
//	}
	
//		2번 방법
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length/*배열의 length엔 ()가 없다.*/; i++) {
			if (arr[i] == 'A') {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {

		String str = "ASDFSGGFGHFGFDGFGGDSFGDSEWERHGSGAAAAHFDGSDFGDSFTGHJHJGHJKJHGKJLOIUYTTRJGNCVBVCBDFG";

		
		int count = countA(str); // 전달받은 str 내의 문자열에서 알파벳 A의 개수를 카운팅해서 return 하는 메서드
		System.out.println("알파벳 A의 개수는 : " + count);
	}
}
