package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public BoardDTO selectSeq(int seq) { // 글목록 띄우는거
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
}
