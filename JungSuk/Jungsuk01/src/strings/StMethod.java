package strings;

public class StMethod {

	public static void main(String[] args) {
		String a = "가나다라마바사아";		// concat = 뒤에 덧붙이는것.
		System.out.println(a.concat(" 반갑"));
		
		// 문자열을 캐릭터 배열로 전환
		char[] b = a.toCharArray();
		System.out.println(b[2]);
		
		// 문자열이 포함되었는지 검사
		System.out.println(a.contains("다라"));
		
		// 문자열이 해당문자열로 끝나는지 반대는 startWith
		System.out.println(a.endsWith("사아"));
		
		// 문자가 문자열에 존재하는지 확인하여 위치를 알려줌
		System.out.println(a.indexOf('라'));
		// 2번쨉터 찾음
		System.out.println(a.indexOf('다', 2));
	}

}
