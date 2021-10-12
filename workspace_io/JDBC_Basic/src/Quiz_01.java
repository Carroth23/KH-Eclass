import java.util.ArrayList;
import java.util.Scanner;

import dao.CafeMenuDAO;
import dto.MenuDTO;

public class Quiz_01 {
	public static void main(String[] args) { // main에선 throws안씀(여기서도 던지면 프로그램 안하겠단뜻)

		CafeMenuDAO dao = new CafeMenuDAO(); // 인스턴스가 있어야 값을 받아오거나 주거나 할수있다.
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println(" == 메뉴 관리 시스템 == ");
			System.out.println("1. 신규 메뉴 등록");
			System.out.println("2. 메뉴 목록 출력");
			System.out.println("3. 메뉴 정보 수정");
			System.out.println("4. 메뉴 정보 삭제");
			System.out.println("5. 시스템 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();
			
			try {
				if (menu.equals("1")) {
					
					System.out.println("메뉴 이름 : ");
					String name = sc.nextLine();

					System.out.println("메뉴 가격 : ");
					int price = Integer.parseInt(sc.nextLine());

					int result = dao.insert(name, price);
					if (result > 0) {
						System.out.println("입력 완료.");
					}
					
				} else if (menu.equals("2")) {
					
					ArrayList<MenuDTO> list = dao.selectAll();
					for (MenuDTO m : list) {
						System.out.println(m.getId() + " : " + m.getName() + " : " + m.getPrice());
					}
					
				} else if (menu.equals("3")) {
					
					// ID기준으로 수정하기
					System.out.println("수정하실 메뉴의 ID를 입력해 주세요 : ");
					int id = Integer.parseInt(sc.nextLine());
					
					System.out.println("메뉴의 새 이름 : ");
					String name = sc.nextLine();
					
					System.out.println("메뉴의 새 가격 : ");
					int price = Integer.parseInt(sc.nextLine());
					
					int result = dao.update(new MenuDTO(id, name, price)); // 객체를 보낼수 있다.
					if (result > 0) {
						System.out.println("변경 성공.");
					}
					
				} else if (menu.equals("4")) {
					System.out.println("삭제하실 메뉴의 ID를 입력해 주세요.");
					int id = Integer.parseInt(sc.nextLine());
					
					int result = dao.delete(id);
					if (result > 0) {
						System.out.println("삭제 성공.");
					}
				} else if (menu.equals("5")) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("메뉴를 다시 확인하세요.");
				}

			} catch (Exception e) {
				e.printStackTrace(); // 개발자가 에러 확인하는 부분.
				System.out.println("요청하신 기능을 수행하는 중 오류가 발생했습니다.");
				System.out.println("같은 오류가 반복될 시 관리자에게 문의해주세요.");
				System.out.println("E-mail : admin@company.com");
			}

		}

	}
}
