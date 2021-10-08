import java.util.Scanner;

public class Exam_02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// System.in.read(); // 한글자만 int형으로 입력받는다.

		System.out.println("남길 메세지를 이볅해주세요.");
		String str = sc.nextLine(); // 한 라인을 String형으로 입력받는다.
		System.out.println("입력한 메세지는 : " + str);
	}
}
