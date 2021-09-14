
public class Exam_01 { // Startup 기업 Exam_01

	public static/*객체지향*/ int/*리턴타입*/ plus/*메서드명*/(int num1/*매개변수*/, int num2/*매개변수*/){
	// 매개변수 : (Arguments)
	// 매개변수의 성질은 지역변수와 같다
		int result/*지역 변수*/ = num1 + num2;
		return result; // 전달값인 result를 써줘야 함(안쓰고 바로 리턴도 가능). 반환값은 자동형변환 가능.
		// 1. 메서드를 종료한다.
		// 2. 값을 caller 에게 전달한다.
	}
	//메서드 완성
	
	//위에껄 주석제거
//	public static int plus(int num1, int num2) { /*메서드 정의부*/
//		int result = num1 + num2;
//		return result;
//	}
	
	
//	double random(/*파라미터가 없기때문에 매개변수도 없다*/){
//		// 어떠어떠한 난수를 만드는 작업...
//		return 더블값;
//	}
	
	
	public static void main(String[] args) { // main 사장님
		/*메서드 호출부*/plus(10, 5); // 소괄호를 치고 콤마로 값을 구분하는게 메서드에게 값을 전달하는 방법
		// 메서드를 부르며 처리를 위해 전달하는 (10, 5)값을 인수/인자(parameter, argument)라고 부른다.
		// Parameter : 메서드를 call 하면서 전달하는 값
		
		int result = plus(10, 5); // 이것도 가능 결국 int 15이기 때문
		
//		plus() - 제어문을 제외하고 키워드 뒤에()붙어있으면 모두 메서드 호출이다.
		System.out.println(10 + 5);
		
		
		Math.random();// 리턴타입이 void인 메서드 ()에 파라미터가 없다
	}

}
