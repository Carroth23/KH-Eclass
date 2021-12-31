package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.ReplyDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<BoardDTO> selectAll() {
		return mybatis.selectList("Board.selectAll");
	}
	
	public int boardInsert(BoardDTO dto) {
		return mybatis.insert("Board.boardInsert", dto);
	}
	
	public BoardDTO selectSeq(int seq) {
		return mybatis.selectOne("Board.selectSeq", seq);
	}
	
	public int deletePost(int seq) {
		return mybatis.update("Board.deletePost", seq);
	}
	
	public int modify (BoardDTO dto) {
		return mybatis.update("Board.modify", dto);
	}
	
	public int replyInsert(ReplyDTO dto) {
		return mybatis.insert("Board.replyInsert", dto);
	}
	
	public List<ReplyDTO> selectReply(int board_seq) {
		return mybatis.selectList("Board.selectReply", board_seq);
	}
	
//	@Autowired
//	private JdbcTemplate jdbc;

//	public List<BoardDTO> selectAll() { // API를 위한 글목록
//		String sql = "select * from board order by seq desc";
//		return jdbc.query(sql, new RowMapper<BoardDTO>() {
//			@Override
//			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				BoardDTO dto = new BoardDTO();
//				dto.setSeq(rs.getInt("seq"));
//				dto.setWriter(rs.getString("writer"));
//				dto.setTitle(rs.getString("title"));
//				dto.setContents(rs.getString("contents"));
//				dto.setWrite_date(rs.getDate("write_date"));
//				dto.setView_count(rs.getInt("view_count"));
//				return dto;
//			}
//		});
//	}

//	public int boardInsert(BoardDTO dto) { // 글 작성
//		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
//		return jdbc.update(sql, dto.getWriter(), dto.getTitle(), dto.getContents());
//	}
	
//	public BoardDTO selectSeq(int seq) { // 글 하나 불러오기
//		String sql = "select * from board where seq = ?";
//		return jdbc.queryForObject(sql, new RowMapper<BoardDTO>() {
//			@Override
//			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				BoardDTO dto = new BoardDTO();
//				dto.setSeq(rs.getInt("seq"));
//				dto.setTitle(rs.getString("title"));
//				dto.setContents(rs.getString("contents"));
//				dto.setWriter(rs.getString("writer"));
//				dto.setView_count(rs.getInt("view_count"));
//				dto.setWrite_date(rs.getDate("write_date"));
//				return dto;
//			}
//		}, seq);
//	}
	
//	public int deletePost(int seq) { // 글 삭제
//		String sql = "delete from board where seq = ?";
//		return jdbc.update(sql, seq);
//	}
	
//	public int modify (BoardDTO dto) { // 글 수정
//		String sql = "update board set title = ?, contents = ? where seq = ?";
//		return jdbc.update(sql, dto.getTitle(), dto.getContents(), dto.getSeq());
//	}
	
	
	///////////// 리플 ////////////
//	public int replyInsert(ReplyDTO dto) { // 리플 넣기
//		String sql = "insert into reply values(reply_seq.nextval, ?, ?, ?, sysdate)";
//		return jdbc.update(sql, dto.getBoard_seq(), dto.getWriter(), dto.getContents());
//	}
	
//	public List<ReplyDTO> selectReply(int board_seq) {
//		String sql = "select * from reply where board_seq = ? order by seq desc";
//		return jdbc.query(sql, new RowMapper<ReplyDTO>() {
//			@Override
//			public ReplyDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				ReplyDTO dto = new ReplyDTO();
//				dto.setSeq(rs.getInt("seq"));
//				dto.setBoard_seq(rs.getInt("board_seq"));
//				dto.setWriter(rs.getString("writer"));
//				dto.setContents(rs.getString("contents"));
//				dto.setWrite_date(rs.getDate("write_date"));
//				return dto;
//			}
//		}, board_seq);
//	}
//	
}
