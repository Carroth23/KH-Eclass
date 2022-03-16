package quiz_Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Q01DAO {
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
		String id = "practice";
		String pw = "practice";
		return DriverManager.getConnection(url, id, pw);
	}
	
	public int signUp (Q01DTO dto) throws Exception {
		String sql = "insert into members values(?, ?, ?, sysdate)";
		try(
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			int result =  pstat.executeUpdate();
			return result;
		}
	}
	
	public boolean isIdExist(String id) throws Exception {
		String sql = "select * from members where id = ?";
		try (
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, id);
			try(ResultSet rs = pstat.executeQuery()){
				return rs.next();
			}
		}
	}
	
	public Q01DTO isIdPwExist (String id, String pw) throws Exception {
		String sql = "select * from members where id = ? and pw = ?";
		try(
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, id);
			pstat.setString(2, pw);
			try(ResultSet rs = pstat.executeQuery()){
				Q01DTO dto = null;
				if (rs.next()) {
					dto = new Q01DTO();
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setSignup_date(rs.getDate("signup_date"));
					return dto;
				}
			}
			return null;
		}
	}
}
