package enumM;

				// 하나하나가 기본형이 아닌 객체임
enum Direction { EAST, SOUTH, WEST, NORTH }

public class 열거형 {
	public static void main(String[] args) {
		Direction d1 = Direction.EAST;							// 열거형타입.상수이름(많이씀)
		Direction d2 = Direction.valueOf("WEST");				// 다른방법
		Direction d3 = Enum.valueOf(Direction.class, "EAST");	// 또다른방법
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		System.out.println("d1 == d2 ? " + (d1 == d2));
		System.out.println("d1 == d3 ? " + (d1 == d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
//		System.out.println("d2 > d3 ? " + (d1 > d3)); 에러 객체라서 비교연산자 불가
		System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));
		
		switch(d1) {
		case EAST: // Direction.EAST라고 쓸 수 없다.
			System.out.println("The direction is EAST"); break;
		case SOUTH:
			System.out.println("The direction is SOUTH"); break;
		default:
			System.out.println("invalid direction"); break;
		}
		
		Direction[] dArr = Direction.values(); // 열거형의 모든 상수를 배열로 반환
		
		for(Direction d : dArr) {
			System.out.printf("%s=%d%n", d.name(), d.ordinal()); // 순서(값이 아님)
		}
	}
}
