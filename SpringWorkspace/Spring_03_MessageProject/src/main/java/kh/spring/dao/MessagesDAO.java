package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MessagesDTO;

@Repository
public class MessagesDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insert(MessagesDTO dto) {
		return mybatis.insert("Message.insert", dto);
	}
	
	public List<MessagesDTO> selectAll(){
		return mybatis.selectList("Message.selectAll");
	}
	
	public List<MessagesDTO> searchSeq(int seq) {
		return mybatis.selectList("Message.searchSeq", seq);
	}
	
	public int delete(int seq) {
		return mybatis.delete("Message.delete", seq);
	}
	
	public int update(MessagesDTO dto) {
		Map<String, String> map = new HashMap<>();
		map.put("seq", String.valueOf(dto.getSeq()));
		map.put("writer", dto.getWriter());
		map.put("message", dto.getMessage());
		return mybatis.update("Message.update", dto);
	}
	
	

	
	
	
//	@Autowired
//	private BasicDataSource bds;
	
//	@Autowired
//	private JdbcTemplate jdbc;
//	
//	public int insert (MessagesDTO dto) throws Exception{
//		String sql = "insert into messages values(messages_seq.nextval, ?, ?, default)";
//		return jdbc.update(sql, dto.getWriter(), dto.getMessage());
//	}
//	
//	public List<MessagesDTO> selectAll () throws Exception{
//		String sql = "select * from messages";
//		return jdbc.query(sql, new RowMapper<MessagesDTO>() {
//			@Override
//			public MessagesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MessagesDTO dto = new MessagesDTO();
//				dto.setSeq(rs.getInt("seq"));
//				dto.setWriter(rs.getString("writer"));
//				dto.setMessage(rs.getString("message"));
//				dto.setWrite_date(rs.getTimestamp("write_date"));
//				return dto;
//			}
//		});
//	}
//	
//	public MessagesDTO searchSeq (int seq) throws Exception {
//		String sql = "select * from messages where seq = ?";
//		return jdbc.queryForObject(sql, new RowMapper<MessagesDTO>() {
//			@Override
//			public MessagesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MessagesDTO dto = new MessagesDTO();
//				dto.setSeq(rs.getInt("seq"));
//				dto.setWriter(rs.getString("writer"));
//				dto.setMessage(rs.getString("message"));
//				dto.setWrite_date(rs.getTimestamp("write_date"));
//				return dto;
//			}
//		}, seq);
//	}
//	
//	public int delete (int seq) throws Exception {
//		String sql = "delete from messages where seq = ?";
//		return jdbc.update(sql, seq);
//	}
//	
//	public int update (MessagesDTO dto) throws Exception {
//		String sql = "update messages set writer = ?, message = ?, write_date = default where seq = ?";
//		return jdbc.update(sql, dto.getWriter(), dto.getMessage(), dto.getSeq());
//	}
	
	
	
	
	
	
	
	
}
