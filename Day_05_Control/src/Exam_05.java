import java.util.Scanner;

public class Exam_05 {

	public static void main(String[] args) {

//		String a = "Hello";
//		String b = "Hello";
		
//		System.out.println(a == b);
		// 기본형은 Stack에 있고
		// 참조형은 heap에 있다.
		// String a 에 담겨있는건 데이터가 담겨있는 공간의 주소가 담겨있나.
		// 그러니까 참조자료형들은 heap에 데이터를 저장하고 Stack에 그 주소값을 저장함.
		// 근데 String b = new String("Hello");로 만들면 Heap에 다른 공간을 또 만듬.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("메세지를 입력하세요.");
		String msg = sc.nextLine(); // 내부적으로 new String("Apple")라고 만들어 사용을 한다.
		
		if (msg == "Apple") {
			System.out.println("입력된 단어는 사과 입니다.");
		}
		// 출력이 안되는 이유는 위에 만든것처럼 new로 만들었기때문에 주소값이 달라짐. 
		// 문자열끼리는 주소값으로 비교하기때문.
//		그래서 문자열끼리 비교할땐 
//		if (msg.equals("Apple")) 를 사용해줘야 함. (msg안에 담겨있는 문자열이 "Apple"가 맞습니까.)
	}

}
