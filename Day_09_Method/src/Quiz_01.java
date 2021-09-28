
public class Quiz_01 {
	
	public static String test(String str) {
		if (str.equals("사과")) { // String값 비교할땐 equals 사용
			return "Apple";
		} else if (str.equals("포도")){
			return "Grape";
		} else {
			return "None";
		}
	}
	
	public static int myRand(int min, int max) {
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
	public static void main(String[] args) {

		// "사과" 를 전달하면, "Apple"를 return 하고
		// "포도" 를 전달하면, "Grape"를 return 하는 메서드 test를 만드세요
		// "사과"나 "포도"가 아니면 "None"을 return!
		
		System.out.println(test("사과"));
		
		System.out.println(myRand(10, 20)); // 10 ~ 20사이의 난수
		
	}
}
