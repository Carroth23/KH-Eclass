package main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.MessageDAO;
import dto.MessageDTO;
import utils.DateUtils;

public class Main {
	public static void main(String[] args) {

		MessageDAO dao = new MessageDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("== 방명록 시스템 ==");
			System.out.println("1. 방명록 남기기");
			System.out.println("2. 방명록 보기");
			System.out.println("3. 방명록 삭제");
			System.out.println("4. 방명록 수정");
			System.out.println("5. 방명록 검색"); // ID로 검색 / 작성자 검색
			System.out.println("6. 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();

			try {
				if (menu.equals("1")) {

					System.out.print("작성자 : ");
					String writer = sc.nextLine();

					System.out.print("메세지 : ");
					String message = sc.nextLine();

					System.out.print("방문 날짜 (yyyy/MM/dd) : ");
					Date visit_date = DateUtils.stringToSQLDate(sc.nextLine(), "yyyy/MM/dd");

					MessageDTO dto = new MessageDTO(0, writer, message, visit_date);

					int result = dao.insert(dto);
					if (result > 0) {
						System.out.println("입력 완료");
					}

				} else if (menu.equals("2")) {

					List<MessageDTO> list = dao.selectAll();
					for (MessageDTO dto : list) {
						System.out.println(dto.getSeq() + "\t" + dto.getWriter() + "\t" + dto.getVisit_date()); // 날짜 출력
						System.out.println(dto.getMessage());
					}

				} else if (menu.equals("3")) {

					List<MessageDTO> list = dao.selectAll();
					for (MessageDTO dto : list) {
						System.out.println(dto.getSeq() + "\t" + dto.getWriter() + "\t" + dto.getVisit_date());
						System.out.println(dto.getMessage());
					}
					System.out.print("삭제 할 항목의 ID : ");
					int id = Integer.parseInt(sc.nextLine());

					int result = dao.delete(id);
					if (result > 0) {
						System.out.println("삭제 완료");
					} else {
						System.out.println("대상을 찾을 수 없습니다.");
					}

				} else if (menu.equals("4")) {

					List<MessageDTO> list = dao.selectAll();
					for (MessageDTO dto : list) {
						System.out.println(dto.getSeq() + "\t" + dto.getWriter() + "\t" + dto.getVisit_date());
						System.out.println(dto.getMessage());
					}

					System.out.print("변경 할 대상 ID : ");
					int id = Integer.parseInt(sc.nextLine());

					System.out.print("작성자 : ");
					String writer = sc.nextLine();

					System.out.print("메세지 : ");
					String message = sc.nextLine();

					System.out.print("방문 날짜 (yyyy/MM/dd) : ");
					Date visit_date = DateUtils.stringToSQLDate(sc.nextLine(), "yyyy/MM/dd");

					int result = dao.modify(new MessageDTO(id, writer, message, visit_date));
					if (result > 0) {
						System.out.println("변경 완료");
					} else {
						System.out.println("대상을 찾을 수 없습니다.");
					}
				} else if (menu.equals("5")) {
					System.out.println("검색 방법을 선택하세요.");
					System.out.println("1. ID로 검색");
					System.out.println("2. 이름으로 검색");
					System.out.print(">> ");
					String searchMenu = sc.nextLine();

					if (searchMenu.equals("1")) {

						System.out.print("검색 할 SEQ 를 입력하세요 : ");
						int seq = Integer.parseInt(sc.nextLine());

						MessageDTO dto = dao.searchById(seq);
						System.out.println("결과 값 : " + dto);

						if (dto.getSeq() != 0) {
							System.out.println(dto.getSeq() + "\t" + dto.getWriter());
							System.out.println(dto.getMessage());
						} else {
							System.out.println("해당 Seq를 찾을 수 없습니다.");
						}

					} else if (searchMenu.equals("2")) {
						System.out.print("검색할 작성자 이름을 입력하세요 : ");
						String writer = sc.nextLine();
						List<MessageDTO> list = dao.searchByWriter(writer);

						if (list.size() != 0) {
							for (MessageDTO dto : list) {
								System.out.println(dto.getSeq() + "\t" + dto.getWriter());
								System.out.println(dto.getMessage());
							}
						} else {
							System.out.println("대상 이름을 검색할 수 없습니다.");
						}

					}

				} else if (menu.equals("6")) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("메뉴를 확인하세요.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("오류가 발생했습니다.관리자에게 문의하세요.010-1234-1234");
			}
		}
	}

}