import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Exam_01_Insert {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// OJDBC : Oracle Java DataBase Connection
		// 1. OJDBC 드라이버 로딩(오라클 드라이버 인스턴스 생성작업)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace(); // 에러발생 원인을 출력(개발 완료 후 제거)
			System.out.println("OJDBC 드라이버를 발견 하지 못하였습니다.");
			System.exit(0);
		}

		// 2. DBMS에 접속
		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
		String username = "kh";
		String password = "kh";
		
		// insert를 위한 값 입력
		System.out.println("신규 메뉴 이름 : ");
		String name = sc.nextLine();
		
		System.out.println("신규 메뉴 가격 : ");
		int price = Integer.parseInt(sc.nextLine());

		
		try {
			Connection con = DriverManager.getConnection(url, username, password);

			// 3. Query를 전달할 수 있는 인스턴스 생성
			Statement stat = con.createStatement();
//			String sql = "insert into cafe_menu values(cafe_menu_seq.nextval, 'Latte', 2000)";
			String sql = "insert into cafe_menu values(cafe_menu_seq.nextval,'" + name + "', " + price + ")";
			int result = stat.executeUpdate(sql);

//			stat.executeUpdate("여기에 바로 쿼리문 써도 됨");
			// executeQuery 는 select등 데이터 조회할때 (리턴값때문)
			// executeUpdate 는 데이터 수정같은걸 하는 쿼리를 쓸때
			
			System.out.println("결 과 : " + result);

			if (result > 0) {
				System.out.println("성공적으로 입력되었습니다.");
			} else {
				System.out.println("입력에 실패했습니다.");
			}

//			con.setAutoCommit(false); // 오토커밋 취소
//			con.commit(); // ojdbc8 버전에선 필요없음 auto커밋됨.
			con.close(); // 중요 반드시 해야함(끝내지않으면 계속 연결이 늘어나서 연결대기줄이 꽉참).
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("접속에 실패했습니다.");
			System.exit(0);
		}
	}

}