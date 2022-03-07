package strings;

public class StringBufferProc {
	public static void main(String[] args) {
		// 기본 16 + 2 길이의 배열 생성
		StringBuffer sb = new StringBuffer("01");
		// sb에 append하고 자기 자신을 반환 -> 결국 sb의 주소를 반환
		StringBuffer sb2 = sb.append(23);
		// 모두 캐릭터형으로 들어감.
		sb.append('4').append(56);
		
		// 다시 sb에 3을 추가하고 sb주소를 반환
		StringBuffer sb3 = sb.append(78);
		// 또 append
		sb3.append(9.0);
		
		System.out.println("sb = " + sb);
		System.out.println("sb2 = " + sb2);
		System.out.println("sb3 = " + sb3);
		
		System.out.println("sb = " + sb.deleteCharAt(10));
		System.out.println("sb = " + sb.delete(3,6));
		System.out.println("sb = " + sb.insert(3, "abc"));
		System.out.println("sb = " + sb.replace(6, sb.length(), "end"));
		
		System.out.println("capacity = " + sb.capacity());
		System.out.println("length = " + sb.length());
		
		
		String s = "Hi";
		int q = Integer.valueOf(s);
		String qq = String.valueOf(3);
	}
}
