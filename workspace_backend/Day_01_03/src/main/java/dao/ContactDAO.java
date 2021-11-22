package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ContactDTO;

public class ContactDAO {
	// 얘는 서블릿이 아닌 클래스로 만듬. 이유 : 클라이언트의 요청을 처리하는 애가 아니라서.
	// DAO를 특정 디자인패턴 위에서는 모델이라고 부른다
	private Connection getConnection() throws Exception {
		String username = "kh";
		String password = "kh";
		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

	public int insert(String name, String contact) throws Exception {
		String sql = "insert into contact values(contact_seq.nextval,?,?)";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, name);
			pstat.setString(2, contact);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public List<ContactDTO> selectAll() throws Exception {
		String sql = "select * from contact";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();) {

			List<ContactDTO> list = new ArrayList<>();

			while (rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				ContactDTO dto = new ContactDTO(seq, name, contact);
				list.add(dto);
			}
			return list;
		}
	}

	public int delete(int delSeq) throws Exception {
		String sql = "delete from contact where seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setInt(1, delSeq);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public int Modify(int seq, String name, String contact) throws Exception {
		String sql = "update contact set name = ?, contact = ? where seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, name);
			pstat.setString(2, contact);
			pstat.setInt(3, seq);
			int result = pstat.executeUpdate();
			return result;
		}

	}

}
