import java.util.*;
public class Exam_03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요 : ");
		String num = sc.nextLine();
		int result = Integer.parseInt(num);
		
//		int result = Integer.parseInt(sc.nextLine()); // 이것도 문법적으로 가능
//		System.out.println("더한 결과는 " + (Integer.parseInt(sc.nextLine()))); 이것도 가능
		System.out.println(result + 10);
		
		//예외 == 에러
	}

}
