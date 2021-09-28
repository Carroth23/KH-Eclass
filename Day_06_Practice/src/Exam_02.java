import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 예외 처리
		
		System.out.println("숫자를 입력하세요 : ");
		
		try {
			int num = Integer.parseInt(sc.nextLine()); // 에러가 발생할것으로 예상되는 코드
		} catch (Exception e) { // catch는 에러가 발생시 이렇게 처치하세요 라는 구문, 에러가 나지않는다면 없는셈 친다.
			System.out.println("입력한 값은 숫자가 아닙니다.");
		}
		
//		System.out.println("입력한 숫자는 " + num + " 입니다."); // num은 try의 지역변수기 때문에 여기선 사용 불가
		
	}
}
