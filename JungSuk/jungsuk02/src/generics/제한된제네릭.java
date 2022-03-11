package generics;

public class 제한된제네릭 {
	public static void main(String[] args) {
		
	}
}

interface Eatable{}
// 인터페이스여도 제네릭은 extends를 쓴다 implements아님
class FruitBox<T extends Eatable>{}
