package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ContactDTO;

public class ContactDAO {
	// 얘는 서블릿이 아닌 클래스로 만듬. 이유 : 클라이언트의 요청을 처리하는 애가 아니라서.
	// DAO를 특정 디자인패턴 위에서는 모델이라고 부른다
	
//	private BasicDataSource bds = new BasicDataSource(); // DBCP는 톰캣안에 내장이 되어있다.
	// 근데 이렇게 만든 커넥션 풀도 결국 DAO가 많아지면 문제가 되어 톰캣 자체에 dbcp를 만들어 달라고 함.
//	Servers에 context.xml로 로 이동해서 작성
	// 생성자를 public로 만들면 여러 DAO에서 커넥션풀을 찍기때문에 더 심각해짐. 한번접속당 30개의 커넥션풀이 생성
	private static ContactDAO instance = null;
	public static ContactDAO getInstance() { // 싱글톤 패턴 적용
		if (instance == null) {
			instance = new ContactDAO();
		}
		return instance;
	}
	
	private ContactDAO() {}// 얘는 걍 냅두는게 좋음.(싱글턴 관련 코드)
	
	// 톰캣안에 넣어놔서 필요없다.
//	private ContactDAO() { // 생성자로 dbcp 정보 할당
//		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		bds.setUrl("jdbc:oracle:thin:@175.123.204.32:1521:xe");
//		bds.setUsername("kh");
//		bds.setPassword("kh");
//		bds.setInitialSize(30);
//	}
	
	private Connection getConnection() throws Exception{
		Context ctx = new InitialContext(); //javax.naming.Context;
		// javax.sql.DataSource;
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); //java:comp/env 여기까지는 고정. jdbc/oracle는 우리가 만든 자원의 이름(context에 name준거)
		return ds.getConnection();
	}
	
//	private Connection getConnection() throws Exception {
//		String username = "kh";
//		String password = "kh";
//		String url = "jdbc:oracle:thin:@175.123.204.32:1521:xe";
//
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con = DriverManager.getConnection(url, username, password);
//		return con;
//	}

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
