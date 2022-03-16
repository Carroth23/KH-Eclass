package kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private String url = "https://kauth.kakao.com/oauth/authorize?client_id=b7b0a7f6722957ddef971b2ff4061bd7&redirect_uri=http://localhost/member/login&response_type=code";

	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	
	
	
	
	@ExceptionHandler
	public String ExceptionHandler(Exception e) {
		e.printStackTrace();
		e.getMessage();
		return "redirect:/";
	}
	
}
