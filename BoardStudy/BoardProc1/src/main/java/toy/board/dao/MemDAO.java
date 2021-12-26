package toy.board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import toy.board.dto.MemDTO;

public class MemDAO {
	private static MemDAO instance = null;
	public static MemDAO getInstance () {
		if(instance == null) {
			instance = new MemDAO();
		}
		return instance;
	}
	
	private MemDAO() {}
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public int memInsert (MemDTO dto) throws Exception { // 회원가입
		String sql = "insert into member values (memseq.nextval, ?, ?, ?, sysdate)";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			return pstat.executeUpdate();
		}
	}
	
	public MemDTO memLogin (String id, String pw) throws Exception { // 로그인 확인
		String sql = "select * from member where id = ? and pw = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, id);
			pstat.setString(2, pw);
			try(ResultSet rs = pstat.executeQuery()){
				rs.next();
				int seq = rs.getInt("seq");
				String ide = rs.getString("id");
				String pwe = rs.getString("pw");
				String name = rs.getString("name");
				Date signupDate = rs.getDate("signupdate");
				return new MemDTO(seq, ide, pwe, name, signupDate);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
