import java.util.*;

public class Quiz_12_If {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 스캐너 사용
		System.out.println("퍼스널컬러 테스트 ver2.0");
		System.out.println("이 테스트는 권위있는 영국 학술지 NATURE에 실리고싶은 테스트입니다.");
		System.out.println("평소 자신이 선호하는 색상을 적어 주세요.>");
		String color = sc.nextLine(); // 사용자의 입력을 문자열로 저장

		System.out.printf("선택하신 색상은 %s 입니다.%n", color);
		double ran = Math.random() * 10; // double형 난수를 생성
		int dom = (int) ran - 5; // int형으로 캐스팅하여 소수점자리 제거와 케이스 줄이기

		System.out.print("분석중"); // 뭔가 분석중이면서 콤마가 늘어나는 느낌이 나게
		char comma = '.';
		int i = 0;
		while (i++ < 13) {
			System.out.print(comma);
			if (i == 13) {
				System.out.println();
			}
		}

		if (dom == 0) { // 아무 말이나 가져다 붙이기
			System.out.printf("%s 색상을 좋아하는 당신은 온화한 사람입니다.%n", color);
			System.out.printf("%s 색상을 좋아하는 사람들의 특징은 남을 먼저 생각하고 배려하며%n", color);
			System.out.println("항상 베푼다는 특징이 있습니다.");
		} else if (dom == 1) {
			System.out.printf("항상 활기차고 웃음기 많은 당신 %s 색상을 선택하셨군요.%n", color);
			System.out.printf("%s 색상은 당신에게 잘 맞으며 훌륭한 퍼스널 컬러가 될것입니다.", color);
		} else if (dom == 2) {
			System.out.println("조금은 소심하지만 누구보다 큰 꿈을 꾸는 당신");
			System.out.printf("혹시 %s 색상을 선택하지 않으셨나요? 그렇다면 잘하셨습니다.%n", color);
			System.out.printf("%s 색상은 당신에게 힘과 앞으로 나아갈 용기를 불어넣어 줄것입니다.", color);
		} else if (dom == 3) {
			System.out.printf("%s 의 주인은 바로 당신, 최고의 궁합색상을 선택하셨네요!%n", color);
			System.out.println("앞으로도 " + color + " 색상과 함께 멋진 날이 기다릴거에요.");
		} else if (dom == 4) {
			System.out.printf("당신과 완벽히 어울리지는 않지만 %s 색상은 언제나 당신을 지켜줄것입니다.%n", color);
			System.out.println("앞으로고 꾸준히 " + color + " 색상을 사랑해 준다면, " + color + " 색상은 최고의 퍼스널 컬러가 될것입니다.");
		} else {
			System.out.printf("축하합니다. 베스트 색상을 고르셨군요.!%n%s 색상과 함께라면 앞으로도 쭉 멋진일이 생길것입니다.", color);
		}
	}

}
