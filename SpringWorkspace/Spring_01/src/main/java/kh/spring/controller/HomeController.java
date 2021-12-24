package kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.ContactDTO;

@Controller
public class HomeController {
	
	@Autowired // 야 스프링 HttpSession형 객체를 찾아다가 메모리에 넣어.(그럼 밑에서도 씀)
	private HttpSession session;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("/ 로 들어온 요청은 이 메서드를 실행합니다.");
		
		// 리턴값은 3개를 쓸수있음
		// void
		// String
		// ModelAndView
		
		return "home";
		// RequestMapping 메서드에서 return값은 default가 forward 이다.
	}
	
	@RequestMapping("toInput")
	public String toInput() {
		System.out.println("toInput 으로 가는 메서드가 실행되었습니다.");
		return "inputForm";
	}
	
	@RequestMapping("inputProc")
//	public String inputProc(HttpServletRequest request) { 리퀘스트 객체가 없으니 매개변수에 만들어버릴 수도 있음
//	public String inputProc(String name, String contact) { 들어오는 name값과 같이하면 리퀘스트 없이 받아짐
	
	public String inputProc(ContactDTO dto) { // 이렇게 받을수도있음 대신 name값이 DTO필드값과 일치해야함(seq는 안받았으니까 0이 들어있음)
//		String name = request.getParameter("name");
//		String contact = request.getParameter("contact");
		System.out.println(dto.getName() + " : " + dto.getContact());
		
		String id = (String) session.getAttribute("loginId"); // 세션은 이렇게 가져올수도 있는데 나중엔 다른방식으로 씀
															  // 밖으로 꺼내놓고 씀
		
		return "home";
	}
	
}
