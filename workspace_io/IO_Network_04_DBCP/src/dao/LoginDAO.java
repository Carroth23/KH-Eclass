package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.LoginDTO;

public class LoginDAO {

	private BasicDataSource bds = new BasicDataSource(); // Connecion Pool
	// 커넥션 풀은 밖으로 뺀다
	// static으로 두는 이유는 static은 main이 실행될 때 한번만 실행되기 때문에

	// Singleton Design Pattern : 클래스의 인스턴스가 한 개 이상 생성되지 않게 통제하는 기법
	private static LoginDAO instance = null;

	public static LoginDAO getInstance() {
		if (instance == null) {
			instance = new LoginDAO();
		}
		return instance;
	}

	private LoginDAO() {
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@175.123.204.32:1521:xe");
		bds.setUsername("practice");
		bds.setPassword("practice");
		bds.setInitialSize(30);
	}

	private Connection getConnection() throws Exception {
		return bds.getConnection();
	}

	public int signUp(LoginDTO dto) throws Exception {
		String sql = "insert into members values(?, ?, ?, sysdate)";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public boolean isIdExist(String id) throws Exception {
		String sql = "select * from members where id = ?";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, id);
			try (ResultSet rs = pstat.executeQuery()) {
				return rs.next();
			}
		}
	}

	public LoginDTO isIdPwExist(String id, String pw) throws Exception {
		String sql = "select * from members where id = ? and pw = ?";
		try (Connection con = getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, id);
			pstat.setString(2, pw);
			try (ResultSet rs = pstat.executeQuery()) {
				LoginDTO dto = null;
				if (rs.next()) {
					dto = new LoginDTO();
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
