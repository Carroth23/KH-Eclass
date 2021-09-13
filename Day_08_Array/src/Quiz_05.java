import java.util.*;

public class Quiz_05 {
	public static void main(String[] args) {

		// 중복되지않는 6개의 1 ~ 45사이의 숫자 + 보너스 번호 ( 총 7개의 숫자 )
		// 오늘의 로또 번호 추천 프로그램

		int[] lotto = new int[45]; // 45개의 칸을 생성

		// 로또번호 초기화 1 ~ 45 까지 순서대로
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}

		// 모든 로또 번호 카드 한장씩 섞기
		for (int i = 0; i < lotto.length; i++) {
			int j = (int) (Math.random() * 45);
			int tmp = lotto[i];
			lotto[i] = lotto[j];
			lotto[j] = tmp;
		}

		// 추천번호를 추천번호 배열에 복사
		int[] rcmd = new int[6]; // 복사할 새로운 6칸의 배열 생성
		for (int i = 0; i < 6; i++) {
			rcmd[i] = lotto[i];
		}

		// 추천 번호 배열 정렬
		for (int i = 0; i < rcmd.length - 1; i++) {
			for (int j = 0; j < rcmd.length - 1; j++) {
				if (rcmd[j] > rcmd[j + 1]) {
					int tmp = rcmd[j];
					rcmd[j] = rcmd[j + 1];
					rcmd[j + 1] = tmp;
				}
			}
		}

		// 추천 번호 발표
		System.out.print("오늘의 로또 번호 : ");
		for (int i = 0; i < rcmd.length; i++) {
			System.out.print(rcmd[i] + " ");
		}
		System.out.println("보너스 번호 : " + lotto[6]);
	}

}
