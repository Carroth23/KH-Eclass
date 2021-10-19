package Login_Message;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDAO {
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
		String id = "practice";
		String pw = "practice";
		return DriverManager.getConnection(url, id, pw);
	}
	
	public int insert(String writer, String message) throws Exception {
		String sql = "insert into guestbook values(guestbook_seq.nextval, ?, ?, sysdate)";
		try (
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)
				){
			pstat.setString(1, writer);
			pstat.setString(2, message);
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	public List<GuestbookDTO> selectAll() throws Exception {
		String sql = "select * from guestbook";
		try (
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()){
			List<GuestbookDTO> list = new ArrayList<>();
			while (rs.next()) {
				GuestbookDTO dto = new GuestbookDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setWriter(rs.getString("writer"));
				dto.setMessage(rs.getString("message"));
				dto.setWrite_date(rs.getDate("write_date"));
				list.add(dto);
			}
			return list;
		}
				
	}

}
