package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.ReplyDTO;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	private BoardDAO bdao;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("list") // 글목록(API로 띄우기)
	public String list(Model model) {
		List<BoardDTO> list = bdao.selectAll();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping("writeForm") // 글쓰기로 이동
	public String writeForm() {
		return "board/writeForm";
	}
	
	@RequestMapping("writeComplete") // 글 작성 완료
	public String writeComplete(BoardDTO dto) {
		dto.setWriter((String) session.getAttribute("loginID"));
		bdao.boardInsert(dto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("toDetail") // 글 세부정보
	public String toDetail(Model model, int seq) {
		model.addAttribute("dto", bdao.selectSeq(seq));
		model.addAttribute("reply", bdao.selectReply(seq));
		return "board/detail";
	}
	
	@RequestMapping("deleteProc") // 글 삭제
	public String deleteProc(int seq) {
		bdao.deletePost(seq);
		return "redirect:/board/list";
	}
	
	@RequestMapping("modify") // 글 수정
	public String modify (BoardDTO dto) {
		bdao.modify(dto);
		return "redirect:/board/toDetail?seq=" + dto.getSeq(); // 디테일로 가게해버리기
	}
	
	
	/////////////// 리플 //////////////////
	@RequestMapping("replyUp")
	public String modify (ReplyDTO dto, Model model) {
		dto.setWriter((String) session.getAttribute("loginID"));
		bdao.replyInsert(dto);
		return "redirect:/board/toDetail?seq=" + dto.getBoard_seq();
	}
	
	

	@ExceptionHandler
	public String ExceptionHandler(Exception e) {
		e.printStackTrace();
		e.getMessage();
		return "redirect:/";
	}
	
	
}
