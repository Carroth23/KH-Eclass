import java.util.*;
public class Ex01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("작성자를 입력해주세요.");
		String str = sc.nextLine();
		
		System.out.println("남길 메세지를 입력해주세요.");
		String str2 = sc.nextLine();
		
		System.out.println(str + " 님이 남긴 메세지");
		System.out.println(str2);
	}

}
