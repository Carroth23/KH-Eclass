package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.GuestbookDTO;

public class GuestbookDAO {

	private BasicDataSource bds = new BasicDataSource();

	private static GuestbookDAO instance = null;

	public static GuestbookDAO getInstance() {
		if (instance == null) {
			instance = new GuestbookDAO();
		}
		return instance;
	}

	private GuestbookDAO() {
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@175.123.204.32:1521:xe");
		bds.setUsername("practice");
		bds.setPassword("practice");
		bds.setInitialSize(30);
	}

	private Connection getConnection() throws Exception {
		return bds.getConnection();
	}

	public int insert(String writer, String message) throws Exception {
		String sql = "insert into guestbook values(guestbook_seq.nextval, ?, ?, sysdate)";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setString(1, writer);
			pstat.setString(2, message);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public List<GuestbookDTO> selectAll() throws Exception {
		String sql = "select * from guestbook";
		try (Connection con = getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()) {
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

	public int delete(int seq) throws Exception {
		String sql = "delete from guestbook where seq = ?";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setInt(1, seq);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public List<GuestbookDTO> search(String keyword) throws Exception {
		String sql = "select * from guestbook where writer like ? or message like ?";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setString(1, "%" + keyword + "%"); // %는 여기에 붙여야 함 (like가 필요할때)
			pstat.setString(2, "%" + keyword + "%");
			try (ResultSet rs = pstat.executeQuery()) {
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

}
