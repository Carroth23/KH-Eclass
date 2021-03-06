package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbc;
	
	public int idDuplCheck(String id) {
		String sql = "select count(*) from member where id = ?";
		return jdbc.queryForObject(sql, Integer.class, id);
	}
	
	public int signUp(MemberDTO dto) {
		String sql = "insert into member values(?,?,?,?,?,?,?,?,sysdate)";
		return jdbc.update(sql, dto.getId(), dto.getPw(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getZipcode(),
				dto.getAddress1(), dto.getAddress2());
	}
	
	public int login(String id, String pw) {
		String sql = "select count(*) from member where id = ? and pw = ?";
		return jdbc.queryForObject(sql, Integer.class, id, pw);
	}
	
	public int leave(String id) {
		String sql = "delete from member where id = ?";
		return jdbc.update(sql, id);
	}
	
	public MemberDTO mypage(String id) {
		String sql = "select * from member where id = ?";
		return jdbc.queryForObject(sql, new RowMapper<MemberDTO>() {
			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
//				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddress1(rs.getString("address1"));
				dto.setAddress2(rs.getString("address2"));
				dto.setSignup_date(rs.getDate("signup_date"));
				return dto;
			}
		}, id);
	}
	
	public int modifyMyInfo(MemberDTO dto) {
		String sql = "update member set name = ?, phone = ?, email = ?, zipcode = ?, address1 = ?, address2 = ? where id = ?";
		return jdbc.update(sql, sql, dto.getName(), dto.getPhone(), dto.getEmail(), dto.getZipcode(), dto.getAddress1(), dto.getAddress2(), dto.getId());
	}
}
