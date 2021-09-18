import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Silver sil = new Silver(); // 인스턴스화
		int id = 1001;
		int index = 0;
		Silver[] sils = new Silver[10];

		
		for (int i = 0; i < 12; i++) {
			System.out.println(sils[i]);
		}
		while (true) {
			System.out.println("== 회원 관리 시스템 ==");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 목록 출력");
			System.out.println("3. 시스템 종료.");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				System.out.println("신규 회원 등록 창입니다.");
				System.out.print("신규 회원의 이름 : _");
				String name = sc.nextLine();
				System.out.print("회원의 포인트 : _");
				int point = Integer.parseInt(sc.nextLine());
				
				sils[index].setId(id);
				sils[index].setName(name);
				sils[index].setPoint(point);
				id++;
				index++;
				break;
			case 2:
				for (int i = 0; i < index; i++) {
					System.out.println(sils[index].getId() + "\t" + sils[index].getName() + "\t"
							+ sils[index].getPoint() + "\t" + sils[index].getBonus());
				}
				break;
			case 3:
				System.exit(0);
			}

		}

	}
}