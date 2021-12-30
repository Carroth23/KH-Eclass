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
	JdbcTemplate jdbc;

//	내가 푼거
//	public Boolean idIdExist(String id) throws Exception {
//		String sql = "select * from member where id = ?";
//		try {
//			return jdbc.queryForObject(sql, new RowMapper<Boolean>() {
//				@Override
//				public Boolean mapRow(ResultSet rs, int rowNum) {
//					return true; // 여기 들어왔으면 이미 트루임
//				}
//			}, id);
//		} catch (EmptyResultDataAccessException e) {
//			return false;
//		}
//	}
	
	// 강사님 코드
	public int idDuplCheck(String id) { // 아이디 중복확인
		String sql = "select count(*) from member where id = ?";
			return jdbc.queryForObject(sql, Integer.class, id); // queryForobject는 결과값이 없으면 에러냄
	}
	
	public int signUp (MemberDTO dto) { // 회원가입
		String sql = "insert into member values(?,?,?,?,?,?,?,?,sysdate)";
		return jdbc.update(sql, dto.getId(), dto.getPw(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getZipcode(),
				dto.getAddress1(), dto.getAddress2());
	}
	
	public int login (String id, String pw) { // 로그인
		String sql = "select count(*) from member where id = ? and pw = ?";
		return jdbc.queryForObject(sql, Integer.class, id, pw); // Integer.class 널값 연산이 가능
	}
	
	public int leave (String id) { // 회원탈퇴
		String sql = "delete from member where id = ?";
		return jdbc.update(sql, id);
	}
	
	public MemberDTO getInfoByID (String id) { // 마이페이지 내용뿌리기
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
	
	public int modifyMyInfo(MemberDTO dto) { // 정보수정
		String sql = "update member set name = ?, phone = ?, email = ?, zipcode = ?, address1 = ?, address2 = ? where id = ?";
		return jdbc.update(sql, dto.getName(), dto.getPhone(), dto.getEmail(), dto.getZipcode(), dto.getAddress1(), dto.getAddress2(), dto.getId());
	}
	
	
	
	
	
	
	
	
}
