import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam_04_Select {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
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

			// 4.Query 전달
			String sql = "select * from cafe_menu order by 1";
			ResultSet rs = stat.executeQuery(sql);
			// ResultSet : 위치(테이블의 헤더라인)를 가리키는 포인터같은 객체
			
			while (rs.next()) { // 한줄씩 내려가며 데이터가 있는지 확인
				int id = rs.getInt("id"); // rs.getInt(1); 1은 첫번째컬럼을 말하는것.
				String name = rs.getString("name"); // rs.getString(2); 2번열
				int price = rs.getInt("price"); // rs.getInt(3);
				System.out.println(id + " : " + name + " : " + price);
			}
			
			con.close(); // 접속이 끊기면 next 사용불가 DB에 접근할수 없기때문.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
