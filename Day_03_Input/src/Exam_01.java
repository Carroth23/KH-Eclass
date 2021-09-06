
public class Exam_01 {

	public static void main(String[] args) throws Exception/* 예외 처리 (문제발생시 프로그램 종료)*/{

		// System.out.println("Hello World"); // 화면에 Hello World를 출력하세요

		// System.in.read(); // 프로그램 사용자로부터 한글자의 입력을 받으세요.
		// 몇글자를 입력하던 입력된 모든 글자중 맨 앞의 한글자만 버퍼에서 가져감.
		
		System.out.print("문자를 한글자 입력하세요 : ");
		int num = System.in.read(); // 이런 코드도 가능. 버퍼에서 한글자만 떼어감.
		System.out.println("입력받은 문자의 값은 : " + num);
		
		System.out.print("문자를 한글자 입력하세요 : ");
		int num2 = System.in.read(); // 
		System.out.println("입력받은 문자의 값은 : " + num2);
		
		System.out.print("문자를 한글자 입력하세요 : ");
		int num3 = System.in.read(); // 
		System.out.println("입력받은 문자의 값은 : " + num3);
		
		System.out.print("문자를 한글자 입력하세요 : ");
		int num4 = System.in.read(); // 
		System.out.println("입력받은 문자의 값은 : " + num4); // 버퍼에 아직 엔터가 있지만 시스템이 끝나서 전부 사라짐.
		
	}

}
