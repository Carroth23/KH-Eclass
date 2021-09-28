
public class Exam_02_While {
	public static void main(String[] args) {

		int i = 49; // 초기값 지정
		while (i < 100) { // 조건문
			i++; // 증감문 (이걸 지우면 무한루프가 된다.)
			if (i % 2 == 1) { // 홀수만 출력하라.
				System.out.println("i = " + i);
			}
//			System.out.println("1 = " + ++i /*증감문을 넣은것*/);
		}

//		반복문은 초기값, 조건문, 증감문이 기본

	}
}
