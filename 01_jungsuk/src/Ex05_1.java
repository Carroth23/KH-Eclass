import java.util.Arrays;

public class Ex05_1 {

	public static void main(String[] args) {
		// 			  01234
		String str = "ABCDE";
		char ch = str.charAt(4);
		System.out.println(ch);
		
		String str2 = str.substring(1); // 1ºÎÅÍ Âß
		String str3 = str.substring(1, 4); // 4´Â Æ÷ÇÔ ¾ÈµÊ.
		System.out.println(str2);
		
	}

}
