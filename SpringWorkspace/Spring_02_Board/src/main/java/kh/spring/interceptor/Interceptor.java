package kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

// 어노테이션 없는이유는 아마 bean으로 생성해서일듯
public class Interceptor implements HandlerInterceptor{ // 핸들러 인터셉터 인터페이스 임플리먼츠
	
	@Autowired
	private HttpSession session;
	
	@Override // 디스패쳐를 거쳐, 인터셉터에서 실행되는 메서드(컨트롤러한테 가기 전)
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String loginID = (String) session.getAttribute("loginID");
		if(loginID == null) {
			response.sendRedirect("/");
			return false; // 프리핸들러 메서드의 리턴값이 불린
			// false를 리턴하면 컨트롤러한테 전달하지 않는다.
			// 아무것도 리턴하지않거나 트루를 리턴하면 걍 통과시킴.
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
