package main;

import java.sql.Date;
import java.util.Scanner;

import dao.MoviesDAO;
import dto.MoviesDTO;
import utils.DateUtils;

public class Movies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MoviesDAO dao = new MoviesDAO();

		while (true) {
			System.out.println(" == Netflix 관리 시스템 == ");
			System.out.println("1. 영화 등록");
			System.out.println("2. 영화 목록");
			System.out.println("3. 영화 삭제");
			System.out.println("4. 영화 정보 수정");
			System.out.println("5. 영화 검색");
			System.out.println("6. 종료");
			int menu = Integer.parseInt(sc.nextLine());

			try {
				if (menu == 1) {
					System.out.println("영화 이름 : ");
					String title = sc.nextLine();
					System.out.println("영화 설명 : ");
					String description = sc.nextLine();
					System.out.println("출시년월 yyyy/MM/dd : ");
					Date rel_date = DateUtils.stringToSQLDate(sc.nextLine(), "yyyy/MM/dd");

					if (dao.insert(new MoviesDTO(0, title, description, rel_date)) > 0) {
						System.out.println("등록 완료.");
					}
				} else if (menu == 2) {
					for (MoviesDTO dto : dao.selectAll()) {
						System.out.println(dto.getId() + "\t" + dto.getTitle() + "\t" + dto.getDescription() + "\t"
								+ dto.getReldate());
					}
				} else if (menu == 3) {
					for (MoviesDTO dto : dao.selectAll()) {
						System.out.println(dto.getId() + "\t" + dto.getTitle() + "\t" + dto.getDescription() + "\t"
								+ dto.getReldate());
					}
					System.out.println("삭제할 영화 ID : ");
					int id = Integer.parseInt(sc.nextLine());
					if (dao.delete(id) > 0) {
						System.out.println("삭제 완료.");
					}
				} else if (menu == 4) {
					System.out.println("수정할 영화 ID : ");
					int id = Integer.parseInt(sc.nextLine());
					System.out.println("영화 이름 : ");
					String title = sc.nextLine();
					System.out.println("영화 설명 : ");
					String description = sc.nextLine();
					System.out.println("출시년월 yyyy/MM/dd : ");
					Date rel_date = DateUtils.stringToSQLDate(sc.nextLine(), "yyyy/MM/dd");
					
					if (dao.update(new MoviesDTO(id, title, description, rel_date)) > 0) {
						System.out.println("변경 완료.");
					}
					
				} else if (menu == 5) {
					System.out.println("어떤 방식으로 검색하시겠습니까?");
					System.out.println("1. ID로 검색");
					System.out.println("2. 제목으로 검색");
					int choice = Integer.parseInt(sc.nextLine());
					
					if (choice == 1) {
						System.out.println("검색할 영화의 ID 입력 : ");
						int id = Integer.parseInt(sc.nextLine());
						
						MoviesDTO dto = dao.searchId(id);
						if (dto.getId() != 0) {
							System.out.println(dto.getId() + "\t" + dto.getTitle());
							System.out.println(dto.getDescription() + "\t" + dto.getReldate());
						} else {
							System.out.println("영화를 찾을 수 없습니다.");
						}
					} else if (choice == 2) {
						System.out.println("검색할 영화의 제목 입력 : ");
						String title = sc.nextLine();
						
						for(MoviesDTO dto : dao.selectAll(title)) {
							System.out.println(dto.getId() + "\t" + dto.getTitle());
							System.out.println(dto.getDescription() + "\t" + dto.getReldate());
						}
					}
					
				} else if (menu == 6) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("메뉴를 다시 확인해 주세요.");
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("기술문제발생");
			}
		}
	}
}
