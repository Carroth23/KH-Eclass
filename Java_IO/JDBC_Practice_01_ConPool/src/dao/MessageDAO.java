package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.MessageDTO;

public class MessageDAO {

	// 1. DBCP 라이브러리 가져오기.
	
//	private Connection getConnection() throws Exception {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
//		String id = "practice";
//		String pw = "practice";
//		return DriverManager.getConnection(url, id, pw);
//	}
	
	
	private BasicDataSource bds = new BasicDataSource(); // Connection Pool 요녀석이 겟커넥션 안으로 가있으면 안됨 계속만듬.
	
	private static MessageDAO instance = null; // 그래서 요놈도 static이 붙는다.  ㅎ
	
	public static MessageDAO getInstance() { // 스태틱인 이유는 new 안하고 쓸거라서. ↑
		if (instance == null) {
			instance = new MessageDAO();
		}
		return instance;
	}
	
	// Singleton Design Pattern
	// 클래스의 인스턴스가 한개 이상 생성되지 않게 통제하는 기법
	private MessageDAO() { // 연결할때 생성자로써 한번만 정보입력
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@175.123.204.32:1521:xe");
		bds.setUsername("practice");
		bds.setPassword("practice");
		bds.setInitialSize(30); // 커넥션 풀 안에 몇개의 커넥션을 만들어 둘것인지.
	}
	
	private Connection getConnection() throws Exception {
		return bds.getConnection();
	}

	public int insert(MessageDTO dto) throws Exception {

		String sql = "insert into message values(seq.nextval, ? , ?, ?)";

		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			pstat.setDate(3, dto.getVisit_date());
			int result = pstat.executeUpdate();
			return result;
		}

	}

	public int delete(int id) throws Exception {
		String sql = "delete from message where seq = ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setInt(1, id);
			int result = pstat.executeUpdate();
			return result;
		}

	}

	public int modify(MessageDTO dto) throws Exception {
		String sql = "update message set writer=?, message=?, visit_date=? where seq = ?";

		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			pstat.setDate(3, dto.getVisit_date());
			pstat.setInt(4, dto.getSeq());
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public List<MessageDTO> selectAll() throws Exception {
		Connection con = this.getConnection();
		Statement stat = con.createStatement();
		String sql = "select * from message order by 1";
		ResultSet rs = stat.executeQuery(sql);

		List<MessageDTO> list = new ArrayList<>();
		while (rs.next()) {
			int seq = rs.getInt("seq");
			String writer = rs.getString("writer");
			String message = rs.getString("message");
			Date visit_date = rs.getDate("visit_date");

			MessageDTO dto = new MessageDTO(seq, writer, message, visit_date);
			list.add(dto);
		}
		return list;
	}

	public List<MessageDTO> searchByWriter(String writer) throws Exception {
		String sql = "select * from message where writer=? order by 1";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, writer);
			try (ResultSet rs = pstat.executeQuery();) {
				List<MessageDTO> list = new ArrayList<>();
				while (rs.next()) {
					int seq = rs.getInt("seq");
					String twriter = rs.getString("writer");
					String message = rs.getString("message");
					Date visit_date = rs.getDate("visit_date");

					MessageDTO dto = new MessageDTO(seq, twriter, message, visit_date);
					list.add(dto);
				}
				return list;
			}
		}
	}

	public MessageDTO searchById(int pseq) throws Exception {

		String sql = "select * from message where seq=? order by 1";

		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setInt(1, pseq);
			try (ResultSet rs = pstat.executeQuery();) {
				MessageDTO dto = null;
				if (rs.next()) {
					int seq = rs.getInt("seq");
					String writer = rs.getString("writer");
					String message = rs.getString("message");
					Date visit_date = rs.getDate("visit_date");
					dto = new MessageDTO(seq, writer, message, visit_date);
				}
				return dto;
			}
		}

	}
}
