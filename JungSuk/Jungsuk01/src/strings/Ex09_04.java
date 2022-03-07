package strings;

public class Ex09_04 {
	
	public static boolean contains(String a, String b) {
		return a.indexOf(b) != -1; // -1이면 -1이 아니기 때문에 false
	}
	
	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
		try {
			throw new Exception("고의에러");
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		} finally {
			System.out.println("예외처리되던말던 실행");
		}
	}
}
