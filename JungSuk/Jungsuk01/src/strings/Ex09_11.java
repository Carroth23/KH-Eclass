package strings;

public class Ex09_11 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println("sb == sb2 ? " + (sb == sb2));
		System.out.println("sb.equals(sb2) ? " + sb.equals(sb2));
		
		String s = sb.toString();
		String s2 = sb2.toString();
		System.out.println("s.equals(s2) ? " + s.equals(s2));
		System.out.println("s == s2 ? " + (s == s2));
		
		// 배열은 길이 변경 불가.
		// 배열의 공간이 부족하면 새로 생성하고 복사하고... 이러면 성능상의 문제가 생김.
		// StringBuffer는 저장할 문자열의 길이를 고려해서 적절한 크기로 생성
		// StringBuffere의 기본 크기는 16 (별 의미는 없음)
		// StringBuffere의 메서드는 자기 자신을 반환
	}

}
