package kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // 클라이언트와 연결해주는 애들은 컨트롤러어노테이션 붙임
public class HomeController {
	
//	@RequestMapping(value = "/", method = RequestMethod.GET) Get으로 명시하면 Get으로 들어오는것만 받음(지우면 둘다 허용)
	@RequestMapping("/")
	public String home() {
		return "home";
		// RequestMapping 메서드에서 return값은 default가 forward 이다.
	}
	
	// 예외 핸들러
	@ExceptionHandler(Exception.class) // 예외의 종류(그렇담 예외의 종류가 여러개면 얘도 나눌수 있을것.)
	public String ExceptionHandler(Exception e) { // 여기서 익셉션 핸들러를 만들면 throws Exception으로 전가한 예외들이 디스패처한테 안가고 여기로 온다.
		e.printStackTrace();
		e.getMessage();
		return "redirect:/";
		// 스프링에서 foward가 아닌 redirect로 페이지를이동해야 할 경우는 앞에 redirect를 붙이고 만약 home로 가고 싶다면,
		// Web-INF는 외부에서 접근이 불가능 하므로, 홈으로 이동시켜주는 매핑을 찾아 적어줘야한다.home.jsp를 쓰고싶지만 외부접근이 불가함
		// redirect를 붙이면 Dispatcher가 뷰 리졸버에게 리턴값을 전달하지 않는다.
		// 뷰 리졸버한테 전달하면 걔가 저 주소를 조립해버리니까 안됨 ㅎㅎ
	}
}
