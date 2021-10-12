package dao;
// DAO : Data Access Object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.MenuDTO;

public class CafeMenuDAO {
	// 템플릿 메서드 익스트랙트 패턴 (반복되는 코드를 하나의 메서드로 묶는 디자인패턴중 하나)
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); // Driver로딩
		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
		String username = "kh";
		String password = "kh";
		Connection con = DriverManager.getConnection(url, username, password);
		return con; // 커넥션 된 상태로 리턴. close도 없다.
	}

	public int insert(String name, int price) throws Exception { // Quiz_01의 main메서드(caller)에게 모든 예외 전가
//																	DAO에서는 에러를 처리하지 않을것이므로 .

		Connection con = getConnection(); // 계정 Connection
		
		
//		String sql = "insert into cafe_menu values(cafe_menu_seq.nextval, '" + name + "', " + price + ")";
//		Statement stat = con.createStatement(); // sql문을 전달할 Statement 생성
//		int result = stat.executeUpdate(sql);
		// 우리가 반환하는것은 int이다.
		
		String sql = "insert into cafe_menu values(cafe_menu_seq.nextval, ?,?)";
		PreparedStatement pstat = con.prepareStatement(sql); // sql이 여기서 들어감.
		pstat.setString(1, name); // 1번 물음표에 name값을 할당
		pstat.setInt(2, price); // 2번 물음표에 price를 할당
		int result = pstat.executeUpdate(); // 얘를 쓰는 가장 큰 이유는 보안성 때문에 (속도도 더 빠르다.) 옥션 사건의 대처방법중 하나
		
		con.close();
		return result; // return이 close밑에 있는 이유는 return은 값의 반환과 동시에 메서드의 끝이라서.
	}

	public int update(MenuDTO dto) throws Exception { // 객체를 받아서 보낼수도 있다 DTO로 묶어서.

		Connection con = getConnection();
		
//		Statement stat = con.createStatement();
//		String sql = "update cafe_menu set name = '" + dto.getName() + "', price = " + dto.getPrice() + " where id = " + dto.getId();
//		int result = stat.executeUpdate(sql);
		
		String sql = "update cafe_menu set name = ?, price = ? where id = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, dto.getName());
		pstat.setInt(2, dto.getPrice());
		pstat.setInt(3, dto.getId());
		int result = pstat.executeUpdate();

		con.close();
		return result;
	}

	public int delete(int id) throws Exception {

		Connection con = getConnection();
		
//		Statement stat = con.createStatement();
//		String sql = "delete from cafe_menu where id = " + id;
//		int result = stat.executeUpdate(sql);
		
		String sql = "delete from cafe_menu where id = ?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setInt(1, id);
		int result = pstat.executeUpdate();

		con.close();
		return result;
	}

	public ArrayList<MenuDTO> selectAll() throws Exception{ // 출력
		
		Connection con = getConnection();
		
//		Statement stat = con.createStatement();
//		String sql = "select * from cafe_menu order by 1";
//		ResultSet rs = stat.executeQuery(sql);
		
		String sql = "select * from cafe_menu order by 1";
		PreparedStatement pstat = con.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		
		ArrayList<MenuDTO> result = new ArrayList<MenuDTO>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			
			MenuDTO m = new MenuDTO(id, name, price);
			result.add(m);
		}
		con.close();
		return result;
	}


}
