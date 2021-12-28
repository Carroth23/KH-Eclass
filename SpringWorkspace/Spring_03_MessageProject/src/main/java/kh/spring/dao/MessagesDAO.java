package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MessagesDTO;

@Repository
public class MessagesDAO {
	
//	@Autowired
//	private BasicDataSource bds;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert (MessagesDTO dto) throws Exception{
		String sql = "insert into messages values(messages_seq.nextval, ?, ?, default)";
		return jdbc.update(sql, dto.getWriter(), dto.getMessage());
	}
	
	public List<MessagesDTO> selectAll () throws Exception{
		String sql = "select * from messages";
		return jdbc.query(sql, new RowMapper<MessagesDTO>() {
			@Override
			public MessagesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MessagesDTO dto = new MessagesDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setWriter(rs.getString("writer"));
				dto.setMessage(rs.getString("message"));
				dto.setWrite_date(rs.getTimestamp("write_date"));
				return dto;
			}
		});
	}
	
	public MessagesDTO searchSeq (int seq) throws Exception {
		String sql = "select * from messages where seq = ?";
		return jdbc.queryForObject(sql, new RowMapper<MessagesDTO>() {
			@Override
			public MessagesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MessagesDTO dto = new MessagesDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setWriter(rs.getString("writer"));
				dto.setMessage(rs.getString("message"));
				dto.setWrite_date(rs.getTimestamp("write_date"));
				return dto;
			}
		}, seq);
	}
	
	public int delete (int seq) throws Exception {
		String sql = "delete from messages where seq = ?";
		return jdbc.update(sql, seq);
	}
	
	public int update (MessagesDTO dto) throws Exception {
		String sql = "update messages set writer = ?, message = ?, write_date = default where seq = ?";
		return jdbc.update(sql, dto.getWriter(), dto.getMessage(), dto.getSeq());
	}
	
	
	
	
	
	
	
	
}
