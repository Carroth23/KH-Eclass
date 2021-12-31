package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.MessagesDAO;
import kh.spring.dto.MessagesDTO;


@Controller
public class HomeController {
	
	@Autowired
	public MessagesDAO dao;

	@RequestMapping("/")
	public String index() {

		return "index";
	}
	
	@RequestMapping("toInput")
	public String toinput() {
		System.out.println("메세지 작성으로 이동");
		return "inputForm";
	}
	
	@RequestMapping("inputForm")
	public String inputForm(MessagesDTO dto) throws Exception {
		int result = dao.insert(dto);
		if (result == 1) System.out.println("정상입력");
		return "redirect:/";
	}
	
	@RequestMapping("toOutput")
	public String toOutput(Model model) throws Exception{
		List<MessagesDTO> list = dao.selectAll();
		model.addAttribute("list", list);
		System.out.println("메세지 출력으로 이동");
		return "outputView";
	}
	
	@RequestMapping("deleteProc")
	public String deleteProc(int seq) throws Exception {
		dao.delete(seq);
		System.out.println("삭제완료");
		return "redirect:toOutput";
	}
	
	@RequestMapping("updateProc")
	public String updateProc(MessagesDTO dto) throws Exception {
		int result = dao.update(dto);
		return "redirect:toOutput";
	}
	
	@RequestMapping("searchSeq")
	public String searchSeq(int seq, Model model) throws Exception {
		List<MessagesDTO> dto = dao.searchSeq(seq);
		model.addAttribute("list", dto);
		return "outputView";
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler (Exception e) {
		e.printStackTrace();
		System.out.println("에러발생");
		return "redirect:/";
	}
	
}
