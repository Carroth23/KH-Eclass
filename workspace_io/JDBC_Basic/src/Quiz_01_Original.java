import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Quiz_01_Original {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1. OJDBC 드라이버 로딩(오라클 드라이버 인스터스 생성작업)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		// 2. DBMS에 접속 하기 위한 정보 저장
		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
		String username = "kh";
		String password = "kh";

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

					// 2. DBMS에 접속
					Connection con = DriverManager.getConnection(url, username, password);
					// 커넥션이 While안에 있는 이유는 커넥션되고 닫히기까지의 텀을 최소한으로 하기위해.
					
					// 3. Query를 전달할 수 있는 인스턴스 생성
					Statement stat = con.createStatement();
					String sql = "insert into cafe_menu values(cafe_menu_seq.nextval, '" + name + "', " + price + ")";
					int result = stat.executeUpdate(sql);
					System.out.println("입력 성공!");
					con.close();

				} else if (menu.equals("2")) {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement stat = con.createStatement();
					String sql = "select * from cafe_menu order by 1";
					ResultSet rs = stat.executeQuery(sql);
					
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						int price = rs.getInt("price");
						System.out.println(id + " : " + name + " : " + price);
					}
					con.close();
				} else if (menu.equals("3")) {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement stat = con.createStatement();
					String sql = "select * from cafe_menu order by 1";
					ResultSet rs = stat.executeQuery(sql);
					
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						int price = rs.getInt("price");
						System.out.println(id + " : " + name + " : " + price);
					}
					con.close();
					
					// ID기준으로 수정하기
					System.out.println("수정하실 메뉴의 ID를 입력해 주세요 : ");
					int id = Integer.parseInt(sc.nextLine());
					
					System.out.println("메뉴의 새 이름 : ");
					String name = sc.nextLine();
					
					System.out.println("메뉴의 새 가격 : ");
					int price = Integer.parseInt(sc.nextLine());
					
					con = DriverManager.getConnection(url, username, password);
					stat = con.createStatement();
					
					sql = "update cafe_menu set name = '" + name + "', price = " + price + " where id = " + id;
					int result = stat.executeUpdate(sql);
					
					if (result > 0) {
						System.out.println("변경 완료.");
					} else {
						System.out.println("대상 ID를 찾을 수 없습니다.");
					}
					
					con.close();
				} else if (menu.equals("4")) {
					Connection con = DriverManager.getConnection(url, username, password);
					Statement stat = con.createStatement();
					String sql = "select * from cafe_menu order by 1";
					ResultSet rs = stat.executeQuery(sql);
					
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						int price = rs.getInt("price");
						System.out.println(id + " : " + name + " : " + price);
					}
					con.close();
					
					System.out.println("삭제하실 메뉴의 ID를 입력해 주세요.");
					int id = Integer.parseInt(sc.nextLine());
					
					con = DriverManager.getConnection(url, username, password);
					stat = con.createStatement();
					sql = "delete from cafe_menu where name = '" + id + "'";
					stat.executeUpdate(sql);
					
					System.out.println("삭제가 완료되었습니다.");
					
					con.close();
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
