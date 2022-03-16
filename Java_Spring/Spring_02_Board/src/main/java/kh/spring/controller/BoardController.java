package kh.spring.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.FilesDTO;
import kh.spring.dto.ReplyDTO;
import kh.spring.service.BoardService;
import kh.spring.service.FileService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	// 컨트롤러 하나가 여러개의 dao를 쓸수있음 ㅎㅎ
//	@Autowired
//	private BoardDAO bdao;
	@Autowired
	private BoardService bService;

	// 이것도 서비스로 빼야됨
	@Autowired
	private FileService fService;

	@Autowired
	private HttpSession session;

	@RequestMapping("list") // 글목록(API로 띄우기)
	public String list(Model model) {
		List<BoardDTO> list = bService.selectAll();
		model.addAttribute("list", list);
		return "board/list";
	}

	@RequestMapping("writeForm") // 글쓰기로 이동
	public String writeForm() {
		return "board/writeForm";
	}

	@RequestMapping("writeComplete") // 글 작성 완료   // MultipartFile 동적바인딩(커맨드객체) 아파치라이브러리가 제공해줌
	public String writeComplete(BoardDTO dto, MultipartFile[] file) throws Exception { // 다중 파일가능이니까 [] 배열씀
		dto.setWriter((String) session.getAttribute("loginID")); // 접속중인 사용자가 작성자일테니까 그걸 받아옴
		String realPath = session.getServletContext().getRealPath("upload");
		bService.writeProc(dto, realPath, file);
		return "redirect:/board/list";
	}

	@RequestMapping("toDetail") // 글 세부정보
	public String toDetail(Model model, int seq) {
		model.addAttribute("files", fService.selectFileBySeq(seq));
		model.addAttribute("dto", bService.selectSeq(seq));
		model.addAttribute("reply", bService.selectReply(seq));
		return "board/detail";
	}

	@RequestMapping("deleteProc") // 글 삭제
	public String deleteProc(int seq) {
		bService.deletePost(seq);
		return "redirect:/board/list";
	}

	@RequestMapping("modify") // 글 수정
	public String modify(BoardDTO dto) {
		bService.modify(dto);
		return "redirect:/board/toDetail?seq=" + dto.getSeq(); // 디테일로 가게해버리기
	}

	/////////////// 리플 //////////////////
	@RequestMapping("replyUp")
	public String modify(ReplyDTO dto, Model model) {
		dto.setWriter((String) session.getAttribute("loginID"));
		bService.replyInsert(dto);
		return "redirect:/board/toDetail?seq=" + dto.getBoard_seq();
	}

	@ExceptionHandler
	public String ExceptionHandler(Exception e) {
		e.printStackTrace();
		e.getMessage();
		return "redirect:/";
	}
}
