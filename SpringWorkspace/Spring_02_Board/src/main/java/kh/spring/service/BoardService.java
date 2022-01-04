package kh.spring.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.ReplyDTO;

@Service
public class BoardService {
	
//	@Autowired 세션은 웹티어에 해당한다. 여기로 오면 안됨
//	private HttpSession session;
	
	@Autowired
	public BoardDAO bdao;
	
	public List<BoardDTO> selectAll(){
		return bdao.selectAll();
	}
	
	public int boardInsert(BoardDTO dto) {
		return bdao.boardInsert(dto);
	}
	
	public BoardDTO selectSeq(int seq) {
		return bdao.selectSeq(seq);
	}
	
	public List<ReplyDTO> selectReply(int seq) {
		return bdao.selectReply(seq);
	}
	
	public int deletePost(int seq) {
		return bdao.deletePost(seq);
	}
	
	public int modify(BoardDTO dto){
		return bdao.modify(dto);
	}
	
	public int replyInsert(ReplyDTO dto){
		return bdao.replyInsert(dto);
	}
	
}
