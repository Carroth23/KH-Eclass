package h.toy.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import h.toy.dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO instance = null;

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	private MemberDAO() {
	};

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	public boolean idCheck(String id) throws Exception{
		String sql = "select id from member where id = ?";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, id);
			try (ResultSet rs = pstat.executeQuery()) {
				if (rs.next()) {
					return false;
				}
				return true;
			}
		}
	}
	
	// 회원가입
	public int signup(MemberDTO dto) throws Exception { 
		String sql = "insert into member values(?,?,?,?,?,?,?,?,sysdate)";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql)) {
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
	
	public MemberDTO loginCheck(String id, String pw) throws Exception {
		String sql = "select * from member where id = ? and pw = ?";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)) {
			pstat.setString(1, id);
			pstat.setString(2, pw);
			try(ResultSet rs = pstat.executeQuery()){
				if (rs.next()) {
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String zipcode = rs.getString("zipcode");
					String address1 = rs.getString("address1");
					String address2 = rs.getString("address2");
					Date signup_date = rs.getDate("signup_date");
					return new MemberDTO(id, pw, name, phone, email, zipcode, address1, address2, signup_date);
				}
				return null;
			}
		}
	}

}
