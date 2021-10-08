package electronic;

public class Temp {

	public int a;			// Instance Member Field (인스턴스와 생명주기가 같다.)
	public static int b;	// Class Member Field (main이 실행될때 같이 선언됨.)
							// static이 붙은 요소들은 모두 Data메모리로 들어감.
	private static int c; 	// private를 붙이면 Temp 인스턴스 내에서만 공유하는 변수가 된다.
}
