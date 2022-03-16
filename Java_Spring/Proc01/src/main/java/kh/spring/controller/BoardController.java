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
import kh.spring.statics.Statics;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	BoardDAO bdao;
	
	@RequestMapping("list")
	public String Boardlist(Model model, String cpage) {
		if(cpage == null) {
			cpage = "1";
		}
		int currentPage = Integer.parseInt(cpage); // 현재페이지
		
		if(currentPage < 1) { // -1넣는거 방어
			currentPage = 1;
		}
		
		if(currentPage > bdao.getPageTotalCount()) { // 페이지수 over 방어
			currentPage = bdao.getPageTotalCount();
		}
		
		int start = currentPage * Statics.RECORD_COUNT_PER_PAGE - (Statics.RECORD_COUNT_PER_PAGE - 1);
		int end = currentPage * Statics.RECORD_COUNT_PER_PAGE;
		System.out.println(start);
		System.out.println(end);
		List<BoardDTO> dto = bdao.selectByBound(start, end);
		model.addAttribute("post_List", dto);
		String navi = bdao.getPageNavi(currentPage);
		model.addAttribute("navi", navi);
		return "board/list";
	}
	
	
	
	@ExceptionHandler
	public String ExceptionHandler(Exception e) {
		e.printStackTrace();
		e.getMessage();
		return "redirect:/";
	}
	
	
}
