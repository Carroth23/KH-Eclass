package kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//	@RequestMapping(value = "/", method = RequestMethod.GET) Get으로 명시하면 Get으로 들어오는것만 받음(지우면 둘다 허용)
	@RequestMapping("/")
	public String index() {
		return "home";
	}

//	@RequestMapping("join")
//	public String join() {
//		
//	}

	@ExceptionHandler(Exception.class)
	public String ExceptionHandler(Exception e) {
		e.printStackTrace();
		System.out.println("에러남ㅋ");
		return "redirect:/";
	}
}
