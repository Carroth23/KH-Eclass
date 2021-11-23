package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.StudentDTO;

public class StudentDAO {
	
	private static StudentDAO instance = null;
	public static StudentDAO getInstance() {
		if (instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
	
	private StudentDAO() {};
	// 이 위는 (싱글턴 관련 코드) 메모리 효율성때문에 싱글턴은 유지하는게 나음
	
	// JNDI
	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext(); //javax.naming.Context;
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); // javax.sql.DataSource;
		return ds.getConnection();
	}
	
	public int insert(String name, int kor, int eng) throws Exception {
		String sql = "insert into student values(student_seq.nextval,?,?,?)";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, name);
			pstat.setInt(2, kor);
			pstat.setInt(3, eng);
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	public List<StudentDTO> selectAll() throws Exception {
		String sql = "select * from student";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			List<StudentDTO> list = new ArrayList();
			
			while(rs.next()) {
				int seq = rs.getInt("id");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				StudentDTO dto = new StudentDTO(seq,name,kor,eng);
				list.add(dto);
			}
			return list;
		}
	}
	
	public int delete(int seq) throws Exception {
		String sql = "delete from student where id = ?";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, seq);
			int result = pstat.executeUpdate();
			return result;
		}
	}
}
