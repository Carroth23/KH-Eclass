package lambda;

public class 람다02 {
	public static void main(String[] args) {
//		Object obj = (a, b) -> a > b ? a : b; // 람다식, 익명객체
		Object obj = new Object() { // 위에 코드와 동일함. 자바특성상 모든 메서드는 객체 안에 있어야함.
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
//		int value = obj.max(3, 5); // obj에는 max가 없음
		// 분명 위에서 Object가 가지고 있지만 Object타입엔 없다.
		
	}
}
