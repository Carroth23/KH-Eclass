package kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.MemberDTO;
import kh.spring.utils.EncryptUtils;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	MemberDAO mdao;
	
	@RequestMapping("join")
	public String memberJoin() {
		return "redirect:/member/join";
	}
	
	@ResponseBody
	@RequestMapping("idDuplCheck")
	public String idDuplCheck(String id) {
		int result = mdao.idDuplCheck(id);
		return String.valueOf(result);
	}
	
	@RequestMapping("signUp")
	public String signUp(MemberDTO dto) {
		dto.setPw(EncryptUtils.getSHA512(dto.getPw()));
		mdao.signUp(dto);
		return "redirect:/";
	}
	
	@RequestMapping("login")
	public String login(String id, String pw, Model model) {
		pw = EncryptUtils.getSHA512(pw);
		if (mdao.login(id, pw) > 0) {
			session.setAttribute("loginID", id);
		}
		return "redirect:/";
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.removeAttribute("loginID");
		return "redirect:/";
	}
	
	@RequestMapping("leave")
	public String leave() {
		mdao.leave((String) session.getAttribute("loginID"));
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("mypage")
	public String mypage(Model model) {
		model.addAttribute("dto", mdao.mypage((String) session.getAttribute("loginID")));
		return "/member/mypage";
	}
	
	@RequestMapping("modifyMyInfo")
	public String modifyMyInfo(MemberDTO dto) {
		mdao.modifyMyInfo(dto);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	@ExceptionHandler
	public String ExceptionHandler(Exception e) {
		e.printStackTrace();
		e.getMessage();
		return "/";
	}
}
