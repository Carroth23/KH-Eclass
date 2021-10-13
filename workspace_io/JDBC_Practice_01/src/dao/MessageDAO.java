package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.MessageDTO;

public class MessageDAO {

	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver"); // driver 로딩
		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
		String username = "practice";
		String password = "practice";
		Connection con = DriverManager.getConnection(url, username, password);
		return con; // 커넥션 된 상태로 리턴.
	}

	public int insert(String writer, String message) throws Exception {
		
		String sql = "insert into message values(seq.ecxtval, ?, ?)";
		try (
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
			) {
			pstat.setString(1, writer);
			pstat.setString(2, message);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public int delete(int seq) throws Exception {
		
		String sql = "delete from message where seq = ?";
		try (
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
			) {
			pstat.setInt(1, seq);
			int result = pstat.executeUpdate();
			return result;
		}
//		Statement stat = con.createStatement();
//		String sql = "delete from message where seq = " + seq;
//		int result = stat.executeUpdate(sql);
//		return result;
	}

	public int update(String writer, String message, int seq) throws Exception {
//		String sql = "update message set writer = '" + writer + "', message = '" + message + "' where seq = " + seq;
		String sql = "update message set writer = ?, message = ? where seq = ?";
		try (
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
			) {
			pstat.setString(1, writer);
			pstat.setString(2, message);
			pstat.setInt(3, seq);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public List<MessageDTO> selectAll() throws Exception {
		
		String sql = "select * from message";
		try (
				Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
			) {
			List<MessageDTO> result = new ArrayList<MessageDTO>();
			while (rs.next()) {
				int seq = rs.getInt("seq"); // rs.getInt(1)도 가능. ""붙이는 이유는 컬럼이라서.
				String writer = rs.getString("writer");
				String message = rs.getString("message");
				
				MessageDTO m = new MessageDTO(seq, writer, message);
				result.add(m);
			}
			return result;
		}

	}

	public MessageDTO search(int id) throws Exception {
		Connection con = getConnection();
		Statement stat = con.createStatement();

		String sql = "select * from message where seq = " + id;
		ResultSet rs = stat.executeQuery(sql);
		
		MessageDTO m = null;
		if(rs.next()) {
			int seq = rs.getInt("seq");
			String writer = rs.getString("writer");
			String message = rs.getString("message");
			m = new MessageDTO(seq, writer, message);
			return m;
		}
		con.close();
		return m;
	}

	public List<MessageDTO> search(String name) throws Exception {
		Connection con = getConnection();
		Statement stat = con.createStatement();

		String sql = "select * from message where writer = '" + name + "'";
		ResultSet rs = stat.executeQuery(sql);

		List<MessageDTO> result = new ArrayList<MessageDTO>();
		while (rs.next()) {
			int seq = rs.getInt("seq");
			String writer = rs.getString("writer");
			String message = rs.getString("message");

			MessageDTO m = new MessageDTO(seq, writer, message);
			result.add(m);
		}
		con.close();
		return result;
	}

}
