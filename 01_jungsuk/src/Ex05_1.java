import java.util.Arrays;

public class Ex05_1 {

	public static void main(String[] args) {
		// 			  01234
		String str = "ABCDE";
		char ch = str.charAt(4);
		System.out.println(ch);
		
		String str2 = str.substring(1); // 1���� ��
		String str3 = str.substring(1, 4); // 4�� ���� �ȵ�.
		System.out.println(str2);
		
	}

}
