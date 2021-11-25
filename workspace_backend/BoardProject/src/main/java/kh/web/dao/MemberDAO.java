package kh.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kh.web.dto.MemberDTO;

public class MemberDAO {
//	패키지의 3단 구조 : kh(회사명).web(프로젝트명).dao(세분류)
	private static MemberDAO instance = null;

	public static MemberDAO getInstance() { // 싱글톤 패턴 적용
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	private MemberDAO() {
	}

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext(); // javax.naming.Context;
		// javax.sql.DataSource;
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle"); // java:comp/env 여기까지는 고정. jdbc/oracle는
																				// 우리가 만든 자원의 이름(context에 name준거)
		return ds.getConnection();
	}

	public boolean isIdExist(String id) throws Exception {
		String sql = "select * from member where id = ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, id);
			try (ResultSet rs = pstat.executeQuery();) {
				return rs.next(); // rs.next가 어차피 boolean값임
			}
		}
	}

	public int insert(MemberDTO dto) throws Exception {
		String sql = "insert into member values(?,?,?,?,?,?,?,?,sysdate)";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getPhone());
			pstat.setString(5, dto.getEmail());
			pstat.setString(6, dto.getZipcode());
			pstat.setString(7, dto.getAddress1());
			pstat.setString(8, dto.getAddress2());
			return pstat.executeUpdate();
		}
	}

	public MemberDTO loginCheck (String id, String pw) throws Exception {
		String sql = "select * from member where id = ? and pw = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			pstat.setString(2, pw);
			try (ResultSet rs = pstat.executeQuery()){
				MemberDTO dto = null;
				while(rs.next()) {
					String idProc = rs.getString("id");
					String pwProc = rs.getString("pw");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String zipcode = rs.getString("zipcode");
					String address1 = rs.getString("address1");
					String address2 = rs.getString("address2");
					Date signup_date = rs.getDate("signup_date");
					dto = new MemberDTO(idProc, pwProc, name, phone, email, zipcode, address1, address2, signup_date);
				}
				return dto;
			}
		}
	}

}
