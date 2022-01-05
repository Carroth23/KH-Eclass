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
import kh.spring.service.MemberService;
import kh.spring.utils.EncryptUtils;

@Controller
@RequestMapping("/member/") // 여기다 달면 다른컨트롤러를 뒤지지않고 바로 여기만 찾는다.
public class MemberController {
	
	@Autowired // 서비스 레이어
	public MemberService mService;
	
//	@Autowired // 스프링 인스턴스 풀 안에 있는 인스턴스를 자동으로 집어넣음.(dependency Injection DI 디펜던시 인젝션)
//	MemberDAO mdao; 서비스레이어가 있으니 이제 여기서 안함
	
	@Autowired // 오토와이어드는 하나당 한놈만 해줄수 있음
	private HttpSession session; // 세션객체도 꺼내둘거니까 밖에서 주입받음
	
	@RequestMapping("join")
	public String memberJoin() {
		return "/member/join"; // 회원가입페이지로 보냄
	}
	
	// @RestController가 아닌 @Controller에서는 ResponseBody를 붙이면 됨
	@ResponseBody // 이 어노테이션을 붙이면, 이 메서드가 리턴하는 결과값은 포워드도 아니고 리다이렉트도 아니게됨(ajax에서 많이씀)
	@RequestMapping("idDuplCheck") // ID중복체크
	public String idDuplCheck(String id) throws Exception{
		return String.valueOf(mService.idDuplCheck(id));
	}
	
	@RequestMapping("signUp") // 회원가입
	public String signUp(MemberDTO dto) throws Exception{
		mService.signUp(dto);
		return "redirect:/";
	}
	
	@RequestMapping("login") // 로그인
	public String login(String id, String pw) {
		int result = mService.login(id, pw);
		if(result > 0) {
			session.setAttribute("loginID", id); // 원래는 사용자 정보 DTO를 담아두겠지
		}
		return "redirect:/"; // 세션에 담아서 가져갈거라 리다이렉트
	}
	
	@RequestMapping("logout") // 로그아웃
	public String logout() {
		session.removeAttribute("loginID");
//		session.invalidate(); 얘는 세션 초기화
		return "redirect:/";
	}
	
	@RequestMapping("leave") // 회원탈퇴
	public String leave() {
		String id = (String) session.getAttribute("loginID");
		mService.leave(id);
		session.invalidate(); // 탈퇴에선 초기화가 맞을듯
		return "redirect:/";
	}
	
	@RequestMapping("mypage") // 마이페이지
	public String mypage(Model model) {
		String id = (String) session.getAttribute("loginID");
		MemberDTO dto = mService.getInfoByID(id);
		model.addAttribute("dto", dto);
		return "/member/mypage";
	}
	
	@RequestMapping("modifyMyInfo") // 정보수정
	public String modifyMyInfo (MemberDTO dto) {
		mService.modifyMyInfo(dto);
		return "redirect:/";
	}
	
	///// 예외처리 /////
	@ExceptionHandler
	public String ExceptionHandler(Exception e) {
		e.printStackTrace();
		e.getMessage();
		return "redirect:/";
	}
}
