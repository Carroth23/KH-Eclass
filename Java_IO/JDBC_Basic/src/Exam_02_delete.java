import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Exam_02_delete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("OJDBC 드라이버를 발견하지 못했습니다.");
			System.exit(0);
		}
		
		// 접속 
		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
		String username = "kh";
		String password = "kh";
		
		
		System.out.println("삭제할 메뉴를 입력해 주세요.");
		String name = sc.nextLine();
		
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			
			// Query발사
			Statement stat = con.createStatement();
			int result = stat.executeUpdate("delete from cafe_menu where name = '" + name + "'");
			
			if (result > 0) {
				System.out.println("삭제완료");
			} else {
				System.out.println("삭제 실패");
			}
			
			con.close(); // 얘 빼먹으면 안됨.
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("접속에 실패했습니다.");
			System.exit(0);
		}
	}
}