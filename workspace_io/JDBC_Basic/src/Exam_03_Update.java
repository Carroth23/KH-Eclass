import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Exam_03_Update {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) { // Exception은 예외의 최고조상급
			System.out.println("드라이버 로딩에 실패하였습니다.");
			e.printStackTrace();
			System.exit(0);
		}

		try {
			// 2.Connection 객체 생성
			String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
			String username = "kh";
			String password = "kh";
			Connection con = DriverManager.getConnection(url, username, password);

			// 3.Statement 객체 생성
			Statement stat = con.createStatement();
			

			System.out.println("가격을 바꿀 메뉴를 입력해 주세요.");
			String name = sc.nextLine();
			
			System.out.println("바꿀 가격을 입력해 주세요.");
			int price = Integer.parseInt(sc.nextLine());
			
			// 4.Query 전달
			String sql = "update cafe_menu set price = " + price + " where name = '" + name + "'";
			int result = stat.executeUpdate(sql);

			// 5.return 값에 따른 결과 출력
			if (result > 0) {
				System.out.println("변경 성공");
			} else {
				System.out.println("변경 실패");
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
