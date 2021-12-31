package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.ContactDAO;
import kh.spring.dto.ContactDTO;

@Controller // 클라이언트와 연결해주는 애들은 컨트롤러어노테이션 붙임
public class HomeController {

	@Autowired
	public ContactDAO dao;

//	@Autowired // 야 스프링 HttpSession형 객체를 찾아다가 메모리에 넣어.(그럼 밑에서도 씀)
//	private HttpSession session;

//	@RequestMapping(value = "/", method = RequestMethod.GET) Get으로 명시하면 Get으로 들어오는것만 받음(지우면 둘다 허용)
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
	public String inputProc(ContactDTO dto) throws Exception { // 이렇게 받을수도있음 대신 name값이 DTO필드값과 일치해야함(seq는 안받았으니까 0이
																// 들어있음)
//		String name = request.getParameter("name");
//		String contact = request.getParameter("contact");
		System.out.println(dto.getName() + " : " + dto.getContact());

//		String id = (String) session.getAttribute("loginId"); // 세션은 이렇게 가져올수도 있는데 나중엔 다른방식으로 씀
		// 밖으로 꺼내놓고 씀

		int result = dao.insert(dto);

//		return "home";
		return "redirect:/";
		// 스프링에서 foward가 아닌 redirect로 페이지를이동해야 할 경우는 앞에 redirect를 붙이고 만약 home로 가고 싶다면,
		// Web-INF는 외부에서 접근이 불가능 하므로, 홈으로 이동시켜주는 매핑을 찾아 적어줘야한다.home.jsp를 쓰고싶지만 외부접근이 불가함
		// redirect를 붙이면 Dispatcher가 뷰 리졸버에게 리턴값을 전달하지 않는다.
		// 뷰 리졸버한테 전달하면 걔가 저 주소를 조립해버리니까 안됨 ㅎㅎ
	}

	@RequestMapping("toOutput")
	public String outputProc(Model model) throws Exception {

		// 목록을 담아 JSP로 보내는 방법 1
		// Return 타입을 ModelAndView로 변경 한 후
//		ModelAndView mav = new ModelAndView();
//		try {
//			List<ContactDTO> list = dao.selectAll();
//			mav.addObject("list", list);
//			mav.setViewName("output"); // output.jsp로 갈건데 list를 가지고 가라
//		} catch (Exception e) {
//			e.printStackTrace();
//			mav.setViewName("error");
//		}
//		return mav;

		// 목록을 담아 JSP로 보내는 방법 2(얘를 주로 씀)
		// Model을 매개변수로 셋팅하고 model객체에 목록을 담아 보낸다

		List<ContactDTO> list = dao.selectAll();
		int count = dao.selectCount(); // 총 contact의 갯수

		model.addAttribute("list", list);
		model.addAttribute("count", count);
		return "output";
	}
	
	@RequestMapping("toSearch")
	public String toSearch() {
		return "search";
	}

	@RequestMapping("search")
	public String search(int searchSeq, Model model) throws Exception {
		List<ContactDTO> list = dao.search(searchSeq);
		model.addAttribute("list", list);
		return "output";
	}
	
	@RequestMapping("searchByMultiCon") // 여러개의 조건을 검색
	public String multiSearch(ContactDTO dto) {
		System.out.println("넣은Con : " + dto.getContact() + ", 넣은Name : " + dto.getName());
		List<ContactDTO> list = dao.searchByMultiCon(dto);
		
		for (ContactDTO dtos : list) {
			System.out.println("검색된 Name : " + dtos.getName() + ", 검색된 Con : " + dtos.getContact());
		}
		
		return "search";
	}

	@RequestMapping("deleteProc")
	public String delProc(int delTarget) throws Exception {

////		dao.delete(Integer.parseInt(delTarget));
		int result = dao.deleteBySeq(delTarget);
		return "redirect:toOutput";
	}
//	// JSP에서 같은 name값을 배열로 받기 = getParameterValues()
	
	@RequestMapping("updateProc")
	public String updateProc(String column, String value, int seq) throws Exception {
//		int result = dao.update(dto);
		int result = dao.update(column, value, seq);
		return "redirect:toOutput";
	}

	@ExceptionHandler(Exception.class) // 예외의 종류(그렇담 예외의 종류가 여러개면 얘도 나눌수 있을것.)
	public String exceptionHandler(Exception e) { // 여기서 익셉션 핸들러를 만들면 throws Exception으로 전가한 예외들이 디스패처한테 안가고 여기로 온다.
		e.printStackTrace();
		System.out.println("예외 코드가 실행되었습니다.");
		return "redirect:/"; // 얘도 리다이렉트
	}

//	@ExceptionHandler(NumberFormatException.class)
//	public String exceptionHandler() {
//		System.out.println("넘버포맷 에러");
//		return "home";
//	}

}
