import java.util.Arrays;

public class Exam_03 {

//	boolean equals(String str) { �Ƹ� �̷��� ��������.
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
		// boolean �� �����ϴ� �޼���� �ǹ������� �о�� �� ("He"�� �����ϴ°ų�?) 
		System.out.println(result);
		System.out.println(result2);
		
		str.contains("ell"); // ���� �Ǿ� �ֳ�? (ĳ���ͽ������� String�� �����ϸ� ��)
		str.equals("Hello");
		String str2 = "Apple:Orange:Mango";
		String[] fruits = str2.split(":");
		for (int i = 0; i < fruits.length; i++) {
			System.out.println(fruits[i]);
		}
		
//		str.replace �����غ���
	}

}
