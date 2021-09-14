import java.util.Arrays;

public class Exam_03 {

//	boolean equals(String str) { 아마 이렇게 생겼을것.
//		
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Hello";
		System.out.println(str.length());
		
		char at = str.charAt(1);
		System.out.println(at);
		
		char[] charr = str.toCharArray();
		
		System.out.println(Arrays.toString(charr));
		
		String sub = "Hello";
		boolean result = str.startsWith("He");
		boolean result2 = str.endsWith("o");
		// boolean 을 리턴하는 메서드는 의문문으로 읽어보면 됨 ("He"로 시작하는거냐?) 
		System.out.println(result);
		System.out.println(result2);
		
		str.contains("ell"); // 포함 되어 있냐? (캐릭터시퀀스는 String로 생각하면 됨)
		str.equals("Hello");
		String str2 = "Apple:Orange:Mango";
		String[] fruits = str2.split(":");
		for (int i = 0; i < fruits.length; i++) {
			System.out.println(fruits[i]);
		}
		
//		str.replace 공부해보기
	}

}
