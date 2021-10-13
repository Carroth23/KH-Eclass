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

		// 예외처리의 여러 방식.
		// try - catch
		// try - catch - catch - catch
		// try - catch - finally (예외가 생기면 catch후 빠져나감[finally로는 안감])
		// finally는 예외가 생기던 안생기던 무조건 실행(구문이 끝나기전 finally를 실행 후 종료).
		// try - finally (전가 시킬때 사용 예외발생하면 예외전가해야되는데 그 직전에 finally 들렸다 나감)
		// try with resource - 얘가 요즘쓰는거 or close를 쓰기 편함

		//////////////////////////////////////////////////////
//		try - finally 사용구문 (근데 이거 옛날방식임)

//		Connection con = null;
//		try {
//			con = getConnection();
//			String sql = "insert into cafe_menu values(cafe_menu_seq.nextval, ?,?)";
//			PreparedStatement pstat = con.prepareStatement(sql);
//			pstat.setString(1, name);
//			pstat.setInt(2, price);
//			int result = pstat.executeUpdate();
//			return result;
//		} finally {
//			con.close();
//		}
		///////////////////////////////////////////////////////
//		try with resource 사용구문

//		String sql = "insert into cafe_menu values(cafe_menu_seq.nextval, ?,?)"; /*pstat가 try안으로 가서 sql이 밖으로 빠짐*/
//		try(Connection con = getConnection();/*리소스를 반환할 코드를 넣음 무조건 close를 하고 나감*/
//			PreparedStatement pstat = con.prepareStatement(sql);) { /*pstat도 close를 해줘야 해서 넣는다.*/
//			pstat.setString(1, name);
//			pstat.setInt(2, price);
//			int result = pstat.executeUpdate();
//			return result;
//		} /*여기에 catch 붙여도 됨. 그래도 close하고 감*/
		/////////////////////////////////////////////////////////

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

		String sql = "update cafe_menu set name = ?, price = ? where id = ?";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getName());
			pstat.setInt(2, dto.getPrice());
			pstat.setInt(3, dto.getId());
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public int delete(int id) throws Exception {

		String sql = "delete from cafe_menu where id = ?";
		try(Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, id);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public ArrayList<MenuDTO> selectAll() throws Exception { // 출력

		String sql = "select * from cafe_menu order by 1";
		try (
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
			) {
			ArrayList<MenuDTO> result = new ArrayList<MenuDTO>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				
				MenuDTO m = new MenuDTO(id, name, price);
				result.add(m);
			}
			return result;
		}

	}

}
