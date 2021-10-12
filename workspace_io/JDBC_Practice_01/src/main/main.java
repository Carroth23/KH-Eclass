package main;

import java.util.List;
import java.util.Scanner;

import dao.MessageDAO;
import dto.MessageDTO;

public class main {
	public static void main(String[] args) {
		MessageDAO dao = new MessageDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			// Messages Project - 방명록 시스템
			System.out.println(" == 방명록 시스템 == ");
			System.out.println("1. 방명록 남기기");
			System.out.println("2. 방명록 보기");
			System.out.println("3. 방명록 삭제");
			System.out.println("4. 방명록 수정");
			System.out.println("5. 방명록 검색"); // ID로 검색 / 작성자 검색
			System.out.println("6. 시스템 종료");
			int menu = Integer.parseInt(sc.nextLine());

			try {
				if (menu == 1) {
					System.out.println("작성자의 이름 : ");
					String writer = sc.nextLine();
					System.out.print("남기실 방명록을 작성해 주세요_");
					String message = sc.nextLine();

					int result = dao.insert(writer, message);
					if (result > 0) {
						System.out.println("작성 완료.");
					}
				} else if (menu == 2) {
					List<MessageDTO> list = dao.selectAll();
					for (MessageDTO m : list) {
						System.out.println(m.getSeq() + " : " + m.getWriter() + " : " + m.getMessage());
					}
				} else if (menu == 3) {
					System.out.println("삭제할 방명록 번호를 입력해주세요_");
					int seq = Integer.parseInt(sc.nextLine());

					int result = dao.delete(seq);
					if (result > 0) {
						System.out.println("삭제 완료.");
					}
				} else if (menu == 4) {
					System.out.println("수정할 방명록 번호를 입력해주세요_");
					int seq = Integer.parseInt(sc.nextLine());
					System.out.println("새 작성자 : ");
					String writer = sc.nextLine();
					System.out.println("새 메세지 : ");
					String message = sc.nextLine();

					int result = dao.update(writer, message, seq);
					if (result > 0) {
						System.out.println("수정 완료.");
					}
				} else if (menu == 5) {
					System.out.println("아이디로 검색하시려면 1번, 이름으로 검색하시려면 2번을 입력해주세요.");
					int choice = Integer.parseInt(sc.nextLine());

					if (choice == 1) {
						System.out.println("검색할 ID : ");
						int id = Integer.parseInt(sc.nextLine());
						
						MessageDTO m = dao.search(id);
						if(m != null) {
							System.out.println(m.getSeq() + " : " + m.getWriter() + " : " + m.getMessage());
						} else {
							System.out.println("해당 ID를 찾을 수 없습니다.");
						}
						
					} else if (choice == 2) {
						System.out.println("검색할 작성자명 : ");
						String writer = sc.nextLine();
						List<MessageDTO> list = dao.search(writer);

						if (list.size() != 0) {
							for (MessageDTO m : list) {
								System.out.println(m.getSeq() + " : " + m.getWriter() + " : " + m.getMessage());
							}
						} else {
							System.out.println("대상 이름을 찾을 수 없습니다.");
						}
					}

				} else if (menu == 6) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("메뉴를 다시 확인해 주십시오.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("기술적인 문제가 발생하였습니다.");
				System.out.println("이 메세지가 반복적으로 나올경우 관리자에게 문의하십시오.");
			}
		}
	}
}
