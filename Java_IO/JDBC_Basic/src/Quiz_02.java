import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜를 입력하세요 (yyyy/MM/dd) : ");
		String input = sc.nextLine();
		
		// 입력받은 날짜의 timestamp를 출력하세요.
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // MM은 대문자 쓰는 이유: 소문자는 minute될수도
//			Date result = sdf.parse(input);
//			System.out.println("분석된 Timestamp : " + result.getTime());
//		
//		// 입력받은 날짜를 dd일 mm월 yyyy년 형식으로 출력해주세요.
//			SimpleDateFormat sdfstr = new SimpleDateFormat("dd일 MM월 yyyy년");
//			String dateString = sdfstr.format(result);
//			System.out.println("변경된 날짜 형식 : " + dateString);
		
		// 입력받은 날짜의 timestamp를 출력하세요.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 분석 방식
		Date result = sdf.parse(input);
		System.out.println("분석 후 : " + result.getTime());
		
		// 입력받은 날짜를 dd일 MM일 yyyy년 형식으로 출력하세요.
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd월 MM일 yyyy년"); // 표현 방식
		String dateString = sdf2.format(result.getTime());
		System.out.println(dateString);
		System.out.println("변환 후 : " + sdf2.format(result.getTime())); // 바로 출력도 가능
	}
}
